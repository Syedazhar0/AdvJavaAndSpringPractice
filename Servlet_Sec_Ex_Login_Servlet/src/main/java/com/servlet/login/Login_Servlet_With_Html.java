package com.servlet.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login_Servlet_With_Html extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	
	String status="";
	if(username.equals("azhar")&& password.equals("azhar@.4321")){
		status="Congratulations... Login Success";
	}else {
		status="Login Failed Please Enter a Valid Password and UserNmae";
	}
	
	PrintWriter writer = response.getWriter();
	response.setContentType("text/html");
	writer.print("<html><head><style>");
	writer.print("h1{color: red}");
	writer.print("</head></style><body>");
    writer.print("<h1>Login Status : </h1>"+status);
    writer.print("</body></html>");
	}

}
