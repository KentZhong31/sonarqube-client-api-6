package com.klodye.sonarqube.client.api.models.users.groups;

import com.google.gson.annotations.SerializedName;

public class Group {

    private int id;
    private String name;
    private String description;
    private Boolean selected;
    @SerializedName("default")
    private Boolean isDefault;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Boolean isSelected() {
        return selected;
    }

    public Boolean isDefault() {
        return isDefault;
    }
}
