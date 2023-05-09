package com.feedback.controller;

import java.util.List;


public interface FeedbackService {
	

	 Feedback create(Feedback Feedback);

	    //get all
	    List<Feedback> getAll();

	    //get single
	    Feedback get(Long adminId);
	    


}
