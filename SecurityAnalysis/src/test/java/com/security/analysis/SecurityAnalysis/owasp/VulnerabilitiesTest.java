package com.security.analysis.SecurityAnalysis.owasp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VulnerabilitiesTest {

    Vulnerabilities testVulnerabilities = new Vulnerabilities();
    private String INFO = "INFO";
    private String MINOR = "MINOR";
    private String MAJOR = "MAJOR";
    private String BLOCKER = "BLOCKER";
    private String CRITICAL = "CRITICAL";
    private String SECURITY_HOTSPOT = "SECURITY_HOTSPOT";
    @BeforeEach
    void setUp() {
        testVulnerabilities.addIssue(INFO);
        testVulnerabilities.addIssue(MINOR);
        testVulnerabilities.addIssue(MAJOR);
        testVulnerabilities.addIssue(BLOCKER);
        testVulnerabilities.addIssue(CRITICAL);
        testVulnerabilities.addIssue(SECURITY_HOTSPOT);
        testVulnerabilities.addIssue(INFO);
        testVulnerabilities.addIssue(MINOR);
    }

    @Test
    void addIssue() {
        testVulnerabilities.addIssue(CRITICAL);
        assertEquals("{INFO=2, MINOR=2, MAJOR=1, BLOCKER=1, CRITICAL=2, SECURITY_HOTSPOTS=1, TOTAL=9}", testVulnerabilities.toString());
    }

}