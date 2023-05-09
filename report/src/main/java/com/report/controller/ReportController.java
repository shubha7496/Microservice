package com.report.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.report.entity.Report;
import com.report.service.ReportService;

@RestController
@RequestMapping("/report")
public class ReportController {
	
	@Autowired
	private ReportService reportService;
	
	    @PostMapping
	    public ResponseEntity<Report> saveReport(@RequestBody Report Report){
	        Report savedReport = reportService.saveReport(Report);
	        return new ResponseEntity<>(savedReport, HttpStatus.CREATED);
	    }

	    @GetMapping("{id}")
	    public ResponseEntity<Report> getReportById(@PathVariable("id") Long ReportId){
	        Report Report = reportService.getReportById(ReportId);
	        return ResponseEntity.ok(Report);
	    }
	    @GetMapping
	    public ResponseEntity<List<Report>> getAll(){
	        return ResponseEntity.ok(reportService.getAll());
	    }

}
