package com.security.analysis.SecurityAnalysis.owasp;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.security.analysis.SecurityAnalysis.model.OwaspReportModel;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "vulnerabilities")
public class Vulnerabilities {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "vulnerabilities")

    private Set<OwaspReportModel> reports = new HashSet<>();
    private int INFO = 0;
    private int MINOR = 0;
    private int MAJOR = 0;
    private int BLOCKER = 0;
    private int CRITICAL = 0;
    private int SECURITY_HOTSPOTS = 0;
    private int TOTAL = 0;


    public void addIssue(String issue) {
        switch (issue) {
            case "INFO":
                this.INFO++;
                this.TOTAL++;
                break;
            case "MINOR":
                this.MINOR++;
                this.TOTAL++;
                break;
            case "MAJOR":
                this.MAJOR++;
                this.TOTAL++;
                break;
            case "BLOCKER":
                this.BLOCKER++;
                this.TOTAL++;
                break;
            case "CRITICAL":
                this.CRITICAL++;
                this.TOTAL++;
                break;
            case "SECURITY_HOTSPOT":
                this.SECURITY_HOTSPOTS++;
                this.TOTAL++;
            default:
                break;
        }

    }

    public String getRating()   {
        if (getCRITICAL() > 0)  {
            return "E";
        } else if (getBLOCKER() > 0)    {
            return "D";
        } else if (getMAJOR() > 0)  {
            return "C";
        } else if (getMINOR() > 0)  {
            return "B";
        }
        return "A";
    }


    public int getINFO(){
        return INFO;
    }

    public int getBLOCKER() {
        return BLOCKER;
    }

    public int getMINOR() {
        return MINOR;
    }

    public int getMAJOR() {
        return MAJOR;
    }

    public int getCRITICAL() {
        return CRITICAL;
    }



    @JsonSetter("BLOCKER")
    public void setBLOCKER(int BLOCKER) {
        this.BLOCKER = BLOCKER;
    }

    @JsonSetter("CRITICAL")
    public void setCRITICAL(int CRITICAL) {
        this.CRITICAL = CRITICAL;
    }

    @JsonSetter("INFO")
    public void setINFO(int INFO) {
        this.INFO = INFO;
    }

    @JsonSetter("MAJOR")
    public void setMAJOR(int MAJOR) {
        this.MAJOR = MAJOR;
    }

    @JsonSetter("MINOR")
    public void setMINOR(int MINOR) {
        this.MINOR = MINOR;
    }

    @Override
    public String toString() {
        return "{INFO=" + getINFO() +
                ", MINOR=" + getMINOR() +
                ", MAJOR=" + getMAJOR() +
                ", BLOCKER=" + getBLOCKER() +
                ", CRITICAL=" + getCRITICAL() +
                ", SECURITY_HOTSPOTS=" + getSECURITY_HOTSPOTS() +
                ", TOTAL=" + TOTAL +
                '}';
    }

    public int getSECURITY_HOTSPOTS() {
        return SECURITY_HOTSPOTS;
    }
}


