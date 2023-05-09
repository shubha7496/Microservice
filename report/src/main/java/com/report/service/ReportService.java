package com.report.service;

import java.util.List;

import com.report.entity.Report;




public interface ReportService {
	

	 Report saveReport(Report Report);

	    Report getReportById(Long ReportId);
	    
	    List<Report> getAll();



}
