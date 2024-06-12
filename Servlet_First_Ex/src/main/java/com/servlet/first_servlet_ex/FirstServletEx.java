package com.servlet.first_servlet_ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServletEx extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        response.setContentType("text/html");
        writer.println("<html><head><style>");
        writer.println("h1 { color: red; background-color: black;font-family:algerian }");
        writer.println("</style></head><body>");
        writer.println("<h1>Hello World! Welcome to the first servlet application</h1>");
        writer.println("</body></html>");
    }
}
