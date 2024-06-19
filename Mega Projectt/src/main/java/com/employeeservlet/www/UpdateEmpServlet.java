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
import com.exceptionhandling.www.InvaildIdExecption;

public class UpdateEmpServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest reqqq,HttpServletResponse resss)throws ServletException,IOException{
		System.out.println("hello");
		int id=Integer.parseInt(reqqq.getParameter("id"));
		String name=reqqq.getParameter("name");
		int age=Integer.parseInt(reqqq.getParameter("age"));
		EmployDetailss aa=new EmployDetailss();
		aa.setId(id);
		aa.setName(name);
		aa.setAge(age);
		
		EmployeService ess=new EmployeService();
		List<EmployDetailss> empp=new ArrayList<EmployDetailss>();
		
		String r="invaid age";
		try {
			r = ess.empUpdate(aa);
		} catch (InvaildIdExecption e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		empp=ess.getalldata();
		reqqq.setAttribute("ui", r);
		reqqq.setAttribute("aii", empp);
		reqqq.getRequestDispatcher("UpdateResponse.jsp").forward(reqqq, resss);
	}

}
