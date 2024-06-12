package com.tcs.cookies_session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Cookies2")
public class Cookies2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		response.setContentType("text/html");
		// read the data from -> form
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		// create cookie array to get the data
		 
		Cookie [] cookies = request.getCookies();
		// get the data from cookies array
		writer.print("<html><head><title>User Details</title></head><body style='font-family: Arial, sans-serif; background-color: #f4f4f4; padding: 20px;'>");
		writer.print("<div style='background-color: #fff; padding: 20px; border-radius: 10px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);'>");
		writer.print("<h1 style='color: #333;'>Name: " + cookies[0].getValue() + "</h1>");		
		writer.print("<h1 style='color: #333;'>Password: " + cookies[1].getValue()  + "</h1>");		
		writer.print("<h1 style='color: #333;'>Qualification: " + cookies[2].getValue() + "</h1>");		
		writer.print("<h1 style='color: #333;'>Age: " + cookies[3].getValue() + "</h1>");		
		writer.print("<h1 style='color: #333;'>Email: " + email + "</h1>");		
		writer.print("<h1 style='color: #333;'>Gender: " + gender + "</h1>");		
		writer.print("</div>");
		writer.print("</body></html>");

				
	}

}
