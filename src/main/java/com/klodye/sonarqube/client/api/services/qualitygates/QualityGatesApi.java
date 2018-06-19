package com.klodye.sonarqube.client.api.services.qualitygates;

import com.klodye.sonarqube.client.api.services.AbstractApi;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

public class QualityGatesApi extends AbstractApi{

    public QualityGatesApi(String url, HTTPBasicAuthFilter auth) {
        super(url, auth);
    }

    public QualityGatesProjectStatusService projectStatus() {
        return new QualityGatesProjectStatusService(getUrl(), getAuth());
    }

}
