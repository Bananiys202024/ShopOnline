<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<c:url value="/resources/css/LogInAndRegister/Register/Register-MainPart.css" />" rel="stylesheet">

</head>
<body>

<!-- Start Second Part Of Main Menu --><!-- StartSecond Part Of Main Menu --><!-- Second Part Of Main Menu -->
<!-- StartSecond Part Of Main Menu --><!-- Second Part Of Main Menu --><!-- Second Part Of Main Menu -->
<!-- Second Part Of Main Menu --><!-- Second Part Of Main Menu --><!-- Second Part Of Main Menu -->
<!-- Second Part Of Main Menu --><!-- Second Part Of Main Menu --><!-- Second Part Of Main Menu -->
<!-- Second Part Of Main Menu --><!-- Second Part Of Main Menu --><!-- Second Part Of Main Menu -->
<!-- Second Part Of Main Menu --><!-- Second Part Of Main Menu --><!-- Second Part Of Main Menu -->
<!-- Second Part Of Main Menu --><!-- Second Part Of Main Menu --><!-- Second Part Of Main Menu -->

<div class="IndentOfContainer"></div>


<div id="LogIn">
<div class="ThatForBackgroundColor" style="height: 700px;">

<div class="comprehensiveContainer" style="height: 350px;">
<div class="TighlyContainer">
<h1 class="cia-heading cia-sign-on__heading">Create an Account</h1>


<%-- <c:url var="validateUrl" value="registerProcess" /> --%>
<%-- <form action="${validateUrl}" method="GET" class="LogInFor"> --%>

<form:form modelAttribute="codeForm" method="GET" action="${pageContext.request.contextPath}/ReceiveCode" enctype="multipart/form-data">

<div>
<label class="cia-form__label" for="fld-e">Recieved code</label>
<form:input path="emailcode" />
<form:errors path="emailcode" class="error-message" />
</div>

<input class="ButtonOfSignIn" name="submit" type="submit" value="Create an Account">
</form:form>

<div class="disclaimer">
<p class="diclaimer">
Code was sended to your email: ${SendedEmail}
</p></div>



<!-- <div class="ForGreyBackground"> -->
<!-- <div class="CreateOne"><span class="HavntAccount">Already have an account?<a href="">Sign In</a></span></div> -->
<!-- </div> -->


</div>
</div>
</div>
</div>
<!-- End Second Part Of Main Menu --><!-- End Second Part Of Main Menu --><!-- End Second Part Of Main Menu -->
<!-- End Second Part Of Main Menu --><!-- End Second Part Of Main Menu --><!-- End Second Part Of Main Menu -->
<!-- End Second Part Of Main Menu --><!-- End Second Part Of Main Menu --><!-- End Second Part Of Main Menu -->
<!-- End Second Part Of Main Menu --><!-- End Second Part Of Main Menu --><!-- End Second Part Of Main Menu -->
<!-- End Second Part Of Main Menu --><!-- End Second Part Of Main Menu --><!-- End Second Part Of Main Menu -->
<!-- End Second Part Of Main Menu --><!-- End Second Part Of Main Menu --><!-- End Second Part Of Main Menu -->
<!-- End Second Part Of Main Menu --><!-- End Second Part Of Main Menu --><!-- End Second Part Of Main Menu -->

</body>
</html>