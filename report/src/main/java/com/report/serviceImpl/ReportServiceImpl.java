package com.report.serviceImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.report.entity.Report;
import com.report.exception.ResourceNotFoundException;
import com.report.repository.ReportRepository;
import com.report.service.ReportService;




@Service
public class ReportServiceImpl implements ReportService {
	
	@Autowired
	private ReportRepository reportRepository;
	
	    @Override
	    public Report saveReport(Report Report) {
	        return reportRepository.save(Report);
	    }

	    @Override
	    public Report getReportById(Long ReportId) {
	        return reportRepository.findById(ReportId).get();
	    }
	    
	    @Override
	    public List<Report> getAll() {
	        return reportRepository.findAll();
	    }

}
