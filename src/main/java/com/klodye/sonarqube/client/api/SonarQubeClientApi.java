package com.klodye.sonarqube.client.api;

import com.klodye.sonarqube.client.api.services.issues.IssuesApi;
import com.klodye.sonarqube.client.api.services.projects.ProjectsApi;
import com.klodye.sonarqube.client.api.services.qualitygates.QualityGatesApi;
import com.klodye.sonarqube.client.api.services.users.UsersApi;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

/**
 * Entry point to SonarQube Client API providing all available kind
 * // TODO finish
 *
 */
public class SonarQubeClientApi {

    private final String url;
    private final HTTPBasicAuthFilter auth;

    private ProjectsApi projectsApi;
    private UsersApi usersApi;
    private IssuesApi issuesApi;
    private QualityGatesApi qualityGatesApi;

    public SonarQubeClientApi(String url, String login, String password) {
        this.url = url;
        this.auth = new HTTPBasicAuthFilter(login, password);
    }

    public SonarQubeClientApi(String url, String securityToken) {
        this.url = url;
        this.auth = new HTTPBasicAuthFilter(securityToken, "");
    }

    public ProjectsApi getProjectsApi(){
        if(this.projectsApi == null){
            this.projectsApi = new ProjectsApi(url, auth);
        }
        return this.projectsApi;
    }

    public UsersApi getUsersApi(){
        if(this.usersApi == null){
            this.usersApi = new UsersApi(url, auth);
        }
        return this.usersApi;
    }

    public IssuesApi getIssuesApi(){
        if(this.issuesApi == null){
            this.issuesApi = new IssuesApi(url, auth);
        }
        return this.issuesApi;
    }


    public QualityGatesApi getQualityGatesApi(){
        if(this.qualityGatesApi == null){
            this.qualityGatesApi = new QualityGatesApi(url, auth);
        }
        return this.qualityGatesApi;
    }


}
