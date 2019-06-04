<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>   
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<c:url value="/resources/css/TopMenu.css" />" rel="stylesheet">    
<spring:url value="/resources/js/jquery-3.3.1.min.js" var="standartLibraryJS" />
   
</head>
<body>
<script src="${standartLibraryJS}"></script>


<div class="ContainerForAllMenu">

<!-- Start MiddleTopMenu -->
<div class="MidleTopmenu">


<div class="ComeTogether">
<!-- Start Saerch Box -->
<a href="StartingPage">
<img class="logo" src="${pageContext.request.contextPath}/resources/images/TopMenu/logo.png" alt="" />
</a>

<div class="search-bar">
 <form:form  modelAttribute="SortingVariables" action="${pageContext.request.contextPath}/CatalogOfitems" method="GET" id="formSearchInput" >
 
  <form:input path="search" type="text" name="searchName" placeholder="Поиск.."/>

  <img id="actionByClick" class="header-search-button" src="${pageContext.request.contextPath}/resources/images/TopMenu/search.png" alt="" /> 

</form:form>
</div>
</div> 
<!-- End SearchBox -->

<script>
$("#actionByClick").click(function () {
   $("#formSearchInput").submit();
})
</script>

<div class="user-menus">

<img class="location" src="${pageContext.request.contextPath}/resources/images/TopMenu/location.png" alt="" />
<a class="Country">Украина, Одесса</a>
<!-- <a class="OpenUntill">Открыто до 14:00</a> -->



<div class="WhiteLine"></div>

<a href="shoppingCart" style="padding: 0;">
<img class="cart" src="${pageContext.request.contextPath}/resources/images/TopMenu/cart.png" alt="" />
</a>
<span class="coutnOfItemsInBusketOfCart">
<span class="number">
${CartForItemsOfTopMenu}
</span>
</span>
<a href="shoppingCart">Корзина</a>

</div> <!-- End OF RightSide Of MiddleTopMenu -->


</div>
<!-- End MiddleTopMenu -->


</div>






















<!-- Start Of BottomTopMenu -->





<!-- Start Of BottomTopMenu -->
<div class="BottomTopMenu">

<div class="ContainerForCenterALink">

<ul class="LeftListOfBottomTopMenu">
<li class="1FirstLiLevel">
<span class="dropdown">
  <button onclick="myFunctionInstrument()" class="dropbtn OnClickShadow">Инструменты</button>
</span>
</li>
<!-- End Copied Container -->


<!-- Start Copied Container -->
<li class="1FirstLiLevel">

<span class="dropdown">
  <button onclick="myFunctionBrand()" class="dropbtn OnClickShadow">Бренды</button>
</span>
</li>

<!-- End Copied Container -->
</ul>



<ul class="RightListOfBottomTopMenu">

<!-- <li class="1FirstLiLevel"><a href="ForTestingPage" class="rightSideOfBottomTopMenu">Testing Page</a></li> -->


<security:authorize  access="hasRole('ROLE_ADMIN')">
<li class="1FirstLiLevel"><a href="orderList" class="rightSideOfBottomTopMenu">Лист заказов</a></li>
<li class="1FirstLiLevel"><a href="product" class="rightSideOfBottomTopMenu">Create Product</a></li>
</security:authorize>
   
<security:authorize  access="isAuthenticated()">


<security:authorize  access="hasRole('ROLE_USER')">
<li class="1FirstLiLevel"><a href="#" class="rightSideOfBottomTopMenu">Привет, ${NameLoggedUser	}</a></li>
</security:authorize>

<%-- <security:authorize  access="hasRole('ROLE_ADMIN')"> --%>
<%-- <li class="1FirstLiLevel"><a href="PersonalTogglingForAdmin" class="rightSideOfBottomTopMenu">Привет, ${NameLoggedUser	}</a></li> --%>
<%-- </security:authorize> --%>

<li class="1FirstLiLevel"><a href="${pageContext.request.contextPath}/logout" class="rightSideOfBottomTopMenu">LogOut</a></li>
</security:authorize>
   
<security:authorize  access="isAnonymous()">
<li class="1FirstLiLevel"><a href="LogIn" class="rightSideOfBottomTopMenu">Войти</a></li>
<!-- <li class="1FirstLiLevel"><a href="уау" class="rightSideOfBottomTopMenu">Войти</a></li> -->

<li class="1FirstLiLevel"><a href="Register" class="rightSideOfBottomTopMenu">Зарегистрироваться</a></li>
</security:authorize>

</ul>

</div>
</div>




<!-- For instruments -->
<div class="Outer"  id="myDropdown"style="display:none;background: #ffffff;height: 250px;">
<div class="shopby">
<nav>
<ul class="CommonUlForDropDownMenuFirstLevel">	

<c:forEach items="${TopMenuInstruments}" var="listInstruments">	
<li class="liMenuOfDropMenu">
<a href="CatalogOfitems?SortingByCategory=${listInstruments.key}" class="HrefOfCatalogMenu">
<span class="iconAppliance">
<img class="slide1" src="${pageContext.request.contextPath}/resources/images/TopMenu/${listInstruments.value}.png" alt="" />
</span>
<span class="SignOfCatalogTopMenu">${listInstruments.value}</span>
</a>
</li>
</c:forEach>

</ul>
</nav>
</div>
</div>
<!-- ... -->



<!-- For Brands -->
<div class="Outer"  id="myDropdownBrand"style="display:none;background: #ffffff;height: 250px;">
<div class="shopby">
<nav>
<ul class="CommonUlForDropDownMenuFirstLevel">

<c:forEach items="${TopMenuBrands}" var="listBrand">	
<li class="liMenuOfDropMenu">
<a href="${pageContext.request.contextPath}/CatalogOfitems?brand=${listBrand.key}" class="HrefOfCatalogMenu">
<span class="iconAppliance">
<img class="slide1" 
src="${pageContext.request.contextPath}/resources/images/TopMenu/Brands/${listBrand.value}.png" alt="" />
</span>
<span class="SignOfCatalogTopMenu">${listBrand.value}</span>
</a></li>
</c:forEach>

</ul></nav></div></div>
<!-- ....... -->




<script>
/* When the user clicks on the button,
toggle between hiding and showing the dropdown content */
function myFunctionInstrument() {
  document.getElementById("myDropdown").classList.toggle("show");
  
  if($("#myDropdownBrand").hasClass("show")){
	  document.getElementById("myDropdownBrand").classList.toggle("show");
  }	
}
	
function myFunctionBrand() {
	  document.getElementById("myDropdownBrand").classList.toggle("show");
	  
	  if($("#myDropdown").hasClass("show")){
		  document.getElementById("myDropdown").classList.toggle("show");
	  }	
	}

</script>



</body>
</html>