<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Confirmation Form</title>
</head>
<body>Customer is Confirmed : ${customer.firstName }
	${customer.lastName} and Free passes availed ${customer.freePasses} and postal code is ${customer.postalCode }
	<br><br>
	and Choosen course code is ${customer.courseCode }
	</body>
</html>