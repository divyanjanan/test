package com.cybage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cybage.model.Complaint;
import com.cybage.model.Department;
import com.cybage.utilities.Utility;

public class CitizenImpl implements ICitizen{
	Connection connection;
	PreparedStatement statement;
	
	 public CitizenImpl() throws ClassNotFoundException, SQLException {
			// TODO Auto-generated constructor stub
			connection=Utility.fetchConnection();
			
			System.out.println("Inside UserDao");
		}

	@Override
	public void addComplaint(Complaint complaint) {
		// TODO Auto-generated method stub
		
		try (PreparedStatement preparedStatement = connection.prepareStatement("insert into complaints(cp_details, reg_date, tentative_date, status, dept_id, ct_id,process_date,close_date) values(?,CURRENT_DATE(),ADDDATE(CURRENT_DATE(), INTERVAL 3 DAY),?,?,?,'','')");) {
			preparedStatement.setString(1, complaint.getCpDetails());
			preparedStatement.setString(2, complaint.getStatus());
			preparedStatement.setString(3, complaint.getDeptId());
			preparedStatement.setInt(4, complaint.getCtId());
			int count = preparedStatement.executeUpdate();
			System.out.println(count + " no of rows updated");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	@Override
	public List<Complaint> complaintList(int id) {
		
		List<Complaint> myComplaintList = new ArrayList<>();
		Complaint complaint = null;
		int ctId=id;
		

		try (Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select cp.cp_id,d.dept_name,cp.cp_details,cp.reg_date,cp.status from complaints cp inner join department d on cp.dept_id=d.dept_id where ct_id="+ctId+";");) {
			while (resultSet.next()) {
				System.out.println(ctId);
				complaint= new Complaint();
				complaint.setCpId(resultSet.getInt(1));
				complaint.setDeptId(resultSet.getString(2));
				complaint.setCpDetails(resultSet.getString(3));
				complaint.setRegDate(resultSet.getString(4));
				complaint.setStatus(resultSet.getString(5));
				myComplaintList.add(complaint);
			}
			System.out.println(myComplaintList);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return myComplaintList;
	}
	
	@Override
	public List<Department> departmentList() {
		
		List<Department> departmentList = new ArrayList<>();
		Department department = null;
		try (Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select dept_id,dept_name,email, head from department");) {
			while (resultSet.next()) {
				department = new Department();
				department.setDeptId(resultSet.getInt(1));
				department.setDeptName(resultSet.getString(2));
				department.setDeptEmail(resultSet.getString(3));
				department.setDeptHead(resultSet.getString(4));
				departmentList.add(department);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return departmentList;
	}

	

}
