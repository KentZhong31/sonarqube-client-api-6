package com.klodye.sonarqube.client.api.services.projects;

import com.klodye.sonarqube.client.api.RestApi;
import com.klodye.sonarqube.client.api.Constants;
import com.klodye.sonarqube.client.api.SonarQubeException;
import com.klodye.sonarqube.client.api.services.AbstractService;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

import javax.ws.rs.core.MultivaluedMap;


public class ProjectsUpdateVisibilityService extends AbstractService<ProjectsUpdateVisibilityService, Boolean> {

    private String project;
    private String visibility;

    public ProjectsUpdateVisibilityService(String url, HTTPBasicAuthFilter auth) {
        super(url, auth);
    }

    @Override
    protected String getPath() {
        return "api/projects/update_visibility";
    }

    @Override
    public Boolean execute() throws SonarQubeException {
        ClientResponse clientResponse = RestApi.post(getUrl(), getPath(), getAuth(), getPostData());
        return clientResponse.getStatus() == 204;
    }

    public ProjectsUpdateVisibilityService project(String project){
        this.project = project;
        return this;
    }

    public ProjectsUpdateVisibilityService visibility(Constants.Visibilities visibility){
        this.visibility = Constants.visibilityMap.get(visibility);
        return this;
    }

    private MultivaluedMap<String, String> getPostData() {
        MultivaluedMap<String, String> postData = getParams();
        // param - project
        if(this.project != null && !this.project.isEmpty()){
            postData.add("project", this.project);
        }
        // param - visibility
        if(this.visibility != null && !this.visibility.isEmpty()){
            postData.add("visibility", this.visibility);
        }
        return postData;
    }
}
