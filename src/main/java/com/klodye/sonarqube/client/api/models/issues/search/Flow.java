package com.klodye.sonarqube.client.api.models.issues.search;

import java.util.List;

public class Flow {

    private List<TextRange> locations;
    private String msg;

    public List<TextRange> getLocations() {
        return locations;
    }

    public String getMsg() {
        return msg;
    }
}
