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
<div class="ThatForBackgroundColor" style="height: 1200px;">

<div class="comprehensiveContainer" style="height: 1045px;">
<div class="TighlyContainer">

<h1 class="cia-heading cia-sign-on__heading">Создать аккаунт</h1>

<form:form modelAttribute="registerForm" method="POST" enctype="multipart/form-data">


<div>

<label class="cia-form__label" for="fld-e">Имя</label>
<form:input path="name" />
<form:errors path="name" class="error-message" />
</div>

<div>

<label class="cia-form__label" for="fld-e">Пароль</label>
<form:input path="password" type="password" />
<form:errors path="password" class="error-message" />


</div>

<div>

<label class="cia-form__label" for="fld-e">Подтвердить пароль</label>
<form:input path="confirmpassword"  type="password"/>
<form:errors path="confirmpassword" class="error-message" />


</div>

<div>

<label class="cia-form__label" for="fld-e">Емайл</label>
<form:input path="email" />
<form:errors path="email" class="error-message" />
<div class="">* Только gmail</div>

</div>

<div>
<label class="cia-form__label" for="fld-e">Телефон</label>
<form:input path="phone" />
<form:errors path="phone" class="error-message" />


</div>

<input class="ButtonOfSignIn" name="submit" type="submit" value="Создать аккаунт">

</form:form>

<div class="disclaimer">
<p class="diclaimer">
Продолжая, вы согласаетесь с <a href="#">Условиями</a>, нашей<a href="#">Приватной политики</a>.
</p></div>


<span class="RestorePassword">Забыл пароль?<a href="RestorePassword">Восставновить</a></span>

<div class="ForGreyBackground">
<div class="CreateOne"><span class="HavntAccount">Уже есть аккаунт?<a href="LogIn">Регистрация</a></span></div>


</div>


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