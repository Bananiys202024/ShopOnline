<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %> 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="<c:url value="/resources/css/ItemsOfShop/addComment/addComment.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/ItemsOfShop/addComment/ForStars.css" />" rel="stylesheet">
<spring:url value="/resources/js/jquery-3.3.1.min.js" var="standartLibraryjQuery" />
<spring:url value="/resources/js/ForStars.js" var="ForStars" />

</head>
<body>



<script src="${standartLibraryjQuery}"></script>

<%-- <form class="form-horizontal" id="comment-form"> --%>

<div class="ForMainPart">
<div class="AlignToTopMapOfLocation">

<div class="ForWhiteSpace">

<div class="InsideForWhiteSpace">

<div class="ForDivisionBothSideOfRiver">

<div class="FirsPart">
<!-- Start . Part for stars. -->

<div class="ContainerForstars">
<div class="InsideForStars">

<div class="Assessment" style="font-size: 20px;">Assessment</div>
<div class="LabelsforStars" style="width: 167%;">

<div class="ThatForStars">
<p class="ValueForStar" style="display:none;"></p>

<c:forEach var="counter"  begin="1" end="5">

<div class="ThatForTransparantStars jsScriptShow${counter}" >
<img class="Star star${counter} showPatric"  id="tg1" src="${pageContext.request.contextPath}/resources/images/addComment/Yellow_Star.png" alt="" />
<img class="TransparantStar" src="${pageContext.request.contextPath}/resources/images/addComment/star.png" alt="" />
</div>

</c:forEach>

</div>	

<!-- <div class="ContainerForAssesments"> -->
<!-- <div><span class="hide Assesment1">Very Bad</span></div> -->
<!-- <div><span class="hide Assesment2">Bad</span></div> -->
<!-- <div><span class="hide Assesment3">Hmmm...</span></div> -->
<!-- <div><span class="hide Assesment4">Well</span></div> -->
<!-- <div><span class="hide Assesment5">Very Well</span></div> -->
<!-- </div> -->

<form:form modelAttribute="CommentInfo" method="POST" enctype="multipart/form-data">


<form:input path="rating" name="starsRating" class="forStarsRating InputErrorsEspecially" style="display:none"/>
<form:errors path="rating" class="errorsRatings errors"/>
<!-- End . Part for stars -->
<%-- <form:errors path="starsRating" class="error-message" /> --%>
<!-- <span id="username.errors" class="starsRating">username is required!</span> -->

<div class="ForEntireTitle">
<div class="ForTitleSign">
<label class="titleTitle" for="title">Title:</label>
<form:input path="title" class="inputForTitle"/>
<form:errors path="title" class="errorsTitle errors"/>
</div>
<div class="FortitleInput"></div>

</div>

































<!-- Start . Revise(textarea) about item. -->
<div class="TextArea about item">
<span class="TitleOfTextArea">Comment about item:</span>
<div class="forTextarea">

<form:textarea  maxlength="2000" path="commentText" name="textArea" id="textArea textareaChars" class="TextArea"
 placeholder="Расскажите, чем именно вам понравился или не понравился этот товар: 
 - как долго вы пользуетесь товаром; 
 - довольны ли качеством товара;  
 - посоветовали бы вы купить его другим."/> 
  <span id="chars">2000</span> characters remaining

 <form:errors path="commentText" class="errors"/> 

<!-- <p></p> Add how many symbols we have-->
</div>
</div>
<!-- End . Revise(textarea) about item. -->

<div class="CheckMarks">
<form:radiobuttons path = "Recommend" items="${numberList}"/>
</div>
<form:errors path="Recommend" class="errors RecommendErrors"/>


<!-- Start . Part with buttons. -->
<div class="PartWithButtons">
<div class="reviewOfAuthor"><p>Reviews are published without the author's last name.</p></div>
<div class="ForButtons">

<button class="addReview btn-lg" type="submit">
<span class="textInsideButton">
Add review</span></button>

</div>
</div>

</form:form>

<div class="RulesOfReview">
<a href="ReviewRules">Review Rules</a>
</div>

</div>
</div>
<!-- End . Part with buttons -->







</div>

</div>
<!-- //end first side -->
<!-- Start. Image in right -->
<div class="ImageWithRightSide">

<div class="titleImage"><p>
<span class="nameproduct">Название продукта: </span>   ${InfoProduct.name}
</p></div>

<img class="ImageInRightSide" src="${pageContext.request.contextPath}/productImage?code=${InfoProduct.code}" alt="" />

</div>


<!-- End. Image in right -->



</div>
</div>

</div>
</div>


<%-- </form> --%>
</div>
<!-- </div> -->




<script>

var maxLength = 2000;
$('textarea').keyup(function() {
  var length = $(this).val().length;
  var length = maxLength-length;
  $('#chars').text(length);
});


</script>


<script src="${ForStars}"></script>

<!-- That script for stars of rating HOVER-->
<!-- </div> -->
<!-- </div> -->
<!-- </div> -->




<!-- <script> -->

<!-- // $(document).ready(function() { -->
<!-- //     $(".btn-lg").click(function() { -->
<!-- //         check(); -->
<!-- //         alert("Sended");  	 			//If you will delete it application won't be work -->
<!-- //     }) -->
<!-- // }); -->

<!-- // function check() { -->
<!-- //     var ReleaseId = $(".ValueForStar").text();  -->
<!-- //     var comment = $("#textArea").val();         -->
<!-- //     var title =  $(".inputForTitle").val();   -->
<!-- //     var checmark = $('.checkbox:checked').val();  -->
<!-- //     var checmarkNo = $('.checkboxNo:checked').val();  -->
<!-- // //     checkboxNo -->
<!-- //     document.location.href = "http://localhost:8080/myapp/AddingToDataBase?ReleaseId="+ReleaseId+"&comment="+comment+"&title="+title+"&checmark="+checmark+"&checmarkNo="+checmarkNo; -->
<!-- // } -->
<!-- </script> -->

</body>
</html>