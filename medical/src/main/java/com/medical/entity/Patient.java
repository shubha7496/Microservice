package com.medical.entity;



public class Patient {
	

	
	public Long getpatientId() {
		return patientId;
	}

	public void setpatientId(Long patientId) {
		this.patientId = patientId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	public String getPatientName() {
		return patientName;
	}



	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}



	public Long getPatientAge() {
		return patientAge;
	}

	public void setPatientAge(Long patientAge) {
		this.patientAge = patientAge;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBloodgroop() {
		return bloodgroop;
	}



	public void setBloodgroop(String bloodgroop) {
		this.bloodgroop = bloodgroop;
	}
	private Long patientId;
	private String password;
	private String patientName;
	private Long patientAge;
	private String gender;
	private String address;
	private String phone;
	private String bloodgroop;
	public Patient(Long patientId, String password, String patientName, Long patientAge, String gender,
			String address, String phone, String bloodgroop) {
		super();
		this.patientId = patientId;
		this.password = password;
		this.patientName = patientName;
		this.patientAge = patientAge;
		this.gender = gender;
		this.address = address;
		this.phone = phone;
		this.bloodgroop = bloodgroop;
	}

	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
}

