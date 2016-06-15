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
<c:url var="css3" value="/resources/page.css" />
<c:url var="js1" value="/resources/bootstrap.js" />
<c:set var="cp" value="${pageContext.request.contextPath}" />
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
			<div class="col-md-3"></div>
			<div class="col-md-6 text-center header-table">
				<h2>Exam Typologies List</h2>
			</div>
			<div class="col-md-3"></div>
		</div>
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<div class="col-md-3 cell cell-left">No</div>
				<div class="col-md-3 cell">Name</div>
				<div class="col-md-3 cell">Description</div>
				<div class="col-md-3 cell cell-right">Delete</div>
			</div>
			<div class="col-md-3"></div>
		</div>
		<c:forEach var="examTypology" items="${examTypologiesList}"
			varStatus="status">
			<div class="row">
				<div class="col-md-3"></div>
				<div class="col-md-6">
					<div class="col-md-3 cell cell-left">
						<b>${status.index + 1}</b>
					</div>
					<div class="col-md-3 cell">${examTypology.name}</div>
					<div class="col-md-3 cell">${examTypology.description}</div>
					<div class="col-md-3 cell cell-right">
						<a href="${cp}/delete/${examTypology.id}">Delete</a>
					</div>
				</div>
				<div class="col-md-3"></div>
			</div>
		</c:forEach>
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<div class="col-md-9"></div>
				<div class="col-md-3">
					<a href="${cp}/addexamtypology">Add More Exam Typologies</a>
				</div>
			</div>
			<div class="col-md-3"></div>
		</div>
	</div>
</body>
</html>