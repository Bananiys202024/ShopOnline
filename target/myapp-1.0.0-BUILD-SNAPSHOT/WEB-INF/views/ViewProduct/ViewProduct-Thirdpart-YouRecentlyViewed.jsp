<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<c:url value="/resources/css/ViewProduct/ViewProduct-ThirdPart-TrendingDeals.css" />" rel="stylesheet">
</head>
<body>








<div class="ContainerForLocationTrendingDealsFirst">
<div class="ContainerForLocationTrendingDealsSecond">
<div class="ContainerForLocationTrendingDealsThird">
<div class="ContainerForLocationTrendingDealsFourth">

<div class="header">
<h2>Вы недавно смотрели</h2>
<!-- <span class="page-count">Page -->
<!-- <span class="current_Page">1</span> -->
<!-- of -->
<!-- <span class="total_Page">3</span> -->
<!-- </span> -->
</div>

<div class="horizontal-ruler"></div>


<div class="containerForInnerItems">
<div class="YetOneContainerForInnerItems">
<div class="LastInnerContainerForPushItemsINsideThisContainer">
<!-- <a class="arrowWraper"> -->
<!-- <div class="leftArrow"> -->
<!-- <span class="Previous">Previous</span> -->
<!-- </div> -->
<!-- </a> -->

<div class="WrapperForThingsInside">
<div class="LastContainerForThingsInside">



<!-- Start owner container of trending deals -->

<c:forEach items="${paginationProducts.list}" var="prodInfo">
<div class="ContainerForThingInside">
<div class="ContainerForThingInsideForLocation">
<div class="TighlyContainer">


<a class="ImageWithSign" href="#">
<span class="ImageWrapper">
<span class="ThatOfImage">
<%--    <img class="Image" src="${pageContext.request.contextPath}/resources/images/StartingPage/imageOfNewCss.jpg" alt="Image" /> --%>
   <img class="Image" style="margin-left: 0;width: 150px;" alt="" src="${pageContext.request.contextPath}/productImage?code=${prodInfo.code}">

	
</span>
</span>

<span class="ItemTitle">${prodInfo.name}</span>
</a>

<!-- Start Ration -->
<div class="Ratings">

<a class="RatingLink">

<span class="YetOneContainerOfRating">

<span class="fill" style="width: ${prodInfo.rating * 20}%;display: inline-block;"></span>
<span class="LaLaLaOfRating">Rating ${prodInfo.rating} of stars</span>
</span>


<span class="mayBeThatWatchingNearWithRating">${NumberReviews} voices
<span class="ThatSeamToBeReviews"></span>
</span>

</a>

</div>
<!-- End Rating -->




<!-- <div class="OnSale"> -->
<!-- <div class="StaticPrice"> -->
<!-- On Sale:</div> -->

<div class="ForAlignOf99And9">
<div class="PriceView">${prodInfo.price}</div>
</div>
</div>







</div>
</div>
</div>
</c:forEach>
<!-- End owner container of trending deals -->



</div>
</div>
<!-- <a class="RightArrowWraper"> -->
<!-- <div class="RightArrow"> -->
<!-- <span class="RightPrevious">PreviousRight</span> -->
<!-- </div>" -->
<!-- </a> -->
</div>
</div>
</div>








</div>
</div>
</div>
</div>
</body>
</html>