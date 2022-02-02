package com.cybage.dao;

import java.util.List;

import com.cybage.model.Complaint;

public interface IDepartment {
	
	
	public List<Complaint> complaintList(int id);

	List<Complaint> complaintFiledList(int id);

	List<Complaint> complaintProcessList(int id);

	String updateComplaint(String id);

	String changeDept(String id, String dept);

	List<Complaint> viewReminder(int id);



}
