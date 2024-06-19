package com.employeeservlet.www;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employeemodel.www.EmployDetailss;
import com.employeeservice.www.EmployeService;
import com.exceptionhandling.www.InvaildAgeExceptio;

public class CreateEmpServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		System.out.println("i'm Servlet here");
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		int age=Integer.parseInt(req.getParameter("age"));
		EmployDetailss aa=new EmployDetailss();
		aa.setId(id);
		aa.setName(name);
		aa.setAge(age);
		
		EmployeService ess=new EmployeService();
		String r=null;
		try {
			r = ess.createEmployee(aa);
		} catch (InvaildAgeExceptio e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<EmployDetailss> empp=new ArrayList<EmployDetailss>();
		empp=ess.getalldata();
		req.setAttribute("xyz", empp);
		req.setAttribute("king", r);
		req.setAttribute("ban", aa);
		req.getRequestDispatcher("EmployeeResponse.jsp").forward(req, res);
//		ess.getalldata();
//		ess.empUpdate(aa);
//		ess.empDelete(aa);
//		
}
}