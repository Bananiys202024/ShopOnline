<%@page import="com.sawforgarden.myapp.model.CartLineInfo"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	    
	    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<c:url value="/resources/css/Cart/Cart-WithItems.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/Cart/Cart-EmptyPag.css" />" rel="stylesheet">
<spring:url value="/resources/js/jquery-3.3.1.min.js" var="standartLibraryjQuery" />

</head>
<body>

<script src="${standartLibraryjQuery}"></script>


<c:if test="${empty cartForm or empty cartForm.cartLines}">

<!-- If busket is empty -->

<div id="ThatEmptyContainer" class="OwnerFromOwnerestContainersSSSSssssssssSS">

<div class="ContainerTu">
<h1 class="empty-cart__title">Your Cart</h1>
<a class="empty-cart__continue-shopping btn btn-outline btn-block btn-lg" href="CatalogOfitems">Continue Shopping</a>

<div class="empty-cart__info">
<h2 class="empty-cart__info-title">Your cart is empty</h2>
Just browsing? You can
<a href="/identity/global/createAccount" class="TuTu">create an account</a>
to get special offers and start earning reward points whenever you make a purchase.
</div>

</div>
</div>

</c:if>









<c:if test="${not empty cartForm and not empty cartForm.cartLines   }">

<div id="ThatNotEmptyCart">
<div class="ThatContainerForCommon">
<div class="ThatNotForLocation">


<div class="ThatForTopHeader">
<div class="heading"></div>
<div class="NamesForTable">


<div class="title">
<h1 class="listing-header__title">
Your Cart<span class="listing-header__count"> 2 Items </span>

<span class="listing-header__button">
<a href="shoppingCartCustomer">
<button class="btnForCheckOutOfCart btn-lg btn-block btn-primary" type="button" data-track="Checkout - Top">Checkout</button>
</a>
</span>

</h1>

</div>


<div class="line">
<div class="col-xs-5"><div class="listing-header__first-item">Item</div></div>
<div class="col-xs-4 listing-header__availability-column" style="margin-left: -30px;">Quantity</div>
<div class="col-xs-1 listing-header__quantity-column" style="margin-left: 30px;">Price</div>
<!-- <div class="col-xs-2 text-right"><div class="listing-header__last-item"></div></div> -->
</div>








</div>

</div>
	


<!-- Start of Item --><!-- Start of Item --><!-- Start of Item -->
<!-- Start of Item --><!-- Start of Item --><!-- Start of Item -->
<!-- Start of Item --><!-- Start of Item --><!-- Start of Item -->
<!-- Start of Item --><!-- Start of Item --><!-- Start of Item -->
<!-- Start of Item --><!-- Start of Item --><!-- Start of Item -->
<!-- Start of Item --><!-- Start of Item --><!-- Start of Item -->
<!-- Start of Item --><!-- Start of Item --><!-- Start of Item -->




<form:form method="POST" modelAttribute="cartForm" action="${pageContext.request.contextPath}/shoppingCart">
<c:forEach items="${cartForm.cartLines}" var="cartLineInfo" varStatus="varStatus">
<div class="item">

<div class="tightlyContainerForItem">

<div class="col-xs-5">

<div class="ThatBlockOfItem">
<div class="cart-item__image-wrapper">
 
<img class="ImageOfCart" src="${pageContext.request.contextPath}/productImage?code=${cartLineInfo.productInfo.code}" />                             

</div>

<div class="item-title">
<div>
<a href="#" class="cart-item__title">
${cartLineInfo.productInfo.name}
<br></br>

<c:set var="GetInputQunt" value="${cartLineInfo.getQuantity()}"/>
<c:set var="GetExistedQuant" value="${cartLineInfo.productInfo.quantity}"/>



<span class="ThatAlarm${cartLineInfo.productInfo.code}" style="display:none;">
<img class="AlarmImage"  style="height: 16px;width: 20px;float: left;margin-right: 10px;" src="${pageContext.request.contextPath}/resources/images/LogInAndRegister/ExclaimingSign.png" alt="" />
<span>Sorry, but we have only ${GetExistedQuant}
 </span>     
</span>


<%-- <div>There is max amount of items: ${GetExistedQuant}</div> --%>

</a></div></div>


</div>



</div>


<div class="col-xs-4">




<%-- <form:form method="POST" action="showPreferences" modelAttribute="preferences"> --%>
<%-- <form:select class="c-dropdown v-medium" path="country"> --%>
<!-- <option value="0" label="Trtr"> 0 </option> -->
<!-- <option value="1" selected> 1 </option> -->
<!-- <option value="2"> 2 </option> -->
<!-- <option value="3"> 3 </option> -->
<!-- <option value="4"> 4 </option> -->
<!-- <option value="5"> 5 </option> -->
<!-- <option value="6"> 6 </option> -->
<!-- <option value="7"> 7 </option> -->
<!-- <option value="8"> 8 </option> -->
<!-- <option value="9"> 9 </option> -->
<!-- <option value="10"> 10+ </option> -->
<%-- </form:select> --%>
<%-- </form:form> --%>


