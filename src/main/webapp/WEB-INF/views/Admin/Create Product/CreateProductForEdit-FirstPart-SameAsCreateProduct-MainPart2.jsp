<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="springForm"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<c:url value="/resources/css/Admin/Create Product/CreateProduct-FirstPart-TopMenu.css" />" rel="stylesheet">
<spring:url value="/resources/js/jquery-3.3.1.min.js" var="standartLibraryjQuery" />

 <style>
      .error {
         color: #ff0000;
         display: inline-block;
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
<div class="ThatForBackgroundColor" style="height: 2100px;">

<div class="comprehensiveContainer" style="height: 1969px;">
<div class="TighlyContainer">
<h1 class="cia-heading cia-sign-on__heading">Create Product</h1>

<form:form  modelAttribute="productFormForEdit" method="POST" enctype="multipart/form-data">


<div>


<form:label path = "name">Name</form:label>
<form:input type="text" path = "name" />
<form:errors path = "name" cssClass = "error" />

</div>





<div>


<form:label path = "price">Price</form:label>
<form:input type="text" path = "price" />
<form:errors path = "price" cssClass = "error" />

</div>

<div>

  
<form:label path = "description">Description</form:label>
<form:textarea path="description" class="forTextArea" cols='60' rows='8'/> 
<form:errors path = "description" cssClass = "error" />

</div>




<div class="Secion">
<span class="sort-by-title addSecion">Add section:</span>
<div class="banner-right-column section">
<label for="sort-by-select" class="sort-by-label">
  <form:select   id="Sections"  path="section" class="c-dropdown v-small sort-dropdown" multiple="multiple">
   
  <c:forEach var="item" items="${listOfSecionTypes}">
  <c:choose>
   
  <c:when test = "${fn:contains(SectionContainer, item.value)}">
  <form:option id="Options" selected="true" value="${item.value}"/>
  </c:when>
  
   <c:otherwise>
     <form:option id="Options" value="${item.value}"/>      
   </c:otherwise>
          
  </c:choose>          
  </c:forEach>
  
  </form:select>
  <form:errors path="section" class="error-message ThatErrors" cssClass = "error"/>
</label>
</div>
</div>
<!--  -->
<div class="Tips">
<span class="Tip">Используй ctr+click для выбора нескольких значений</span>
</div>

<div class="Secion">
<span class="sort-by-title addSecion">Add category:</span>
<div class="banner-right-column category">
<label for="sort-by-select" class="sort-by-label">
  <form:select   style="margin-left: 24%;" id="Category"  path="category" class="c-dropdown v-small sort-dropdown"  multiple="multiple">
 
 <c:forEach var="item" items="${listOfCategoryTypes}">
  <c:choose>
   
  <c:when test = "${fn:contains(CategoryContainer, item.value)}">
  <form:option selected="true" value="${item.value}"/>
  </c:when>
  
   <c:otherwise>
     <form:option value="${item.value}"/>      
   </c:otherwise>
          
  </c:choose>          
  </c:forEach>
  </form:select>
 
 
  <form:errors path="category" class="error-message ThatErrors" cssClass = "error"/>
</label>
</div>
</div>

<div class="Tips">
<span class="Tip">Используй ctr+click для выбора нескольких значений</span>
</div>
<!--  -->

<div class="Secion">
<span class="sort-by-title addSecion" style="margin-left:40%">Add brand:</span>
<div class="banner-right-column brand">
<label for="sort-by-select" class="sort-by-label">
  <form:select style="margin-left: 40%;" id="Brand"  path="brand" class="c-dropdown v-small sort-dropdown"  multiple="multiple">
    
  <c:forEach var="item" items="${listOfBrands}">
  <c:choose>
   
  <c:when test = "${fn:contains(BrandContainer, item.value)}">
  <form:option id="BrandOption" selected="true" value="${item.value}"/>
  </c:when>
  
   <c:otherwise>
     <form:option id="BrandOption" value="${item.value}"/>      
   </c:otherwise>
          
  </c:choose>          
  </c:forEach>
  
  </form:select>
 
 
 
  <form:errors path="brand" class="error-message ThatErrors" cssClass = "error" />
</label>
</div>
</div>

<div class="Tips">
<span class="Tip">Используй ctr+click для выбора нескольких значений</span>
</div>



<div>

<form:label path = "quantity">Quantity</form:label>
<form:input type="text" path = "quantity" />
<form:errors path = "quantity" cssClass = "error" />

</div>




<div class="ThatImageInterestig">
<label class="cia-form__label" for="fld-e"><span class="That">Image</span></label>
<img src="${pageContext.request.contextPath}/productImage?code=${productFormForEdit.getCode()}" width="100"/>

<!-- <input type='password' name='password' id="fld-e" class="cia-form__field js-e" required="" aria-required="true" data-validation-attribute="password" data-kiosk-input="true"> -->
</div>

<div>
<label class="cia-form__label" for="fld-e">Upload Image</label>
<form:input type="file" path="fileData"/>
</div>

<a href="StartingPage">
<input class="ButtonOfSignIn" name="submit" type="submit" value="Edit product">
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





<!-- var prev_val; -->

<!-- $('#dropdown').focus(function() { -->
<!--     prev_val = $(this).val(); -->
<!-- }).change(function() { -->
<!--      $(this).blur() // Firefox fix as suggested by AgDude -->
<!--     var success = confirm('Are you sure you want to change the Dropdown?'); -->
<!--     if(success) -->
<!--     { -->
<!--         alert('changed'); -->
<!--         // Other changed code would be here... -->
<!--     }   -->
<!--     else -->
<!--     { -->
<!--         $(this).val(prev_val); -->
<!--         alert('unchanged'); -->
<!--         return false;  -->
<!--     } -->
<!-- }); -->










<script>


jQuery(function(){
	
    var DesicionAboutChangeSection=false;
    var DesicionAboutChangeCategory=false;
    var DesicionAboutChangeBrands=false;
	
    
//Sections
$('#Sections option').mousedown( function(e) {


	 if(DesicionAboutChangeSection==false)
	 {
	 var value = confirm('Вы уверены что хотите поменять секцию продукта?');	
	  	 
	 if(value==true)
	 {
	  DesicionAboutChangeSection=true;
	 }
	 else 
	 {
	  e.preventDefault();
	 }
	 
	 }
	
	});
//.....

//Category
$('#Category option').mousedown( function(e) {


	 if(DesicionAboutChangeCategory==false)
	 {
	 var value = confirm('Вы уверены что хотите поменять категорию продукта?');	
	  	 
	 if(value==true)
	 {
		 DesicionAboutChangeCategory = true;
	 }
	 else 
	 {
	  e.preventDefault();
	 }
	 
	 }
	
	});
//...

//Brand
$('#Brand option').mousedown( function(e) {


	 if(DesicionAboutChangeBrands==false)
	 {
	 var value = confirm('Вы уверены что хотите поменять бренд продукта?');	
	  	 
	 if(value==true)
	 {
		 DesicionAboutChangeBrands = true;
	 }
	 else 
	 {
	  e.preventDefault();
	 }
	 
	 }
	
	});
//..
})

// $( ".section" ).on( "click", function() {
// 	alert('Your action here');
// 	});
// 	alert('Your action here');
// 	   if(window.confirm("Are you sure?"))
// 	     alert('Your action here');
// 	});
			//get list of selected options
		
// 	    var option_all = $("#Sections option:selected").map(function () {
//    	     return $(this).text();
//   		  }).get().join(',');

// 		$.each(option_all.split(","), function(i,e){
//    		$("#Sections option[value='" + e + "']").prop("selected", true);
//    		alert(e);
// 		});
		
// 		alert('Chan');
// 		//...
		
		

// $('.category').click(function(){ 
// 	   if(window.confirm("Are you sure?"))
// 	     alert('Your action here');
// 	});
	
// $('.brand').click(function(){ 
// 	   if(window.confirm("Are you sure?"))
// 	     alert('Your action here');
// 	});

</script>




</body>
</html>