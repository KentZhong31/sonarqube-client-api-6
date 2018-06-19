package com.klodye.sonarqube.client.api.models.issues.search;


public class TextRange {

    private int startLine;
    private int endLine;
    private int startOffset;
    private int endOffset;

    public int getStartLine() {
        return startLine;
    }

    public int getEndLine() {
        return endLine;
    }

    public int getStartOffset() {
        return startOffset;
    }

    public int getEndOffset() {
        return endOffset;
    }
}
