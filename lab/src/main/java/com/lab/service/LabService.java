package com.lab.service;

import java.util.List;

import com.lab.entity.Lab;



public interface LabService {
	

	 Lab create(Lab lab);

	    //get all
	    List<Lab> getAll();

	    //get single
	    Lab get(String id);
	    


}
