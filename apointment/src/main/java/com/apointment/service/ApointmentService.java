package com.apointment.service;



import java.util.List;

import org.springframework.http.ResponseEntity;

//import org.springframework.cloud.openfeign.FeignClient;

import com.apointment.entity.Apointment;
import com.apointment.responseDto.ResponseDto;



//@FeignClient(name = "PATIENT-SERVICE")
public interface ApointmentService {
	

	 Apointment create(Apointment Apointment);

	    //get all
	    List<Apointment> getAll();

	    //get single
	    Apointment get(String adminId);
	    
		public Apointment updateApointment(Apointment apointment);

//	 Apointment saveApointment(Apointment Apointment);
//
//	    ResponseDto getApointment(Long apoinmentId);

	    

}
