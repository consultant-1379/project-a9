package com.security.analysis.SecurityAnalysis.jsonReader;

public class IssueData {
    private String severity;
    private final String owaspIssue;
    private final String type;

    public IssueData(String type, String owaspIssue) {
        this.owaspIssue = owaspIssue;
        this.type = type;
    }

    public IssueData(String type, String owaspIssue, String severity) {
        this.owaspIssue = owaspIssue;
        this.severity = severity;
        this.type = type;
    }

    public String getOwaspIssue() {
        return this.owaspIssue;
    }

    public String getData() {
        if (type.equals("SECURITY_HOTSPOT")) {
            return "SECURITY_HOTSPOT";
        }
        return this.severity;
    }

}

