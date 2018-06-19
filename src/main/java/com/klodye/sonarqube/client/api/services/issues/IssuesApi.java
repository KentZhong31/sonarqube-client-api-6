package com.klodye.sonarqube.client.api.services.issues;

import com.klodye.sonarqube.client.api.services.AbstractApi;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

/**
 * Created by klodye on 3/24/2018.
 */
public class IssuesApi extends AbstractApi {

    public IssuesApi(String url, HTTPBasicAuthFilter auth) {
        super(url, auth);
    }


}
