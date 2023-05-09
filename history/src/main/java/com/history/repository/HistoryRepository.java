package com.history.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.history.entity.History;



public interface HistoryRepository extends JpaRepository<History, Long> {

}
