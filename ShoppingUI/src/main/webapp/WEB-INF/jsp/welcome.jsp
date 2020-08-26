<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<!DOCTYPE html>
<html>

<head>
<title>Shopping Application</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link href="/resources/css/common.css" rel="stylesheet">
</head>

<body>
	<%-- <h2> ${msg}</h2> --%>
	<div class="container">
		<h3>Hello, ${username}</h3>
		<form method="post" action="/list-orders">
			<input type="hidden" name="tokenStr" id="tokenStr" value="${token}" />
			<input type="hidden" name="usernameStr" id="usernameStr" value="${username} " /> 
			<button class="btn btn-primary" type="submit">Click here to view your orders</button>
		</form>
	</div>
		
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>

</html>
