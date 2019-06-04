	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>   
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
		<link href="<c:url value="/resources/css/ReviewRatingComment/ReviewRatingComment-AllOtherParts.css" />" rel="stylesheet">
<spring:url value="/resources/js/jquery-3.3.1.min.js" var="standartLibraryjQuery" />
<link href="<c:url value="/resources/css/ItemsOfShop/addComment/ForStars.css" />" rel="stylesheet">

<spring:url value="/resources/js/ForStars.js" var="ForStars" />
</head>
<body>

<script src="${standartLibraryjQuery}"></script>


<div class="IndentOfTop"></div>


<div class="LocationOfEntireContainer">
<div class="PaddingFromBoth">
<!-- Start Result Container -->


<!-- Start First Part Of Ways --><!-- Start First Part Of Ways --><!-- Start First Part Of Ways -->
<!-- Start First Part Of Ways --><!-- Start First Part Of Ways --><!-- Start First Part Of Ways -->
<!-- Start First Part Of Ways --><!-- Start First Part Of Ways --><!-- Start First Part Of Ways -->
<!-- Start First Part Of Ways --><!-- Start First Part Of Ways --><!-- Start First Part Of Ways -->
<!-- Start First Part Of Ways --><!-- Start First Part Of Ways --><!-- Start First Part Of Ways -->
<!-- Start First Part Of Ways --><!-- Start First Part Of Ways --><!-- Start First Part Of Ways -->
<!-- Start First Part Of Ways --><!-- Start First Part Of Ways --><!-- Start First Part Of Ways -->
<!-- Start First Part Of Ways --><!-- Start First Part Of Ways --><!-- Start First Part Of Ways -->
<!-- Start First Part Of Ways --><!-- Start First Part Of Ways --><!-- Start First Part Of Ways -->
<!-- Start First Part Of Ways --><!-- Start First Part Of Ways --><!-- Start First Part Of Ways -->
<nav class="NavThatShowWays">
<!-- <ol class="listOfNavWays"> -->
<!-- <li><a href="">Best Buy</a></li> -->
<!-- <li><span class="arrow"></span><a href="">Audio</a></li> -->
<!-- <li><span class="arrow"></span><a href="">Home Audio</a></li> -->
<!-- <li><span class="arrow"></span><a href="">CD Players &amp; Turntables</a></li> -->
<!-- <li><span class="arrow"></span><a href="">CD Players &amp; Recorders</a></li> -->
<!-- <li><span class="arrow"></span><a href="">Product Details</a></li> -->
<!-- </ol> -->
</nav>

<!-- End First Part Of Ways --><!-- End First Part Of Ways --><!-- End First Part Of Ways -->
<!-- End First Part Of Ways --><!-- End First Part Of Ways --><!-- End First Part Of Ways -->
<!-- End First Part Of Ways --><!-- End First Part Of Ways --><!-- End First Part Of Ways -->
<!-- End First Part Of Ways --><!-- End First Part Of Ways --><!-- End First Part Of Ways -->
<!-- End First Part Of Ways --><!-- End First Part Of Ways --><!-- End First Part Of Ways -->
<!-- End First Part Of Ways --><!-- End First Part Of Ways --><!-- End First Part Of Ways -->
<!-- End First Part Of Ways --><!-- End First Part Of Ways --><!-- End First Part Of Ways -->
<!-- End First Part Of Ways --><!-- End First Part Of Ways --><!-- End First Part Of Ways -->
<!-- End First Part Of Ways --><!-- End First Part Of Ways --><!-- End First Part Of Ways -->
<!-- End First Part Of Ways --><!-- End First Part Of Ways --><!-- End First Part Of Ways -->
<!-- End First Part Of Ways --><!-- End First Part Of Ways --><!-- End First Part Of Ways -->





