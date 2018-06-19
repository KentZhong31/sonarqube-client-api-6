package com.klodye.sonarqube.client.api.models.qualitygates.projectstatus;

public class Period {

    private Integer index;
    private String mode;
    private String date;
    private String parameter;

    public Integer getIndex() {
        return index;
    }

    public String getMode() {
        return mode;
    }

    public String getDate() {
        return date;
    }

    public String getParameter() {
        return parameter;
    }
}
