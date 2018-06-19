package com.klodye.sonarqube.client.api;

import java.util.HashMap;
import java.util.Map;

public class Constants {

    public static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";

    public enum Method {GET, POST}

    public enum Visibilities {PUBLIC, PRIVATE}
    public static Map<Visibilities, String> visibilityMap = new HashMap<Visibilities, String>() {{
        put(Visibilities.PRIVATE,"private");
        put(Visibilities.PUBLIC,"public");
    }};

    public enum Qualifiers {TRK, VW, APP}
    public static Map<Qualifiers, String> qualifiersMap = new HashMap<Qualifiers, String>(){{
        put(Qualifiers.TRK, "TRK");
        put(Qualifiers.VW, "VW");
        put(Qualifiers.APP, "APP");
    }};

    public enum AdditionalFields {_ALL, COMMENTS, LANGUAGES, ACTION_PLANS, RULES, TRANSITIONS, ACTIONS, USERS}
    public static Map<AdditionalFields, String> additionalFieldsMap = new HashMap<AdditionalFields, String>(){{
       put(AdditionalFields._ALL, "_all");
       put(AdditionalFields.COMMENTS, "comments");
       put(AdditionalFields.LANGUAGES, "languages");
       put(AdditionalFields.ACTION_PLANS, "actionPlans");
       put(AdditionalFields.RULES, "rules");
       put(AdditionalFields.TRANSITIONS, "transitions");
       put(AdditionalFields.ACTIONS, "actions");
       put(AdditionalFields.USERS, "users");
    }};

    public enum FacetModes {COUNT, EFFORT, DEBT}
    public static Map<FacetModes, String> facetModesMap = new HashMap<FacetModes, String>() {{
        put(FacetModes.COUNT,"count");
        put(FacetModes.EFFORT,"effort");
        put(FacetModes.DEBT,"debt");
    }};

    public enum Facets {SEVERITIES, STATUSES, RESOLUTIONS, ACTION_PLANS, PROJECT_UUIDS, RULES, ASSIGNEES, ASSIGNED_TO_ME, REPORTERS, AUTHORS, MODULE_UUIDS, FILE_UUIDS, DIRECTORIES, LANGUAGES, TAGS, TYPES, CREATED_AT}
    public static Map<Facets, String> facetsMap = new HashMap<Facets, String>() {{
        put(Facets.SEVERITIES,"severities");
        put(Facets.STATUSES,"statuses");
        put(Facets.RESOLUTIONS,"resolutions");
        put(Facets.ACTION_PLANS,"actionPlans");
        put(Facets.PROJECT_UUIDS,"projectUuids");
        put(Facets.RULES,"rules");
        put(Facets.ASSIGNEES,"assignees");
        put(Facets.ASSIGNED_TO_ME,"assigned_to_me");
        put(Facets.REPORTERS,"reporters");
        put(Facets.AUTHORS,"authors");
        put(Facets.MODULE_UUIDS,"moduleUuids");
        put(Facets.FILE_UUIDS,"fileUuids");
        put(Facets.DIRECTORIES,"directories");
        put(Facets.LANGUAGES,"languages");
        put(Facets.TAGS,"tags");
        put(Facets.TYPES,"types");
        put(Facets.CREATED_AT,"createdAt");
    }};

    public enum Resolutions {FALSE_POSITIVE, WONTFIX, FIXED, REMOVED}
    public static Map<Resolutions, String> resolutionsMap = new HashMap<Resolutions, String>() {{
        put(Resolutions.FALSE_POSITIVE, "FALSE-POSITIVE");
        put(Resolutions.WONTFIX, "WONTFIX");
        put(Resolutions.FIXED, "FIXED");
        put(Resolutions.REMOVED, "REMOVED");
    }};

    public enum SortFields {CREATION_DATE, UPDATE_DATE, CLOSE_DATE, ASSIGNEE, SEVERITY, STATUS, FILE_LINE}
    public static Map<SortFields, String> sortFieldMap = new HashMap<SortFields, String>() {{
        put(SortFields.CREATION_DATE, "CREATION_DATE");
        put(SortFields.UPDATE_DATE, "UPDATE_DATE");
        put(SortFields.CLOSE_DATE, "CLOSE_DATE");
        put(SortFields.ASSIGNEE, "ASSIGNEE");
        put(SortFields.SEVERITY, "SEVERITY");
        put(SortFields.STATUS, "STATUS");
        put(SortFields.FILE_LINE, "FILE_LINE");
    }};

    public enum Severities {INFO, MINOR, MAJOR, CRITICAL, BLOCKER}
    public static Map<Severities, String> severitiesMap = new HashMap<Severities, String>() {{
        put(Severities.INFO, "INFO");
        put(Severities.MINOR, "MINOR");
        put(Severities.MAJOR, "MAJOR");
        put(Severities.CRITICAL, "CRITICAL");
        put(Severities.BLOCKER, "BLOCKER");
    }};

    public enum Statuses {OPEN, CONFIRMED, REOPENED, RESOLVED, CLOSED}
    public static Map<Statuses, String> statusesMap = new HashMap<Statuses, String>() {{
        put(Statuses.OPEN, "OPEN");
        put(Statuses.CONFIRMED, "CONFIRMED");
        put(Statuses.REOPENED, "REOPENED");
        put(Statuses.RESOLVED, "RESOLVED");
        put(Statuses.CLOSED, "CLOSED");
    }};

    public enum Types {CODE_SMELL, BUG, VULNERABILITY}
    public static Map<Types, String> typesMap = new HashMap<Types, String>() {{
        put(Types.CODE_SMELL, "CODE_SMELL");
        put(Types.BUG, "BUG");
        put(Types.VULNERABILITY, "VULNERABILITY");
    }};

    public enum Selected {ALL, DESELECTED, SELECTED}
    public static Map<Selected, String> selectedMap = new HashMap<Selected, String>() {{
        put(Selected.ALL, "all");
        put(Selected.DESELECTED, "deselected");
        put(Selected.SELECTED, "selected");
    }};


}
