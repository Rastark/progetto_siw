<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Cerca Esami Medico</title>
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
				<h3>Search Medic</h3>
			</div>
		</div>
		<c:url var="actionURL" value="/" />
		<form:form method="POST" modelAttribute="exam" action="${actionURL}">

			<form:label path="name">Name</form:label>
			<form:input path="name" />
			<br />
			<form:label path="surname">Surname</form:label>
			<form:input path="surname" />
			<br>
			<br>
			<input type="submit" value="invia" />
		</form:form>
		<div>
			<a href="${cp}/">Home</a>
		</div>
	</div>
</body>
</html>