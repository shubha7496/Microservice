package com.feedback.controller;

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



@RestController
@RequestMapping("/feedback")
public class FeedbackController {
	
	@Autowired
	private FeedbackService feedbackService;
	
	    @PostMapping
	    public ResponseEntity<Feedback> createFeedback(@RequestBody Feedback feedback) {
	        return ResponseEntity.status(HttpStatus.CREATED).body(feedbackService.create(feedback));
	    }


	    //get single
	  //  @PreAuthorize("hasAuthority('SCOPE_internal')")
//	    @GetMapping("{id}")
//	    public ResponseEntity<Feedback> createFeedback(@PathVariable("id") String adminId) {
//	        return ResponseEntity.status(HttpStatus.OK).body(feedbackService.get(adminId));
//	    }
	    @GetMapping("{id}")
	    public ResponseEntity<Feedback> createFeedback(@PathVariable("id") Long adminId ){
	        Feedback feedback = feedbackService.get(adminId);
	        return ResponseEntity.ok(feedback);
	    }


	    //get all
	  //  @PreAuthorize("hasAuthority('SCOPE_internal') || hasAuthority('Feedback')")
	    @GetMapping
	    public ResponseEntity<List<Feedback>> getAll(){
	        return ResponseEntity.ok(feedbackService.getAll());
	    }
	   

}
