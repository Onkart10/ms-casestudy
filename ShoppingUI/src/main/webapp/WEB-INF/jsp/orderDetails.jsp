<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order Details</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link href="/resources/css/common.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<h2>Your Order Details:</h2>
		<table class="table">
		  <thead>
		    <tr>
		      <th scope="col">Order Id</th>
		      <th scope="col">Order Date</th>
		      <th scope="col">Amount</th>
		      <th scope="col">Customer Name</th>
		      <th scope="col">Customer Address</th>
		      <th scope="col">Customer Email</th>
		      <th scope="col">Phone Number</th>
		    </tr>
		  </thead>
		  <tbody>
		  	<c:forEach items="${orderDetails}" var="order">
				<tr>
      				<td>${order.id}</td>
      				<td>${order.orderDate}</td>
      				<td>${order.amount}</td>
      				<td>${order.customerName}</td>
      				<td>${order.customerAddress}</td>
      				<td>${order.customerEmail}</td>
      				<td>${order.customerPhone}</td>
    			</tr>
			</c:forEach>
		  </tbody>
  		</table>
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>