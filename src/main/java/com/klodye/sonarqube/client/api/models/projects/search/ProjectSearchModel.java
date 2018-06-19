package com.klodye.sonarqube.client.api.models.projects.search;

import com.klodye.sonarqube.client.api.models.Component;
import com.klodye.sonarqube.client.api.models.Paging;

import java.util.List;

/**
 * Created by klodye on 3/19/2018.
 */
public class ProjectSearchModel {

    private Paging paging;
    private List<Component> components;

    public Paging getPaging() {
        return paging;
    }

    public List<Component> getComponents() {
        return components;
    }
}
