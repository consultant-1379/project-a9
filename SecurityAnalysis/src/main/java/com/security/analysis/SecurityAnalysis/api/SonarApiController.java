package com.security.analysis.SecurityAnalysis.api;

import com.security.analysis.SecurityAnalysis.exception.ResourceNotFoundException;
import com.security.analysis.SecurityAnalysis.jsonReader.OwaspParser;
import com.security.analysis.SecurityAnalysis.model.OwaspReportModel;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Base64;
import java.util.HashMap;

@Controller
public class SonarApiController {
    //Ericsson
    //TODO: Hide Token
    private final String tokenBase = "a94dfb0888ab7121c55860f7e436bbc7d55230ad" + ":";
    private final String basicAuthHeader = "Basic " + new String(Base64.getEncoder().encode(tokenBase.getBytes()));
    private final String companyUrl = "https://sonarqube.lmera.ericsson.se/api/issues/search?componentKeys=";

    private ReportController reportService;

    //SonarCloud
    private final String cloudName = "org.xwiki.platform:xwiki-platform";
    private final String cloudUrl = "https://sonarcloud.io/api/issues/search?componentKeys=";


    private String project_name = "eric-hssims-imssubscriptiondata:master";

    @Autowired
    public SonarApiController(ReportController reportService) {
        this.reportService = reportService;
    }

    public OwaspReportModel getOwaspReport(String url, String project_name) throws MalformedURLException {
        HashMap<String, JSONObject> jsonObjectHashMap = new HashMap<>();
        String[] owaspTypes = {"a1", "a2", "a3", "a4", "a5", "a6", "a7", "a8", "a9", "a10"};
        for(String type: owaspTypes)    {
            URL currentUrl = new URL(url + project_name + "&" +
                    "facets=owaspTop10,projects&" +
                    "owaspTop10=" + type + "&" +
                    "types=SECURITY_HOTSPOT,VULNERABILITY"
            );
            jsonObjectHashMap.put(type, performUrlRequest(currentUrl));
        }
        OwaspParser owaspParser = new OwaspParser();

        return owaspParser.parseOWASPDataList(project_name, jsonObjectHashMap);

    }


    @GetMapping(value = "/output", produces = {"application/json"})
    public OwaspReportModel getMetrics(Model model, @RequestParam String project_name) {
        if(project_name.isEmpty()){
            model.addAttribute("reportObj", null);
            return null;
        }
        this.project_name = project_name;

        try {
            OwaspReportModel owasp = getOwaspReport(cloudUrl, project_name);

            if (owasp != null) {
                try {
                    reportService.getReportByProjectName(project_name);
                    reportService.updateReport(project_name, owasp);
                } catch (ResourceNotFoundException e) {
                    reportService.addReport(owasp);
                }
                model.addAttribute("reportObj", owasp);
                return owasp;
            }
            model.addAttribute("reportObj", null);

            } catch(MalformedURLException e){
                System.out.println("new URL() failed");
        }
        return null;
    }


    public JSONObject performUrlRequest(java.net.URL url) {
        try {
            //Url connection object created to set parameters before connecting
            URLConnection urlConnection = url.openConnection();
            if (url.toString().contains(companyUrl))    {
                urlConnection.setRequestProperty("Authorization", basicAuthHeader);
            }

            BufferedReader in = new BufferedReader(new InputStreamReader(
                    urlConnection.getInputStream()));

            //StringBuilder created to store input stream and convert to
            //JSON object later for formatting purposes
            StringBuilder stringBuilder = new StringBuilder();
            String inputLine;

            while ((inputLine = in.readLine()) != null)
                stringBuilder.append(inputLine);
            in.close();

            JSONParser parser = new JSONParser();
            Object obj = parser.parse(stringBuilder.toString());
            JSONObject jsonObject = (JSONObject) obj;
            return jsonObject;

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}

