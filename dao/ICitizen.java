package com.cybage.dao;

import java.util.List;

import com.cybage.model.Complaint;
import com.cybage.model.Department;

public interface ICitizen {
	

	String addComplaint(Complaint complaint);

	List<Complaint> complaintList(int id);
	public List<Department> departmentList();

	List<Complaint> complaintReminderList(int citizenId);

	public String sendReminder(String complaint_id, int id);


}
