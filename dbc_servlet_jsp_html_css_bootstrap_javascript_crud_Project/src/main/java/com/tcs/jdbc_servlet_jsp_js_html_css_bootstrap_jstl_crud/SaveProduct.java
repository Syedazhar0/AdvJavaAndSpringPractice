package com.tcs.jdbc_servlet_jsp_js_html_css_bootstrap_jstl_crud;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SaveProduct")
@MultipartConfig
public class SaveProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// call the method
		try {
			ProductDao.createTable();
			System.out.println("table created successfully..........");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
