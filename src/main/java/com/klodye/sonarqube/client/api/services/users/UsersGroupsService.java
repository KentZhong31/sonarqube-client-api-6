package com.klodye.sonarqube.client.api.services.users;

import com.google.gson.Gson;
import com.klodye.sonarqube.client.api.RestApi;
import com.klodye.sonarqube.client.api.Constants;
import com.klodye.sonarqube.client.api.SonarQubeException;
import com.klodye.sonarqube.client.api.models.users.groups.Group;
import com.klodye.sonarqube.client.api.models.users.groups.UsersGroupsModel;
import com.klodye.sonarqube.client.api.services.AbstractService;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

import java.util.*;

public class UsersGroupsService extends AbstractService<UsersGroupsService, List<Group>> {

    public UsersGroupsService(String url, HTTPBasicAuthFilter auth) {
        super(url, auth);
    }

    protected String getPath() {
        return "api/users/groups";
    }

    public List<Group> execute() throws SonarQubeException {
        List<Group> groups = new ArrayList<>();
        Gson gson = new Gson();
        boolean isNotLast;
        int page = 1;
        int ps = 100;
        do{
            getParams().add("p", Integer.toString(page));
            ClientResponse clientResponse = RestApi.get(getUrl(), getPath(), getAuth(), getParams());
            String output = clientResponse.getEntity(String.class);
            UsersGroupsModel groupsModel = gson.fromJson(output, UsersGroupsModel.class);
            groups.addAll(groupsModel.getGroups());
            isNotLast = page * ps < groupsModel.getPaging().getTotal();
            page = groupsModel.getPaging().getTotal();
        }while(isNotLast);

        return groups;
    }

    public UsersGroupsService login(String login){
        getParams().add("login", login);
        return this;
    }

    public UsersGroupsService selected(Constants.Selected selected){
        getParams().add("selected", Constants.selectedMap.get(selected));
        return this;
    }

    public UsersGroupsService query(String query){
        getParams().add("query", query);
        return this;
    }

}
