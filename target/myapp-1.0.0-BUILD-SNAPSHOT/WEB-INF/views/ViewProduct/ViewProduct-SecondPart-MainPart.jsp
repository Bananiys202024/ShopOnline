<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %> 
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<c:url value="/resources/css/ViewProduct/ViewProduct-SecondPart-MainPart.css" />" rel="stylesheet">
</head>
<body>

<div class="LocationOfEntireContainer">

<div class="MainPart">
<section>




<!-- One Section --><!-- One Section --><!-- One Section --><!-- One Section -->
<!-- One Section --><!-- One Section --><!-- One Section --><!-- One Section -->
<!-- One Section --><!-- One Section --><!-- One Section --><!-- One Section -->
<!-- One Section --><!-- One Section --><!-- One Section --><!-- One Section -->
<!-- One Section --><!-- One Section --><!-- One Section --><!-- One Section -->

<div class="postcard">





<div class="photo">
<div class="title">
<div class="TitleUnderTitle">

<h1 class="heading-5 v-fw-regular">
${productFormOfViewPage.getName()}
</h1>
<!-- <div class="title-data lv "> -->
<!-- <div class="data-section"> -->
<!-- <div class="model product-data"> -->
<!-- <span class="product-data-label v-fw-medium body-copy">Model:</span> -->
<!-- <span class="product-data-value body-copy">EL52-2 </span> -->
<!-- </div> -->
<!-- <div class="sku product-data"> -->
<!-- <span class="product-data-label v-fw-medium body-copy">SKU:</span> -->
<!-- <span class="product-data-value body-copy">5578244 </span> -->
<!-- </div> -->
<!-- </div> -->
<!-- </div> -->

</div> <!-- End TitleUnderTitle -->

<div class="RatingUnderTitle">

<div class="FirstContainer">



<!-- <div class="ugc-stat"> -->
<!-- <a href="#"> -->
<!-- <div class="c-ratings-reviews v-small"> -->

<!-- <span class="c-stars c-stars-small"> -->
<!-- <span class="unfilled"></span> -->
<!-- <span class="filled" style="width:90%"></span> -->
<!-- </span> -->

<!-- <span class="c-reviews"> -->
<!-- <span class="c-review-average" aria-hidden="true">4.5</span> -->
<!-- <span class="c-total-reviews" aria-hidden="true"> (2 Customers)</span> -->
<!-- </span> -->

<!-- </div></a></div> -->





</div>

</div>
</div>




<div class="ContainerForThatPhoto">
<div class="ContainerForThatPhotoSecond">

<button>

<%-- <img class="ImageForViewOfCartItem" src="${pageContext.request.contextPath}/resources/images/ViewProduct/Cart.jpg" alt="" /> --%>

<img class="ImageForViewOfCartItem" alt="" src="${pageContext.request.contextPath}/productImage?code=${productFormOfViewPage.getCode()}">

</button>

</div>
</div>



<div class="border"></div>

<div class="TextunderImage">
<h3>Описание:</h3>

<p>

${productFormOfViewPage.getDescription()}.
</p>

</div>

</div>



<!-- End One Section --><!-- End One Section --><!-- End One Section --><!-- End One Section -->
<!-- End One Section --><!-- End One Section --><!-- End One Section --><!-- End One Section -->
<!-- End One Section --><!-- End One Section --><!-- End One Section --><!-- End One Section -->
<!-- End One Section --><!-- End One Section --><!-- End One Section --><!-- End One Section -->
<!-- End One Section --><!-- End One Section --><!-- End One Section --><!-- End One Section -->


<!-- Start Other Section --><!-- Start Other Section --><!-- Start Other Section -->
<!-- Start Other Section --><!-- Start Other Section --><!-- Start Other Section -->
<!-- Start Other Section --><!-- Start Other Section --><!-- Start Other Section -->
<!-- Start Other Section --><!-- Start Other Section --><!-- Start Other Section -->
<div class="RightPartFromImageOnPageOfViewCart">


<div class="CommonContainerInRightCatalogOfPageViewCart">

