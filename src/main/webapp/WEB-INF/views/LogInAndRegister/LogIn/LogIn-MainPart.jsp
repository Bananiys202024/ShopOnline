	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<c:url value="/resources/css/LogInAndRegister/LogIn/LogIn-MainPart.css" />" rel="stylesheet">
</head>
<body>


<%--  <c:if test="${param.error == 'true'}"> --%>
<!--          <div style="color:red;margin:10px 0px;"> -->
          
<!--                 Login Failed!!!<br /> -->
<%--                 Reason :  ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message} --%>
                 
<!--          </div> -->
<%--  </c:if> --%>


<!-- Start Second Part Of Main Menu --><!-- StartSecond Part Of Main Menu --><!-- Second Part Of Main Menu -->
<!-- StartSecond Part Of Main Menu --><!-- Second Part Of Main Menu --><!-- Second Part Of Main Menu -->
<!-- Second Part Of Main Menu --><!-- Second Part Of Main Menu --><!-- Second Part Of Main Menu -->
<!-- Second Part Of Main Menu --><!-- Second Part Of Main Menu --><!-- Second Part Of Main Menu -->
<!-- Second Part Of Main Menu --><!-- Second Part Of Main Menu --><!-- Second Part Of Main Menu -->
<!-- Second Part Of Main Menu --><!-- Second Part Of Main Menu --><!-- Second Part Of Main Menu -->
<!-- Second Part Of Main Menu --><!-- Second Part Of Main Menu --><!-- Second Part Of Main Menu -->

<div class="IndentOfContainer"></div>


<div id="LogIn">
<div class="ThatForBackgroundColor">

<div class="comprehensiveContainer">

<div class="internationlization">
<a href="LogIn?locale=en" class="links">EN</a>
<!-- <span class="lines">|</span> -->
<a href="LogIn?locale=gr" class="links" style="border-left: 1px solid #dfe1f0;">GR</a>
<!-- <span class="lines">|</span> -->
<a href="LogIn?locale=ru" class="links" style="border-left: 1px solid #dfe1f0;">RU</a>
</div>
<div class="TighlyContainer">



<h1 class="cia-heading cia-sign-on__heading"><spring:message code="label.title" /></h1>

<form class="LogInFor" name='f' action="${pageContext.request.contextPath}/j_spring_security_check" method='POST'>

<div>
<label class="cia-form__label" for="fld-e"><spring:message code="label.email" /></label>
<input type='text' name='email' value='' id="fld-e" class="cia-form__field js-e" aria-required="true" data-validation-attribute="email" data-kiosk-input="true">
</div>

<c:if test="${param.error == 'true'}">
<div class="ThatAlarm">
<img class="AlarmImage" src="${pageContext.request.contextPath}/resources/images/LogInAndRegister/ExclaimingSign.png" alt="" />
<p>Please enter a valid user name or password.</p>     
</div>
</c:if>

<div>
<label class="cia-form__label" for="fld-e"><spring:message code="label.password" /></label>
<input type='password' name='password' id="password" class="cia-form__field js-e"   aria-required="true">
</div>

<a href="StartingPage">
<input class="ButtonOfSignIn" name="submit" type="submit" value="<spring:message code="label.submit" />">
</a>


<div class="disclaimer">
<p class="diclaimer">
Продолжая вы соглашаетесь с нашими<a href="#">условиями</a>, нашей <a href="#">Приватной политикой</a>.
</p></div>


<span class="RestorePassword">Забыл пароль?<a href="RestorePassword">Восстановить пароль</a></span>

<div class="ForGreyBackground">
<div class="CreateOne"><span class="HavntAccount">Нет аккаунта?<a href="Register">Создать аккаунт</a></span></div>
</div>


</form>

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