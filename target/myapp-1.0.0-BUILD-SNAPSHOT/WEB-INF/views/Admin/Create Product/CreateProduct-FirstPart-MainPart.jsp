<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<c:url value="/resources/css/Admin/Create Product/CreateProduct-FirstPart-TopMenu.css" />" rel="stylesheet">
<spring:url value="/resources/js/jquery-3.3.1.min.js" var="standartLibraryjQuery" />



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
<div class="ThatForBackgroundColor">

<div class="comprehensiveContainer">
<div class="TighlyContainer">
<h1 class="cia-heading cia-sign-on__heading">Create Product</h1>

<%-- <form class="LogInFor" name='f' action="${pageContext.request.contextPath}/j_spring_security_check" method='POST'> --%>
<form:form modelAttribute="productForm" method="POST" enctype="multipart/form-data">

<div>
<label class="cia-form__label" for="fld-e">Name</label>
<form:input path="name" />
<form:errors path="name" class="error-message" />

<!-- <input type='text' name='username' value='' id="fld-e" class="cia-form__field js-e" required="" aria-required="true" data-validation-attribute="email" data-kiosk-input="true"> -->
</div>

<div>
<label class="cia-form__label" for="fld-e">Price</label>

<form:input path="price" />
<form:errors path="price" class="error-message" />

<!-- <input type='password' name='password' id="fld-e" class="cia-form__field js-e" required="" aria-required="true" data-validation-attribute="password" data-kiosk-input="true"> -->
</div>

<div>
<label class="cia-form__label" for="fld-e">Description</label>

<form:textarea path="description" class="forTextArea" cols='60' rows='8'/> 
<%-- <form:input path="description" /> --%>
<form:errors path="description" class="error-message" />

</div>

<!-- <div> -->
<!-- <label class="cia-form__label" for="fld-e">Category</label> -->

<%-- <form:input path="category" /> --%>
<%-- <form:errors path="category" class="error-message" /> --%>
<!-- <p class="subparagraph">You can add some catagories, -->
<!-- example: #Drill #Machine #Screw Driver #Saw #ChainSaw -->

<!-- </p>  -->
<!-- </div> -->

<div class="Secion">
<span class="sort-by-title addSecion">Add section:</span>
<div class="banner-right-column">
<label for="sort-by-select" class="sort-by-label">
  <form:select id="SectionChoose" path="section" class="c-dropdown v-small sort-dropdown section" items="${listOfSecionTypes}" multiple="multiple"/>
  <form:errors path="section" class="error-message ThatErrors" />
</label>
</div>
</div>
<!--  -->
<div class="Tips">
<span class="Tip">Используй ctr+click для выбора нескольких значений</span>
</div>

<div class="Secion">
<span class="sort-by-title addSecion">Add category:</span>
<div class="banner-right-column">
<label for="sort-by-select" class="sort-by-label">
  <form:select id="SectionChoose" style="margin-left: 24%;"  path="category" class="c-dropdown v-small sort-dropdown category" items="${listOfCategoryTypes}" multiple="multiple"/>
  <form:errors path="category" class="error-message ThatErrors" />
</label>
</div>
</div>

<div class="Tips">
<span class="Tip">Используй ctr+click для выбора нескольких значений</span>
</div>
<!--  -->

<div class="Secion">
<span class="sort-by-title addSecion" style="margin-left:40%">Add brand:</span>
<div class="banner-right-column">
<label for="sort-by-select" class="sort-by-label">
  <form:select id="SectionChoose" style="margin-left: 40%;"  path="brand" class="c-dropdown v-small sort-dropdown brand" items="${listOfBrands}" multiple="multiple"/>
  <form:errors path="brand" class="error-message ThatErrors" />
</label>
</div>
</div>

<div class="Tips">
<span class="Tip">Используй ctr+click для выбора нескольких значений</span>
</div>

<div class="ThatImageInterestig">
<label class="cia-form__label" for="fld-e"><span class="That">Image</span></label>
<img src="${pageContext.request.contextPath}/productImage?code=${productForm.code}" width="100"/>

<!-- <input type='password' name='password' id="fld-e" class="cia-form__field js-e" required="" aria-required="true" data-validation-attribute="password" data-kiosk-input="true"> -->
</div>

<div>


<c:if test="${ThatCheckOfQuantity}">
<div class="ThatAlarm">
<img class="AlarmImage" src="${pageContext.request.contextPath}/resources/images/LogInAndRegister/ExclaimingSign.png" alt="" />
<p>For quantity only numbers.</p>     
</div>
</c:if>

<label class="cia-form__label" for="fld-e">Quantity</label>

<form:input path="quantity" />
<form:errors path="quantity" class="error-message" />

</div>

<div>
<label class="cia-form__label" for="fld-e">Upload Image</label>
<form:input type="file" path="fileData"/>
</div>

<a href="StartingPage">
<input class="ButtonOfSignIn" name="submit" type="submit" value="Create product">
<!-- <input class="ButtonOfSignIn" name="submit" type="reset" value="Reset"> -->
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








</body>
</html>