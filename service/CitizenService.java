package com.cybage.service;

import java.sql.SQLException;
import java.util.List;

import com.cybage.dao.CitizenImpl;
import com.cybage.model.Complaint;
import com.cybage.model.Department;

public class CitizenService {
		CitizenImpl citizenDao;
		public CitizenService() {
			try {
				citizenDao=new CitizenImpl();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		}
		
		public String addComplaint(Complaint complaint) {
			return citizenDao.addComplaint(complaint);
		}
		
		public List<Complaint> complaintList(int id){
			return citizenDao.complaintList(id);
		}
		public List<Department> departmentList(){
			return citizenDao.departmentList();
		}

		public List<Complaint> complaintReminderList(int citizenId) {
			return citizenDao.complaintReminderList(citizenId);
		}

		public String sendReminder(String complaint_id, int id) {
			return citizenDao.sendReminder(complaint_id, id);
		}
		
	
}
