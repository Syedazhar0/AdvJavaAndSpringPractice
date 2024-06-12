<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.Base64" %>
<%@ page import="com.tcs.jdbc_jsp_crud_operation.ProductData" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Product</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .blur {
            filter: blur(5px);
            transition: filter 0.3s ease-in-out;
        }
    </style>
</head>
<body>
    <div class="container mt-5">
        <h2 class="mb-4">Edit Product</h2>
        <form action="UpdateProduct" method=post enctype="multipart/form-data">
           
                <input type="hidden" name="productId" value="${product.pid}">
                <div class="form-group">
                    <label for="pname">Product Name:</label>
                    <input type="text" class="form-control" id="pname" name="pname" value="${product.pname}" autofocus>
                </div>
                <div class="form-group">
                    <label for="pprice">Product Price:</label>
                    <input type="number" class="form-control" id="pprice" name="pprice" value="${product.pprice}">
                </div>
                <div class="form-group">
                    <label for="pbrand">Product Brand:</label>
                    <input type="text" class="form-control" id="pbrand" name="pbrand" value="${product.pbrand}">
                </div>
                <div class="form-group">
                    <label for="pmadein">Product Made In:</label>
                    <input type="text" class="form-control" id="pmadein" name="pmadein" value="${product.pmadein}">
                </div>
                <div class="form-group">
                    <label for="pmfddate">Product Manufacturing Date:</label>
                    <input type="date" class="form-control" id="pmfddate" name="pmfddate" value="${product.pmfddate}">
                </div>
                <div class="form-group">
                    <label for="pexpDate">Product Expiry Date:</label>
                    <input type="date" class="form-control" id="pexpDate" name="pexpDate" value="${product.pexpDate}">
                </div>
                <div class="form-group">
                    <label for="pimage">Current Image:</label>
                    <img src="data:image/jpeg;base64,${Base64.getEncoder().encodeToString(product.pimage)}" class="img-fluid" alt="Product Image">
                </div>
                <div class="form-group">
                    <label for="paudio">Current Audio:</label>
                    <audio controls>
                        <source src="data:audio/mpeg;base64,${Base64.getEncoder().encodeToString(product.paudio)}" type="audio/mpeg">
                    </audio>
                </div>
                <div class="form-group">
                    <label for="pvideo">Current Video:</label>
                    <video controls class="img-fluid">
                        <source src="data:video/mp4;base64,${Base64.getEncoder().encodeToString(product.pvideo)}" type="video/mp4">
                    </video>
                </div>
                <div class="form-group">
                    <label for="newImage">Select New Image:</label>
                    <input type="file" class="form-control-file" id="newImage" name="newImage">
                </div>
                <div class="form-group">
                    <label for="newAudio">Select New Audio:</label>
                    <input type="file" class="form-control-file" id="newAudio" name="newAudio">
                </div>
                <div class="form-group">
                    <label for="newVideo">Select New Video:</label>
                    <input type="file" class="form-control-file" id="newVideo" name="newVideo">
                </div>
                <button type="submit" class="btn btn-primary">Update</button>
          
        </form>
    </div>
</body>
</html>
