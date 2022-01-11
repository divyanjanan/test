package com.cybage.model;

public class Department {
	private int deptId;
	private String deptName;
	private String deptHead;
	private String deptEmail;
	private String deptPassword;
	private int adminId;
	public Department() {
		
	}
	public Department(String deptName, String deptHead, String deptEmail, String deptPassword,
			int adminId) {
		super();
		this.deptName = deptName;
		this.deptHead = deptHead;
		this.deptEmail = deptEmail;
		this.deptPassword = deptPassword;
		this.adminId = adminId;
	}
	
	
	public Department(int deptId, String deptEmail, String deptHead) {
		super();
		this.deptId = deptId;
		this.deptEmail = deptEmail;
		this.deptHead = deptHead;
	}
	
	
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getDeptHead() {
		return deptHead;
	}
	public void setDeptHead(String deptHead) {
		this.deptHead = deptHead;
	}
	public String getDeptEmail() {
		return deptEmail;
	}
	public void setDeptEmail(String deptEmail) {
		this.deptEmail = deptEmail;
	}
	public String getDeptPassword() {
		return deptPassword;
	}
	public void setDeptPassword(String deptPassword) {
		this.deptPassword = deptPassword;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName + ", deptHead=" + deptHead + ", deptEmail="
				+ deptEmail + ", deptPassword=" + deptPassword + ", adminId=" + adminId + "]";
	}
	
	
}
