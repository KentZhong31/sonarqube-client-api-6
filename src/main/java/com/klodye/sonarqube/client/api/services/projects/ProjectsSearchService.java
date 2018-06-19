package com.klodye.sonarqube.client.api.services.projects;

import com.google.gson.Gson;
import com.klodye.sonarqube.client.api.RestApi;
import com.klodye.sonarqube.client.api.Constants;
import com.klodye.sonarqube.client.api.SonarQubeException;
import com.klodye.sonarqube.client.api.models.projects.search.ProjectSearchModel;
import com.klodye.sonarqube.client.api.services.AbstractService;
import com.klodye.sonarqube.client.api.models.Component;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

import java.security.Timestamp;
import java.util.*;

public class ProjectsSearchService extends AbstractService<ProjectsSearchService, List<Component>> {

    public ProjectsSearchService(String url, HTTPBasicAuthFilter auth) {
        super(url, auth);
    }

    protected String getPath() {
        return "api/projects/search";
    }

    public List<Component> execute() throws SonarQubeException {
        List<Component> components = new ArrayList<>();
        Gson gson = new Gson();
        boolean isNotLast;
        int page = 1;
        int ps = 100;
        do{
            getParams().add("p", Integer.toString(page));
            ClientResponse clientResponse = RestApi.get(getUrl(), getPath(), getAuth(), getParams());
            String output = clientResponse.getEntity(String.class);
            ProjectSearchModel projects = gson.fromJson(output, ProjectSearchModel.class);
            components.addAll(projects.getComponents());
            isNotLast = page * ps < projects.getPaging().getTotal();
            page = projects.getPaging().getTotal();
        }while(isNotLast);

        return components;
    }

    public ProjectsSearchService analyzedBefore(Timestamp analyzedBefore){
        addDateParam("analyzedBefore", analyzedBefore);
        return this;
    }

    public ProjectsSearchService onProvisionedOnly(boolean onProvisionedOnly){
        addBooleanParam("onProvisionedOnly", onProvisionedOnly);
        return this;
    }

    public ProjectsSearchService projects(String... projects){
        addCSVParam("projects", projects);
        return this;
    }

    public ProjectsSearchService qualifiers(Constants.Qualifiers... qualifiers){
        String[] temp = Arrays.stream(qualifiers).map(x->Constants.qualifiersMap.get(x)).toArray(String[]::new);
        addCSVParam("qualifiers", temp);
        return this;
    }

}
