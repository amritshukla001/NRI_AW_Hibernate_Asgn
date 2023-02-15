package com.registration.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.registration.model.Employee;

public class EmployeeDao {
	public int registerEmployee(Employee employee) throws ClassNotFoundException{
		String Insert_Emp_SQL="Insert into employeenew"+"(id,first_name,last_name,username,password,address,contact)VALUES"+"(?,?,?,?,?,?,?)";
		int result=0;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		try(Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl","sys as sysdba","Oracle_1");
				PreparedStatement preparedStatement =connection.prepareStatement(Insert_Emp_SQL)) 
		{
			preparedStatement.setInt(1,101);
			preparedStatement.setString(2, employee.getFirstname());
			preparedStatement.setString(3, employee.getLastname());
			preparedStatement.setString(4,employee.getUsername());
			preparedStatement.setString(5,employee.getPassword());
			preparedStatement.setString(6, employee.getAddress());
			preparedStatement.setString(7,employee.getContact());
		
			System.out.println(preparedStatement);
			
			result= preparedStatement.executeUpdate();
		}
		
		catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
