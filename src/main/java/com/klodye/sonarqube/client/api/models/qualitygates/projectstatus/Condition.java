package com.klodye.sonarqube.client.api.models.qualitygates.projectstatus;

public class Condition {

    private String status;
    private String metricKey;
    private String comparator;
    private String periodIndex;
    private String errorThreshold;
    private String actualValue;

    public String getStatus() {
        return status;
    }

    public String getMetricKey() {
        return metricKey;
    }

    public String getComparator() {
        return comparator;
    }

    public String getPeriodIndex() {
        return periodIndex;
    }

    public String getErrorThreshold() {
        return errorThreshold;
    }

    public String getActualValue() {
        return actualValue;
    }
}
