package com.cybage.model;

public class Complaint {
	
	private int cpId;
	private String cpDetails;
	private String regDate;
	private String processDate;
	private String closeDate;
	private String status;
	private String tentativeDate;
	private String deptId;
	private int ctId;
	private String ctName;
	private String ctMobile;
	private String ctAddress;
	private String rmDate;
	
	
	public Complaint(String cpDetails, String status, String deptId, int ctId) {
		super();
		this.cpDetails = cpDetails;
		this.status = status;
		this.deptId = deptId;
		this.ctId = ctId;
	}
	
	
	
	
	public String getRmDate() {
		return rmDate;
	}

	public void setRmDate(String rmDate) {
		this.rmDate = rmDate;
	}




	public Complaint() {
		super();
	}



	public String getCtMobile() {
		return ctMobile;
	}



	public void setCtMobile(String ctMobile) {
		this.ctMobile = ctMobile;
	}



	public String getCtAddress() {
		return ctAddress;
	}



	public void setCtAddress(String ctAddress) {
		this.ctAddress = ctAddress;
	}



	public String getCtName() {
		return ctName;
	}

	public void setCtName(String ctName) {
		this.ctName = ctName;
	}

	public int getCpId() {
		return cpId;
	}
	public void setCpId(int cpId) {
		this.cpId = cpId;
	}
	public String getCpDetails() {
		return cpDetails;
	}
	public void setCpDetails(String cpDetails) {
		this.cpDetails = cpDetails;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getProcessDate() {
		return processDate;
	}
	public void setProcessDate(String processDate) {
		this.processDate = processDate;
	}
	public String getCloseDate() {
		return closeDate;
	}
	public void setCloseDate(String closeDate) {
		this.closeDate = closeDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTentativeDate() {
		return tentativeDate;
	}
	public void setTentativeDate(String tentativeDate) {
		this.tentativeDate = tentativeDate;
	}
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public int getCtId() {
		return ctId;
	}
	public void setCtId(int ctId) {
		this.ctId = ctId;
	}
	
	

}
