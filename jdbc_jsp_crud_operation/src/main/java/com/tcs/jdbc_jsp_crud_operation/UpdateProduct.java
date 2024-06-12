package com.tcs.jdbc_jsp_crud_operation;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
@MultipartConfig
@WebServlet("/UpdateProduct")
public class UpdateProduct extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	 String productIdString = request.getParameter("productId");
         if (productIdString != null && !productIdString.isEmpty()) {
             try {
                 int pid = Integer.parseInt(productIdString);
            String pname = request.getParameter("pname");
            int pprice = Integer.parseInt(request.getParameter("pprice"));
            String pbrand = request.getParameter("pbrand");
            String pmadein = request.getParameter("pmadein");
            Date pmfddate = Date.valueOf(request.getParameter("pmfddate")); 
            Date pexpDate =Date.valueOf(request.getParameter("pexpDate")); 
            
            Part imagePart = request.getPart("newImage");
            byte[] pimage = imagePart.getInputStream().readAllBytes();

            Part audioPart = request.getPart("newAudio");
            byte[] paudio = audioPart.getInputStream().readAllBytes();

            Part videoPart = request.getPart("newVideo");
            byte[] pvideo = videoPart.getInputStream().readAllBytes();

          
            if (imagePart.getSize() == 0) {
                
                ProductData existingProduct = ProductDao.findById(pid);
                pimage = existingProduct.getPimage();
            }

            if (audioPart.getSize() == 0) {
                
                ProductData existingProduct = ProductDao.findById(pid);
                paudio = existingProduct.getPaudio();
            }

            if (videoPart.getSize() == 0) {
               
                ProductData existingProduct = ProductDao.findById(pid);
                pvideo = existingProduct.getPvideo();
            }

           
            ProductData productData = new ProductData();
            productData.setPid(pid);
            productData.setPname(pname);
            productData.setPprice(pprice);
            productData.setPbrand(pbrand);
            productData.setPmadein(pmadein);
            productData.setPmfddate(pexpDate);
            productData.setPexpDate(pmfddate);
            productData.setPimage(pimage);
            productData.setPaudio(paudio);
            productData.setPvideo(pvideo);

            RequestDispatcher dispatcher = null;
           
            int count = ProductDao.updateProduct(productData);
            if (count > 0) {
                System.out.println("data  updated "+count);
            	dispatcher=request.getRequestDispatcher("display.jsp");
            	dispatcher.forward(request, response);
            } else {
            	System.out.println("data  updation failed "+count);
            	response.setContentType("text/html");
            	PrintWriter printWriter = response.getWriter();
            	
            	printWriter.println("<!DOCTYPE html>");
            	printWriter.println("<html>");
            	printWriter.println("<head>");
            	printWriter.println("<title>Data Updation Failed</title>");
            	printWriter.println("<style> h1 { color: red; } </style>");
            	printWriter.println("</head>");
            	printWriter.println("<body>");
            	printWriter.println("<h1>Data Updation Failed. Please Try Again Later</h1>");
            	printWriter.println("</body>");
            	printWriter.println("</html>");

            	dispatcher=request.getRequestDispatcher("saveproduct.html");
            	dispatcher.include(request, response);
            }
        } catch (Exception e) {
            
            e.printStackTrace();
            
        }
    }
    }
}
