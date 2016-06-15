<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<head>
<title>Exam typology persisted</title>
<c:url var="css1" value="/clinic.css"/>
<c:url var="css2" value="/resources/bootstrap.css"/>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<link href="${css1}" rel="stylesheet" type="text/css" />
<link href="${css2}" rel="stylesheet" type="text/css" />
</head>
<body>
	Hai inserito la tipologia d'esame: ${examTypology.name}
	<br /> Lista delle tipologie d'esame:
	<table class="table-striped clinic">
		<tr>
			<td colspan="6" class="clinic-first" align="center">Exam Typologies List</td>
		</tr>
		<tr>
			<th>No</th>
			<th>Name</th>
			<th>Code</th>
			<th>Cost</th>
			<th>Description</th>
			<th>Delete</th>
		</tr>

		<c:forEach var="examTypology" items="${examTypologiesList}"
			varStatus="status">
			<tr>
				<td><b>${status.index + 1}</b></td>
				<td>${examTypology.name}</td>
				<td>${examTypology.code}</td>
				<td>${examTypology.cost}</td>
				<td>${examTypology.description}</td>
				<td><a href="${cp}/deleteet/${examTypology.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<div class="footer">
		Navigate: <a href="${cp}/">Index</a> <br /> <a href="${cp}/addexamtypology">Add
			another exam typology</a>
	</div>
</body>
</html>