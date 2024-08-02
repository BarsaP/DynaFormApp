//FirstServlet.java
package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/firsturl")
public class FirstServlet extends HttpServlet {
   
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get PrintWriter
		PrintWriter pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//read form data
		String name=req.getParameter("pname");
		String fname=req.getParameter("fname");
		String ms=req.getParameter("ms");
		//generate dynamic form page based on the marital status
		if(ms.equalsIgnoreCase("single")) {
			pw.println("<form action='secondurl'method='post'>");
			pw.println("<table border='0'bgcolor='cyan'align='center'>");
			pw.println("<tr><td>when do u want to marry?</td>");
			pw.println("<td><input type='text'name='f2t1'></td></tr>");
			pw.println("<tr><td>why do u want to marry?</td>");
			pw.println("<td><input type='text'name='f2t2'></td></tr>");
			pw.println("<tr><td colspan='2'><input type='submit'value='submit'></td></tr>");
			pw.println("</table>");
			pw.println("</form>");
			
		}
		else {
			pw.println("<form action='secondurl'method='post'>");
			pw.println("<table border='0'bgcolor='cyan'align='center'>");
			pw.println("<tr><td>spouse name::</td>");
			pw.println("<td><input type='text'name='f2t1'></td></tr>");
			pw.println("<tr><td>No.of children::</td>");
			pw.println("<td><input type='text'name='f2t2'></td></tr>");
			pw.println("<tr><td colspan='2'><input type='submit'value='submit'></td></tr>");
			pw.println("</table>");
			pw.println("</form>");
		}//else
		//close stream
		pw.close();
	}//doGet(-,-)
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}
}
