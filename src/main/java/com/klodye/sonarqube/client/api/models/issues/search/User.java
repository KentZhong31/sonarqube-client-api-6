package com.klodye.sonarqube.client.api.models.issues.search;

public class User {

    private String login;
    private String name;
    private boolean active;
    private String avatar;

    public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return active;
    }

    public String getAvatar() {
        return avatar;
    }
}
