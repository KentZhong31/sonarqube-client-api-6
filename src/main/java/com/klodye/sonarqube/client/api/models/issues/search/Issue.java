package com.klodye.sonarqube.client.api.models.issues.search;

import java.util.List;
import java.util.Map;

public class Issue {

    private String key;
    private String component;
    private String project;
    private String rule;
    private String status;
    private String resolution;
    private String severity;
    private String message;
    private int line;
    private String hash;
    private String author;
    private String effort;
    private String creationDate;
    private String updateDate;
    private List<String> tags;
    private String type;
    private List<Comment> comments;
    private Map<String, String> attr;
    private List<String> transitions;
    private List<String> actions;
    private TextRange textRange;
    private List<Flow> flows;

    public String getKey() {
        return key;
    }

    public String getComponent() {
        return component;
    }

    public String getProject() {
        return project;
    }

    public String getRule() {
        return rule;
    }

    public String getStatus() {
        return status;
    }

    public String getResolution() {
        return resolution;
    }

    public String getSeverity() {
        return severity;
    }

    public String getMessage() {
        return message;
    }

    public int getLine() {
        return line;
    }

    public String getHash() {
        return hash;
    }

    public String getAuthor() {
        return author;
    }

    public String getEffort() {
        return effort;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public List<String> getTags() {
        return tags;
    }

    public String getType() {
        return type;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public Map<String, String> getAttr() {
        return attr;
    }

    public List<String> getTransitions() {
        return transitions;
    }

    public List<String> getActions() {
        return actions;
    }

    public TextRange getTextRange() {
        return textRange;
    }

    public List<Flow> getFlows() {
        return flows;
    }
}
