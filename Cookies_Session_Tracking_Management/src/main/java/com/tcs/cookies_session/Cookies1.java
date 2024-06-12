package com.tcs.cookies_session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Cookies1")
public class Cookies1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
			response.setContentType("text/html");
			// read the data from -> form
			String qualification = request.getParameter("qualification").replace(" ", "_");
			String age = request.getParameter("number").replace(" ", "_");
			
			// create cookies object
			
			Cookie  cookie = new Cookie("qualification",qualification);
			Cookie  cookie1 = new Cookie("age",age);
			// add  the data into response object
			response.addCookie(cookie);
			response.addCookie(cookie1);
			// dispatch servlet
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("Form5.html");
			dispatcher.forward(request, response);
			
	}

}
