<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="<c:url value="/resources/css/ContinueConfirmationOfOrder/ConfirmationOfOrder-SecondPart-MainPart.css" />" rel="stylesheet">

</head>
<body>

  <fmt:setLocale value="en_US" scope="session"/>




<!-- Start Second Part Of Main Menu --><!-- StartSecond Part Of Main Menu --><!-- Second Part Of Main Menu -->
<!-- StartSecond Part Of Main Menu --><!-- Second Part Of Main Menu --><!-- Second Part Of Main Menu -->
<!-- Second Part Of Main Menu --><!-- Second Part Of Main Menu --><!-- Second Part Of Main Menu -->
<!-- Second Part Of Main Menu --><!-- Second Part Of Main Menu --><!-- Second Part Of Main Menu -->
<!-- Second Part Of Main Menu --><!-- Second Part Of Main Menu --><!-- Second Part Of Main Menu -->
<!-- Second Part Of Main Menu --><!-- Second Part Of Main Menu --><!-- Second Part Of Main Menu -->
<!-- Second Part Of Main Menu --><!-- Second Part Of Main Menu --><!-- Second Part Of Main Menu -->

<div class="ThereForUnityBothContainers">



<!-- Start Left Side -->
<div id="BlockForContactInformation">
<div class="BlockForContactInformation">

<div class="ContactContainer"><p class="i18n-paragraph">Адрес доставки</p></div>
<section class="SectionOfContainer">






<!-- Start label one yet --><!-- Start label one yet --><!-- Start label one yet -->
<!-- Start label one yet --><!-- Start label one yet --><!-- Start label one yet -->
<ul>
          <li><span class="title">Имя: </span><span class="informationofTitle">${myCart.customerInfo.name}</span></li>
          <li><span class="title">Емайл: </span><span class="informationofTitle">${myCart.customerInfo.email}</span></li>
          <li><span class="title">Телефон: </span><span class="informationofTitle">${myCart.customerInfo.phone}</span></li>
          <li><span class="title">Город: </span><span class="informationofTitle">${myCart.customerInfo.town}</span></li>          
          <li><span class="title">Адресс: </span><span class="informationofTitle">${myCart.customerInfo.address}</span></li>
</ul>

      <h3 class="CartSummary">Результат:</h3>
      <ul class="SecondUL">
          <li>Количество: ${myCart.quantityTotal}</li>
          <li>Сумма:
          <span class="total">
            <fmt:formatNumber currencySymbol="$"  value="${myCart.amountTotal}" type="currency"/>
          </span></li>
      </ul>



<form method="POST" action="${pageContext.request.contextPath}/shoppingCartConfirmation">

<!-- Send/Save -->
<input type="submit" value="Place Your Order" class="btnForContinueToPaymentInformation" />

<!-- Edit Cart -->
<div class="BlockForHref">
<a class="navi-item" href="${pageContext.request.contextPath}/shoppingCart" class="btnForContinueToPaymentInformation">Edit Cart</a>
</div>

<!-- Edit Customer Info -->
<div class="BlockForHref">
<a class="navi-item" href="${pageContext.request.contextPath}/shoppingCartCustomer" class="btnForContinueToPaymentInformation">Customer Info</a>
</div>

</form>

<!-- <div class="button--continue" style="margin-top: 20px;"> -->
<!-- <a href="SuccessStatusOrder" class="ContinueConfirmatioNOfOrder"> -->
<!-- <button class="btnForContinueToPaymentInformation btn-lg btn-block btn-secondary" style="background-color:#0046be;"> -->
<!-- <span> -->

<!-- <p class="i18n-paragraph" style="color: white; font-weight: 500;"> -->
<!-- Edit Cart</p></span></button></a></div> -->

<!-- <div class="button--continue" style="margin-top: 20px;"> -->
<!-- <a href="SuccessStatusOrder" class="ContinueConfirmatioNOfOrder"> -->
<!-- <button class="btnForContinueToPaymentInformation btn-lg btn-block btn-secondary" style="background-color:#0046be;"> -->
<!-- <span> -->

