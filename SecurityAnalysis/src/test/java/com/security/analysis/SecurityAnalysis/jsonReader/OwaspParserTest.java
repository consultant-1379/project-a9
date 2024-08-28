

package com.security.analysis.SecurityAnalysis.jsonReader;

import com.security.analysis.SecurityAnalysis.api.ReportController;
import com.security.analysis.SecurityAnalysis.api.SonarApiController;
import com.security.analysis.SecurityAnalysis.model.OwaspReportModel;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class OwaspParserTest {

    SonarApiController sonarApiController;
    OwaspReportModel owasp;
    OwaspReportModel noIssues;


    @BeforeEach
    void setUp() {
        try {
            sonarApiController = new SonarApiController(new ReportController());
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testNoProjectResponse() throws IOException, ParseException {
        OwaspReportModel noProject = sonarApiController.getOwaspReport("https://sonarcloud.io/api/issues/search?componentKeys=", "blahblah123blahnotaproject");
        assertNull(noProject);
    }

    @Test
    void testNoIssuesResponse() throws IOException {
        noIssues = sonarApiController.getOwaspReport("https://sonarcloud.io/api/issues/search?componentKeys=", "simgrid_simgrid");
        String expected = "simgrid_simgrid{ \n" +
                "a1={INFO=0, MINOR=0, MAJOR=0, BLOCKER=0, CRITICAL=0, SECURITY_HOTSPOTS=0, TOTAL=0}, \n" +
                "a2={INFO=0, MINOR=0, MAJOR=0, BLOCKER=0, CRITICAL=0, SECURITY_HOTSPOTS=0, TOTAL=0}, \n" +
                "a3={INFO=0, MINOR=0, MAJOR=0, BLOCKER=0, CRITICAL=0, SECURITY_HOTSPOTS=12, TOTAL=12}, \n" +
                "a4={INFO=0, MINOR=0, MAJOR=0, BLOCKER=0, CRITICAL=0, SECURITY_HOTSPOTS=0, TOTAL=0}, \n" +
                "a5={INFO=0, MINOR=0, MAJOR=0, BLOCKER=0, CRITICAL=0, SECURITY_HOTSPOTS=1, TOTAL=1}, \n" +
                "a6={INFO=0, MINOR=0, MAJOR=0, BLOCKER=0, CRITICAL=0, SECURITY_HOTSPOTS=0, TOTAL=0}, \n" +
                "a7={INFO=0, MINOR=0, MAJOR=0, BLOCKER=0, CRITICAL=0, SECURITY_HOTSPOTS=0, TOTAL=0}, \n" +
                "a8={INFO=0, MINOR=0, MAJOR=0, BLOCKER=0, CRITICAL=0, SECURITY_HOTSPOTS=0, TOTAL=0}, \n" +
                "a9={INFO=0, MINOR=0, MAJOR=0, BLOCKER=0, CRITICAL=0, SECURITY_HOTSPOTS=0, TOTAL=0}, \n" +
                "a10={INFO=0, MINOR=0, MAJOR=0, BLOCKER=0, CRITICAL=0, SECURITY_HOTSPOTS=0, TOTAL=0}}";
        assertEquals(expected, noIssues.toString());
    }

    @Test
    void testResponse() throws MalformedURLException {
        owasp = sonarApiController.getOwaspReport(
                "https://sonarcloud.io/api/issues/search?componentKeys=",
                "org.xwiki.platform:xwiki-platform");

        assertEquals("org.xwiki.platform:xwiki-platform{ \n" +
                "a1={INFO=0, MINOR=17, MAJOR=0, BLOCKER=16, CRITICAL=0, SECURITY_HOTSPOTS=67, TOTAL=100}, \n" +
                "a2={INFO=0, MINOR=0, MAJOR=0, BLOCKER=0, CRITICAL=0, SECURITY_HOTSPOTS=2, TOTAL=2}, \n" +
                "a3={INFO=0, MINOR=40, MAJOR=0, BLOCKER=0, CRITICAL=0, SECURITY_HOTSPOTS=60, TOTAL=100}, \n" +
                "a4={INFO=0, MINOR=0, MAJOR=0, BLOCKER=15, CRITICAL=0, SECURITY_HOTSPOTS=0, TOTAL=15}, \n" +
                "a5={INFO=0, MINOR=0, MAJOR=0, BLOCKER=23, CRITICAL=0, SECURITY_HOTSPOTS=77, TOTAL=100}, \n" +
                "a6={INFO=0, MINOR=0, MAJOR=0, BLOCKER=0, CRITICAL=1, SECURITY_HOTSPOTS=15, TOTAL=16}, \n" +
                "a7={INFO=0, MINOR=0, MAJOR=0, BLOCKER=1, CRITICAL=3, SECURITY_HOTSPOTS=12, TOTAL=16}, \n" +
                "a8={INFO=0, MINOR=0, MAJOR=0, BLOCKER=0, CRITICAL=0, SECURITY_HOTSPOTS=2, TOTAL=2}, \n" +
                "a9={INFO=0, MINOR=0, MAJOR=0, BLOCKER=0, CRITICAL=0, SECURITY_HOTSPOTS=0, TOTAL=0}, \n" +
                "a10={INFO=0, MINOR=0, MAJOR=0, BLOCKER=0, CRITICAL=0, SECURITY_HOTSPOTS=3, TOTAL=3}}", owasp.toString());
    }

}
