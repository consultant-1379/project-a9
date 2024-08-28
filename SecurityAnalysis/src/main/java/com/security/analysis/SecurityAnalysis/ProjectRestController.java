package com.security.analysis.SecurityAnalysis;

import com.security.analysis.SecurityAnalysis.api.ReportController;
import com.security.analysis.SecurityAnalysis.exception.ResourceNotFoundException;
import com.security.analysis.SecurityAnalysis.model.OwaspReportModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProjectRestController {

    @Autowired
    private ReportController restController;

    @RequestMapping(value = "/")
    public String getDb(Model model) throws ResourceNotFoundException {
       List<OwaspReportModel> owasp = restController.getAllReports();
       model.addAttribute("obj", owasp);
        return "index";
    }
    @RequestMapping(value = "/owasp_report")
    public String getDbProj(Model model, @RequestParam("owasp_project_name") String project) throws ResourceNotFoundException {
        OwaspReportModel owasp = restController.getReportByProjectName(project).getBody();
        model.addAttribute("reportObj",owasp);
        return "owasp_report";
    }


}