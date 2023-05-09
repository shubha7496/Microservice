package com.history.entity;



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
@Table(name="history")
public class History {
	
	
	@Id
	private Long patientId;
	private String patientDiseases;
	private String treatment;
	private String docterName;
	private String historyDate;
	private String historyTime;
	private String historyDay;

}
