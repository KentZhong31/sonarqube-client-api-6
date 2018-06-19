package com.klodye.sonarqube.client.api.services.projects;

import com.google.gson.Gson;
import com.klodye.sonarqube.client.api.RestApi;
import com.klodye.sonarqube.client.api.SonarQubeException;
import com.klodye.sonarqube.client.api.models.projects.bulkupdatekey.ProjectBulkUpdateKeyModel;
import com.klodye.sonarqube.client.api.services.AbstractService;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

public class ProjectsBulkUpdateKeyService extends AbstractService<ProjectsUpdateKeyService, ProjectBulkUpdateKeyModel> {

    public ProjectsBulkUpdateKeyService(String url, HTTPBasicAuthFilter auth) {
        super(url, auth);
    }

    @Override
    protected String getPath() {
        return "api/projects/update_key";
    }

    @Override
    public ProjectBulkUpdateKeyModel execute() throws SonarQubeException {
        Gson gson = new Gson();
        ClientResponse clientResponse = RestApi.post(getUrl(), getPath(), getAuth(), getParams());
        String output = clientResponse.getEntity(String.class);
        return gson.fromJson(output, ProjectBulkUpdateKeyModel.class);
    }

    public ProjectsBulkUpdateKeyService dryRun(boolean dryRun){
        addBooleanParam("dryRun", dryRun);
        return this;
    }

    public ProjectsBulkUpdateKeyService from(String from){
        getParams().add("from", from);
        return this;
    }

    public ProjectsBulkUpdateKeyService project(String project){
        getParams().add("project", project);
        return this;
    }

    public ProjectsBulkUpdateKeyService to(String to){
        getParams().add("to", to);
        return this;
    }

}
