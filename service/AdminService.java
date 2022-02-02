package com.cybage.service;

import java.sql.SQLException;
import java.util.List;

import com.cybage.dao.AdminImpl;
import com.cybage.model.Admin;
import com.cybage.model.Citizens;
import com.cybage.model.Complaint;
import com.cybage.model.Department;

public class AdminService {
		AdminImpl adminDao;
		public AdminService() {
			try {
				adminDao=new AdminImpl();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		}
		public Admin authenticateAdmin(String email,String password) throws SQLException {
			Admin user=adminDao.authenticateAdmin(email, password);
			return user;
		}
		
		public Citizens authenticateCitizen(String email,String password) throws SQLException {
			Citizens user=adminDao.authenticateCitizen(email, password);
			return user;
		}
		
		public Department authenticateDept(String email,String password) throws SQLException {
			Department user=adminDao.authenticateDept(email, password);
			return user;
		}
		
		public String addDepartment(Department department) {
			return adminDao.addDepartment(department);
		}
		public String removeDepartment(String departmentName) {
			System.out.println(departmentName);
			String deptName=adminDao.removeDepartment(departmentName);
			return deptName;
		}
		public List<Department> departmentList(){
			return adminDao.departmentList();
		}
		public List<Citizens> citizensList(){
			return adminDao.citizensList();
		}
		public List<Complaint> complaintList(){
			return adminDao.complaintList();
		}
		public Department updateDeptList(String department) throws SQLException {
			return adminDao.updateDeptList(department);
		}
		public String updateDepartment(Department department) {
			return adminDao.updateDepartment(department);
			
		}
	
}
