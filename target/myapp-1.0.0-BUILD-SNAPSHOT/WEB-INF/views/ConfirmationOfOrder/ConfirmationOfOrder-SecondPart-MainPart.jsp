<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<c:url value="/resources/css/ConfirmationOfOrder/ConfirmationOfOrder-SecondPart-MainPart.css" />" rel="stylesheet">
</head>
<body>

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

<section class="SectionOfContainer">


 
<div class="ContactContainer"><p class="i18n-paragraph">Contact Information</p></div>

<p><span><span class="i18n-paragraph">
Мы отправим подтверждение заказа на ваш телефон и будем использовать ваш телефонный
номер только если у нас есть вопросы или проблемы выполнения заказа.
</span></span></p>



 <c:url var="validateUrl" value="shoppingCartCustomer" />
   <form:form method="POST" modelAttribute="customerForm"
       action="${validateUrl}">





<!-- Start label one yet --><!-- Start label one yet --><!-- Start label one yet -->
<!-- Start label one yet --><!-- Start label one yet --><!-- Start label one yet -->


<!-- <label for="user.Name"> -->
<!-- <span> -->
<!-- <p class="i18n-paragraph"> -->
<!-- First Name</p></span> -->
<!-- <div class=""> -->
<!-- <input id="user.Name" value="" class="form-control"></div> -->
<!-- </label> -->

<!-- End label one yet --><!-- End label one yet --><!-- End label one yet -->
<!-- End label one yet --><!-- End label one yet --><!-- End label one yet -->

<!-- Start label one yet --><!-- Start label one yet --><!-- Start label one yet -->
<!-- Start label one yet --><!-- Start label one yet --><!-- Start label one yet -->


<!-- <label for="user.SecondName"> -->
<!-- <span> -->
<!-- <p class="i18n-paragraph"> -->
<!-- Second Name</p></span> -->
<!-- <div class=""> -->
<!-- <input id="user.SecondName" value="" class="form-control"></div> -->
<!-- </label> -->

<!-- End label one yet --><!-- End label one yet --><!-- End label one yet -->
<!-- End label one yet --><!-- End label one yet --><!-- End label one yet -->




<!-- Start label one yet --><!-- Start label one yet --><!-- Start label one yet -->
<!-- Start label one yet --><!-- Start label one yet --><!-- Start label one yet -->


<!-- <label for="user.Address"> -->
<!-- <span> -->
<!-- <p class="i18n-paragraph"> -->
<!-- Address</p></span> -->
<!-- <div class=""> -->
<!-- <input id="user.Address" value="" class="form-control"></div> -->
<!-- </label> -->

<!-- End label one yet --><!-- End label one yet --><!-- End label one yet -->
<!-- End label one yet --><!-- End label one yet --><!-- End label one yet -->

<!-- Start label one yet --><!-- Start label one yet --><!-- Start label one yet -->
<!-- Start label one yet --><!-- Start label one yet --><!-- Start label one yet -->


<!-- <label for="user.City"> -->
<!-- <span> -->
<!-- <p class="i18n-paragraph"> -->
<!-- City</p></span> -->
<!-- <div class=""> -->
<!-- <input id="user.City" value="" class="form-control"></div> -->
<!-- </label> -->

<!-- End label one yet --><!-- End label one yet --><!-- End label one yet -->
<!-- End label one yet --><!-- End label one yet --><!-- End label one yet -->

<!-- Start label one yet --><!-- Start label one yet --><!-- Start label one yet -->
<!-- Start label one yet --><!-- Start label one yet --><!-- Start label one yet -->


<!-- <label for="user.ZIPCode"> -->
<!-- <span> -->
<!-- <p class="i18n-paragraph"> -->
<!-- ZIP Code</p></span> -->
<!-- <div class=""> -->
<!-- <input id="user.ZIPCode" value="" class="form-control"></div> -->
<!-- </label> -->

<!-- End label one yet --><!-- End label one yet --><!-- End label one yet -->
<!-- End label one yet --><!-- End label one yet --><!-- End label one yet -->
<!-- Start label one yet --><!-- Start label one yet --><!-- Start label one yet -->
<!-- Start label one yet --><!-- Start label one yet --><!-- Start label one yet -->




<!-- <label for="user.emailAddress"> -->
<!-- <span> -->
<!-- <p class="i18n-paragraph"> -->
<!-- Email Address</p></span> -->
<!-- <div class=""> -->
<!-- <input id="user.emailAddress" value="" class="form-control" aria-labelledby="emailAddress"></div> -->
<!-- </label> -->

<!-- End label one yet --><!-- End label one yet --><!-- End label one yet -->
<!-- End label one yet --><!-- End label one yet --><!-- End label one yet -->

<!-- Start label one yet --><!-- Start label one yet --><!-- Start label one yet -->
<!-- Start label one yet --><!-- Start label one yet --><!-- Start label one yet -->


