package com.klodye.sonarqube.client.api.services.projects;

import com.klodye.sonarqube.client.api.RestApi;
import com.klodye.sonarqube.client.api.SonarQubeException;
import com.klodye.sonarqube.client.api.services.AbstractService;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

public class ProjectsUpdateKeyService extends AbstractService<ProjectsUpdateKeyService, Boolean> {

    public ProjectsUpdateKeyService(String url, HTTPBasicAuthFilter auth) {
        super(url, auth);
    }

    @Override
    protected String getPath() {
        return "api/projects/update_key";
    }

    @Override
    public Boolean execute() throws SonarQubeException {
        ClientResponse clientResponse = RestApi.post(getUrl(), getPath(), getAuth(), getParams());
        return clientResponse.getStatus() == 204;
    }

    public ProjectsUpdateKeyService from(String from){
        getParams().add("from", from);
        return this;
    }

    public ProjectsUpdateKeyService to(String to){
        getParams().add("to", to);
        return this;
    }

}
