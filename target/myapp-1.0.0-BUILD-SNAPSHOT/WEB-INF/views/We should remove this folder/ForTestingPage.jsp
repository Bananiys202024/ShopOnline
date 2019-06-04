<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="springForm"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee Save Page</title>
<spring:url value="/resources/js/jquery-3.3.1.min.js" var="standartLibraryjQuery" />
<link href="<c:url value="/resources/css/CatalogOfitems/CatalogOfitems-SecondPart-SideMenuANDcatalogOfItemsTogether.css" />" rel="stylesheet">
</head>

<script src="${standartLibraryjQuery}"></script>

<form:form  action="ForTestingPage" modelAttribute="TestingClass" method="POST" enctype="multipart/form-data">

<form:label path = "name">Name</form:label>
<form:input type="text" path = "name" />
<form:errors path = "name" cssClass = "error" />



</form:form>

</body>
</html>