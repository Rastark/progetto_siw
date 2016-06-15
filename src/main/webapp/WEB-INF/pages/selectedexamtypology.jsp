<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<head>
<title>Find an exam by his code</title>
<c:url var="css1" value="/clinic.css" />
<c:url var="css2" value="/resources/bootstrap.css" />
<c:set var="cp" value="${pageContext.request.contextPath}" />
<link href="${css1}" rel="stylesheet" type="text/css" />
<link href="${css2}" rel="stylesheet" type="text/css" />
</head>
<body>
	<header class="navbar navbar-fixed-top">
	<div class="container">
		<div class="collapse navbar-collapse navHeaderCollapse">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="${cp}/">Home</a></li>
				<li><p></p></li>
				<li><a href='${cp}/login' data-toggle='modal'>Accedi</a></li>
			</ul>
		</div>
	</div>
	</header>
	<div>
		<p>Name: ${examTypology.name}</p>
		<p>Cost: ${examTypology.cost}</p>
		<p>Description: ${examTypology.description}</p>
		<p>Prerequisites:</p>
		<p>
			<c:forEach var="prerequisites" items="${prerequistesList}"
				varStatus="status">
				<p style="margin-left: 35px;"><b>${prerequisites.name}</b> - ${prerequisites.description}</p>
			</c:forEach>
		</p>
		<p>
			<a href="${cp }/listexamtypology">Look another exam typology</a>
		</p>

	</div>

</body>
</html>