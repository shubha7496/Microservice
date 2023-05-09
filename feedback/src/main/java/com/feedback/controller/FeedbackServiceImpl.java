package com.feedback.controller;


import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FeedbackServiceImpl implements FeedbackService {
	
	@Autowired
	private FeedbackRepository feedbackRepository;
	
	    @Override
	    public Feedback create(Feedback Feedback) {
	        return feedbackRepository.save(Feedback);
	    }

	    @Override
	    public List<Feedback> getAll() {
	        return feedbackRepository.findAll();
	    }

	    @Override
	    public Feedback get(Long adminId) {
	        return feedbackRepository.findById(adminId).orElseThrow(() -> new ResourceNotFoundException("hotel with given id not found !!"));
	}


}
