package com.security.analysis.SecurityAnalysis.model;

import com.security.analysis.SecurityAnalysis.jsonReader.IssueData;
import com.security.analysis.SecurityAnalysis.owasp.Vulnerabilities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sonar_projects")
public class OwaspReportModel {
    @Id
    private String projectKey;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "owasp_reports",
            joinColumns = {@JoinColumn(name = "report_id")},
            inverseJoinColumns = {@JoinColumn(name = "vul_id")}
    )
    private List<Vulnerabilities> vulnerabilities = new ArrayList<>();

    public OwaspReportModel() {
        System.out.println("in default");
    }



    public OwaspReportModel(@NotBlank String projectKey, List<IssueData> issueDataList) {
        this.projectKey = projectKey;
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
        for (IssueData issue : issueDataList) {
            switch (issue.getOwaspIssue()) {
                case "a1":
                    a1.addIssue(issue.getData());
                    break;
                case "a2":
                    a2.addIssue(issue.getData());

                    break;
                case "a3":
                    a3.addIssue(issue.getData());

                    break;
                case "a4":
                    a4.addIssue(issue.getData());

                    break;
                case "a5":
                    a5.addIssue(issue.getData());

                    break;
                case "a6":
                    a6.addIssue(issue.getData());

                    break;
                case "a7":
                    a7.addIssue(issue.getData());

                    break;
                case "a8":
                    a8.addIssue(issue.getData());

                    break;
                case "a9":
                    a9.addIssue(issue.getData());

                    break;
                case "a10":
                    a10.addIssue(issue.getData());

                    break;
                default:
                    break;
            }

        }

        this.vulnerabilities.add(a1);
        this.vulnerabilities.add(a2);
        this.vulnerabilities.add(a3);
        this.vulnerabilities.add(a4);
        this.vulnerabilities.add(a5);
        this.vulnerabilities.add(a6);
        this.vulnerabilities.add(a7);
        this.vulnerabilities.add(a8);
        this.vulnerabilities.add(a9);
        this.vulnerabilities.add(a10);
    }

    public String getProjectKey() {
        return projectKey;

    }

    public Vulnerabilities getA1() {
        return vulnerabilities.get(0);
    }

    public Vulnerabilities getA2() {
        return vulnerabilities.get(1);
    }

    public Vulnerabilities getA3() {
        return vulnerabilities.get(2);
    }

    public Vulnerabilities getA4() {
        return vulnerabilities.get(3);
    }

    public Vulnerabilities getA5() {
        return vulnerabilities.get(4);
    }

    public Vulnerabilities getA6() {
        return vulnerabilities.get(5);
    }

    public Vulnerabilities getA7() {
        return vulnerabilities.get(6);
    }

    public Vulnerabilities getA8() {
        return vulnerabilities.get(7);
    }

    public Vulnerabilities getA9() {
        return vulnerabilities.get(8);
    }

    public Vulnerabilities getA10() {
        return vulnerabilities.get(9);
    }

    public void setProjectKey(String projectKey) {
        this.projectKey=projectKey;
    }


    public void setA1(Vulnerabilities a1) {
        this.vulnerabilities.set(0, a1);
    }

    public void setA2(Vulnerabilities a2) {
        this.vulnerabilities.set(1, a2);
    }

    public void setA3(Vulnerabilities a3) {
        this.vulnerabilities.set(2, a3);
    }

    public void setA4(Vulnerabilities a4) {
        this.vulnerabilities.set(3, a4);
    }

    public void setA5(Vulnerabilities a5) {
        this.vulnerabilities.set(4, a5);
    }

    public void setA6(Vulnerabilities a6) {
        this.vulnerabilities.set(5, a6);
    }

    public void setA7(Vulnerabilities a7) {
        this.vulnerabilities.set(6, a7);
    }

    public void setA8(Vulnerabilities a8) {
        this.vulnerabilities.set(7, a8);
    }

    public void setA9(Vulnerabilities a9) {
        this.vulnerabilities.set(8, a9);
    }

    public void setA10(Vulnerabilities a10) {
        this.vulnerabilities.set(9, a10);
    }

    @Override
    public String toString() {

        return projectKey + "{ " +
                "\na1=" + this.getA1() +
                ", \na2=" + this.getA2() +
                ", \na3=" + this.getA3() +
                ", \na4=" + this.getA4() +
                ", \na5=" + this.getA5() +
                ", \na6=" + this.getA6() +
                ", \na7=" + this.getA7() +
                ", \na8=" + this.getA8() +
                ", \na9=" + this.getA9() +
                ", \na10=" + this.getA10() +
                '}';
    }

}
