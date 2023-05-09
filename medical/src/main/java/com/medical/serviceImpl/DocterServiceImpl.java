package com.medical.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medical.DocterRepository.DocterRepository;
import com.medical.entity.Docter;
import com.medical.exception.ResourceNotFoundException;
import com.medical.service.DocterService;



@Service
public class DocterServiceImpl  implements DocterService{
	
	@Autowired
	private DocterRepository docterrepository;
	
	

	List<Docter> list=new ArrayList<>() ;
	@Override
	public Docter create(Docter Docter) {
		return docterrepository.save(Docter);
	}
	@Override
	public List<Docter> getAll() {
		return docterrepository.findAll();
	}

	@Override
	public Docter get(String id) {
		// TODO Auto-generated method stub
		return  docterrepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Docter with given id not found !!"));
	}
	@Override
	public Docter getDocter(String id) {
		// TODO Auto-generated method stub
	return list.stream().filter(user ->user.getDocterId().equals(id)).findAny().orElse(null);

	}
	


}
