package com.klodye.sonarqube.client.api.models.users.groups;

import com.klodye.sonarqube.client.api.models.Paging;

import java.util.List;

/**
 * Created by klodye on 3/28/2018.
 */
public class UsersGroupsModel {

    private Paging paging;
    private List<Group> groups;

    public Paging getPaging() {
        return paging;
    }

    public List<Group> getGroups() {
        return groups;
    }
}
