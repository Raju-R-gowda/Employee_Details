package com.employeeservice.www;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.employeemodel.www.EmployDetailss;
import com.exceptionhandling.www.InvaildAgeExceptio;
import com.exceptionhandling.www.InvaildIdExecption;

public class EmployeService {
	String username="root";
	String pwd="Raju@123";
	String url="jdbc:mysql://localhost:3306/employee";
	String insquery="insert into employeee(id,name,age) values(?,?,?)";
	String getqry="select* from employeee";
	String dlqry="delete from employeee where id=?";
	String upqry="update employeee set name=?,age=? where id=?";
	public String createEmployee(EmployDetailss aa )throws InvaildAgeExceptio{
		if(aa.getAge()<18) {
		throw new InvaildAgeExceptio("invaild age")	;
		}
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
		try {
			Connection con=DriverManager.getConnection(url,username,pwd);
			PreparedStatement pr=con.prepareStatement(insquery);
			pr.setInt(1, aa.getId());
			pr.setString(2, aa.getName());
			pr.setInt(3, aa.getAge());
			int result = pr.executeUpdate();
			con.close();
			pr.close();
			if(result==1) {
				System.out.println("Connection Established SucessFully");
			}
			else
			{
				System.out.println("Something Went Wrong");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("connection established");
//		System.out.println(aa.getId());
//		System.out.println(aa.getName());
//		System.out.println(aa.getAge());
		return "Table Created";
	}
	
	
	public List<EmployDetailss> getalldata(){
		List<EmployDetailss> empp=new ArrayList<EmployDetailss>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Connection con=DriverManager.getConnection(url,username,pwd);
			PreparedStatement pr=con.prepareStatement(getqry);
			ResultSet r1=pr.executeQuery();
			while(r1.next()) {
				int id=r1.getInt("id");
				String name=r1.getString("name");
				int age =r1.getInt("age");
				EmployDetailss empp1 = new EmployDetailss(id,name,age);
				empp.add(empp1);
			}
			con.close();
			pr.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return empp;
	}
	public String empUpdate(EmployDetailss aa) throws InvaildIdExecption {
		if(aa.getId()<1) {
	throw new InvaildIdExecption("invaild id");
		}
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		try {
			Connection con=DriverManager.getConnection(url,username,pwd);
			PreparedStatement pr=con.prepareStatement(upqry);
			pr.setString(1,aa.getName());
			pr.setInt(2,aa.getAge());
			pr.setInt(3,aa.getId());
			int result=pr.executeUpdate();
			if(result > 0) {
				return "table updated";
			}
			con.close();
			pr.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "not updated";
	}
	public String empDelete(int deleteid) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Connection con=DriverManager.getConnection(url,username,pwd);
			PreparedStatement pr=con.prepareStatement(dlqry);
			pr.setInt(1,deleteid);
			int result=pr.executeUpdate();
			if(result>0) {
				return "deleted";
			}
			con.close();
			pr.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "not deleted";
	}
}
