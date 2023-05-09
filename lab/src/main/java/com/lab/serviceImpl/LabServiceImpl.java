package com.lab.serviceImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lab.entity.Lab;
import com.lab.excepion.ResourceNotFoundException;
import com.lab.repository.LabRepository;
import com.lab.service.LabService;




@Service
public class LabServiceImpl implements LabService {
	
	@Autowired
	private LabRepository labRepository;
	
	  @Override
	    public Lab create(Lab lab) {
	        return labRepository.save(lab);
	    }

	    @Override
	    public List<Lab> getAll() {
	        return labRepository.findAll();
	    }

	    @Override
	    public Lab get(String labId) {
	        return labRepository.findById(labId).orElseThrow(() -> new ResourceNotFoundException("hotel with given id not found !!"));
	}


}
