package com.medical.service;

import java.util.List;

import com.medical.entity.Docter;


public interface DocterService {

	 Docter create(Docter Docter);

	    //get all
	    List<Docter> getAll();

	    //get single
	    Docter get(String id);
		public Docter getDocter(String id);


}
