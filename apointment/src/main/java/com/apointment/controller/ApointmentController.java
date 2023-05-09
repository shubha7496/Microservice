package com.apointment.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.apointment.entity.Apointment;
import com.apointment.responseDto.ResponseDto;
import com.apointment.service.ApointmentService;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
import com.fasterxml.jackson.databind.util.JSONPObject;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/welcome")
public class ApointmentController {
	
	@Autowired
	private ApointmentService apointmentService;
	
	
	@Autowired
	private RestTemplate restTemplate;
	
	    @PostMapping
	    public ResponseEntity<Apointment> create(@RequestBody Apointment Apointment) {
	        return ResponseEntity.status(HttpStatus.CREATED).body(apointmentService.create(Apointment));
	    }

	    @GetMapping("/{id}")
	    public List get(@PathVariable("id")String id) {
			String docterName = restTemplate.exchange("http://localhost:8084/patient/"+id,HttpMethod.GET,null,String.class).getBody();
			String apointmentDay =restTemplate.exchange("http://localhost:8088/docter/"+id,HttpMethod.GET,null,String.class).getBody();
			String apointmentDate =restTemplate.exchange("http://localhost:8083/history/"+id,HttpMethod.GET,null,String.class).getBody();
			String apointmentTime =restTemplate.exchange("http://localhost:8091/test/"+id,HttpMethod.GET,null,String.class).getBody();
			String userId =restTemplate.exchange("http://localhost:8090/report/"+id,HttpMethod.GET,null,String.class).getBody();
			String adminId =restTemplate.exchange("http://localhost:8087/feedback/"+id,HttpMethod.GET,null,String.class).getBody();
			String patientId =restTemplate.exchange("http://localhost:8082/lab/"+id,HttpMethod.GET,null,String.class).getBody();
//			
			Apointment p=new Apointment();	
			List list=new ArrayList<>();
			JsonParser springParser = JsonParserFactory.getJsonParser();
			Map < String, Object > map = springParser.parseMap(docterName);
			Map < String, Object > map1 = springParser.parseMap(apointmentDay);
			Map < String, Object > map2 = springParser.parseMap(apointmentDate);
			Map < String, Object > map3 = springParser.parseMap(apointmentTime);
			Map < String, Object > map4 = springParser.parseMap(userId);
			Map < String, Object > map5 = springParser.parseMap(adminId);
			Map < String, Object > map6 = springParser.parseMap(patientId);

//			String mapArray[] = new String[map.size()];

			list.add(map);
			list.add(map1);
			list.add(map2);
			list.add(map3);
			list.add(map4);
			list.add(map5);
			list.add(map6);			
//	    
//

	        return list;
		}
	    //get all
	    @GetMapping
	    public ResponseEntity<List<Apointment>> getAll(){
	        return ResponseEntity.ok(apointmentService.getAll());
	    }
	    
	    @PutMapping("/update")
		public Apointment updateApointment(@RequestBody Apointment Apointment)
		{
			return this.apointmentService.updateApointment(Apointment);
		}
	
	 
	    
	 
	   

}