<!-- Start Second Part Of Item --><!-- Start Second Part Of Item --><!-- Start Second Part Of Item -->
<!-- Start Second Part Of Item --><!-- Start Second Part Of Item --><!-- Start Second Part Of Item -->
<!-- Start Second Part Of Item --><!-- Start Second Part Of Item --><!-- Start Second Part Of Item -->
<!-- Start Second Part Of Item --><!-- Start Second Part Of Item --><!-- Start Second Part Of Item -->
<!-- Start Second Part Of Item --><!-- Start Second Part Of Item --><!-- Start Second Part Of Item -->
<!-- Start Second Part Of Item --><!-- Start Second Part Of Item --><!-- Start Second Part Of Item -->
<!-- Start Second Part Of Item --><!-- Start Second Part Of Item --><!-- Start Second Part Of Item -->
<!-- Start Second Part Of Item --><!-- Start Second Part Of Item --><!-- Start Second Part Of Item -->
<!-- Start Second Part Of Item --><!-- Start Second Part Of Item --><!-- Start Second Part Of Item -->




<div id="ItemOfReviewComment">

<h1 class="headerUnderReviewComment">Рейтинг &amp; Отзывы</h1>

<div class="OtherConteinrReviewComment">


<div class="FirstPartFromLeft">	
<figure class="product-image">
<a href="" class="ThatHrefOfVewImage">
<img class="ViewCommentOfImage" alt="" src="${pageContext.request.contextPath}/productImage?code=${productFormOfReviewRatingPage.getCode()}">
</a>
</figure>
</div>


<div class="SecondPartFromLeft">


<h2 class="product-title"><a href="#">
${productFormOfReviewRatingPage.getName()}

</a></h2>
<!-- <div class="product-model-info"> -->
<!-- <span> -->
<!-- <span class="v-fw-medium">Model:</span>DX-C390(B)</span> -->
<!-- <span> -->
<!-- <span class="v-fw-medium">SKU:</span>6762924</span> -->
<!-- </div> -->

<!-- <div class="stars"> -->
<!-- <div class="starsTutuLaLaChaCha"><div class="unfilledStars"></div><span class="unfilledOfItem"></span></div> -->
<!-- <div class="filledStars"><span class="filledOfItem"></span></div> -->






<span class="unfilledOfItem"></span>
<span class="filledOfItem" style="width: calc(${RatingValueOfItem}% * 8.5);"></span>
<div class="ForRatingValueOfItem" >
<fmt:formatNumber value="${RatingValueOfItem}" type="number" />
</div>

</div>


<div class="ThirdPartFromLeft">

<div class="priceView-hero-price priceView-purchase-price">
<span aria-label="Your price for this item is $179.99">


<fmt:formatNumber value="${productFormOfReviewRatingPage.getPrice()}" currencySymbol="$"  type="currency" /></span>
</div>

</div>

<div class="FourthPartFromLeft">

<div class="forButton">

<a href="${pageContext.request.contextPath}/AddToCart?code=${productFormOfReviewRatingPage.getCode()}">
<button class="btn btn-lg btn-block button-state-default btn-primary btn-leading-ficon btnInRightSide">
<i class="ficon-cart">
<img class="ImageForPageOfView" src="${pageContext.request.contextPath}/resources/images/ReviewRatingComment/CART.png" alt="" />


</i>
Добавить в корзину
</button>
</a>



<a href="addComment?code=${productFormOfReviewRatingPage.getCode()}">
<button class="btn btn-lg btn-block button-state-default btn-primary btn-leading-ficon btnLALAInRightSide">	
Добавить комментарий
</button>

</a>

</div>






</div>

</div>
</div>





<div class="locationOfComment">

<div class="MenuForComments">

<div class="LeftPartSignOfReviews"><h1>Отзывы:</h1></div>

<div class="SortByOfMenuForComments">

<div class="banner-right-column">
<label for="sort-by-select" class="sort-by-label">
<span class="sort-by-title">Сортировка: </span>

<form:form  modelAttribute="SortType" action="${pageContext.request.contextPath}/ReviewRatingComment" method="GET" id="formSelectMenu" >

<input style="display:none" name='code' value="${productFormOfReviewRatingPage.getCode()}">

  <form:select  path="ChoosenTypeOfSorting" class="c-dropdown v-small sort-dropdown">
     <c:forEach items="${listOfSortingTypes}" var="category">
            <option
            <c:if test="${category.key eq AttributeForSelecetdFieldInDropMenu}">selected="selected"</c:if>
            class="items" value="${category.key}">
            
