package com.medical.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="docter")
public class Docter {
	
//	@Transient
//	List<Patient> patients=new ArrayList<>();



	@Id
	private String docterId;
	private String password;
	private String Doctername;
	private String phone;
	private String qualification;
	private String specilization;


	
	
	

	

}
