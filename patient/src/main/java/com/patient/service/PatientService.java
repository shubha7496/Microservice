package com.patient.service;

import java.util.List;

import com.patient.entity.Patient;



public interface PatientService {
	
	 Patient savePatient(Patient Patient);

	    Patient getPatientById(Long PatientId);

	    public List<Patient> getAll();
	    }
