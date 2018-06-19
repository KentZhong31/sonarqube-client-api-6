package com.klodye.sonarqube.client.api.models.issues.search;

public class Comment {

    private String key;
    private String login;
    private String htmlText;
    private String markdown;
    private Boolean updatable;
    private String createdAt;

    public String getKey() {
        return key;
    }

    public String getLogin() {
        return login;
    }

    public String getHtmlText() {
        return htmlText;
    }

    public String getMarkdown() {
        return markdown;
    }

    public Boolean getUpdatable() {
        return updatable;
    }

    public String getCreatedAt() {
        return createdAt;
    }
}
