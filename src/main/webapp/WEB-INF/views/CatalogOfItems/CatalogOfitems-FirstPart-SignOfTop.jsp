<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="<c:url value="/resources/css/CatalogOfitems/CatalogOfitems-FirstPart-SignOfTop.css" />" rel="stylesheet">

</head>
<body>



<div class="IndentOfCatalogItems"></div>

<div class="OwnerContainerForDefineLocation">
<div class="DefineLocationInsideOwnerContainer">
<div class="TryToRegulateLocationOfTextInsideOfContainer">


<!-- Start Sign In the TOP --><!-- Start Sign In the TOP --><!-- Start Sign In the TOP --><!-- Start Sign In the TOP --><!-- Start Sign In the TOP -->
<!-- Start Sign In the TOP --><!-- Start Sign In the TOP --><!-- Start Sign In the TOP --><!-- Start Sign In the TOP --><!-- Start Sign In the TOP -->
<!-- Start Sign In the TOP --><!-- Start Sign In the TOP --><!-- Start Sign In the TOP --><!-- Start Sign In the TOP --><!-- Start Sign In the TOP -->
<!-- Start Sign In the TOP --><!-- Start Sign In the TOP --><!-- Start Sign In the TOP --><!-- Start Sign In the TOP --><!-- Start Sign In the TOP -->

<div class="app-container lv breadcrumb-and-title" data-reactroot="">

<!-- <nav aria-label="Breadcrumb" class="search-header-breadcrumb-list"> -->

<!-- <ol> -->
<!-- <li class="crumb-list-item"> -->
<!-- <a class="crumb" href="https://www.bestbuy.com/">магазин "Пила для сада"</a> -->
<!-- <span class="crumb-divider"></span></li> -->

<!-- <li class="crumb-list-item"> -->
<!-- <a class="crumb" href="https://www.bestbuy.com/site/electronics/audio/abcat0200000.c?id=abcat0200000">Audio</a> -->
<!-- </li> -->

<!-- </ol> -->
<!-- </nav> -->


<!-- Форматирование  переменных для рейтинга -->

<!-- /for price -->

<c:set var="ResultVariable" value=""/>
            <c:if test="${priceSorting eq 1000}">
            <c:set var="ResultVariable" value="1000"/>
            </c:if>
            
            <c:if test="${priceSorting eq 10003000}">
            <c:set var="ResultVariable" value="1000-3000"/>
            </c:if>
            
            
            <c:if test="${priceSorting eq 30005000}">
            <c:set var="ResultVariable" value="3000-5000"/>
            </c:if>
            
            
            <c:if test="${priceSorting eq 50009999}">
            <c:set var="ResultVariable" value="5000-9999"/>
            </c:if>
            
            
            <c:if test="${priceSorting eq 10000}">
            <c:set var="ResultVariable" value=">10000"/>
            </c:if>
            
<!-- ... -->


<!-- .....-->











<h1 class="browse-title title">
<span class="ChoosenFilters">Выбранные фильтры:</span>
<span class="OtherFilters">


<c:if test="${not empty searchName}">
<span class="blockFilter ">
<span class="categorySort leftAlign styleThat">${searchName}</span>
<a href="DeleteSearchName">
<img class="X styleThat" alt="Удалить этот фильтр?" src="${pageContext.request.contextPath}/resources/images/CatalogOfItems/XMark.png"  />
</a>
</span>
</c:if>


<c:if test="${not empty categorySort}">
<span class="blockFilter ">
<span class="categorySort leftAlign styleThat">${categorySort}</span>
<a href="DeleteCategory">
<img class="X styleThat" alt="Удалить этот фильтр?" src="${pageContext.request.contextPath}/resources/images/CatalogOfItems/XMark.png"  />
</a>
</span>
</c:if>


<c:if test="${not empty brandSort}">
<span class="blockFilter ">
<span class="categorySort leftAlign styleThat">${brandSort}</span>
<a href="DeleteBrand">
<img class="X styleThat" alt="Удалить этот фильтр?" src="${pageContext.request.contextPath}/resources/images/CatalogOfItems/XMark.png"  />
</a>
</span>
</c:if>

<c:if test="${not empty priceSorting}">
<span class="blockFilter ">
<span class="categorySort leftAlign styleThat"><c:out value = "${ResultVariable}"/></span>
<a href="DeletePrice">
<img class="X styleThat" alt="Удалить этот фильтр?" src="${pageContext.request.contextPath}/resources/images/CatalogOfItems/XMark.png"  />
</a>
</span>
</c:if>

<c:if test="${not empty ratingSorting}">
<span class="blockFilter ">
<span class="categorySort leftAlign styleThat">rating: ${ratingSorting} stars</span>
<a href="DeleteRating">
<img class="X styleThat" alt="X" src="${pageContext.request.contextPath}/resources/images/CatalogOfItems/XMark.png"  />
</a>
</span>
</c:if>


</span>
</h1>

</div>

<!-- End Sign In the TOP --><!-- End Sign In the TOP --><!-- End Sign In the TOP --><!-- End Sign In the TOP -->
<!-- End Sign In the TOP --><!-- End Sign In the TOP --><!-- End Sign In the TOP --><!-- End Sign In the TOP -->
<!-- End Sign In the TOP --><!-- End Sign In the TOP --><!-- End Sign In the TOP --><!-- End Sign In the TOP -->
<!-- End Sign In the TOP --><!-- End Sign In the TOP --><!-- End Sign In the TOP --><!-- End Sign In the TOP -->
<!-- End Sign In the TOP --><!-- End Sign In the TOP --><!-- End Sign In the TOP --><!-- End Sign In the TOP -->

</div>
</div>
</div>






</body>
</html>