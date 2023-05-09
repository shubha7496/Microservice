package com.lab.controller;

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

import com.lab.entity.Lab;
import com.lab.service.LabService;

@RestController
@RequestMapping("/lab")
public class LabController {
	
	@Autowired
	private LabService labService;
	
	   @PostMapping
	    public ResponseEntity<Lab> createLab(@RequestBody Lab Lab) {
	        return ResponseEntity.status(HttpStatus.CREATED).body(labService.create(Lab));
	    }

	    @GetMapping("/{LabId}")
	    public ResponseEntity<Lab> createLab(@PathVariable String LabId) {
	        return ResponseEntity.status(HttpStatus.OK).body(labService.get(LabId));
	    }

	    @GetMapping
	    public ResponseEntity<List<Lab>> getAll(){
	        return ResponseEntity.ok(labService.getAll());
	    }
	   

}
