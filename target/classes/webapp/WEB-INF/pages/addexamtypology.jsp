<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Pagina creazione nuova tipologia d'esame</title>
<c:set var="cp" value="${pageContext.request.contextPath}" />
<c:url var="css1" value="/clinic.css" />
<c:url var="css2" value="/resources/bootstrap.css" />
<c:url var="css3" value="/resources/page.css" />
<c:url var="js1" value="/resources/bootstrap.js" />
<link href="${css1}" rel="stylesheet" type="text/css" />
<link href="${css2}" rel="stylesheet" type="text/css" />
<link href="${css3}" rel="stylesheet" type="text/css" />
<script src="${js1}" type="text/javascript"></script>
</head>
<body>
	<header class="navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<a href="${cp}/" class="navbar-brand">Clinica DawnStone</a>

			<button class="navbar-toggle" data-toggle="collapse"
				data-target=".navHeaderCollapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
		</div>
		<div class="collapse navbar-collapse navHeaderCollapse">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="${cp}/">Home</a></li>
				<li><a href='#' data-toggle='modal'>Accedi</a></li>
			</ul>
		</div>
	</div>
	</header>
	<div class="container home-body-container">
		<div class="row">
			<div class="col-md-12 text-left">
				<h3>Insert Exam Typology</h3>
			</div>
		</div>
		<c:url var="actionURL" value="/updateexamtypology" />
		<form:form method="POST" modelAttribute="examTypology"
			action="${actionURL}">

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
				<%-- 				<form:label path="prerequisites">Prerequisites:</form:label> --%>
				<!-- 				<br /> -->
				<%-- 				<form:checkboxes items="prerequisitesList}" path="prerequisites" /> --%>
				<%-- 				<form:errors path="prerequisites" /> --%>
				<!-- 				<input type="submit" value="invia" /> -->
				<!-- 				<br /><br /> -->
				<%-- 				<form:label path="resultTypologies">Result Typologies:</form:label> --%>
				<!-- 				<br /> -->
				<%-- 				<form:checkboxes items="resultTypologiesList}" path="resultTypologies" /> --%>
				<%-- 				<form:errors path="resultTypologies" /> --%>
				<!-- 				<br /> -->
				<input type="submit" value="invia" />
		</form:form>
		<div>
			<a href="${cp}/">Home</a>
		</div>
	</div>
</body>
</html>