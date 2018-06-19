package com.klodye.sonarqube.client.api.services.projects;

import com.google.gson.Gson;
import com.klodye.sonarqube.client.api.RestApi;
import com.klodye.sonarqube.client.api.SonarQubeException;
import com.klodye.sonarqube.client.api.models.projects.create.ProjectCreateModel;
import com.klodye.sonarqube.client.api.services.AbstractService;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;


public class ProjectsCreateService extends AbstractService<ProjectsCreateService, ProjectCreateModel> {

    public ProjectsCreateService(String url, HTTPBasicAuthFilter auth) {
        super(url, auth);
    }

    @Override
    protected String getPath() {
        return "api/projects/create";
    }

    @Override
    public ProjectCreateModel execute() throws SonarQubeException {
        Gson gson = new Gson();
        ClientResponse clientResponse = RestApi.post(getUrl(), getPath(), getAuth(), getParams());
        String output = clientResponse.getEntity(String.class);
        return gson.fromJson(output, ProjectCreateModel.class);
    }

    public ProjectsCreateService name(String name){
        getParams().add("name", name);
        return this;
    }

    public ProjectsCreateService project(String project){
        getParams().add("project", project);
        return this;
    }


}
