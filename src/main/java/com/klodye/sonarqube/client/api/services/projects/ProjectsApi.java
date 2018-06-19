package com.klodye.sonarqube.client.api.services.projects;

import com.klodye.sonarqube.client.api.services.AbstractApi;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;


public class ProjectsApi extends AbstractApi{

    public ProjectsApi(String url, HTTPBasicAuthFilter auth) {
        super(url, auth);
    }

    public ProjectsSearchService search(){
        return new ProjectsSearchService(getUrl(), getAuth());
    }

    public ProjectsCreateService create(){
        return new ProjectsCreateService(getUrl(), getAuth());
    }

    public ProjectsDeleteService delete(){
        return new ProjectsDeleteService(getUrl(), getAuth());
    }

    public ProjectsUpdateVisibilityService updateVisibility(){
        return new ProjectsUpdateVisibilityService(getUrl(), getAuth());
    }

    public ProjectsUpdateKeyService updateKey(){
        return new ProjectsUpdateKeyService(getUrl(), getAuth());
    }

}
