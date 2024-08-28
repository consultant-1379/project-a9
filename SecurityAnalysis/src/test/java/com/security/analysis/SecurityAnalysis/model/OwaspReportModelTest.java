
package com.security.analysis.SecurityAnalysis.model;

import com.security.analysis.SecurityAnalysis.jsonReader.IssueData;
import com.security.analysis.SecurityAnalysis.owasp.Vulnerabilities;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OwaspReportModelTest {
    String exampleProjectName = "testProject";
    OwaspReportModel owasp;


    @BeforeEach
    void setUp() {
        try {
            List<IssueData> issueDataList = new ArrayList<>();
            issueDataList.add(new IssueData("VULNERABILITY", "a1", "INFO"));
            issueDataList.add(new IssueData("VULNERABILITY", "a2", "MINOR"));
            issueDataList.add(new IssueData("VULNERABILITY", "a3", "MAJOR"));
            issueDataList.add(new IssueData("VULNERABILITY", "a4", "CRITICAL"));
            issueDataList.add(new IssueData("VULNERABILITY", "a5", "BLOCKER"));
            issueDataList.add(new IssueData("VULNERABILITY", "a6", "INFO"));
            issueDataList.add(new IssueData("VULNERABILITY", "a7", "INFO"));
            issueDataList.add(new IssueData("VULNERABILITY", "a8", "INFO"));
            issueDataList.add(new IssueData("VULNERABILITY", "a9", "INFO"));
            issueDataList.add(new IssueData("VULNERABILITY", "a10", "INFO"));
            issueDataList.add(new IssueData("SECURITY_HOTSPOT", "a1"));

            owasp = new OwaspReportModel(exampleProjectName, issueDataList);


        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    void testSetters()  {
        Vulnerabilities a1 = new Vulnerabilities();
        Vulnerabilities a2 = new Vulnerabilities();
        Vulnerabilities a3 = new Vulnerabilities();
        Vulnerabilities a4 = new Vulnerabilities();
        Vulnerabilities a5 = new Vulnerabilities();
        Vulnerabilities a6 = new Vulnerabilities();
        Vulnerabilities a7 = new Vulnerabilities();
        Vulnerabilities a8 = new Vulnerabilities();
        Vulnerabilities a9 = new Vulnerabilities();
        Vulnerabilities a10 = new Vulnerabilities();

        owasp.setA1(a1);
        owasp.setA2(a2);
        owasp.setA3(a3);
        owasp.setA4(a4);
        owasp.setA5(a5);
        owasp.setA6(a6);
        owasp.setA7(a7);
        owasp.setA8(a8);
        owasp.setA9(a9);
        owasp.setA10(a10);
        String expected = "testProject{ \n" +
                "a1={INFO=0, MINOR=0, MAJOR=0, BLOCKER=0, CRITICAL=0, SECURITY_HOTSPOTS=0, TOTAL=0}, \n" +
                "a2={INFO=0, MINOR=0, MAJOR=0, BLOCKER=0, CRITICAL=0, SECURITY_HOTSPOTS=0, TOTAL=0}, \n" +
                "a3={INFO=0, MINOR=0, MAJOR=0, BLOCKER=0, CRITICAL=0, SECURITY_HOTSPOTS=0, TOTAL=0}, \n" +
                "a4={INFO=0, MINOR=0, MAJOR=0, BLOCKER=0, CRITICAL=0, SECURITY_HOTSPOTS=0, TOTAL=0}, \n" +
                "a5={INFO=0, MINOR=0, MAJOR=0, BLOCKER=0, CRITICAL=0, SECURITY_HOTSPOTS=0, TOTAL=0}, \n" +
                "a6={INFO=0, MINOR=0, MAJOR=0, BLOCKER=0, CRITICAL=0, SECURITY_HOTSPOTS=0, TOTAL=0}, \n" +
                "a7={INFO=0, MINOR=0, MAJOR=0, BLOCKER=0, CRITICAL=0, SECURITY_HOTSPOTS=0, TOTAL=0}, \n" +
                "a8={INFO=0, MINOR=0, MAJOR=0, BLOCKER=0, CRITICAL=0, SECURITY_HOTSPOTS=0, TOTAL=0}, \n" +
                "a9={INFO=0, MINOR=0, MAJOR=0, BLOCKER=0, CRITICAL=0, SECURITY_HOTSPOTS=0, TOTAL=0}, \n" +
                "a10={INFO=0, MINOR=0, MAJOR=0, BLOCKER=0, CRITICAL=0, SECURITY_HOTSPOTS=0, TOTAL=0}}";
        assertEquals(expected, owasp.toString());

    }


    @Test
    void testToString() {
        String expected = "testProject{ \n" +
                "a1={INFO=1, MINOR=0, MAJOR=0, BLOCKER=0, CRITICAL=0, SECURITY_HOTSPOTS=1, TOTAL=2}, \n" +
                "a2={INFO=0, MINOR=1, MAJOR=0, BLOCKER=0, CRITICAL=0, SECURITY_HOTSPOTS=0, TOTAL=1}, \n" +
                "a3={INFO=0, MINOR=0, MAJOR=1, BLOCKER=0, CRITICAL=0, SECURITY_HOTSPOTS=0, TOTAL=1}, \n" +
                "a4={INFO=0, MINOR=0, MAJOR=0, BLOCKER=0, CRITICAL=1, SECURITY_HOTSPOTS=0, TOTAL=1}, \n" +
                "a5={INFO=0, MINOR=0, MAJOR=0, BLOCKER=1, CRITICAL=0, SECURITY_HOTSPOTS=0, TOTAL=1}, \n" +
                "a6={INFO=1, MINOR=0, MAJOR=0, BLOCKER=0, CRITICAL=0, SECURITY_HOTSPOTS=0, TOTAL=1}, \n" +
                "a7={INFO=1, MINOR=0, MAJOR=0, BLOCKER=0, CRITICAL=0, SECURITY_HOTSPOTS=0, TOTAL=1}, \n" +
                "a8={INFO=1, MINOR=0, MAJOR=0, BLOCKER=0, CRITICAL=0, SECURITY_HOTSPOTS=0, TOTAL=1}, \n" +
                "a9={INFO=1, MINOR=0, MAJOR=0, BLOCKER=0, CRITICAL=0, SECURITY_HOTSPOTS=0, TOTAL=1}, \n" +
                "a10={INFO=1, MINOR=0, MAJOR=0, BLOCKER=0, CRITICAL=0, SECURITY_HOTSPOTS=0, TOTAL=1}}";
        assertEquals(expected, owasp.toString());
    }
}
