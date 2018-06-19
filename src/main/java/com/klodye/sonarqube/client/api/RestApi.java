package com.klodye.sonarqube.client.api;

import com.google.gson.Gson;
import com.klodye.sonarqube.client.api.models.Errors;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import java.util.stream.IntStream;


/**
 * Rest API executioner. Executes GET and POST requests to SonarQube
 */
public class RestApi {

    /**
     * Execute GET request to SonarQube
     *
     * @param url URL to SonarQube instance
     * @param path Path the requested API
     * @param auth Auth object containing username and password or security token
     * @param queryParams Query parameters for the request
     * @return Response object with all required data (status code, response data etc.)
     * @throws SonarQubeException Exception returned in case the request was not successful. Returned message from SonarQube is passed to this exception
     */
    public static ClientResponse get(String url, String path, HTTPBasicAuthFilter auth, MultivaluedMap<String, String> queryParams) throws SonarQubeException {
        Client client = Client.create();
        client.addFilter(auth);
        WebResource webResource = client.resource(url).path(path).queryParams(queryParams);
        ClientResponse clientResponse = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
        checkResponse(clientResponse);
        return clientResponse;
    }

    /**
     * Execute POST request to SonarQube
     *
     * @param url URL to SonarQube instance
     * @param path Path the requested API
     * @param auth Auth object containing username and password or security token
     * @param data Query parameters for the request
     * @return Response object with all required data (status code, response data etc.)
     * @throws SonarQubeException Exception thrown in case the request was not successful. Returned message from SonarQube is passed to this exception
     */
    public static ClientResponse post(String url, String path, HTTPBasicAuthFilter auth, MultivaluedMap<String, String> data) throws SonarQubeException {
        Client client = Client.create();
        client.addFilter(auth);
        WebResource webResource = client.resource(url).path(path);
        ClientResponse clientResponse = webResource.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_FORM_URLENCODED).post(ClientResponse.class, data);
        checkResponse(clientResponse);
        return clientResponse;
    }

    /**
     * Checks response and trows SonarQubeException in case the returned success code is not successful
     *
     * @param clientResponse Response object with all required data (status code, response data etc.)
     * @throws SonarQubeException Exception thrown in case the request was not successful. Returned message from SonarQube is passed to this exception
     */
    private static void checkResponse(ClientResponse clientResponse) throws SonarQubeException {
        int[] errorStatuses = {400, 401, 403, 404};

        int status = clientResponse.getStatus();

        if(IntStream.of(errorStatuses).anyMatch(x -> x == status)){
            String output = clientResponse.getEntity(String.class);
            Errors errors = new Gson().fromJson(output, Errors.class);
            StringBuilder message = new StringBuilder();
            for (Errors.Error error : errors.getErrors()) {
                message.append(error.getMsg()).append("|");
            }
            throw new SonarQubeException(message.substring(0, message.length()-1));
        }
    }

}
