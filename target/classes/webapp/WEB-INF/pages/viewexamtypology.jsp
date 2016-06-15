<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<head>
<title>Exam typology list</title>
<c:url var="css1" value="/clinic.css" />
<c:url var="css2" value="/resources/bootstrap.css" />
<c:set var="cp" value="${pageContext.request.contextPath}" />
<link href="${css1}" rel="stylesheet" type="text/css" />
<link href="${css2}" rel="stylesheet" type="text/css" />
</head>
<body>
	<table class="table-striped clinic">
		<tr>
			<td colspan="6" class="clinic-first" align="center">Exam
				typology ${examTypology.name} details</td>
		</tr>
		<tr>
			<th>Name</th>
			<th>Code</th>
			<th>Cost</th>
			<th>Description</th>
			<th>Prerequisite</th>
			<th>Result Typologies</th>
		</tr>
		<tr>
			<td>${examTypology.name}</td>
			<td>${examTypology.code}</td>
			<td>${examTypology.cost}</td>
			<td>${examTypology.description}</td>
			<td><c:forEach var="prerequisite"
					items="${examTypology.prerequisitesList}" varStatus="status">
						${prerequisite.name} : ${prerequisite.description}<br />
				</c:forEach></td>
			<td><c:forEach var="resultTypology"
					items="${examTypology.resultTypologiesList}" varStatus="status">
						${resultTypology.name}<br />
				</c:forEach></td>
		</tr>
	</table>
	<div class="footer">
		Navigate: <a href="${cp}/">Index</a> <br /> <a
			href="${cp}/listexamtypology">Go back to the exam typologies list</a>
		<br />
	</div>
</body>
</html>