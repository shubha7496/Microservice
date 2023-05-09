package com.report.entity;

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
@Table(name="report")
public class Report {
	
	@Id
	private Long id;
	private String patientId;
	private String report;
	private String result;
	private String docterName;
	private String date;
	private String time;
	private String day;


}
