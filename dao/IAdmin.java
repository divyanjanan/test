package com.cybage.dao;

import java.sql.SQLException;
import java.util.List;

import com.cybage.model.Admin;
import com.cybage.model.Citizens;
import com.cybage.model.Complaint;
import com.cybage.model.Department;

public interface IAdmin {
	
	public Admin authenticateAdmin(String email,String password) throws SQLException;
	public Citizens authenticateCitizen(String email,String password) throws SQLException;
	public Department authenticateDept(String email,String password) throws SQLException;
	public String addDepartment(Department department);
	public String removeDepartment(String departmentName);
	public List<Department> departmentList();
	public List<Citizens> citizensList();
	public List<Complaint> complaintList();
	public Department updateDeptList(String department) throws SQLException;
	public String updateDepartment(Department department);

}
