package com.cybage.model;

public class Citizens 
{
	private int citizenId;
	private String name;
	private String email;
	private String password;
	private String mobile;
	private String aadhaar;
	private String address;
	private String gender;
	
public Citizens() {
	// TODO Auto-generated constructor stub
}

public Citizens(int citizenId, String name, String email, String password, String mobile, String aadhaar, String address,
		String gender) {
	super();
	this.citizenId = citizenId;
	this.name = name;
	this.email = email;
	this.password = password;
	this.mobile = mobile;
	this.aadhaar = aadhaar;
	this.address = address;
	this.gender = gender;
}



public Citizens(int citizenId, String name, String email) {
	super();
	this.citizenId = citizenId;
	this.name = name;
	this.email = email;
}

public int getCitizenId() {
	return citizenId;
}

public void setCitizenId(int citizenId) {
	this.citizenId = citizenId;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getMobile() {
	return mobile;
}

public void setMobile(String mobile) {
	this.mobile = mobile;
}

public String getAadhaar() {
	return aadhaar;
}

public void setAadhaar(String aadhaar) {
	this.aadhaar = aadhaar;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getGender() {
	return gender;
}

public void setGender(String gender) {
	this.gender = gender;
}

@Override
public String toString() {
	return "Citizens [citizenId=" + citizenId + ", name=" + name + ", email=" + email + ", password=" + password + ", mobile="
			+ mobile + ", aadhaar=" + aadhaar + ", address=" + address + ", gender=" + gender + "]";
}


	
}
