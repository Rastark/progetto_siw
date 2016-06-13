<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<head>
<title>Exam typology persisted</title>
</head>
<body>
	Hai inserito la tipologia d'esame: ${examTypology.name}
	<br /> Lista delle tipologie d'esame:
	<table cellspacing="0" cellpadding="6" border="1" width="100%">
		<tr>
			<td colspan="7"
				style="background-color: lightblue; color: darkgreen; font-size: 16pt"
				align="center">Exam Typologies List</td>
		</tr>
		<tr bgcolor="grey" style="color: white">
			<th>Id</th>
			<th>Name</th>
			<th>Code</th>
			<th>Cost</th>
			<th>Description</th>
			<th>Delete</th>
		</tr>

		<c:forEach var="examTypology" items="${examTypologiesList}"
			varStatus="status">
			<tr bgcolor="lightyellow">
				<td><b>${status.index + 1}</b></td>
				<td>${examTypology.name}</td>
				<td>${examTypology.code}</td>
				<td>${examTypology.cost}</td>
				<td>${examTypology.description}</td>
				<td><a
					href="${contextPath}/delete/${examTypology.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>