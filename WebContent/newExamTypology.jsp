<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="springForm"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Pagina creazione nuova tipologia d'esame</title>
</head>
<body>
	<h1>Creazione nuova tipologia d'esame</h1>
	<div>Inserimento dati:</div>
	<springForm:form method="POST" commandName="examTypology" action="updateExamTypology">
	<div></div>

	<div>Naviga nel sito:</div>
	<div>
		<a href="newExamTypology.jsp">crea nuova tipologia d'esame</a>
	</div>
</body>
</html>