<div class="priceBlock">

<div class="price">


<!-- That Block For To point save money --><!-- That Block For To point save money -->
<!-- That Block For To point save money --><!-- That Block For To point save money -->
<!-- That Block For To point save money --><!-- That Block For To point save money -->
<div class="priceView-hero-price priceView-purchase-price">
<span aria-label="Your price for this item is $36.99">
<fmt:formatNumber currencySymbol="$"  value="${productFormOfViewPage.getPrice()}" type="currency" /></span>
</div>


<!-- <div class="pricing-price__savings">Save $23</div> -->
<!-- <div class="pricing-price__regular-price" aria-label="The price was $59.99">Was $59.99</div> -->
<!-- That Block For To point save money --><!-- That Block For To point save money -->
<!-- That Block For To point save money --><!-- That Block For To point save money -->
<!-- That Block For To point save money --><!-- That Block For To point save money -->

<div id="pdp-add-to-cart-button">
<div class="add-to-cart-button">
<div>
<%-- <a href="${pageContext.request.contextPath}/DuplicatedbuyProductForViewPage?code=${productFormOfViewPage.code}"> --%>

<a href="${pageContext.request.contextPath}/DuplicatedbuyProductFromViewPage?code=${productFormOfViewPage.getCode()}">

<%-- <a href="${pageContext.request.contextPath}/DuplicatedbuyProduct?code=${prodInfo.code}&page=${paginationProducts.getCurrentPage()}"> --%>


<button class="btn btn-lg btn-block button-state-default btn-primary btn-leading-ficon btnInRightSide">
<i class="ficon-cart">
<img class="ImageForPageOfView" src="${pageContext.request.contextPath}/resources/images/ViewProduct/CART.png" alt="" />


</i>
Добавить в корзину
</button>
</a>
</div>
</div>
</div>












 <security:authorize  access="hasRole('ROLE_ADMIN')">
<div id="pdp-add-to-cart-button">
<div class="add-to-cart-button">
<div>
<%-- <a href="${pageContext.request.contextPath}/DuplicatedbuyProductForViewPage?code=${productFormOfViewPage.code}"> --%>

<%-- <a href="${pageContext.request.contextPath}/DuplicatedbuyProductFromViewPage?code=${productFormOfViewPage.getCode()}"> --%>
<a href="${pageContext.request.contextPath}/productEditForViewPage?code=${productFormOfViewPage.getCode()}">
<%-- <a href="${pageContext.request.contextPath}/DuplicatedbuyProduct?code=${prodInfo.code}&page=${paginationProducts.getCurrentPage()}"> --%>


<button class="btn btn-lg btn-block button-state-default btn-primary btn-leading-ficon btnInRightSide">
<i class="ficon-cart">
<img class="ImageForPageOfView" src="${pageContext.request.contextPath}/resources/images/ViewProduct/CART.png" alt="" />


</i>
Редактировать
</button>
</a>
</div>
</div>
</div>

</security:authorize>














</div>

</div>

</div>









<div class="row">
<div class="col-xs-12 add-to-wishlist" >
<!-- <button type="button" class="btn btn-outline v-medium btn-block TransparentButton">Save for Later</button> -->
</div>
</div>



<div class="ForContainerUnderRightMenuForRatins">
<!-- <h3 class="headingOfRating">Reviews</h3> -->
<!-- Ratings &amp;  -->
<hr role="presentation">
<!-- <div class="ratings-headerOfOverallCustomerRating">Overall Customer Rating:</div> -->

<div class="rating-start">


<!-- <div class="ConainerForStarsSongEgorKrid"> -->
<%-- <c:if test="${prodInfo.rating>0.0}"> --%>
<%-- <c:if test="${prodInfo.rating<=0.5}"> --%>

<!-- <div class="ForRatingValueOfItemCatalog"> -->
<%-- <f:formatNumber type="number" pattern="0.00" value="${prodInfo.rating}"/> --%>
<!-- </div> -->
<%-- </c:if> --%>
<%-- </c:if> --%>
<!-- </div> -->


