package com.security.analysis.SecurityAnalysis.api;

import com.security.analysis.SecurityAnalysis.dao.OwaspReportDao;
import com.security.analysis.SecurityAnalysis.exception.ResourceNotFoundException;
import com.security.analysis.SecurityAnalysis.model.OwaspReportModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/report")
public class ReportController {

    @Autowired
    private OwaspReportDao owaspService;

    @GetMapping("sonar_projects")
    public List<OwaspReportModel> getAllReports() {
        return this.owaspService.findAll();
    }

    @GetMapping("sonar_projects/{projectName}")
    public ResponseEntity<OwaspReportModel> getReportByProjectName(@PathVariable("projectName") String projectName) throws ResourceNotFoundException {

        OwaspReportModel report = this.owaspService.findById(projectName)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found for project key : " + projectName));
        return ResponseEntity.ok().body(report);
    }

    @PostMapping("sonar_projects")
    public OwaspReportModel addReport(@Valid @RequestBody OwaspReportModel report) {
        return this.owaspService.save(report);
    }

    @PutMapping("sonar_projects/{projectName}")
    public ResponseEntity<OwaspReportModel> updateReport(@PathVariable("projectName") String projectName, @Valid @RequestBody OwaspReportModel reportDetails) throws ResourceNotFoundException  {

        OwaspReportModel report = this.owaspService.findById(projectName)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found for project key : " + projectName));

        report.setA1(reportDetails.getA1());
        report.setA2(reportDetails.getA2());
        report.setA3(reportDetails.getA3());
        report.setA4(reportDetails.getA4());
        report.setA5(reportDetails.getA5());
        report.setA6(reportDetails.getA6());
        report.setA7(reportDetails.getA7());
        report.setA8(reportDetails.getA8());
        report.setA9(reportDetails.getA9());
        report.setA10(reportDetails.getA10());

        return ResponseEntity.ok(this.owaspService.save(report));
    }

    @DeleteMapping("sonar_projects/{projectName}")
    public Map<String, Boolean> deleteReport(@PathVariable("projectName") String projectName) throws ResourceNotFoundException {
        OwaspReportModel report = this.owaspService.findById(projectName)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found for project key : " + projectName));

        this.owaspService.delete(report);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;

    }


}
