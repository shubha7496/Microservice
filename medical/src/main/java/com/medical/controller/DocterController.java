package com.medical.controller;

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
import org.springframework.web.client.RestTemplate;

import com.medical.entity.Docter;
import com.medical.service.DocterService;


@RestController
@RequestMapping("/docter")
public class DocterController {

	@Autowired
	private DocterService docterService;
	
	
	@Autowired
	private RestTemplate restTemplate;
	
    @PostMapping
    public ResponseEntity<Docter> createDocter(@RequestBody Docter Docter) {
        return ResponseEntity.status(HttpStatus.CREATED).body(docterService.create(Docter));
    }


    //get single
    @GetMapping("/{DocterId}")
    public ResponseEntity<Docter> createDocter(@PathVariable String DocterId) {
        return ResponseEntity.status(HttpStatus.OK).body(docterService.get(DocterId));
    }


    //get all
    @GetMapping
    public ResponseEntity<List<Docter>> getAll(){
        return ResponseEntity.ok(docterService.getAll());
    }
    

	
}
