<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="springForm"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<c:url value="/resources/css/Admin/Create Product/CreateProduct-FirstPart-TopMenu.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/ItemsOfShop/EditComment/EditComment.css" />" rel="stylesheet">
<%-- <link href="<c:url value="/resources/css/ItemsOfShop/addComment/addComment.css" />" rel="stylesheet"> --%>
<link href="<c:url value="/resources/css/ItemsOfShop/addComment/ForStars.css" />" rel="stylesheet">
<spring:url value="/resources/js/ForStars.js" var="ForStars" />
<spring:url value="/resources/js/jquery-3.3.1.min.js" var="standartLibraryjQuery" />

 <style>
      .error {
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


<script src="${standartLibraryjQuery}"></script>



<!-- Start Second Part Of Main Menu --><!-- StartSecond Part Of Main Menu --><!-- Second Part Of Main Menu -->
<!-- StartSecond Part Of Main Menu --><!-- Second Part Of Main Menu --><!-- Second Part Of Main Menu -->
<!-- Second Part Of Main Menu --><!-- Second Part Of Main Menu --><!-- Second Part Of Main Menu -->
<!-- Second Part Of Main Menu --><!-- Second Part Of Main Menu --><!-- Second Part Of Main Menu -->
<!-- Second Part Of Main Menu --><!-- Second Part Of Main Menu --><!-- Second Part Of Main Menu -->
<!-- Second Part Of Main Menu --><!-- Second Part Of Main Menu --><!-- Second Part Of Main Menu -->
<!-- Second Part Of Main Menu --><!-- Second Part Of Main Menu --><!-- Second Part Of Main Menu -->

<div class="IndentOfContainer"></div>


<div id="LogIn">
<div class="ThatForBackgroundColor" style="height: 1080px;">

<div class="comprehensiveContainer" style="height: 900px;">
<div class="TighlyContainer">
<h1 class="cia-heading cia-sign-on__heading">Edit Comment</h1>

<%-- <form class="LogInFor" name='f' action="${pageContext.request.contextPath}/j_spring_security_check" method='POST'> --%>
<form:form modelAttribute="productFormForEdit" method="POST" enctype="multipart/form-data">

<div>

</div>


<!-- <div> -->

<!-- 				Employee ID: -->
<%-- 				<springForm:input path="id" /> --%>
<%-- 				<springForm:errors path="id" cssClass="error" /> --%>

<!-- </div> -->
































<div class="ContainerForstars">
<div class="InsideForStars">

<div class="Assessment" style="font-size: 20px;">Assessment:</div>

<div class="LabelsforStars" style="margin-top: -10px;">

<div class="ThatForStars">

<p class="ValueForStar" style="display:none;"></p>

<div class="ThatForTransparantStars jsScriptShow1" >
<img class="Star star1 showPatric" id="tg1" src="${pageContext.request.contextPath}/resources/images/addComment/Yellow_Star.png" alt="" />
<img class="TransparantStar" src="${pageContext.request.contextPath}/resources/images/addComment/star.png" alt="" />
</div>


<div class="ThatForTransparantStars jsScriptShow2">
<p class="SecondP" style="display:none;"></p>

<img class="Star star2 showPatric" id="tg1" src="${pageContext.request.contextPath}/resources/images/addComment/Yellow_Star.png" alt="" />
<img class="TransparantStar" src="${pageContext.request.contextPath}/resources/images/addComment/star.png" alt="" />
</div>


<div class="ThatForTransparantStars jsScriptShow3">
<img class="Star star3 showPatric" id="tg1" src="${pageContext.request.contextPath}/resources/images/addComment/Yellow_Star.png" alt="" />
<img class="TransparantStar" src="${pageContext.request.contextPath}/resources/images/addComment/star.png" alt="" />
</div>

<div class="ThatForTransparantStars jsScriptShow4">
<img class="Star star4 showPatric" id="tg1" src="${pageContext.request.contextPath}/resources/images/addComment/Yellow_Star.png" alt="" />
<img class="TransparantStar" src="${pageContext.request.contextPath}/resources/images/addComment/star.png" alt="" />
</div>

<div class="ThatForTransparantStars jsScriptShow5">
<img class="Star star5 showPatric" id="tg1" src="${pageContext.request.contextPath}/resources/images/addComment/Yellow_Star.png" alt="" />
<img class="TransparantStar" src="${pageContext.request.contextPath}/resources/images/addComment/star.png" alt="" />
</div>

</div>	
</div></div></div>

<div class="ContainerForAssesments">
<div><span class="hide Assesment1">Very Bad</span></div>
<div><span class="hide Assesment2">Bad</span></div>
<div><span class="hide Assesment3">Hmmm...</span></div>
<div><span class="hide Assesment4">Well</span></div>
<div><span class="hide Assesment5">Very Well</span></div>
</div>





















































<div style="margin-top: 50px;">
<!-- <label class="cia-form__label" for="fld-e">Price</label> -->

<%-- <form:input path="price" /> --%>
<%-- <form:errors path="price" class="error-message" /> --%>


<form:label path = "title">title</form:label>
<form:input type="text" path = "title" />
<form:errors path = "title" cssClass = "error" />

<div class="Container" style="margin-top: 30px;">
<form:label path = "commentText">Comment</form:label>
<form:textarea style="margin-top: 10px;width: 100%;" type="text" path = "commentText" />
<form:errors path = "commentText" cssClass = "error" />
</div>
<%-- ${numberList.get(0)} --%>


<div class="CheckMarks">
<form:radiobuttons path = "Recommend"  items="${numberList}"  checked="checked" />
<form:errors path="Recommend" class="errors RecommendErrors"/>
</div>



<!-- <input type='password' name='password' id="fld-e" class="cia-form__field js-e" required="" aria-required="true" data-validation-attribute="password" data-kiosk-input="true"> -->
</div>

<div>

<!-- <label class="cia-form__label" for="fld-e">Description</label> -->
<%-- <form:input path="description" /> --%>
<%-- <form:errors path="description" class="error-message" /> --%>



</div>


<%-- <c:if test="${ThatCheckOfQuantity}"> --%>
<!-- <div class="ThatAlarm"> -->
<%-- <img class="AlarmImage" src="${pageContext.request.contextPath}/resources/images/LogInAndRegister/ExclaimingSign.png" alt="" /> --%>
<!-- <p>For quantity only numbers.</p>      -->
<!-- </div> -->
<%-- </c:if> --%>



<!-- <div> -->

<%-- <form:label path = "quantity">Quantity</form:label> --%>
<%-- <form:input type="text" path = "quantity" /> --%>
<%-- <form:errors path = "quantity" cssClass = "error" /> --%>

<!-- </div> -->

<!-- <div class="ThatImageInterestig"> -->
<!-- <label class="cia-form__label" for="fld-e"><span class="That">Image</span></label> -->
<%-- <img src="${pageContext.request.contextPath}/productImage?code=${productFormForEdit.getCode()}" width="100"/> --%>

<!-- <!-- <input type='password' name='password' id="fld-e" class="cia-form__field js-e" required="" aria-required="true" data-validation-attribute="password" data-kiosk-input="true"> --> 
<!-- </div> -->

<!-- <div> -->
<!-- <label class="cia-form__label" for="fld-e">Upload Image</label> -->
<%-- <form:input type="file" path="fileData"/> --%>
<!-- </div> -->

<a href="StartingPage">
<input class="ButtonOfSignIn" name="submit" type="submit" value="Edit product">
<input class="ButtonOfSignIn" name="submit" type="reset" value="Reset">
</a>


</form:form>






<!-- </form> -->

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



<script src="${ForStars}"></script>





</body>
</html>