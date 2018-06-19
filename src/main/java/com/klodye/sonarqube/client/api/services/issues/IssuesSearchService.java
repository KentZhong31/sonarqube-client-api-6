package com.klodye.sonarqube.client.api.services.issues;

import com.klodye.sonarqube.client.api.Constants;
import com.klodye.sonarqube.client.api.SonarQubeException;
import com.klodye.sonarqube.client.api.services.AbstractService;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import java.security.Timestamp;
import java.util.Arrays;

public class IssuesSearchService extends AbstractService<IssuesSearchService, Object> {

    public IssuesSearchService(String url, HTTPBasicAuthFilter auth) {
        super(url, auth);
    }

    @Override
    protected String getPath() {
        return "api/issues/search";
    }

    @Override
    public Object execute() throws SonarQubeException {
        return null;
    }

    public IssuesSearchService additionalFields(Constants.AdditionalFields... additionalFields) {
        String[] temp = Arrays.stream(additionalFields).map(x->Constants.additionalFieldsMap.get(x)).toArray(String[]::new);
        addCSVParam("additionalFields", temp);
        return this;
    }

    public IssuesSearchService asc(boolean asc) {
        addBooleanParam("asc", asc);
        return this;
    }

    public IssuesSearchService assigned(boolean assigned) {
        addBooleanParam("asc", assigned);
        return this;
    }

    public IssuesSearchService assignees(String... assignees) {
        addCSVParam("assignees", assignees);
        return this;
    }

    public IssuesSearchService authors(String authors) {
        addCSVParam("authors", authors);
        return this;
    }

    public IssuesSearchService componentKeys(String componentKeys) {
        addCSVParam("componentKeys", componentKeys);
        return this;
    }

    public IssuesSearchService createdAfter(Timestamp createdAfter) {
        addDateParam("createdAfter", createdAfter);
        return this;
    }

    public IssuesSearchService createdAt(Timestamp createdAt) {
        addDateParam("createdAt", createdAt);
        return this;
    }

    public IssuesSearchService createdBefore(Timestamp createdBefore) {
        addDateParam("createdBefore", createdBefore);
        return this;
    }

    public IssuesSearchService createdInLast(int years, int months, int weeks, int days) {
        getParams().add("createdInLast", years + "y" + months + "m" + weeks + "w" + days + "d");
        return this;
    }

    public IssuesSearchService facetMode(Constants.FacetModes facetMode) {
        getParams().add("facetMode", Constants.facetModesMap.get(facetMode));
        return this;
    }

    public IssuesSearchService facets(Constants.Facets... facets) {
        String[] temp = Arrays.stream(facets).map(x->Constants.facetsMap.get(x)).toArray(String[]::new);
        addCSVParam("facets", temp);
        return this;
    }

    public IssuesSearchService issues(String... issues) {
        addCSVParam("issues", issues);
        return this;
    }

    public IssuesSearchService languages(String... languages) {
        addCSVParam("languages", languages);
        return this;
    }

    public IssuesSearchService onComponentOnly(boolean onComponentOnly) {
        addBooleanParam("onComponentOnly", onComponentOnly);
        return this;
    }

    public IssuesSearchService resolutions(Constants.Resolutions... resolutions) {
        String[] temp = Arrays.stream(resolutions).map(x->Constants.resolutionsMap.get(x)).toArray(String[]::new);
        addCSVParam("resolutions",  temp);
        return this;
    }

    public IssuesSearchService resolved(boolean resolved) {
        addBooleanParam("resolved", resolved);
        return this;
    }

    public IssuesSearchService rules(String... rules) {
        addCSVParam("rules", rules);
        return this;
    }

    public IssuesSearchService sortField(Constants.SortFields sortField) {
        getParams().add("s", Constants.sortFieldMap.get(sortField));
        return this;
    }

    public IssuesSearchService severities(Constants.Severities... severities) {
        String[] temp = Arrays.stream(severities).map(x->Constants.severitiesMap.get(x)).toArray(String[]::new);
        addCSVParam("severities",  temp);
        return this;
    }

    public IssuesSearchService siceLeakPeriod(boolean siceLeakPeriod) {
        addBooleanParam("siceLeakPeriod", siceLeakPeriod);
        return this;
    }

    public IssuesSearchService statuses(Constants.Statuses... statuses) {
        String[] temp = Arrays.stream(statuses).map(x->Constants.statusesMap.get(x)).toArray(String[]::new);
        addCSVParam("statuses",  temp);
        return this;
    }

    public IssuesSearchService tags(String... tags) {
        addCSVParam("tags", tags);
        return this;
    }

    public IssuesSearchService types(Constants.Types... types) {
        String[] temp = Arrays.stream(types).map(x->Constants.typesMap.get(x)).toArray(String[]::new);
        addCSVParam("types",  temp);
        return this;
    }
}
