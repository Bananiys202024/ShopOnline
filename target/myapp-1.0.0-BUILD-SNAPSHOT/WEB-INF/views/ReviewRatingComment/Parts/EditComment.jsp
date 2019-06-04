<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>




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




<c:if test="${!comInfo.deleted}">



<form:form modelAttribute="CommentInfo" method="POST" enctype="multipart/form-data">

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
<form:input path="title" class="inputForTitle"/>
<form:errors path="title" class="errorsTitle errors"/>
</h1>
</div>

	

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




<div class="ContainerForstars">
<div class="ForWroteComments">

<div class="Assessment" style="font-size: 20px;">Assessment</div>
<div class="LabelsforStars" style="width: 167%;">


<!-- Stars assesmentStars assesmentStars assesmentStars assesmentStars assesmentStars assesmentStars assesment -->
<!-- Stars assesmentStars assesmentStars assesmentStars assesmentStars assesmentStars assesmentStars assesment -->
<!-- Stars assesmentStars assesmentStars assesmentStars assesmentStars assesmentStars assesmentStars assesment -->
<!-- Stars assesmentStars assesmentStars assesmentStars assesmentStars assesmentStars assesmentStars assesment -->
<!-- Stars assesmentStars assesmentStars assesmentStars assesmentStars assesmentStars assesmentStars assesment -->
<!-- Stars assesmentStars assesmentStars assesmentStars assesmentStars assesmentStars assesmentStars assesment -->

<div class="ThatForStars" style="margin: 15px 5px 15px 0px;">

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

<div class="ContainerForAssesments">
<div><span class="hide Assesment1">Very Bad</span></div>
<div><span class="hide Assesment2">Bad</span></div>
<div><span class="hide Assesment3">Hmmm...</span></div>
<div><span class="hide Assesment4">Well</span></div>
<div><span class="hide Assesment5">Very Well</span></div>
</div>


<!-- Stars assesmentStars assesmentStars assesmentStars assesmentStars assesmentStars assesmentStars assesment -->
<!-- Stars assesmentStars assesmentStars assesmentStars assesmentStars assesmentStars assesmentStars assesment -->
<!-- Stars assesmentStars assesmentStars assesmentStars assesmentStars assesmentStars assesmentStars assesment -->
<!-- Stars assesmentStars assesmentStars assesmentStars assesmentStars assesmentStars assesmentStars assesment -->
<!-- Stars assesmentStars assesmentStars assesmentStars assesmentStars assesmentStars assesmentStars assesment -->
<!-- Stars assesmentStars assesmentStars assesmentStars assesmentStars assesmentStars assesmentStars assesment -->


<div class="ThatForRating">
<span class="ratingStarsComment" style="margin: 0;font-size: 25px;padding-top: 23px;display: inline-block;padding-left: 7px;">${comInfo.rating}</span>
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
  <span id="chars">2000</span> characters remaining

 <form:errors path="commentText" class="errors"/> 

</div>
</div>


</div>
</div>
<div class="unity">


<div class="CheckMarks">
<form:radiobuttons path = "Recommend" items="${numberList}"/>
<form:errors path="Recommend" class="errors RecommendErrors"/>
</div>




<div class="EditComment" style="float: left;;border-right:0px;width: 100%;margin-top: 15px;"><a style="text-decoration:none;"href="EditComment?code=${comInfo.id}&CodeOfItem=${comInfo.product_id}"><button type="submit" class="EditSendBUtton" style="color: #fff;
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
<c:if test="${comInfo.nameOfUser == NameLoggedUser}">
<div class="PostComment"><a href="deleteComment?page=${InfoAboutComments.currentPage}&TransitTypeSorting=${AttributeTransitTypeSorting}&code=${comInfo.product_id}&id=${comInfo.id}"><button type="button" class="PostComment">Delete</button></a></div>


</c:if>

<div class="ShowComment" style="border-right: 0;padding-right: 0;"><button style="border-right:0;"	 type="button" class="PostCommentLast">Show comment(1)</button></div>


<div class="EditComment"><a style="text-decoration: none;" href="EditComment?code=${comInfo.id}&CodeOfItem=${comInfo.product_id}"><button type="button" class="PostComment">Edit</button></a></div>
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



</body>
</html>