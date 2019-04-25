<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Registration Form</title>
</head>
<body>
	<form:form action="processForm" modelAttribute="studentDeta">
		FirstName : <form:input path="firstName" />
		<br>
		<br>
		LastName : <form:input path="lastName" />
		<br>
		<br>
		Country :
		<!-- 	<form:select path="country">
			<form:option value="Brazil" label="Brazil"></form:option>
			<form:option value="France" label="France"></form:option>
			<form:option value="Germany" label="Germany"></form:option>
			<form:option value="India" label="India"></form:option>
		</form:select>-->
		<form:select path="country">
			<form:options items="${theCountryOptions}" />
		</form:select>
		<br>
		<br>
		<br>
		<br>
		Favourite Language:
		<!--<form:radiobuttons path="favoriteLanguage" items="${studentDeta.favoriteLanguageOptions }"/>-->
		<form:radiobuttons path="favoriteLanguage" items="${theFavLanguage }" />
		<!-- Java <form:radiobutton path="favoriteLanguage" value="Java"/>
		C# <form:radiobutton path="favoriteLanguage" value="C#"/>
		PHP <form:radiobutton path="favoriteLanguage" value="PHP"/>
		Ruby <form:radiobutton path="favoriteLanguage" value="Ruby"/> -->
		<br>
		<br>
		Operating Systems :
		Linux <form:checkbox path="operatingSystems" value="Linux" />
		Microsoft Windows<form:checkbox path="operatingSystems"
			value="Microsoft Windows" />
		Mac OS<form:checkbox path="operatingSystems" value="Mac OS" />
		<br>
		<br>

		<input type="submit" value="Submit">

	</form:form>

</body>
</html>