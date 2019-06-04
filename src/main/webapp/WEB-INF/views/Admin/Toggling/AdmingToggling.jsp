<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>.errors {color:red;font-size:18px;}</style>
<style>
.SimpleToggling
{
top: 30%;
left: 30%;
position: absolute;
}
</style>

</head>
<body>

<div class="SimpleToggling">
<form:form  enctype="multipart/form-data" modelAttribute="AdminInfo" method="POST" >

<h1>Toggling used email and phone on web site</h1>
<h3>It need for sending message and email from web site name<br>
We will use that email to send messages to emails of our users.<br>
We will use that phone to send messsages to phones of our users.<br>
This toggle important for right working of application.
</h3>

<table>

<tr>
<td>Setted values:</td>
</tr>
<tr>
<td>Company Phone: ${CompanyData.phone}</td>
</tr>

<tr>
<td>Company Email: ${CompanyData.email}</td>


<tr>
<td>Phone:<form:input path="phoneAdmin"/></td>
<td><form:errors path="phoneAdmin" class="errors"/></td>
</tr>

<tr>
<td>Email:<form:input path="emailAdmin"/></td>
<td><form:errors path="emailAdmin" class="errors"/></td>
</tr>


<tr>
<td><input type="submit" value="Отправить"/></td>
</tr>

</table>

</form:form>
</div>

</body>
</html>