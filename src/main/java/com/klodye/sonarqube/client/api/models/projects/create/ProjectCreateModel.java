package com.klodye.sonarqube.client.api.models.projects.create;

import com.klodye.sonarqube.client.api.models.Component;

/**
 * Created by klodye on 3/21/2018.
 */
public class ProjectCreateModel {

    private Component project;

    public Component getProject() {
        return project;
    }
}
