package com.history.controller;

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

import com.history.entity.History;
import com.history.service.HistoryService;


@RestController
@RequestMapping("/history")
public class HistoryController {
	
	@Autowired
	private HistoryService historyService;
	
	    @PostMapping
	    public ResponseEntity<History> savehistory(@RequestBody History history) {
	        return ResponseEntity.status(HttpStatus.CREATED).body(historyService.saveHistory(history));
	    }


	    //get single
	  //  @PreAuthorize("hasAuthority('SCOPE_internal')")
	    @GetMapping("/{patientId}")
	    public ResponseEntity<History> getHistoryById(@PathVariable Long patientId) {
	        return ResponseEntity.status(HttpStatus.OK).body(historyService.getHistoryById(patientId));
	    }


	    //get all
	  //  @PreAuthorize("hasAuthority('SCOPE_internal') || hasAuthority('history')")
	    @GetMapping
	    public ResponseEntity<List<History>> getAll(){
	        return ResponseEntity.ok(historyService.getAll());
	    }
	   

}