<!--             translate by russian -->

            <c:if test="${category.value == 'Oldest'}">Сначало старые</c:if>
            <c:if test="${category.value == 'Lowest rating'}">Самый низкий рейтинг</c:if>
            <c:if test="${category.value == 'Newest'}">Самы новые</c:if>
           <c:if test="${category.value == 'Highest rating'}">Самый высокий рейтинг</c:if>

<!-- 			.... -->
             
            
            
            </option>
        </c:forEach>
  </form:select>
</form:form>

</label>
</div>
</div>


</div><!-- End MenuForComments -->

</div>

<!-- End Fourth Part Of SortMenu --><!-- End Fourth Part Of SortMenu --><!-- End Fourth Part Of SortMenu -->
<!-- End Fourth Part Of SortMenu --><!-- End Fourth Part Of SortMenu --><!-- End Fourth Part Of SortMenu -->
<!-- End Fourth Part Of SortMenu --><!-- End Fourth Part Of SortMenu --><!-- End Fourth Part Of SortMenu -->
<!-- End Fourth Part Of SortMenu --><!-- End Fourth Part Of SortMenu --><!-- End Fourth Part Of SortMenu -->
<!-- End Fourth Part Of SortMenu --><!-- End Fourth Part Of SortMenu --><!-- End Fourth Part Of SortMenu -->
<!-- End Fourth Part Of SortMenu --><!-- End Fourth Part Of SortMenu --><!-- End Fourth Part Of SortMenu -->
<!-- End Fourth Part Of SortMenu --><!-- End Fourth Part Of SortMenu --><!-- End Fourth Part Of SortMenu -->
<!-- End Fourth Part Of SortMenu --><!-- End Fourth Part Of SortMenu --><!-- End Fourth Part Of SortMenu -->
<!-- End Fourth Part Of SortMenu --><!-- End Fourth Part Of SortMenu --><!-- End Fourth Part Of SortMenu -->
<!-- End Fourth Part Of SortMenu --><!-- End Fourth Part Of SortMenu --><!-- End Fourth Part Of SortMenu -->
<!-- End Fourth Part Of SortMenu --><!-- End Fourth Part Of SortMenu --><!-- End Fourth Part Of SortMenu -->
<!-- End Fourth Part Of SortMenu --><!-- End Fourth Part Of SortMenu --><!-- End Fourth Part Of SortMenu -->
<!-- End Fourth Part Of SortMenu --><!-- End Fourth Part Of SortMenu --><!-- End Fourth Part Of SortMenu -->








<!-- Start Fith Part Section of Comment --><!-- Start Fith Part Section of Comment -->
<!-- Start Fith Part Section of Comment --><!-- Start Fith Part Section of Comment -->
<!-- Start Fith Part Section of Comment --><!-- Start Fith Part Section of Comment -->
<!-- Start Fith Part Section of Comment --><!-- Start Fith Part Section of Comment -->
<!-- Start Fith Part Section of Comment --><!-- Start Fith Part Section of Comment -->
<!-- Start Fith Part Section of Comment --><!-- Start Fith Part Section of Comment -->
<!-- Start Fith Part Section of Comment --><!-- Start Fith Part Section of Comment -->
<!-- Start Fith Part Section of Comment --><!-- Start Fith Part Section of Comment -->
<!-- Start Fith Part Section of Comment --><!-- Start Fith Part Section of Comment -->
<!-- Start Fith Part Section of Comment --><!-- Start Fith Part Section of Comment -->
<!-- Start Fith Part Section of Comment --><!-- Start Fith Part Section of Comment -->



<!-- <div class="v-fw-bold result-range"> -->
<!-- <div class="body-copy-lg results-summary" tabindex="0"> -->

<!-- <span class="message-text"> -->
<!-- 1-20 of 31Reviews -->
<!-- </span></div></div> -->


<div class="Comments">
<c:forEach items="${InfoAboutComments.list}" var="comInfo">


