package com.security.analysis.SecurityAnalysis.api;

import com.security.analysis.SecurityAnalysis.model.OwaspReportModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SonarApiControllerTest {
    private SonarApiController sonarApiController;

    //SonarCloud
    private final String cloudName = "org.xwiki.platform:xwiki-platform";
    private final String cloudUrl = "https://sonarcloud.io/api/issues/search?componentKeys=";



    @BeforeEach
    public void setup(){
        sonarApiController = new SonarApiController(new ReportController());

    }

    @Test
    void getOwaspReport() throws MalformedURLException {
        OwaspReportModel owasp = sonarApiController.getOwaspReport(cloudUrl, cloudName);
        String expected = "org.xwiki.platform:xwiki-platform{ \n" +
                "a1={INFO=0, MINOR=17, MAJOR=0, BLOCKER=16, CRITICAL=0, SECURITY_HOTSPOTS=67, TOTAL=100}, \n" +
                "a2={INFO=0, MINOR=0, MAJOR=0, BLOCKER=0, CRITICAL=0, SECURITY_HOTSPOTS=2, TOTAL=2}, \n" +
                "a3={INFO=0, MINOR=40, MAJOR=0, BLOCKER=0, CRITICAL=0, SECURITY_HOTSPOTS=60, TOTAL=100}, \n" +
                "a4={INFO=0, MINOR=0, MAJOR=0, BLOCKER=15, CRITICAL=0, SECURITY_HOTSPOTS=0, TOTAL=15}, \n" +
                "a5={INFO=0, MINOR=0, MAJOR=0, BLOCKER=23, CRITICAL=0, SECURITY_HOTSPOTS=77, TOTAL=100}, \n" +
                "a6={INFO=0, MINOR=0, MAJOR=0, BLOCKER=0, CRITICAL=1, SECURITY_HOTSPOTS=15, TOTAL=16}, \n" +
                "a7={INFO=0, MINOR=0, MAJOR=0, BLOCKER=1, CRITICAL=3, SECURITY_HOTSPOTS=12, TOTAL=16}, \n" +
                "a8={INFO=0, MINOR=0, MAJOR=0, BLOCKER=0, CRITICAL=0, SECURITY_HOTSPOTS=2, TOTAL=2}, \n" +
                "a9={INFO=0, MINOR=0, MAJOR=0, BLOCKER=0, CRITICAL=0, SECURITY_HOTSPOTS=0, TOTAL=0}, \n" +
                "a10={INFO=0, MINOR=0, MAJOR=0, BLOCKER=0, CRITICAL=0, SECURITY_HOTSPOTS=3, TOTAL=3}}";
        assertEquals(expected, owasp.toString());
    }
}