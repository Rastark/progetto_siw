<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Home</title>
<c:url var="css1" value="/resources/clinic.css" />
<c:url var="css2" value="/resources/bootstrap.css" />
<c:set var="cp" value="${pageContext.request.contextPath}" />
<link href="${css1}" rel="stylesheet" type="text/css" />
<link href="${css2}" rel="stylesheet" type="text/css" />
</head>
<body>
	<h1 class="page-header text-center clinic-header">

		Welcome to the <i>Dawnstone Clinic</i><sup><small>TM</small></sup>

	</h1>
	<div class="container">
		<div class="col-md-4">
			<ul>
				<li><a href="${cp}/login">Login</a></li>
				<li><a href="news.asp">News</a></li>
				<li><a href="contact.asp">Contact</a></li>
				<li><a href="about.asp">About</a></li>
			</ul>
		</div>
		<div>Navigate:</div>
		<div>
			<a href="${cp}/addexamtypology">create a new exam typology</a><br />
			<a href="${cp}/listexamtypology">View exam typologies list</a><br />
			<a href="${cp}/addexam">Add a new exam prenotation</a><br /> <a
				href="${cp}/findmedic">Add results to an exam</a><br />
		</div>
	</div>
</body>
</html>
