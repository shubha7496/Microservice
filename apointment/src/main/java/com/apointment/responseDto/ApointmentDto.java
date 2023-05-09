package com.apointment.responseDto;




import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApointmentDto {
	
	private Long id;
	private String patientId;
	private String docterName;
	private String apointmentDate;
	private String apointmentTime;
	private String apointmentDay;
	private String userId;

}
