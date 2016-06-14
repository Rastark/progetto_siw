<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add new Exam</title>
<link href="bootstrap.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<h1>Insert new exam:</h1>
	<c:url var="actionURL" value="/insertexam" />
	<form:form method="POST" modelAttribute="exam" action="${actionURL}">
		<div class="container">
			<div class="row">
				<div class="col-md-6">
					<form:label path="visitDate" />
					<form:input path="visitDate" />
					<br />
					<form:label path="code" />
					<form:input path="code" />
					<br />
				</div>
				<div class="col-md-6">
					<form:label path="examTypology" />
					<form:select path="examTypology">
						<form:options items="${examTypologiesList}" />
					</form:select>
					<br />
					<form:label path="medic" />
					<form:select path="medic">
						<form:options items="${medicsList}" />
					</form:select>
					<br />
					<form:label path="patient" />
					<form:select path="patient">
						<form:options items="${patientsList}" />
					</form:select>
				</div>
			</div>
		</div>
	</form:form>
	<div class="footer">
		Navigate: <a href="index">Index</a> <br /> <a href="addexamtypology">Add
			an exam typology</a>
	</div>

</body>
</html>