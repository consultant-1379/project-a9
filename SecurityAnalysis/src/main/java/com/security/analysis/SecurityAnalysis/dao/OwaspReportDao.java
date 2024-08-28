package com.security.analysis.SecurityAnalysis.dao;

import com.security.analysis.SecurityAnalysis.model.OwaspReportModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwaspReportDao extends JpaRepository<OwaspReportModel, String> {

}
