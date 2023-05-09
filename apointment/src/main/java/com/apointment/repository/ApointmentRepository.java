package com.apointment.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.apointment.entity.Apointment;


public interface ApointmentRepository extends JpaRepository<Apointment,String> {

}