<!-- <p class="i18n-paragraph" style="color: white; font-weight: 500;"> -->
<!-- Edit Customer Info</p></span></button></a></div> -->


<!-- <input type="submit" value="Place Your Order" class="btnForContinueToPaymentInformation" />  -->


</section>


</div>
</div>
<!-- End Left Side -->
 

<!-- Start Right Side -->
<div id="RightContainer">
<div class="RightSide">
<section class="ContainerOfRightMenu">
<div class="headerRightMenu"><h2 class="heading-5 order-summary__title">Результат заказа</h2></div>
<div class="ItemsRightMenu">

<div class="Items">
<!-- <div class="fulfillment-list-entry__hd"></div> -->
<div class="TighltContainer">
<ul class="item-count">


<!-- Start Item -->
<c:forEach items="${myCart.cartLines}" var="cartLineInfo">
<li class="item-list_enty">

<!-- <div class="item-listTTT"> -->
<!-- <span><span><p class="i18n-paragraph">Available </p></span></span> -->
<!-- <span><span><p class="i18n-paragraph">Wed, Jan 9</p></span></span> -->


<!-- </div> -->
<div class="item-list__chunk">
<div class="item-list__spacer">
<div class="item-list__image">
<img class="ImageThatItem" src="${pageContext.request.contextPath}/productImage?code=${cartLineInfo.productInfo.code}" alt="" />
</div></div></div>


<div class="item-list__chunk item-list__chunk--max" style="width: 59%;">
<div class="item-list__spacer text-left item-list__title" >
${cartLineInfo.productInfo.name}</div>
<p class="item-list__device-message"></p>
</div>


<div class="item-list__chunk" style="width: 20%;">
<div class="text-right">
<div class="item-list__content item-list__price">
<span class="cash-money"><fmt:formatNumber currencySymbol="$"  value="${cartLineInfo.productInfo.price}" type="currency"/></span></div>
<span class="sr-only"><span class="forquantity">Количество: &nbsp; </span><span class="number">${cartLineInfo.quantity}</span></span>
</div></div>

</li>
</c:forEach>
<!-- End Item -->


</ul>
</div>
</div>



<div class="AmountOfMoney">
<div class="TighlyContainer">
<div class="summary"><span class="MonayOfResult">Сумма продуктов</span><span class="Money">$${myCart.amountTotal}</span></div>
<div class="summaryOfDiscount"><span class="Discout">Скидка</span><span class="NumberOfDiscount">$0</span></div>
<hr class="order-summary__rule">
<div class="TotalMoney"><span class="Total">Цена</span><span class="TotalAmount">$${myCart.amountTotal}</span></div>


</div>
</div>

</div>
</section>
</div>
</div>
<!-- End Right Side -->



</div>
<!-- End Unity Both Container -->



<div class="borderIndent"></div>







<!-- End Second Part Of Main Menu --><!-- End Second Part Of Main Menu --><!-- End Second Part Of Main Menu -->
<!-- End Second Part Of Main Menu --><!-- End Second Part Of Main Menu --><!-- End Second Part Of Main Menu -->
<!-- End Second Part Of Main Menu --><!-- End Second Part Of Main Menu --><!-- End Second Part Of Main Menu -->
<!-- End Second Part Of Main Menu --><!-- End Second Part Of Main Menu --><!-- End Second Part Of Main Menu -->
<!-- End Second Part Of Main Menu --><!-- End Second Part Of Main Menu --><!-- End Second Part Of Main Menu -->
<!-- End Second Part Of Main Menu --><!-- End Second Part Of Main Menu --><!-- End Second Part Of Main Menu -->
<!-- End Second Part Of Main Menu --><!-- End Second Part Of Main Menu --><!-- End Second Part Of Main Menu -->

</body>
</html>