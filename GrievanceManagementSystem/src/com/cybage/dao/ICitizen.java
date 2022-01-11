package com.cybage.dao;

import java.util.List;

import com.cybage.model.Complaint;
import com.cybage.model.Department;

public interface ICitizen {
	

	void addComplaint(Complaint complaint);

	List<Complaint> complaintList(int id);
	public List<Department> departmentList();


}
