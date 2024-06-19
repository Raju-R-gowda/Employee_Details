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

public class DeleteEmpServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest reqqqq,HttpServletResponse ressss)throws ServletException,IOException{
		System.out.println("Raj");
		int deleteid =Integer.parseInt(reqqqq.getParameter("id"));
		EmployeService ess=new EmployeService();
		ess.empDelete(deleteid);
		List<EmployDetailss> empp=new ArrayList<EmployDetailss>();
		empp=ess.getalldata();
		reqqqq.setAttribute("xyz", empp);

		reqqqq.setAttribute("abc", deleteid);
		reqqqq.getRequestDispatcher("DeleteResponse.jsp").forward(reqqqq, ressss);
		}

}