<c:if test="${comInfo.deleted}">
<!-- Delete container -->
<div class="DeleteContainer" id="Form${comInfo.id}">
<div class="Sign">
Отзыв удален пользователем
<fmt:formatDate value="${comInfo.modifiedDateTime}" pattern="yyyy-MM-dd HH:mm:ss" />

</div>
</div>
</c:if>
<!-- Delete container -->

<c:if test="${comInfo.id ne ChoosendFormForEdit}">
<c:if test="${!comInfo.deleted}">

<div id="FormOfComment" >
<div class="BlockForComment">
<ul class="review-list">

<!-- Start review-list section(item) --><!-- Start review-list section(item) -->
<!-- Start review-list section(item) --><!-- Start review-list section(item) -->

<li class="review-itemlast">
<div class="YetOneContainer">

<div class="ContainerHeaderOrContainerForName">
<div class="NameOfAComment">${comInfo.nameOfUser}</div>
</div>

<div class="ContainerForRatingANDDescribeOfFollowers">
<h1>${comInfo.title}</h1>
	

 <div class="UniteBothPostedAndModifiedTime" style="margin-bottom: 40px;">
<!--  //Not midified. Data of publishing -->
<div class="disclaimer">Posted: 
<time class="submission-date" title="${comInfo.dateTime}">
<fmt:formatDate value="${comInfo.dateTime}" pattern="yyyy-MM-dd HH:mm:ss" />
</time>
</div>

<c:if test="${comInfo.thatWasModified}">
<div class="disclaimer">Last modified
<time class="submission-date" title="Jan 6, 2016 10:46 AM">
${comInfo.modifiedDateTime}
</time>
</div>
</c:if>
</div>





<div class="ForWroteComments">

<div class="stars">
<div class="starsTutuLaLaChaCha">
<div class="unfilledStars"></div><span class="unfilled"></span></div>
<div class="filledStars"><span class="filled" style="width: calc(${comInfo.rating}% * 3.3);"></span></div>
</div>

<div class="ThatForRating">

<span class="ratingStarsComment">${comInfo.rating}</span>
</div>
</div>






<div class="ugc-review-body body-copy-lg"><p class="pre-white-space">
${comInfo.commentText}
</p></div>


</div>

<div class="unity">

<div class="LeftSide">

<c:if test="${comInfo.nameOfUser == NameLoggedUser}">
<c:if test="${comInfo.nameOfUser != NameLoggedUser}">
<div class="PostComment"><a href="deleteComment?page=${InfoAboutComments.currentPage}&TransitTypeSorting=${AttributeTransitTypeSorting}&code=${comInfo.product_id}&id=${comInfo.id}"><button type="button" class="PostComment">Delete</button></a></div>
<div class="EditComment"><a href="EditComment?page=${InfoAboutComments.currentPage}&code=${comInfo.id}&CodeOfItem=${comInfo.product_id}"><button type="button" class="PostComment">Edit</button></a></div>
</c:if>
</c:if>

<%-- ${NameLoggedUser} NameLoggedUser --%>
<c:if test="${comInfo.nameOfUser == NameLoggedUser}">
<div class="PostComment"><a href="deleteComment?page=${InfoAboutComments.currentPage}&TransitTypeSorting=${AttributeTransitTypeSorting}&code=${comInfo.product_id}&id=${comInfo.id}"><button type="button" class="PostComment">Delete</button></a></div>
<div class="EditComment"><a href="EditComment?page=${InfoAboutComments.currentPage}&code=${comInfo.id}&CodeOfItem=${comInfo.product_id}"><button type="button" class="PostComment">Edit</button></a></div>
</c:if>



<!-- <div class="ShowComment"><button type="button" class="PostCommentLast">Show comment(1)</button></div> -->
</div>


<div class="ContainersBlock">
<c:choose>
            <c:when test="${comInfo.wouldRecommendThisToAFriend}">
            
<div class="YesIWould">
<span class="Image">
<img class="X" src="${pageContext.request.contextPath}/resources/images/ReviewRatingComment/CheckMark.png" alt="" />
</span>
<p class="v-fw-medium  ugc-recommendation"> Yes, I would recommend this to a friend</p>
</div> 
 </c:when>
 
 
 
 <c:otherwise>
 <div class="NoIWouldNot">
