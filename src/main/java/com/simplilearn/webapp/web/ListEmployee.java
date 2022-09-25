package com.simplilearn.webapp.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


import com.simplilearn.webapp.model.Employee;
import com.simplilearn.webapp.util.HibernateSessionUtil;

@WebServlet("/list-employee")
public class ListEmployee extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("index.jsp").include(request, response);

		try {
			// 1. build hibernate session factory
			SessionFactory factory = HibernateSessionUtil.buildSessionFactory();
			
			// 2. create session object
			Session session = factory.openSession();
			
			// 3. read products
			List<Employee> obj = session.createQuery("from Employee").list();
			
			//show data as table.
			out.print("<h1> Customer List :- </h1>");
			
			out.print("<style> table,td,th {"
					+ "border:2px solid red;"
					+ "padding: 10px; "
					+ "}</style>");
			out.print("<table >");
			out.print("<tr>");
				out.print("<th> Id</th>");
				out.print("<th> Name</th>");
				out.print("<th>  Email</th>");
				out.print("<th> Password</th>");
				out.print("<th> Country</th>");
				
			out.print("</tr>");
			
			for(Employee p : obj) {
				out.print("<tr>");
				out.print("<td>"+p.getId()+"</td>");
				out.print("<td>"+p.getName()+"</td>");
				out.print("<td>"+p.getEmail()+"</td>");
				out.print("<td>"+p.getPassword()+"</td>");
				out.print("<td>"+p.getCountry()+"</td>");
				
				out.print("</tr>");
			}
			out.print("</table>");
			// 3. close session
			session.close();
		} catch (Exception e) {
			out.print("<h3 style='color:red'> Hibernate session is failed ! </h3>");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}