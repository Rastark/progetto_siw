<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Pagina creazione nuova tipologia d'esame</title>
</head>
<body>
	<h1>Creazione nuova tipologia d'esame</h1>
	<div>Inserimento dati:</div>
	<c:url var="actionURL" value="/addexamtypology" /> 
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
				<input type="submit" value="invia" />
				<br />
			</div>
<!-- <input type="text" name="name"  -->
	</form:form>

	<div>Naviga nel sito:</div>
	<div>
		<a href="addexamtypology.jsp">crea nuova tipologia d'esame</a>
		<p>Ciao!</p>
	</div>

</body>
</html>