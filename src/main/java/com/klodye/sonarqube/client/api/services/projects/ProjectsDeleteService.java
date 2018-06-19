package com.klodye.sonarqube.client.api.services.projects;

import com.klodye.sonarqube.client.api.RestApi;
import com.klodye.sonarqube.client.api.SonarQubeException;
import com.klodye.sonarqube.client.api.services.AbstractService;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

public class ProjectsDeleteService extends AbstractService<ProjectsDeleteService, Boolean> {

    protected ProjectsDeleteService(String url, HTTPBasicAuthFilter auth) {
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

    public ProjectsDeleteService project(String project){
        getParams().add("project", project);
        return this;
    }

}
