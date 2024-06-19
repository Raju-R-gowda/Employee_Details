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

public class GetDataEmpServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest reqq,HttpServletResponse ress)throws ServletException,IOException{
		System.out.println("hiiii");
		EmployeService ess=new EmployeService();
		List<EmployDetailss> empp=new ArrayList<EmployDetailss>();
		empp=ess.getalldata();
		reqq.setAttribute("sss", empp);
		reqq.getRequestDispatcher("GetallResponse.jsp").forward(reqq, ress);
}
}
