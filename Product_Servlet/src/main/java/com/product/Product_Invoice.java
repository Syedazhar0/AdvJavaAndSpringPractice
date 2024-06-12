package com.product;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Product_Invoice")
public class Product_Invoice extends HttpServlet {
    
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
	    response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    
	    int id = Integer.parseInt( request.getParameter("productId"));
	    String productName = request.getParameter("productName");
	    double price = Double.parseDouble(request.getParameter("price"));
	    int quantity = Integer.parseInt(request.getParameter("quantity"));
	    
	
	    
	    double total =  price * quantity;
	    
	    out.println("<!DOCTYPE html>");
	    out.println("<html>");
	    out.println("<head>");
	    out.println("<title>Product Invoice</title>");
	    out.println("</head>");
	    out.println("<body>");
	    out.println("<h2>Product Invoice</h2>");
	    out.println("<table border='1'>");
	    out.println("<tr><th>Product ID</th><th>Name</th><th>Quantity</th><th>Price</th><th>Total</th></tr>");
	    out.println("<tr><td>" + id + "</td><td>" + productName + "</td><td>" + quantity + "</td><td>$" + price + "</td><td>$" + total + "</td></tr>");
	    out.println("</table>");
	    out.println("</body>");
	    out.println("</html>");
	}

    }

