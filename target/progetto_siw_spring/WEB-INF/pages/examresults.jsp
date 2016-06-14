<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<head>
<title>Exam results</title>
<link href="clinic.css" rel="stylesheet" type="text/css" />
<link href="bootstrap.css" rel="stylesheet" type="text/css" />
</head>
<body>
<h1>Exam ${exam.id} results</h1>
<table class="table-striped clinic-table">
<tr class="tr-first">
<th>No</th>
<th>Typology</th>
<th>Result</th>
</tr>
<c:forEach var="result" items="${resultList}" varStatus="status">
<tr>
<td><b>${status.index + 1}</b></td>
<td>${result.resultTypology}</td>
<td>${result.value}
</td>
</tr>
</c:forEach>
</table>
	<div class="footer">
		Navigate: <a href="index">Index</a> <br /> <a href="patientexams"> 
		<a href="patientexams">Go back to your exams</a>
	</div>
</body>
</html>