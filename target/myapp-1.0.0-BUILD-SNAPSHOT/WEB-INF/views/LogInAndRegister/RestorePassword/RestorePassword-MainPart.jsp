<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<c:url value="/resources/css/LogInAndRegister/Register/Register-MainPart.css" />" rel="stylesheet">

<style>


 .error-message {
         color: #ff0000;
      }

      .errors {
         color: #000;
         background-color: #ffEEEE;
         border: 3px solid #ff0000;
         padding: 8px;
         margin: 16px;
      }

.subtitelOfh1 {
text-align: center;
margin-bottom: 20px;
font-size: 15px;
}



</style>

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
<h1 class="cia-heading cia-sign-on__heading">Восстановить пароль</h1>
<h4 class="subtitelOfh1">Пожалуйста введите ваш емайл</h4>

<%-- <c:url var="validateUrl" value="registerProcess" /> --%>
<%-- <form action="${validateUrl}" method="GET" class="LogInFor"> --%>

<form:form modelAttribute="restorepassword" method="POST" action="${pageContext.request.contextPath}/RestorePassword" enctype="multipart/form-data">

<div>
<label class="cia-form__label" for="fld-e">Емайл адрес</label>
<form:input path="emailAddress" />
<form:errors path="emailAddress" class="error-message" />
</div>	

<input class="ButtonOfSignIn" name="submit" type="submit" value="Продолжить">
</form:form>

<div class="disclaimer">
<p class="diclaimer">
* Код будет отправлен на ваш емайл
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