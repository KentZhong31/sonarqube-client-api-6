package com.klodye.sonarqube.client.api.models.issues.search;

/**
 * Created by klodye on 3/24/2018.
 */
public class Rule {

    private String key;
    private String name;
    private String status;
    private String java;
    private String langName;

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public String getJava() {
        return java;
    }

    public String getLangName() {
        return langName;
    }
}
