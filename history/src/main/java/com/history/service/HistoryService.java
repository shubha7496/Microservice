package com.history.service;

import java.util.List;

import com.history.entity.History;


public interface HistoryService {
	


	    //get all
	    List<History> getAll();

	    //get single
	    
	    History saveHistory(History History);

	    History getHistoryById(Long patientId);
	    


}
