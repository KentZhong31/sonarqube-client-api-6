package com.klodye.sonarqube.client.api.services.qualitygates;

import com.google.gson.Gson;
import com.klodye.sonarqube.client.api.RestApi;
import com.klodye.sonarqube.client.api.Constants;
import com.klodye.sonarqube.client.api.SonarQubeException;
import com.klodye.sonarqube.client.api.models.qualitygates.projectstatus.QualityGatesProjectStatusModel;
import com.klodye.sonarqube.client.api.models.users.groups.Group;
import com.klodye.sonarqube.client.api.models.users.groups.UsersGroupsModel;
import com.klodye.sonarqube.client.api.services.AbstractService;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

import java.util.*;

public class QualityGatesProjectStatusService extends AbstractService<QualityGatesProjectStatusService, QualityGatesProjectStatusModel> {

    public QualityGatesProjectStatusService(String url, HTTPBasicAuthFilter auth) {
        super(url, auth);
    }

    protected String getPath() {
        return "api/users/groups";
    }

    public QualityGatesProjectStatusModel execute() throws SonarQubeException {
        Gson gson = new Gson();
        ClientResponse clientResponse = RestApi.get(getUrl(), getPath(), getAuth(), getParams());
        String output = clientResponse.getEntity(String.class);
        QualityGatesProjectStatusModel projectStatus = gson.fromJson(output, QualityGatesProjectStatusModel.class);
        return projectStatus;
    }

    public QualityGatesProjectStatusService analysisId(String analysisId){
        getParams().add("analysisId", analysisId);
        return this;
    }

    public QualityGatesProjectStatusService projectId(String projectId){
        getParams().add("projectId", projectId);
        return this;
    }

    public QualityGatesProjectStatusService projectKey(String projectKey){
        getParams().add("projectKey", projectKey);
        return this;
    }

}
