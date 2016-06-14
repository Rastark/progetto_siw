<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Pagina creazione nuova tipologia d'esame</title>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
</head>
<body>
	<h1>New exam typology creation page</h1>
	<div>Date form:</div>
	<c:url var="actionURL" value="/updateexamtypology" /> 
	<form:form method="POST" modelAttribute="examTypology" action="${actionURL}">

			<div>
				<form:label path="name">Name:</form:label>
				<br />
				<form:input path="name" /> 
				<form:errors path="name" />
				<br /> <br />
				<form:label path="code">Code:</form:label>
				<br />
				<form:input path="code" />
				<form:errors path="code" />
				<br /> <br />
				<form:label path="description">Description:</form:label>
				<br />
				<form:input path="description" />
				<form:errors path="description" />
				<br /> <br />
				<form:label path="cost">Cost:</form:label>
				<br />
				<form:input path="cost" />
				<form:errors path="cost" />
				<br />
				<form:label path="prerequisites">Prerequisites:</form:label>
				<br />
				<form:checkboxes items="prerequisitesList}" path="prerequisites" />
				<form:errors path="prerequisites" />
				<input type="submit" value="invia" />
				<br /><br />
				<form:label path="resultTypologies">Result Typologies:</form:label>
				<br />
				<form:checkboxes items="resultTypologiesList}" path="resultTypologies" />
				<form:errors path="resultTypologies" />
				<br />
				<input type="submit" value="invia" />
			</div>
	</form:form>

	<div>Naviga nel sito:</div>
	<div>
		<a href="addexamtypology">crea nuova tipologia d'esame</a>
	</div>
</body>
</html>