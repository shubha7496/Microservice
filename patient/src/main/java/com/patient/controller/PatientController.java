package com.patient.controller;

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

import com.patient.entity.Patient;
import com.patient.service.PatientService;



@RestController
@RequestMapping("/patient")
//@CrossOrigin("*")
public class PatientController {

	@Autowired
	private PatientService patientService;

//	    @PostMapping
//	    public ResponseEntity<Patient> savePatient(@RequestBody Patient Patient){
//	        Patient savedPatient = patientService.savePatient(Patient);
//	        return new ResponseEntity<>(savedPatient, HttpStatus.CREATED);
//	    }

	    @GetMapping("{id}")
	    public ResponseEntity<Patient> getPatientById(@PathVariable("id") Long PatientId){
	        Patient Patient = patientService.getPatientById(PatientId);
	        return ResponseEntity.ok(Patient);
	    }
	    
	    @GetMapping
	    public ResponseEntity<List<Patient>> getAll(){
	        return ResponseEntity.ok(patientService.getAll());
	    }
	   

	} 
	

