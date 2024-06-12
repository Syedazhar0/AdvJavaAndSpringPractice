package com.tcs.jdbc_jsp_crud_operation;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.NoSuchFileException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.apache.commons.io.IOUtils;

@MultipartConfig
@WebServlet("/SaveProduct")
public class SaveProduct extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException,NumberFormatException,NoSuchFileException{
    	
    	try {
//			ProductDao.createTable();
			System.out.println("table created successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	try {
    	    int pid = Integer.parseInt(request.getParameter("pid"));
    	    String pname = request.getParameter("pname");
    	    int pprice = Integer.parseInt(request.getParameter("pprice"));
    	    String pbrand = request.getParameter("pbrand");
    	    String pmadein = request.getParameter("pmadein");
    	    Date pmfddate = Date.valueOf(request.getParameter("pmfddate"));
    	    Date pexpDate = Date.valueOf(request.getParameter("pexpDate"));
    	    // please do not forgot to add commons.io jar in lib folder 
    		// while working with files like image audio and video
//    	        Part pimages = request.getPart("pimage");
//    	        InputStream pimageStream = pimages.getInputStream();
//    	        byte[] pimage = IOUtils.toByteArray(pimageStream);
//    	        IOUtils.closeQuietly(pimageStream);
//    	   
//    	        Part paudios = request.getPart("paudio");
//    	        InputStream audioStream = paudios.getInputStream();
//    	        byte[] paudio = IOUtils.toByteArray(audioStream);
//    	        IOUtils.closeQuietly(audioStream);
//    	    
//    	        Part pvideos = request.getPart("pvideo");
//    	        InputStream videoStream = pvideos.getInputStream();
//    	        byte[] pvideo = IOUtils.toByteArray(videoStream);
//    	        IOUtils.closeQuietly(videoStream);
    	    
    	        //another approach to work with input files just syntax is different
    	    // decreased the line of code
    	        byte[] pimage = request.getPart("pimage").getInputStream().readAllBytes();
    	        byte[] paudio = request.getPart("paudio").getInputStream().readAllBytes();
    	        byte[] pvideo = request.getPart("pvideo").getInputStream().readAllBytes();

    	   
    	    ProductData product = new ProductData(pid, pname, pprice, pbrand, pmadein, pmfddate, pexpDate, pimage, paudio, pvideo);

    	    boolean success = ProductDao.saveProduct(product);
    	    if (success) {
                request.setAttribute("datasaved", 1);
            } else {
                request.setAttribute("datasaved", 0);
            }
            request.getRequestDispatcher("display.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("datasaved", 0);
            request.getRequestDispatcher("display.jsp").forward(request, response);
    	}
    }
}

