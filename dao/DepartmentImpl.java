package com.cybage.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cybage.model.Complaint;
import com.cybage.utilities.Utility;


public class DepartmentImpl implements IDepartment{
	
	Connection connection;
	PreparedStatement statement;
	
	 public DepartmentImpl() throws ClassNotFoundException, SQLException {
			// TODO Auto-generated constructor stub
			connection=Utility.fetchConnection();
		}
	


	@Override
	public List<Complaint> complaintList(int id) {
		List<Complaint> complaintList = new ArrayList<>();
		Complaint complaint = null;
		try (Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select cp.cp_id,c.ct_name, c.ct_mobile, c.ct_address, cp.cp_details,cp.reg_date,cp.status from complaints cp inner join citizen c on cp.ct_id =c.ct_id where dept_id="+id+";");) {
			while (resultSet.next()) {
				complaint= new Complaint();
				complaint.setCpId(resultSet.getInt(1));
				complaint.setCtName(resultSet.getString(2));
				complaint.setCtMobile(resultSet.getString(3));
				complaint.setCtAddress(resultSet.getString(4));
				complaint.setCpDetails(resultSet.getString(5));
				complaint.setRegDate(resultSet.getString(6));
				complaint.setStatus(resultSet.getString(7));
				complaintList.add(complaint);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return complaintList;
	}

	
	@Override
	public List<Complaint> complaintFiledList(int id) {
		List<Complaint> complaintList = new ArrayList<>();
		Complaint complaint = null;
		try (Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select cp.cp_id,c.ct_name, c.ct_mobile, c.ct_address, cp.cp_details,cp.reg_date,cp.status from complaints cp inner join citizen c on cp.ct_id =c.ct_id where status='Filed' and dept_id="+id+";");) {
			while (resultSet.next()) {
				complaint= new Complaint();
				complaint.setCpId(resultSet.getInt(1));
				complaint.setCtName(resultSet.getString(2));
				complaint.setCtMobile(resultSet.getString(3));
				complaint.setCtAddress(resultSet.getString(4));
				complaint.setCpDetails(resultSet.getString(5));
				complaint.setRegDate(resultSet.getString(6));
				complaint.setStatus(resultSet.getString(7));
				complaintList.add(complaint);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return complaintList;
	}
	
	@Override
	public List<Complaint> complaintProcessList(int id) {
		List<Complaint> complaintList = new ArrayList<>();
		Complaint complaint = null;
		try (Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select cp.cp_id,c.ct_name, c.ct_mobile, c.ct_address, cp.cp_details,cp.reg_date,cp.status from complaints cp inner join citizen c on cp.ct_id =c.ct_id where status='Processing' and dept_id="+id+";");) {
			while (resultSet.next()) {
				complaint= new Complaint();
				complaint.setCpId(resultSet.getInt(1));
				complaint.setCtName(resultSet.getString(2));
				complaint.setCtMobile(resultSet.getString(3));
				complaint.setCtAddress(resultSet.getString(4));
				complaint.setCpDetails(resultSet.getString(5));
				complaint.setRegDate(resultSet.getString(6));
				complaint.setStatus(resultSet.getString(7));
				complaintList.add(complaint);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return complaintList;
	}


	@Override
	public String updateComplaint(String id) {
		
		try (PreparedStatement preparedStatement = connection.prepareStatement("update complaints set process_date=if(status='Filed',CURRENT_DATE(), process_date), close_date=if(status='Processing',CURRENT_DATE(), close_date), status=case when status='Filed' then 'Processing' when status='Processing' then 'Closed' end where cp_id="+id);) {
			
			preparedStatement.executeUpdate();
			
			return "Complaint Status Changed Successfully !!!";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}

	
	@Override
	public String changeDept(String id, String dept) {
		
		try (PreparedStatement preparedStatement = connection.prepareStatement("update complaints set dept_id="+dept+" where cp_id="+id);) {
			
			preparedStatement.executeUpdate();
			
			return "Complaint Reassigned Successfully !!!";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}

	
	@Override
	public List<Complaint> viewReminder(int id) {
		List<Complaint> complaintList = new ArrayList<>();
		Complaint complaint = null;
		try (Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select cp.cp_id, cp.cp_details,cp.reg_date,cp.status, r.rm_date from complaints cp inner join reminder r on cp.cp_id=r.cp_id where dept_id="+id+";");) {
			while (resultSet.next()) {
				complaint= new Complaint();
				complaint.setCpId(resultSet.getInt(1));
				complaint.setCpDetails(resultSet.getString(2));
				complaint.setRegDate(resultSet.getString(3));
				complaint.setStatus(resultSet.getString(4));
				complaint.setRmDate(resultSet.getString(5));
				complaintList.add(complaint);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return complaintList;
	}



		
}




