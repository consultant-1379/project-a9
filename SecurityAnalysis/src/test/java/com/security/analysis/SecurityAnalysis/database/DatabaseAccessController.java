package com.security.analysis.SecurityAnalysis.database;

import com.security.analysis.SecurityAnalysis.api.ReportController;
import com.security.analysis.SecurityAnalysis.api.SonarApiController;
import com.security.analysis.SecurityAnalysis.dao.OwaspReportDao;
import com.security.analysis.SecurityAnalysis.exception.ResourceNotFoundException;
import com.security.analysis.SecurityAnalysis.model.OwaspReportModel;
import com.security.analysis.SecurityAnalysis.owasp.Vulnerabilities;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.useRepresentation;

@RunWith(SpringRunner.class)
public class DatabaseAccessController {

    @TestConfiguration
    static class ReportControllerTestContextConfiguration {

        @Bean
        public ReportController reportController() {
            return new ReportController();
        }
    }

    @Autowired
    private ReportController reportController;

    @MockBean
    private OwaspReportDao owaspReportDao;

    private SonarApiController sonarApiController;
    //SonarCloud
    private final String cloudName = "org.xwiki.platform:xwiki-platform";
    private final String cloudUrl = "https://sonarcloud.io/api/issues/search?componentKeys=";
    private OwaspReportModel owaspReportObject;

    @BeforeEach
    public void setUp() throws ResourceNotFoundException, MalformedURLException {

        sonarApiController = new SonarApiController(new ReportController());
        owaspReportObject = sonarApiController.getOwaspReport(cloudUrl, cloudName);

        //reportController.addReport(owaspReportObject);
//        owaspReportObject.getA1().setBLOCKER(5);
//        reportController.updateReport(projectName, owaspReportObject);

        Mockito.when(owaspReportDao.findById(cloudName)).thenReturn(java.util.Optional.of(owaspReportObject));
        Mockito.when(owaspReportObject.getA1().getBLOCKER()).thenReturn(5);

    }

    @Test
    public void canAddAndGetReport() throws ResourceNotFoundException {

        reportController.addReport(owaspReportObject);

        OwaspReportModel found = reportController.getReportByProjectName(cloudName).getBody();

        assertThat(found.getProjectKey()).isEqualTo(cloudName);
    }

    @Test
    public void canUpdateReport() throws ResourceNotFoundException {

        reportController.addReport(owaspReportObject);

        owaspReportObject.getA1().setBLOCKER(5);
        reportController.updateReport(owaspReportObject.getProjectKey(), owaspReportObject);

        assertThat((owaspReportObject.getA1().getBLOCKER())).isEqualTo(5);
    }

    @Test
    public void canRemoveReport() throws ResourceNotFoundException {
        String projectName = "CRUDTest";
        String newProjectName = "UpdatedProjects";
        OwaspReportModel found = reportController.getReportByProjectName(projectName).getBody();
        reportController.updateReport(newProjectName, found);

        assertThat(found.getProjectKey()).isEqualTo(null);
    }

    @Test
    public void canGetOneReport() throws ResourceNotFoundException {
        String projectName = "CRUDTest";

        OwaspReportModel found = reportController.getReportByProjectName(projectName).getBody();

        assertThat(found.getProjectKey()).isEqualTo(projectName);
    }

    @Test
    public void canGetAllReports() throws ResourceNotFoundException {
        String projectName = "CRUDTest";

        OwaspReportModel found = reportController.getReportByProjectName(projectName).getBody();

        assertThat(found.getProjectKey()).isEqualTo(projectName);
    }

    //duplication test

}
