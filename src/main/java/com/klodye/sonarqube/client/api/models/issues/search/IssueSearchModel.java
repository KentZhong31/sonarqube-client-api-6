package com.klodye.sonarqube.client.api.models.issues.search;

import com.klodye.sonarqube.client.api.models.Component;
import com.klodye.sonarqube.client.api.models.Paging;

import java.util.List;

public class IssueSearchModel {

    private Paging paging;
    private List<Issue> issues;
    private List<Component> components;
    private List<Rule> rules;
    private List<User> users;

    public Paging getPaging() {
        return paging;
    }

    public List<Issue> getIssues() {
        return issues;
    }

    public List<Component> getComponents() {
        return components;
    }

    public List<Rule> getRules() {
        return rules;
    }

    public List<User> getUsers() {
        return users;
    }
}