<!-- <label for="user.phoneNumber"> -->
<!-- <span> -->
<!-- <p class="i18n-paragraph"> -->
<!-- Phone Number</p></span> -->
<!-- <div class=""> -->
<!-- <input id="user.phoneNumber" value="" class="form-control"></div> -->
<!-- </label> -->

<!-- End label one yet --><!-- End label one yet --><!-- End label one yet -->
<!-- End label one yet --><!-- End label one yet --><!-- End label one yet -->


<!-- <div class="button--continue"> -->
<!-- <a href="ContinueConfirmationOfOrder" class="ContinueConfirmatioNOfOrder"> -->
<!-- <button class="btnForContinueToPaymentInformation btn-lg btn-block btn-secondary"> -->
<!-- <span> -->

<!-- <p class="i18n-paragraph"> -->
<!-- Continue to Payment Information</p></span></button></a></div> -->




<!-- Start label one yet --><!-- Start label one yet --><!-- Start label one yet -->
<!-- Start label one yet --><!-- Start label one yet --><!-- Start label one yet -->


<label for="user.Name">
<span><span class="i18n-paragraph">Имя</span></span>
<form:input path="name" placeholder="  Emma Watson"/>
<form:errors path="name" class="error-message" id="user.Address"/>
</label>

<!-- End label one yet --><!-- End label one yet --><!-- End label one yet -->
<!-- End label one yet --><!-- End label one yet --><!-- End label one yet -->

<!-- Start label one yet --><!-- Start label one yet --><!-- Start label one yet -->
<!-- Start label one yet --><!-- Start label one yet --><!-- Start label one yet -->


<label for="user.Email">
<span><span class="i18n-paragraph">Емайл</span></span>
<form:input path="email" placeholder="  ImAclient@gmail.com"/> 
<form:errors path="email" class="error-message" /> 
</label>


                

<!-- End label one yet --><!-- End label one yet --><!-- End label one yet -->
<!-- End label one yet --><!-- End label one yet --><!-- End label one yet -->


<!-- Start label one yet --><!-- Start label one yet --><!-- Start label one yet -->
<!-- Start label one yet --><!-- Start label one yet --><!-- Start label one yet -->


<label for="user.Phone">
<span><span class="i18n-paragraph">Телефон</span></span>
<form:input path="phone" placeholder="  +44_7123_456_789"/> 
<form:errors path="phone" class="error-message" />
</label>

 
                 

<!-- End label one yet --><!-- End label one yet --><!-- End label one yet -->
<!-- End label one yet --><!-- End label one yet --><!-- End label one yet -->


<!-- Start label one yet --><!-- Start label one yet --><!-- Start label one yet -->
<!-- Start label one yet --><!-- Start label one yet --><!-- Start label one yet -->


<label for="user.Address">
<span><span class="i18n-paragraph">Адрес</span></span>
<form:input path="address" placeholder="  132, My Street,"/> 
<form:errors path="address" class="error-message" />
</label>

<label for="user.Address">
<span><span class="i18n-paragraph">Город</span></span>
<form:input path="town" placeholder="Odessa, Ukraine"/> 
<form:errors path="town" class="error-message" />
</label>

<!-- End label one yet --><!-- End label one yet --><!-- End label one yet -->
<!-- End label one yet --><!-- End label one yet --><!-- End label one yet -->

               
<input type="submit" value="Отправить заказ" class="btnForContinueToPaymentInformation" /> 


<!-- <div class="button--continue"> -->
<!-- <a href="SuccessStatusOrder" class="ContinueConfirmatioNOfOrder"> -->

<!-- <input type="submit" value="Place Your Order" class="btnForContinueToPaymentInformation" /> -->
<!-- <button class="btnForContinueToPaymentInformation btn-lg btn-block btn-secondary"></button> --> 


<!-- </a></div> -->
 </form:form>


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
<!-- <div class="fulfillment-list-entry__hd">Store Pickup</div> -->
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



<!-- <div class="borderIndent"></div> -->







<!-- End Second Part Of Main Menu --><!-- End Second Part Of Main Menu --><!-- End Second Part Of Main Menu -->
<!-- End Second Part Of Main Menu --><!-- End Second Part Of Main Menu --><!-- End Second Part Of Main Menu -->
<!-- End Second Part Of Main Menu --><!-- End Second Part Of Main Menu --><!-- End Second Part Of Main Menu -->
<!-- End Second Part Of Main Menu --><!-- End Second Part Of Main Menu --><!-- End Second Part Of Main Menu -->
<!-- End Second Part Of Main Menu --><!-- End Second Part Of Main Menu --><!-- End Second Part Of Main Menu -->
<!-- End Second Part Of Main Menu --><!-- End Second Part Of Main Menu --><!-- End Second Part Of Main Menu -->
<!-- End Second Part Of Main Menu --><!-- End Second Part Of Main Menu --><!-- End Second Part Of Main Menu -->


</body>
</html>