<!-- <a id="rating-count" class="HrefUnderRatingStars"> -->
<!-- <div class="c-ratings"> -->
<span class="StartOfRating">
<c:if test="${productFormOfViewPage.getRating()==5.0}">
<span class="StarsImage">
<span class="unfilledOfItemView"></span>
<span class="filledOfItemView"></span>
</span>
<span class="StarsNumbers">
<f:formatNumber type="number" pattern="0.00" value="${productFormOfViewPage.getRating()}"/>
</span>
</c:if>



<c:if test="${productFormOfViewPage.getRating()>=4.0}">
<c:if test="${productFormOfViewPage.getRating()<5.0}">
<span class="StarsImage">
<span class="unfilledOfItemView"></span>
<span class="filledOfItemView" style="width:100px;"></span>
</span>
<span class="StarsNumbers">
<f:formatNumber type="number" pattern="0.00" value="${productFormOfViewPage.getRating()}"/>
</span>
</c:if>
</c:if>


<c:if test="${productFormOfViewPage.getRating()>=3.0}">
<c:if test="${productFormOfViewPage.getRating()<4.0}">
<span class="StarsImage">
<span class="unfilledOfItemView"></span>
<span class="filledOfItemView" style="width:75px;"></span>
</span>
<span class="StarsNumbers">
<f:formatNumber type="number" pattern="0.00" value="${productFormOfViewPage.getRating()}"/>
</span>
</c:if>
</c:if>

<c:if test="${productFormOfViewPage.getRating()>=2.0}">
<c:if test="${productFormOfViewPage.getRating()<3.0}">
<span class="StarsImage">
<span class="unfilledOfItemView"></span>
<span class="filledOfItemView" style="width:50px;"></span>
</span>
<span class="StarsNumbers">
<f:formatNumber type="number" pattern="0.00" value="${productFormOfViewPage.getRating()}"/>
</span>
</c:if>
</c:if>

<c:if test="${productFormOfViewPage.getRating()>=1.0}">
<c:if test="${productFormOfViewPage.getRating()<2.0}">
<span class="StarsImage">
<span class="unfilledOfItemView"></span>
<span class="filledOfItemView" style="width:25px;"></span>
</span>
<span class="StarsNumbers">
<f:formatNumber type="number" pattern="0.00" value="${productFormOfViewPage.getRating()}"/>
</span>
</c:if>
</c:if>

<c:if test="${productFormOfViewPage.getRating()<1.0}">
<span class="StarsImage">
<span class="unfilledOfItemView"></span>
<span class="filledOfItemView" style="width:0px;"></span>
</span>
<span class="StarsNumbers">
<f:formatNumber type="number" pattern="0.00" value="${productFormOfViewPage.getRating()}"/>
</span>
</c:if>
</span>

 
</div>

<c:if test="${Rivises>1}">
<span class="SignUnderStartsOfRating">(${Rivises} Отзывы)</span>

<div class="ratings-message">
<span class="percent v-fw-medium">
<f:formatNumber type="number" pattern="0.00" value="${percentOfRevises}"/>%
</span>
<!-- of customers would recommend this product to a friend (1444 out of 1497) -->
</div>
</c:if>











<a href="ReviewRatingComment?code=${productFormOfViewPage.code}">
<button class="btn btn-lg btn-block button-state-default btn-primary btn-leading-ficon btnLALAInRightSide">	
Все отзывы
</button>
</a>

<a href="addComment?code=${productFormOfViewPage.code}">
<button class="btn btn-lg btn-block button-state-default btn-primary btn-leading-ficon btnLALAInRightSide">	
Добавить комментарий
</button>

</a>

</div>

</div>



<!-- End Other Section --><!-- End Other Section --><!-- End Other Section -->
<!-- End Other Section --><!-- End Other Section --><!-- End Other Section -->
<!-- End Other Section --><!-- End Other Section --><!-- End Other Section -->
<!-- End Other Section --><!-- End Other Section --><!-- End Other Section -->



</div>
</section>
</div>







</div>

</body>
</html>