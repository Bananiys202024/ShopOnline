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


.cia-verify-phone__actions {
    text-align: center;
    line-height: 1em;
    margin-bottom: 18px;
}

.cia-verify-phone__actions a:first-child {
    border-left: none;
}



.cia-verify-phone__actions a {
    display: inline-block;
    padding: 0 10px;
    border-left: 1px solid #1d252c;
}

.btn-default-link, a {
    color: #0457c8;
    text-decoration: none;
}

.btn-default-link, a {
    background-color: rgba(0,0,0,0);
}

.cia-verify-phone__actions {
    text-align: center;
    line-height: 1em;
}


.cia-verify-phone__actions a {
    display: inline-block;
    padding: 0 10px;
    border-left: 1px solid #1d252c;
}

.btn-default-link, a {
    color: #0457c8;
    text-decoration: none;
}

.btn-default-link, a {
    background-color: rgba(0,0,0,0);
}

.cia-verify-phone__actions {
    text-align: center;
    line-height: 1em;
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
<h1 class="cia-heading cia-sign-on__heading">Ввести новый пароль</h1>


<form:form modelAttribute="restorepassword" method="GET" action="${pageContext.request.contextPath}/SuccessRestorePassword" enctype="multipart/form-data">

<div>
<label class="cia-form__label" for="fld-e">Пароль</label>
<form:input path="newPassword"/>
<form:errors path="newPassword" class="error-message" />
</div>

<div>
<label class="cia-form__label" for="fld-e">Подтвердить пароль</label>
<form:input path="repeateNewPassword" />
<form:errors path="repeateNewPassword" class="error-message" />
</div>

<input class="ButtonOfSignIn" name="submit" type="submit" value="Сохранить & Продолжить">
</form:form>

<div class="disclaimer">
<p class="diclaimer">
<!-- * Code was sended to your email -->
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