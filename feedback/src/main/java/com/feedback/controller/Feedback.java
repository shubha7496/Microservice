package com.feedback.controller;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="feedback")
public class Feedback {
	
	
	@Id
	private Long feedbackId;
	private String docterName;
	private String rating;
	private String comments;
	private String adminId;

}
