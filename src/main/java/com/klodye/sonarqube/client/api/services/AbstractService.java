package com.klodye.sonarqube.client.api.services;

import com.klodye.sonarqube.client.api.Constants;
import com.klodye.sonarqube.client.api.SonarQubeException;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import javax.ws.rs.core.MultivaluedMap;
import java.security.Timestamp;
import java.text.SimpleDateFormat;

public abstract class AbstractService<T, S>{

    private final String url;
    private final HTTPBasicAuthFilter auth;
    private MultivaluedMap<String, String> params = new MultivaluedMapImpl();

    public AbstractService(String url, HTTPBasicAuthFilter auth) {
        this.url = url;
        this.auth = auth;
    }

    protected String getUrl() {
        return url;
    }

    protected HTTPBasicAuthFilter getAuth() {
        return auth;
    }

    public T addCustomParam(String key, String value){
        params.add(key, value);
        return (T)this;
    }

    protected void addBooleanParam(String key, boolean value){
        params.add(key, Boolean.toString(value));
    }

    protected void addDateParam(String key, Timestamp timestamp){
        if(timestamp != null){
            params.add(key, new SimpleDateFormat(Constants.DATE_FORMAT).format(timestamp));
        }
    }

    protected void addCSVParam(String key, String... value){
        params.add(key, String.join(",", value));
    }

    protected MultivaluedMap<String, String> getParams(){
        return this.params;
    }

    protected abstract String getPath();
    public abstract S execute() throws SonarQubeException;

}
