<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<c:url value="/resources/css/StatusOfOrder/SuccessStatusOrder.css" />" rel="stylesheet">
</head>
<body>



<!-- <span class="BigFont"><p>Your order is completed successfully. After some time, our worker will contact you.</p></span> -->

<!-- <span class="SmallFont"><p>Payment upon receipt.</p></span> -->



<!-- If busket is empty -->

<div id="ThatEmptyContainer" class="OwnerFromOwnerestContainersSSSSssssssssSS">

<div class="ContainerTu">
<h1 class="empty-cart__title">Спасибо за заказ.  </h1>
<a class="empty-cart__continue-shopping btn btn-outline btn-block btn-lg" href="CatalogOfitems">Continue Shopping</a>

<div class="empty-cart__info">
<h2 class="empty-cart__info-title"></h2>
<h3 style="font-weight: 500;margin: 0;"> Ваш заказ номер: ${lastOrderedCart.orderNum} . Через некоторое время наши операторы свяжуться с вами. Оплата при получении</h3>

</div>




</div>
</div><!-- The End -->


</body>
</html>