<!-- https://www.tutorialspoint.com/springmvc/springmvc_dropdown.htm -->
<!-- https://netjs.blogspot.com/2018/09/spring-mvc-dropdown-example-using-select-option-options-tag.html -->

<!-- <select class="c-dropdown v-medium"> -->
<!-- <option value="0" label="TTTTTT"> 0 </option> -->
<!-- <option value="1" selected> 1 </option> -->
<!-- <option value="2"> 2 </option> -->
<!-- <option value="3"> 3 </option> -->
<!-- <option value="4"> 4 </option> -->
<!-- <option value="5"> 5 </option> -->
<!-- <option value="6"> 6 </option> -->
<!-- <option value="7"> 7 </option> -->
<!-- <option value="8"> 8 </option> -->
<!-- <option value="9"> 9 </option> -->
<!-- <option value="10"> 10+ </option> -->
<!-- </select> -->


<%-- <c:if test="${cartLineInfo.getQuantity() > 7}"> --%>
<!-- <div class="ThatAlarm"> -->
<%-- <img class="AlarmImage" src="${pageContext.request.contextPath}/resources/images/LogInAndRegister/ExclaimingSign.png" alt="" /> --%>
<!-- <p>Sorry, but we havn't only 7.</p>      -->
<!-- </div> -->
<%-- </c:if> --%>



<div class="ThatForQuantity">
<!-- <div class="minus"> -->
<%-- <a style="margin-right: 20px;" href="MinusOfShoppingCart?quantity=${cartLineInfo.getQuantity()}&code=${cartLineInfo.productInfo.code}"><span class="qt-minus">-</span></a> --%>
<!-- </div> -->

<!-- <div class="ThatQuantitywweew"> -->
<%-- <span class="qt">${cartLineInfo.getQuantity()}</span> --%>
<!-- </div> -->

<!-- <div class="ThatPlus"> -->
<%-- <a style="text-decoration: none;margin-left: 20px;"href="PlusOfShoppingCart?quantity=${cartLineInfo.getQuantity()}&code=${cartLineInfo.productInfo.code}"><span class="qt-plus">+</span></a> --%>
<!-- </div> -->


<div class="minusT" id="Minus${cartLineInfo.productInfo.code}">
<%-- href="MinusOfShoppingCart?quantity=${cartLineInfo.getQuantity()}&code=${cartLineInfo.productInfo.code}" --%>
<a>
   <img class="MinusOfQuantityCart" src="${pageContext.request.contextPath}/resources/images/Cart/minus-2-icon-256.png" alt="Mns" />

</a>

<%-- <a href="MinusOfShoppingCart?quantity=${cartLineInfo.getQuantity()}&code=${cartLineInfo.productInfo.code}"><span class="qt-minusT">-</span></a> --%>
</div>

<div class="ThatPlusT" id="Plus${cartLineInfo.productInfo.code}">
<%-- href="PlusOfShoppingCart?quantity=${cartLineInfo.getQuantity()}&code=${cartLineInfo.productInfo.code}" --%>
<a>
   <img class="PlusOfQuantityCart" src="${pageContext.request.contextPath}/resources/images/Cart/black-plus-icon-11.png" alt="Pls" />
</a>
<%-- <a href="PlusOfShoppingCart?quantity=${cartLineInfo.getQuantity()}&code=${cartLineInfo.productInfo.code}"><span class="qt-plusT">+</span></a> --%>
</div>
<%-- <form:form method="POST" modelAttribute="cartForm" action="${pageContext.request.contextPath}/shoppingCart"> --%>
<%-- <form:input path="cartLines[${varStatus.index}].quantity" class="x-quantity__input" id="quantity" value="${cartLineInfo.getQuantity()}"/>  --%>
<%-- <input class="x-quantity__input" id="quantity" value="${cartLineInfo.getQuantity()}"/>  --%>
<%-- </form:form> --%>
<p class="x-quantity__input" id="quantity${cartLineInfo.productInfo.code}" style="margin: 0;">${cartLineInfo.getQuantity()}</p>

<%-- <form:form method="POST" modelAttribute="cartForm" action="${pageContext.request.contextPath}/shoppingCart"> --%>
<%-- <c:forEach items="${cartForm.cartLines}" var="cartLineInfo" varStatus="varStatus"> --%>
<%-- <form:input value="${cartLineInfo.getQuantity()}" class="x-quantity__input" path="cartLines[${varStatus.index}].quantity" /> --%>
<%-- </c:forEach> --%>
<%-- </form:form> --%>





</div>





<%-- <form:form method="POST" modelAttribute="cartForm" action="${pageContext.request.contextPath}/shoppingCart"> --%>
<!-- Quantity: -->
<%-- <form:input path="cartLines[${varStatus.index}].quantity" class="x-quantity__input" id="quantity" value="${cartLineInfo.getQuantity()}"/>  --%>
<%-- </form:form> --%>
						


<%-- <a href="MinusOfShoppingCart?quantity=${cartLineInfo.getQuantity()}&code=${cartLineInfo.productInfo.code}"><span class="qt-minus">-</span></a> --%>
<%-- <span class="qt">${cartLineInfo.getQuantity()}</span> --%>
<%-- <a href="PlusOfShoppingCart?quantity=${cartLineInfo.getQuantity()}&code=${cartLineInfo.productInfo.code}"><span class="qt-plus">+</span></a> --%>