<span class="Image">
<img class="X" src="${pageContext.request.contextPath}/resources/images/ReviewRatingComment/X.png" alt="" />
</span>
<p class="v-fw-medium  ugc-recommendation">No,I would not recommend this to a friend</p></div>
</c:otherwise>
	
</c:choose>
</div>


</div>
</div>
</li>
</ul>
</div>
</div>
</c:if>
</c:if>




<!-- That for edit comment --><!-- That for 




 comment --><!-- That for edit comment --><!-- That for edit comment -->
<!-- That for edit comment --><!-- That for edit comment --><!-- That for edit comment --><!-- That for edit comment -->
<!-- That for edit comment --><!-- That for edit comment --><!-- That for edit comment --><!-- That for edit comment -->
<!-- That for edit comment --><!-- That for edit comment --><!-- That for edit comment --><!-- That for edit comment -->
<!-- That for edit comment --><!-- That for edit comment --><!-- That for edit comment --><!-- That for edit comment -->
<!-- That for edit comment --><!-- That for edit comment --><!-- That for edit comment --><!-- That for edit comment -->
<!-- That for edit comment --><!-- That for edit comment --><!-- That for edit comment --><!-- That for edit comment -->
<!-- That for edit comment --><!-- That for edit comment --><!-- That for edit comment --><!-- That for edit comment -->
<!-- That for edit comment --><!-- That for edit comment --><!-- That for edit comment --><!-- That for edit comment -->
<!-- That for edit comment --><!-- That for edit comment --><!-- That for edit comment --><!-- That for edit comment -->
<!-- That for edit comment --><!-- That for edit comment --><!-- That for edit comment --><!-- That for edit comment -->
<!-- That for edit comment --><!-- That for edit comment --><!-- That for edit comment --><!-- That for edit comment -->


<c:if test="${comInfo.id eq ChoosendFormForEdit}">

<c:if test="${!comInfo.deleted}">

<div class="EditForm">

<form:form modelAttribute="CommentInfo" method="POST" enctype="multipart/form-data">

<form:input path="id" style="display:none;" value="${comInfo.id}"/>
<%-- <form:input path="PostedDate" style="display:none;" value="${comInfo.dateTime}"/> --%>
<%-- <form:input path="deleted" style="display:none;" value="${comInfo.deleted}"/> --%>
<%-- <form:input path="modifiedPostedDate" style="display:none;" value="${comInfo.modifiedDateTime}"/> --%>
<%-- <form:input path="nameOfUser" style="display:none;" value="${comInfo.nameOfUser}"/> --%>
<%-- <form:input path="product_id" style="display:none;" value="${comInfo.product_id}"/> --%>
<%-- <form:input path="thatWasModified" style="display:none;" value="${comInfo.thatWasModified}"/> --%>
<form:input path="rating"  class="forStarsRating" style="display:none;" value="${comInfo.rating}"/>
<form:input path="page"  class="forStarsRating" style="display:none;" value="${InfoAboutComments.currentPage}"/>
<form:input path="codeOfItem"  class="forStarsRating" style="display:none;" value="${comInfo.product_id}"/>



<div id="FormOfComment" >
<div class="BlockForComment">
<ul class="review-list">

<!-- Start review-list section(item) --><!-- Start review-list section(item) -->
<!-- Start review-list section(item) --><!-- Start review-list section(item) -->

<li class="review-itemlast">
<div class="YetOneContainer">

<div class="ContainerHeaderOrContainerForName">
<div class="NameOfAComment">${comInfo.nameOfUser}</div>
</div>

<div class="ContainerForRatingANDDescribeOfFollowers">

<div>
<h1>
<label class="titleTitle" for="title">Title:</label>
<form:input path="title" maxlength="60" class="inputForTitle"/>
<form:errors path="title" class="errorsTitle errors"/>
</h1>
</div>

	

 <div class="UniteBothPostedAndModifiedTime" style="margin-bottom: 40px;">
