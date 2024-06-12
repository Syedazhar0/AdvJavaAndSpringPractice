package com.Calculator;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Calculator")
public class Calculator extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		response.setContentType("text/html");
		
		int first_number = Integer.parseInt(request.getParameter("first_num"));
		int second_number = Integer.parseInt(request.getParameter("sec_num"));
		String operator = request.getParameter("operator");
		
		double result =0.0;
		switch (operator) {
		case "+": 
			result =first_number+second_number;
			break;
			
		case "-": 
			result =first_number-second_number;
			break;
			
		case "*": 
			result =first_number*second_number;
			break;
			
		case "/": 
			result =first_number/second_number;
			break;
			
		case "%": 
			result =first_number%second_number;
			break;

		default: System.out.println("invalid operator");
			break;
		}
		
		writer.print("<html><head><style>");
		writer.print("h1{background-color:bisque; color:red; font-family:algerian}");
		writer.print("</head></style><body>");
		writer.print("<h1> First_number :"+first_number+"</h1>");
		writer.print("<h1> Second_number :"+second_number+"</h1>");
		writer.print("<h1>Operator :"+operator+"</h1>");
		writer.print("<h1> Result :"+result+"</h1>");

		writer.print("</body></html>");
		
		
	}
	

}
