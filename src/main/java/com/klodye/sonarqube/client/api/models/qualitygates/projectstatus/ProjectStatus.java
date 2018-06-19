package com.klodye.sonarqube.client.api.models.qualitygates.projectstatus;

import java.util.List;

public class ProjectStatus {

    private String status;
    private Boolean ignoredConditions;
    private List<Condition> conditions;
    private List<Period> periods;

    public String getStatus() {
        return status;
    }

    public Boolean getIgnoredConditions() {
        return ignoredConditions;
    }

    public List<Condition> getConditions() {
        return conditions;
    }

    public List<Period> getPeriods() {
        return periods;
    }
}
