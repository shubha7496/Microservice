package com.patient.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patient.entity.Patient;
import com.patient.repository.Patientrepository;
import com.patient.resourcenotfoundexception.ResourceNotFoundException;
import com.patient.service.PatientService;

@Service
public class ServiceImpl implements PatientService {
	
	@Autowired
	private  Patientrepository patientrepository;

	    @Override
	    public Patient savePatient(Patient Patient) {
	        return patientrepository.save(Patient);
	    }

	    @Override
	    public Patient getPatientById(Long PatientId) {
	        return patientrepository.findById(PatientId).get();
	    }

		@Override
		public List<Patient> getAll() {
			// TODO Auto-generated method stub
	        return patientrepository.findAll();
		}

	  
}