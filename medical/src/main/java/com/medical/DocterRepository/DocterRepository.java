package com.medical.DocterRepository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.medical.entity.Docter;

public interface DocterRepository extends JpaRepository<Docter, String> {
	
	

}