<a class="cart-item__remove" href="${pageContext.request.contextPath}/shoppingCartRemoveProduct?quantity=${cartLineInfo.getQuantity()}&code=${cartLineInfo.productInfo.code}" title="Remove">Remove</a>
<!-- <a class="cart-item__save" href="javascript://" title="Save for Later">Save for Later</a> -->

</div>


<div class="col-xs-3">
<div class="priceblock__primary-price" style="margin-left: -40px;"><fmt:formatNumber currencySymbol="$"  value="${cartLineInfo.amount}" type="currency"/></div>
</div>


<!-- That main block we should inset after fix the bug -->




</div>

</div>



<div class="MaxValueOfItems${cartLineInfo.productInfo.code}" style="display:none">${GetExistedQuant}</div>

<!-- //minus -->
<script>



$( "#Minus${cartLineInfo.productInfo.code}" ).click(function(e) {
	e.preventDefault();
	e.stopPropagation();

	 	var code = jQuery(this).attr("id");
	 	code = code.replace("Minus", "");
	 	var quantityNowByCodeAbow = $("#quantity${cartLineInfo.productInfo.code}").text();
		var AmountItemsOfCartForTopMenu = $(".number").text();
	 	
	
		
	    executeAJAXMinus(code,quantityNowByCodeAbow,AmountItemsOfCartForTopMenu,e);	
	    return false;
	    
	 });
	 
function executeAJAXMinus(code,quantity,AmountItemsOfCartForTopMenu,e) {
// 	alert('Helloef');
    e.preventDefault();
    e.stopPropagation();
     
    $.ajax({
         type: "POST",
         dataType : 'json',
    contentType: "application/x-www-form-urlencoded; charset=UTF-8", // this is the default value, so it's optional
         url: "MinusOfShoppingCart",
         data: "code=" + code + "&quantity=" + quantity+"&AmountItemsOfCartForTopMenu=" + AmountItemsOfCartForTopMenu,
         success: function(msg){
        	 
        	 
//         	 alert(msg.quantity);
//         	 alert(code);
		$('#quantity'+code).text(msg.quantity);
		
		
		
		//check for limit amount items
		
		var existedQuantity = ${GetExistedQuant};
		var quantityInstock = msg.quantity;
	
		var getNumberCart = msg.AmountItemsOfCartForTopMenu;

		$('.number').text(getNumberCart);
// 		alert('Hellowwefwfefewfef');
                  },
    error : function(e) {
		console.log("ERROR: ", e);
		display(e);
	},
	done : function(e) {
		console.log("DONE");
		enableSearchButton(true);
	}

	
    });
    
    return false;
}

</script>





<script>



$( "#Plus${cartLineInfo.productInfo.code}" ).click(function(e) {
	e.preventDefault();
	e.stopPropagation();

	 	var code = jQuery(this).attr("id");
	 	code = code.replace("Plus", "");
	 	var quantityNowByCodeAbow = $("#quantity${cartLineInfo.productInfo.code}").text();
		var AmountItemsOfCartForTopMenu = $(".number").text();
	 	
// 		alert(AmountItemsOfCartForTopMenu);
		
	    executeAJAXPlus(code,quantityNowByCodeAbow,AmountItemsOfCartForTopMenu,e);	
	    return false;
	    
	 });
	 
function executeAJAXPlus(code,quantity,AmountItemsOfCartForTopMenu,e) {

    e.preventDefault();
    e.stopPropagation();
     
    $.ajax({
         type: "POST",
         dataType : 'json',
    contentType: "application/x-www-form-urlencoded; charset=UTF-8", // this is the default value, so it's optional
         url: "PlusOfShoppingCart",
         data: "code=" + code + "&quantity=" + quantity+"&AmountItemsOfCartForTopMenu=" + AmountItemsOfCartForTopMenu,
         success: function(msg){
        	 

		$('#quantity'+code).text(msg.quantity);
		
		//check for limit amount items
		
		var existedQuantity = ${GetExistedQuant};
		var quantityInstock = msg.quantity;

		var getNumberCart = msg.AmountItemsOfCartForTopMenu;

		$('.number').text(getNumberCart);
		
                  },
    error : function(e) {
		console.log("ERROR: ", e);
		display(e);
	},
	done : function(e) {
		console.log("DONE");
		enableSearchButton(true);
	}

	
    });
    
    return false;
}

</script>





</c:forEach>
</form:form>




<!-- End of Item --><!-- End of Item --><!-- End of Item -->
<!-- End of Item --><!-- End of Item --><!-- End of Item -->
<!-- End of Item --><!-- End of Item --><!-- End of Item -->
<!-- End of Item --><!-- End of Item --><!-- End of Item -->
<!-- End of Item --><!-- End of Item --><!-- End of Item -->
<!-- End of Item --><!-- End of Item --><!-- End of Item -->


</div>
</div>
</div>


</c:if>	



</body>
</html>