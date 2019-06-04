<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<c:url value="/resources/css/LogInAndRegister/Register/Register-MainPart.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/LogInAndRegister/RestorePassword/RestorePassword-InputSendedCode.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/LogInAndRegister/RestorePassword/loading.css" />" rel="stylesheet">


<spring:url value="/resources/js/jquery-3.3.1.min.js" var="standartLibraryJS" />

</head>
<body>


<div class="loader DisplayOrNot"></div>	

<!-- Start Second Part Of Main Menu --><!-- StartSecond Part Of Main Menu --><!-- Second Part Of Main Menu -->
<!-- StartSecond Part Of Main Menu --><!-- Second Part Of Main Menu --><!-- Second Part Of Main Menu -->
<!-- Second Part Of Main Menu --><!-- Second Part Of Main Menu --><!-- Second Part Of Main Menu -->
<!-- Second Part Of Main Menu --><!-- Second Part Of Main Menu --><!-- Second Part Of Main Menu -->
<!-- Second Part Of Main Menu --><!-- Second Part Of Main Menu --><!-- Second Part Of Main Menu -->
<!-- Second Part Of Main Menu --><!-- Second Part Of Main Menu --><!-- Second Part Of Main Menu -->
<!-- Second Part Of Main Menu --><!-- Second Part Of Main Menu --><!-- Second Part Of Main Menu -->

<script src="${standartLibraryJS}"></script>


<div class="IndentOfContainer"></div>


<div id="LogIn">
<div class="ThatForBackgroundColor" style="height: 700px;">

<div class="comprehensiveContainer" style="height: 400px;">
<div class="TighlyContainer">
<h1 class="cia-heading cia-sign-on__heading">Восстановить ваш пароль</h1>
<h4 class="subtitelOfh1">Пожалуйста введите код отправленый на ваш емайл ${TemporaryVariable}.</h4>




<div class="cia-verify-phone__actions">
<a class="js-resend-code" id="actionbyclickResendCode">Повторно отправить код</a>
<a href="RestorePassword" class="js-change-email">Изменить емайл адрес</a>
</div>

<!-- <div class="loaderContainer"> -->

<!-- <div class="sign">Resending code...</div> -->

<!-- <div id="loader"> -->

<!-- <div class="loader"></div>	 -->

<!-- </div> -->

<%-- <img class="ResendingCode" src="${pageContext.request.contextPath}/resources/images/LogInAndRegister/SendingCode.png" alt="" /> --%>


<!-- </div> -->


<!-- <div class="loader TogglingShowOrHide" id="loading" style="position: absolute;">Loading...</div> -->

<%-- <c:url var="validateUrl" value="registerProcess" /> --%>
<%-- <form action="${validateUrl}" method="GET" class="LogInFor"> --%>

<form:form modelAttribute="restorepassword" method="GET" action="${pageContext.request.contextPath}/InputRestorePassword" enctype="multipart/form-data">

<div>
<label class="cia-form__label" for="fld-e">Полученый код</label>
<form:input path="InputedCode" />
<form:errors path="InputedCode" class="error-message" />
</div>

<input class="ButtonOfSignIn" name="submit" type="submit" value="Continue">
</form:form>

<!-- <div class="disclaimer"> -->
<!-- <p class="diclaimer"> -->
<!-- * Код был отправлен на ваш  -->
<!-- </p></div> -->

<!-- <div id="loader"> -->
<!-- </div> -->


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

<input value="${TemporaryVariable}" style="display:none" id="GetEmail"/>

<script>
$("#actionbyclickResendCode").click(function(e) {

	
	var email = $('#GetEmail').val();
	
	executeAJAXResendCode(email,e);

});




function executeAJAXResendCode(email,e) {

 e.preventDefault();
 e.stopPropagation();
 
 //show or hide loader
 $('#BottomPartMenu').addClass("BackgroundForLoading");
 $('#LogIn').addClass("BackgroundForLoading");
 $('#TopMenuOfCheckOut').addClass("BackgroundForLoading");
 $('.loader').removeClass("DisplayOrNot");
 //....
 
 $.ajax({
      type: "GET",
      dataType : 'json',
 contentType: "application/x-www-form-urlencoded; charset=UTF-8", // this is the default value, so it's optional
      url: "ResendCodeAgain",
      data: "email=" + email,
      success: function(msg){
    	  //show or hide loader
    	  $('#BottomPartMenu').removeClass("BackgroundForLoading");
    	  $('#LogIn').removeClass("BackgroundForLoading");
    	  $('#TopMenuOfCheckOut').removeClass("BackgroundForLoading");
    	  $('.loader').addClass("DisplayOrNot");
    	  //...
    	  
    	  
           alert(msg.msg);
           console.log("ERROR: ", e);
               },
 error : function(e) {
	//show or hide loader
	  $('#BottomPartMenu').removeClass("BackgroundForLoading");
	  $('#LogIn').removeClass("BackgroundForLoading");
	  $('#TopMenuOfCheckOut').removeClass("BackgroundForLoading");
	  $('.loader').addClass("DisplayOrNot");
	  //...
		console.log("ERROR: ", e);
// 		display(e);
	},
	done : function(e) {
	//show or hide loader
  	  $('#BottomPartMenu').removeClass("BackgroundForLoading");
  	  $('#LogIn').removeClass("BackgroundForLoading");
  	  $('#TopMenuOfCheckOut').removeClass("BackgroundForLoading");
  	  $('.loader').addClass("DisplayOrNot");
  	  //...
		console.log("DONE");
// 		enableSearchButton(true);
	}

	
 });
 
}
</script>








</body>
</html>