package com.tcs.httpsession;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/HttpSessionTracking2")
public class HttpSessionTracking2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		response.setContentType("text/html");
		// read the data from -> form
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		
		// create session object
		
		HttpSession session = request.getSession();
		// get the data from session object
		writer.print("<html><head><title>User Details</title></head><body style='font-family: Arial, sans-serif; background-color: #f4f4f4; padding: 20px;'>");
		writer.print("<div style='background-color: #fff; padding: 20px; border-radius: 10px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);'>");
		writer.print("<h1 style='color: #333;'>Name: " + session.getAttribute("name") + "</h1>");		
		writer.print("<h1 style='color: #333;'>Password: " + session.getAttribute("password") + "</h1>");		
		writer.print("<h1 style='color: #333;'>Qualification: " + session.getAttribute("qualification") + "</h1>");		
		writer.print("<h1 style='color: #333;'>Age: " + session.getAttribute("number") + "</h1>");		
		writer.print("<h1 style='color: #333;'>Email: " + email + "</h1>");		
		writer.print("<h1 style='color: #333;'>Gender: " + gender + "</h1>");		
		writer.print("</div>");
		writer.print("</body></html>");

	}
}
