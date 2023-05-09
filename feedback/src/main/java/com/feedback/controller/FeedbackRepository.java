package com.feedback.controller;

import org.springframework.data.jpa.repository.JpaRepository;



public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

}
