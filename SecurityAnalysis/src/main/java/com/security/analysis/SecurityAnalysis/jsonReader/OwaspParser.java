package com.security.analysis.SecurityAnalysis.jsonReader;
import com.security.analysis.SecurityAnalysis.model.OwaspReportModel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.*;

public class OwaspParser {

    public OwaspReportModel parseOWASPDataList(String projectName, HashMap<String, JSONObject> jsonObjectHashMap) {
        if (projectDoesNotExist(jsonObjectHashMap.get("a1"))) return null;
        List<IssueData> issueDataList = new ArrayList<>();
        for (Map.Entry<String, JSONObject> entry : jsonObjectHashMap.entrySet()) {
            String key = entry.getKey();
            JSONObject value = entry.getValue();
            JSONArray issues = (JSONArray) value.get("issues");
            Iterator<JSONObject> issuesIterator = issues.iterator();
            while (issuesIterator.hasNext())    {
                JSONObject current = issuesIterator.next();
                if (current.get("type").toString().equals("SECURITY_HOTSPOT")) {
                    IssueData currentData = new IssueData(current.get("type").toString(), key);
                    issueDataList.add(currentData);
                } else {
                    IssueData currentData = new IssueData(current.get("type").toString(), key, current.get("severity").toString());
                    issueDataList.add(currentData);
                }
            }
        }
        return new OwaspReportModel(projectName, issueDataList);
}


    public OwaspReportModel parseOWASPData (String projectName, JSONObject jsonObject){
        if (projectDoesNotExist(jsonObject)) return null;
        JSONArray issues = (JSONArray) jsonObject.get("issues");
        Iterator<JSONObject> issuesIterator = issues.iterator();
        List<IssueData> issueDataList = new ArrayList<>();
        while (issuesIterator.hasNext()) {
            JSONObject current = issuesIterator.next();
            JSONArray tags = (JSONArray) current.get("tags");
            tags.forEach(tag -> {
                        if (tag.toString().contains("owasp")) {
                            if (current.get("type").toString().equals("SECURITY_HOTSPOT")) {
                                IssueData currentData = new IssueData(current.get("type").toString(), tag.toString());
                                issueDataList.add(currentData);
                            } else {
                                IssueData currentData = new IssueData(current.get("type").toString(), tag.toString(), current.get("severity").toString());
                                issueDataList.add(currentData);
                            }
                        }
                    }
            );
        }


        return new OwaspReportModel(projectName, issueDataList);
    }
    private Boolean projectDoesNotExist (JSONObject jsonObject){
        JSONArray facets = (JSONArray) jsonObject.get("facets");
        JSONObject projects = (JSONObject) facets.get(1);
        JSONArray projectValues = (JSONArray) projects.get("values");
        if (projectValues.size() == 0) {
            System.out.println("Project does not exist");
            return true;
        }
        return false;
    }
}
