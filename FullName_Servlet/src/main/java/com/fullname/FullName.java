package com.fullname;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FullName extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        
        String status = "";
        if (firstName != null && !firstName.isEmpty() && lastName != null && !lastName.isEmpty()) {
            status = "Your full name is " + firstName + " " + lastName;
        } else {
            status = "Name cannot be null. Please enter your name.";
        }
        
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.print("<html><head><style>");
        writer.print("h1 {color: red; background-color: black; font-family: Algerian;}");
        writer.print("</style></head><body>");
        writer.print("<h1>Your Full Name is:</h1>");
        writer.print("<p style=\"color: red;\">" + status + "</p>");
        writer.print("</body></html>");
    }
}
