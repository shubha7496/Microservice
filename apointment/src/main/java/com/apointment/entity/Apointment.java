package com.apointment.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Entity
@Builder
@Table(name="apointment")
public class Apointment {
	
	@Override
	public String toString() {
		return "Apointment [adminId=" + adminId + ", id=" + id + ", patientId=" + patientId + ", docterName="
				+ docterName + ", apointmentDate=" + apointmentDate + ", apointmentTime=" + apointmentTime
				+ ", apointmentDay=" + apointmentDay + ", userId=" + userId + "]";
	}
	@Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
	private String adminId;
	private Long id;
	private String patientId;
	private String docterName;
	private String apointmentDate;
	private String apointmentTime;
	private String apointmentDay;
    @Column(nullable = false, unique = true)
	private String userId;





}
