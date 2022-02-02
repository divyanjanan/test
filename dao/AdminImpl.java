package com.cybage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cybage.model.Admin;
import com.cybage.model.Citizens;
import com.cybage.model.Complaint;
import com.cybage.model.Department;
import com.cybage.utilities.Utility;

public class AdminImpl implements IAdmin{
	Connection connection;
	PreparedStatement statement;
	
	 public AdminImpl() throws ClassNotFoundException, SQLException {
			// TODO Auto-generated constructor stub
			connection=Utility.fetchConnection();
			
			System.out.println("Inside UserDao");
		}

	@Override
	public Admin authenticateAdmin(String email, String password) throws SQLException {
		// TODO Auto-generated method stub
		statement=connection.prepareStatement("select * from admin where email=? and password=?");
		statement.setString(1, email);
		statement.setString(2, password);
		
		try(ResultSet resultSet= statement.executeQuery()){
			
			if(resultSet.next()) {
				
				return new Admin(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
			}
		}
		return null;
	}
	
	@Override
	public Citizens authenticateCitizen(String email, String password) throws SQLException {
		// TODO Auto-generated method stub
		statement=connection.prepareStatement("select * from citizen where ct_email=? and ct_password=?");
		statement.setString(1, email);
		statement.setString(2, password);
		
		try(ResultSet resultSet= statement.executeQuery()){
			
			if(resultSet.next()) {
				
				return new Citizens(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
			}
		}
		return null;
	}
	
	@Override
	public Department authenticateDept(String email, String password) throws SQLException {
		// TODO Auto-generated method stub
		statement=connection.prepareStatement("select dept_id,email,head, dept_name from department where email=? and password=?");
		statement.setString(1, email);
		statement.setString(2, password);
		
		try(ResultSet resultSet= statement.executeQuery()){
			
			if(resultSet.next()) {
				
				return new Department(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4));
			}
		}
		return null;
	}

	@Override
	public String addDepartment(Department department) {
		
			try (PreparedStatement preparedStatement = connection.prepareStatement("insert into department(dept_name,email,password,head,admin_id) values(?,?,?,?,?)");) {
				preparedStatement.setString(1, department.getDeptName());
				preparedStatement.setString(2, department.getDeptEmail());
				preparedStatement.setString(3, department.getDeptPassword());
				preparedStatement.setString(4, department.getDeptHead());
				preparedStatement.setInt(5, department.getAdminId());
				preparedStatement.executeUpdate();
				return department.getDeptName()+" Added Suceesfully !!!";
			} catch (SQLException e) {
				e.printStackTrace();
			}

		return null;
	}

	@Override
	public String removeDepartment(String departmentName) {

		try (PreparedStatement preparedStatement = connection
				.prepareStatement("delete from department where dept_id=?");) {
			preparedStatement.setString(1,departmentName);
			preparedStatement.executeUpdate();
			return  "Department Details Removed Successfully !!!";
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
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

	@Override
	public List<Citizens> citizensList() {
		List<Citizens> citizensList = new ArrayList<>();
		Citizens citizen = null;
		try (Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select ct_id, ct_name, ct_email, ct_mobile, ct_address, ct_gender, ct_aadhaar from citizen");) {
			while (resultSet.next()) {
				citizen= new Citizens();
				citizen.setCitizenId(resultSet.getInt(1));
				citizen.setName(resultSet.getString(2));
				citizen.setEmail(resultSet.getString(3));
				citizen.setMobile(resultSet.getString(4));
				citizen.setAddress(resultSet.getString(5));
				citizen.setGender(resultSet.getString(6));
				citizen.setAadhaar(resultSet.getString(7));
				citizensList.add(citizen);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return citizensList;
	}

	@Override
	public List<Complaint> complaintList() {
		List<Complaint> complaintList = new ArrayList<>();
		Complaint complaint = null;
		try (Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select cp.cp_id,c.ct_name,d.dept_name,cp.cp_details,cp.reg_date,cp.status from complaints cp inner join citizen c on cp.ct_id =c.ct_id inner join  department d on cp.dept_id=d.dept_id;");) {
			while (resultSet.next()) {
				System.out.println("in while");
				complaint= new Complaint();
				complaint.setCpId(resultSet.getInt(1));
				complaint.setCtName(resultSet.getString(2));
				complaint.setDeptId(resultSet.getString(3));
				complaint.setCpDetails(resultSet.getString(4));
				complaint.setRegDate(resultSet.getString(5));
				complaint.setStatus(resultSet.getString(6));
				complaintList.add(complaint);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return complaintList;
	}

	@Override
	public Department updateDeptList(String dept) throws SQLException {
		
		statement=connection.prepareStatement("select dept_id,dept_name,email, head, password from department where dept_id='"+dept+"';");
		
		try(ResultSet resultSet = statement.executeQuery()) {
			
			if(resultSet.next()) {
				System.out.println("In if");
				
				Department d1= new Department(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5));
				System.out.println(d1);
				
				return d1;
			}
		}
		return null;
		
		
	}

	@Override
	public String updateDepartment(Department department) {
		
		try (PreparedStatement preparedStatement = connection.prepareStatement("update department set email=?, password=?, head=? where dept_id="+department.getDepartId());) {
			preparedStatement.setString(1, department.getDeptEmail());
			preparedStatement.setString(2, department.getDeptPassword());
			preparedStatement.setString(3, department.getDeptHead());
			preparedStatement.executeUpdate();
			
			return "Department Details Updated Successfully";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}

}
