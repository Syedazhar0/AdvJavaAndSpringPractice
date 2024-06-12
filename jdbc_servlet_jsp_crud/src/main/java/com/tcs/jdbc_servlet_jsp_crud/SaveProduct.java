package com.tcs.jdbc_servlet_jsp_crud;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SaveProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			ProductDao.createTable();
			System.out.println("table created successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
