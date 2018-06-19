package com.klodye.sonarqube.client.api.services.projects;

import com.klodye.sonarqube.client.api.Constants;
import com.klodye.sonarqube.client.api.RestApi;
import com.klodye.sonarqube.client.api.SonarQubeException;
import com.klodye.sonarqube.client.api.services.AbstractService;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

import java.security.Timestamp;
import java.util.Arrays;

public class ProjectsBulkDeleteService extends AbstractService<ProjectsDeleteService, Boolean> {

    protected ProjectsBulkDeleteService(String url, HTTPBasicAuthFilter auth) {
        super(url, auth);
    }

    @Override
    public String getPath() {
        return "api/projects/delete";
    }

    @Override
    public Boolean execute() throws SonarQubeException {
        ClientResponse clientResponse = RestApi.post(getUrl(), getPath(), getAuth(), getParams());
        return clientResponse.getStatus() == 204;
    }

    public ProjectsBulkDeleteService analyzedBefore(Timestamp analyzedBefore){
        addDateParam("analyzedBefore", analyzedBefore);
        return this;
    }

    public ProjectsBulkDeleteService onProvisionedOnly(boolean onProvisionedOnly){
        addBooleanParam("onProvisionedOnly", onProvisionedOnly);
        return this;
    }

    public ProjectsBulkDeleteService projects(String... projects){
        addCSVParam("projects", projects);
        return this;
    }

    // TODO check if really array parameter
    public ProjectsBulkDeleteService queries(String... queries){
        addCSVParam("q", queries);
        return this;
    }

    public ProjectsBulkDeleteService qualifiers(Constants.Qualifiers... qualifiers){
        String[] temp = Arrays.stream(qualifiers).map(x->Constants.qualifiersMap.get(x)).toArray(String[]::new);
        addCSVParam("qualifiers", temp);
        return this;
    }

}
