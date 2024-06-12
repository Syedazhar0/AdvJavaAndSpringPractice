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

@WebServlet("/HttpSessionTracking")
public class HttpSessionTracking extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter writer = response.getWriter();
		response.setContentType("text/html");
		// read the data from -> form
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		// create session object
		
		HttpSession session = request.getSession();
		// set the data into session object
		session.setAttribute("name", name);
		session.setAttribute("password", password);
		
		// dispatch servlet
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Form1.html");
		dispatcher.forward(request, response);
		
		
	}

}
