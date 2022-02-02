package com.cybage.service;

import java.sql.SQLException;
import java.util.List;

import com.cybage.dao.DepartmentImpl;
import com.cybage.model.Complaint;

public class DeptService {
		DepartmentImpl deptDao;
		public DeptService() throws ClassNotFoundException, SQLException {
			deptDao=new DepartmentImpl();
				
		}
		
		
		public List<Complaint> complaintList(int id){
			return deptDao.complaintList(id);
		}


		public List<Complaint> complaintFiledList(int deptId) {
			return deptDao.complaintFiledList(deptId);
		}
		
		public List<Complaint> complaintProcessList(int deptId) {
			return deptDao.complaintProcessList(deptId);
		}


		public String updateComplaint(String id) {
			return deptDao.updateComplaint(id);	
		}


		public String changeDept(String id, String dept) {
			return deptDao.changeDept(id, dept);
			
		}


		public List<Complaint> viewReminder(int deptId) {
			return deptDao.viewReminder(deptId);
		}






		
	
}
