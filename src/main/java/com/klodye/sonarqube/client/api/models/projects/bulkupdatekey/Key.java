package com.klodye.sonarqube.client.api.models.projects.bulkupdatekey;

public class Key {

    String key;
    String newKey;
    Boolean duplicate;

    public String getKey() {
        return key;
    }

    public String getNewKey() {
        return newKey;
    }

    public Boolean getDuplicate() {
        return duplicate;
    }
}
