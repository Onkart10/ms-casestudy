<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<head>
<title>Log in with your account</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="/resources/css/common.css" rel="stylesheet">
</head>

<body>
	<div class="container">
		<div class="form-group ${errorMessage != null ? 'has-error' : ''}">
	    	<form:form method="post" modelAttribute="userForm" action="/login" class="form-signin">
		    	<h2 class="form-heading">Log in</h2>
		        <form:input type="text" path="username" value="user1" name="name" class="form-control" placeholder="Username" autofocus="true"/>
		        <form:input type="password" path="password" value="password" name="password" class="form-control" placeholder="Password"/>
		        <span>${errorMessage}</span> 
		        <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
	    	</form:form>
    	</div>
	</div>
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>

</html>
