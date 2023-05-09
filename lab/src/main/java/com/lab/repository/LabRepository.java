package com.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lab.entity.Lab;

public interface LabRepository extends JpaRepository<Lab, String> {

}
