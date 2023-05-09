package com.apointment.serviceImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.apointment.entity.Apointment;
import com.apointment.exception.ResourceNotFoundException;
import com.apointment.repository.ApointmentRepository;
import com.apointment.responseDto.ApointmentDto;
import com.apointment.responseDto.ResponseDto;
import com.apointment.responseDto.UserDto;
import com.apointment.service.ApointmentService;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class ApointmentServiceImpl implements ApointmentService{
	
		@Autowired
		private ApointmentRepository apointmentRepository;
	

		    @Override
		    public Apointment create(Apointment Apointment) {
		     
		        return apointmentRepository.save(Apointment);
		    }

		    @Override
		    public List<Apointment> getAll() {
		        return apointmentRepository.findAll();
		    }

		    @Override
		    public Apointment get(String userId) {
		        return  apointmentRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("hotel with given id not found !!"));
		}
		    @Override
			public Apointment updateApointment(Apointment apointment) {
				 apointmentRepository.save(apointment);
				 
				 return apointment;
			}


	
}