<!--  //Not midified. Data of publishing -->
<div class="disclaimer">Опубликовано: 
<time class="submission-date" title="${comInfo.dateTime}">
<fmt:formatDate value="${comInfo.dateTime}" pattern="yyyy-MM-dd HH:mm:ss" />
</time>
</div>

<c:if test="${comInfo.thatWasModified}">
<div class="disclaimer">Последнее изменение
<time class="submission-date" title="Jan 6, 2016 10:46 AM">
${comInfo.modifiedDateTime}
</time>
</div>
</c:if>
</div>




<div class="ContainerForstars">
<div class="ForWroteComments">

<div class="Assessment" style="font-size: 20px;">Рейтинг</div>
<div class="LabelsforStars" style="width: 167%;">


<!-- Stars assesmentStars assesmentStars assesmentStars assesmentStars assesmentStars assesmentStars assesment -->
<!-- Stars assesmentStars assesmentStars assesmentStars assesmentStars assesmentStars assesmentStars assesment -->
<!-- Stars assesmentStars assesmentStars assesmentStars assesmentStars assesmentStars assesmentStars assesment -->
<!-- Stars assesmentStars assesmentStars assesmentStars assesmentStars assesmentStars assesmentStars assesment -->
<!-- Stars assesmentStars assesmentStars assesmentStars assesmentStars assesmentStars assesmentStars assesment -->
<!-- Stars assesmentStars assesmentStars assesmentStars assesmentStars assesmentStars assesmentStars assesment -->

<div class="ThatForStars" style="margin: 15px 5px 15px 0px;">
<p class="ValueForStar" style="display:none;"></p>

<c:forEach var="counter"  begin="1" end="5">

<div class="ThatForTransparantStars jsScriptShow${counter}" >
<img class="Star star${counter} showPatric"  id="tg1" src="${pageContext.request.contextPath}/resources/images/addComment/Yellow_Star.png" alt="" />
<img class="TransparantStar" src="${pageContext.request.contextPath}/resources/images/addComment/star.png" alt="" />
</div>

</c:forEach>

</div>	

<!-- Stars assesmentStars assesmentStars assesmentStars assesmentStars assesmentStars assesmentStars assesment -->
<!-- Stars assesmentStars assesmentStars assesmentStars assesmentStars assesmentStars assesmentStars assesment -->
<!-- Stars assesmentStars assesmentStars assesmentStars assesmentStars assesmentStars assesmentStars assesment -->
<!-- Stars assesmentStars assesmentStars assesmentStars assesmentStars assesmentStars assesmentStars assesment -->
<!-- Stars assesmentStars assesmentStars assesmentStars assesmentStars assesmentStars assesmentStars assesment -->
<!-- Stars assesmentStars assesmentStars assesmentStars assesmentStars assesmentStars assesmentStars assesment -->


<div class="ThatForRating ThatForRatingEdit">
<span class="ChoosenRating">Выбраный рейтинг:</span>
<span class="ratingStarsComment ratingStarsCommentForEdit" style="margin:0;position:relative;font-size:20px;">${comInfo.rating}</span>
</div>
</div>






<div class="ugc-review-body body-copy-lg">
<%-- <p class="pre-white-space">${comInfo.commentText}</p> --%>
<div class="forTextarea" style="float: left;clear: left;display: inline-block;width: 100%;">

<form:textarea  style="width: 100%;height: 100px;font-size: 15px;" maxlength="2000" path="commentText" name="textArea" id="textArea textareaChars" class="TextArea"
 placeholder="Расскажите, чем именно вам понравился или не понравился этот товар: 
 - как долго вы пользуетесь товаром; 
 - довольны ли качеством товара;  
 - посоветовали бы вы купить его другим."/> 
  <span id="chars">2000</span> символов осталось

 <form:errors path="commentText" class="errors"/> 

</div>
</div>


</div>
</div>
<div class="unity">


<div class="CheckMarks">
<form:radiobuttons path = "Recommend" items="${numberList}" checked="checked"/>
<form:errors path="Recommend" class="errors RecommendErrors"/>
</div>




