<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Your exams</title>
<link href="clinic.css" rel="stylesheet" type="text/css" />
<link href="bootstrap.css" rel="stylesheet" type="text/css" />
<c:set var="cp" value="${pageContext.request.contextPath}"/>
</head>
<body>
	<h1>Viewing exams</h1>
	<div class="container">
		<table class="table-striped clinic-table">
			<tr>
				<td>${patient.name}'s exams</td>
			</tr>
			<tr class="tr tr-first">
				<th>Id</th>
				<th>Code</th>
				<th>Typology</th>
				<th>Medic</th>
				<th>Prenotation date</th>
				<th>Visit date</th>
				<th>Results</th>
			</tr>
			<c:forEach var="exam" items="${examByPatientList}" varStatus="status">
				<tr>
					<td><b>${status.index + 1}</b></td>
					<td>${exam.code}</td>
					<td>${exam.examTypology}</td>
					<td>${exam.medic}</td>
					<td>${exam.prenotationDate}</td>
					<td>${exam.visitDate}</td>
					<td><a href="results/${exam.id}"><button>Result</button></a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div class="footer">
		Navigate: <a href="index">Index</a> <br /> <a href="examtypologies">Check
			all exam typologies available</a>
	</div>
</body>
</html>