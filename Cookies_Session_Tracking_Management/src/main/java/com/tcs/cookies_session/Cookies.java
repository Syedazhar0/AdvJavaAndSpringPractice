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

@WebServlet("/Cookies")
public class Cookies extends HttpServlet {
	private static final long serialVersionUID = 1L;

 	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		
 				PrintWriter writer = response.getWriter();
 				response.setContentType("text/html");
 				// read the data from -> form
 				String name = request.getParameter("name").replace(" ", "_");
 				String password = request.getParameter("password").replace(" ", "_");
 				// note please don't enter spaces with name or pass or etc 
 				// this will throws exceptions IllegalArgumentException to avoid this
 				// give inputs without space ex: syed_azhar or use trim or replace method
 				// because it follows key value pair format it will confused where the name end , starts
 				
 				// create cookies object
 				
 				Cookie  cookie = new Cookie("name",name);
 				Cookie  cookie1 = new Cookie("password",password);
 				// add  the data into response object
 				response.addCookie(cookie);
 				response.addCookie(cookie1);
 				// dispatch servlet
 				
 				RequestDispatcher dispatcher = request.getRequestDispatcher("Form4.html");
 				dispatcher.forward(request, response);
 				
 			}
	}