<div class="EditComment" style="float: left;;border-right:0px;width: 100%;margin-top: 15px;"><a style="text-decoration:none;"href="EditComment?CodeOfItem=${comInfo.product_id}"><button type="submit" class="EditSendBUtton" style="color: #fff;
border-color: #001e73;
background: #001e73;
margin-left: -14px;
border: 1px solid #0046be;
color: #0046be;
background: #fff;
text-decoration: none;
display: block;
text-align: center;
width: 30%;
border: 1px solid #0046be;
text-decoration: none;
font-size: 18px;
height: 35px;
line-height: normal;
cursor: pointer;
border-radius: 4px;
font-weight: 500;
text-align: center;
vertical-align: middle;
transition: all .3s ease-out 0s;
margin: 0px;
padding: 0px 10px 0px 10px;">Редактировать</button></a></div>


<div class="LeftSide" style="width: 280px;clear: left;">

<div class="RightSideOFNavigationPanel">



</div>







</div>




</div>
</div>
</div>


</li>
</ul>

</div>
</div>



</form:form>
</div>
</c:if>
</c:if>


<!-- That for edit comment --><!-- That for edit comment --><!-- That for edit comment --><!-- That for edit comment -->
<!-- That for edit comment --><!-- That for edit comment --><!-- That for edit comment --><!-- That for edit comment -->
<!-- That for edit comment --><!-- That for edit comment --><!-- That for edit comment --><!-- That for edit comment -->
<!-- That for edit comment --><!-- That for edit comment --><!-- That for edit comment --><!-- That for edit comment -->
<!-- That for edit comment --><!-- That for edit comment --><!-- That for edit comment --><!-- That for edit comment -->
<!-- That for edit comment --><!-- That for edit comment --><!-- That for edit comment --><!-- That for edit comment -->
<!-- That for edit comment --><!-- That for edit comment --><!-- That for edit comment --><!-- That for edit comment -->
<!-- That for edit comment --><!-- That for edit comment --><!-- That for edit comment --><!-- That for edit comment -->
<!-- That for edit comment --><!-- That for edit comment --><!-- That for edit comment --><!-- That for edit comment -->
<!-- That for edit comment --><!-- That for edit comment --><!-- That for edit comment --><!-- That for edit comment -->
<!-- That for edit comment --><!-- That for edit comment --><!-- That for edit comment --><!-- That for edit comment -->
<!-- That for edit comment --><!-- That for edit comment --><!-- That for edit comment --><!-- That for edit comment -->











</c:forEach>
</div>
</div>


<c:if test="${InfoAboutComments.list.size() eq 0}">

<div class="HigherClass">
<div class="MiddleClass">
<div class="InnerClass">
<p class="paragraphInside">Пока что нет комментариев для этого продукта</p>
</div>
</div>
</div>

</c:if>

<!-- End Fith Part Section of Comment --><!-- End Fith Part Section of Comment -->
<!-- End Fith Part Section of Comment --><!-- End Fith Part Section of Comment -->
<!-- End Fith Part Section of Comment --><!-- End Fith Part Section of Comment -->
<!-- End Fith Part Section of Comment --><!-- End Fith Part Section of Comment -->
<!-- End Fith Part Section of Comment --><!-- End Fith Part Section of Comment -->
<!-- End Fith Part Section of Comment --><!-- End Fith Part Section of Comment -->
<!-- End Fith Part Section of Comment --><!-- End Fith Part Section of Comment -->
<!-- End Fith Part Section of Comment --><!-- End Fith Part Section of Comment -->
<!-- End Fith Part Section of Comment --><!-- End Fith Part Section of Comment -->
<!-- End Fith Part Section of Comment --><!-- End Fith Part Section of Comment -->
<!-- End Fith Part Section of Comment --><!-- End Fith Part Section of Comment -->
<!-- End Fith Part Section of Comment --><!-- End Fith Part Section of Comment -->






















   
   </div>


















<div class="ThatContainerForPages">

<div class="WordForPages">

	<c:if test="${InfoAboutComments.totalPages > 1}">
       <div class="page-navigator">

