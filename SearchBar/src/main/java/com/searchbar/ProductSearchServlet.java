package com.searchbar;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.util.*;

@WebServlet("/productSearch")
public class ProductSearchServlet extends HttpServlet {
 
	private static final long serialVersionUID = 1L;
	private Map<String, String> products = new HashMap<>();

    public void init() throws ServletException {
        
        products.put("1", "iPhone");
        products.put("2", "Samsung Galaxy");
        products.put("3", "Google Pixel");
        
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String query = request.getParameter("query");
        List<String> matchingProducts = searchProducts(query);
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Product Search Results</title></head><body>");
        out.println("<h2>Search Results for: " + query + "</h2>");
        out.println("<ul>");
        for (String product : matchingProducts) {
            out.println("<li>" + product + "</li>");
        }
        out.println("</ul>");
        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    private List<String> searchProducts(String query) {
        List<String> matchingProducts = new ArrayList<>();
        for (Map.Entry<String, String> entry : products.entrySet()) {
            if (entry.getValue().toLowerCase().startsWith(query.toLowerCase())) {
                matchingProducts.add(entry.getValue());
            }
        }
        return matchingProducts;
    }
}
