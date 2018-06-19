package com.klodye.sonarqube.client.api.services.users;

import com.klodye.sonarqube.client.api.services.AbstractApi;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

public class UsersApi extends AbstractApi{

    public UsersApi(String url, HTTPBasicAuthFilter auth) {
        super(url, auth);
    }

    public UsersGroupsService groups() {
        return new UsersGroupsService(getUrl(), getAuth());
    }

}