<c:set var="currentSPageleft" value="${InfoAboutComments.currentPage-3}"/>

<c:set var="ThatInForward" value="${InfoAboutComments.currentPage+1}"/>
<c:set var="ThatInBack" value="${InfoAboutComments.currentPage-1}"/>

<c:choose>
<c:when test="${currentSPageleft >= 1}">	  
<a class="nav-item" href="ReviewRatingComment?page=${ThatInBack}&TransitTypeSorting=${AttributeTransitTypeSorting}&code=${productFormOfReviewRatingPage.code}">
<img class="ArrowsBothSides" src="${pageContext.request.contextPath}/resources/images/CatalogOfItems/LeftArrow.png" alt="" />
<span class="Back">Back</span></a>
</c:when>	 
<c:otherwise></c:otherwise>
</c:choose>	






 <c:choose>
 		  <c:when test="${currentSPageleft >= 1}">
 		  		
 		  		<a href="ReviewRatingComment?page=1&TransitTypeSorting=${AttributeTransitTypeSorting}&code=${productFormOfReviewRatingPage.code}" class="nav-item">1</a>
 		  		<span class="dots"><a class="nav-item">...</a></span>
 		  </c:when>	 
 		 <c:otherwise>
		</c:otherwise>
	</c:choose>	






          <c:forEach items="${InfoAboutComments.navigationPages}" var = "page">
              <c:if test="${page != -1 }">
              <c:set var="currentSPagePlus" value="${InfoAboutComments.currentPage+3}"/>
              <c:set var="currentSPageMinus" value="${InfoAboutComments.currentPage-3}"/>
              
              
              
              
              
              
				<c:if test="${currentSPagePlus > page }"> 
				<c:if test="${currentSPageMinus < page }"> 
	<c:choose>
 		 <c:when test="${InfoAboutComments.totalPages == page }"></c:when>
 		 <c:otherwise>
			<a href="ReviewRatingComment?page=${page}&TransitTypeSorting=${AttributeTransitTypeSorting}&code=${productFormOfReviewRatingPage.code}" class="nav-item">${page} </a>
  		</c:otherwise>
	</c:choose>				       
                </c:if>
                </c:if>
              </c:if>
          </c:forEach>
          
<c:set var="totalPagesS" value="${InfoAboutComments.totalPages}"/>
<c:set var="currentSPage" value="${InfoAboutComments.currentPage+3}"/>
	<c:choose>
 		  <c:when test="${currentSPage >= totalPagesS}">
 		  		<a href="ReviewRatingComment?page=${InfoAboutComments.totalPages}&TransitTypeSorting=${AttributeTransitTypeSorting}&code=${productFormOfReviewRatingPage.code}" class="nav-item">${InfoAboutComments.totalPages}</a>
 		  </c:when>	 
 		 <c:otherwise>
			<span class="dots"><a class="nav-item">...</a></span>
			<a href="ReviewRatingComment?page=${InfoAboutComments.totalPages}&TransitTypeSorting=${AttributeTransitTypeSorting}&code=${productFormOfReviewRatingPage.code}" class="nav-item">${InfoAboutComments.totalPages}</a>		
  		</c:otherwise>
	</c:choose>		



<c:choose>
<c:when test="${currentSPageleft >= 1}">	  
<a class="nav-item" href="ReviewRatingComment?page=${ThatInForward}&TransitTypeSorting=${AttributeTransitTypeSorting}&code=${productFormOfReviewRatingPage.code}">
<img class="ArrowsBothSides" src="${pageContext.request.contextPath}/resources/images/CatalogOfItems/RightArrows.png" alt="" />
<span class="Next">Next</span></a></c:when>	 
<c:otherwise></c:otherwise>
</c:choose>	



          
       </div>
</c:if></div></div>




<!-- End Result Container -->

<script>

$(".items" ).click(function() {
    $( "#formSelectMenu" ).submit();
    });

</script> 


<script>

var maxLength = 2000;
$('textarea').keyup(function() {
  var length = $(this).val().length;
  var length = maxLength-length;
  $('#chars').text(length);
});


</script>

<script src="${ForStars}"></script>



</body>
</html>