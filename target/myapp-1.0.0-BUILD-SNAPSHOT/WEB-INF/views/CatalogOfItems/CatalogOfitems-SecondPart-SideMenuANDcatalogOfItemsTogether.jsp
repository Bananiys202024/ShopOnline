<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>   
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="<c:url value="/resources/css/CatalogOfitems/CatalogOfitems-SecondPart-SideMenuANDcatalogOfItemsTogether.css" />" rel="stylesheet">
<spring:url value="/resources/js/jquery-3.3.1.min.js" var="standartLibraryJS" />

</head>
<body>

<script src="${standartLibraryJS}"></script>

<div class="OwnerContainerForDefineLocation">
<div class="DefineLocationInsideOwnerContainer">
<div class="TryToRegulateLocationOfTextInsideOfContainer">





<div class="ContainerForBothContainerOfRightCatalogOfItemsAndSideMenu">





<!-- --------------------------------------------------------- -->
<!-- --------------------------------------------------------- -->
<!-- --------------------------------------------------------- -->
<!-- --------------------------------------------------------- -->
<!-- --------------------------------------------------------- -->


<div class="CommonSideMenu">
<div class="ContainerForRepair">
<div class="TryDefineLocation">

<div class="facet-section">
<section class="lv facet">
<fieldset name="Category">

<legend class="facet-legend">
<span class="c-section-title-text">Category</span>
</legend>

<nav>
<ul class="facet-option-list thatRightSide1">

<%-- ${listOfSectionsMain.value} --%>


<!-- path="categories" -->
<%-- <form:select path="categories"> --%>
<c:forEach items="${listOfSectionsMain}" var="listSection">	


<c:set var="string1" value="${listSection.value}"/>
<c:set var="string2" value="${fn:replace(string1,' ', '')}" />
<c:set var="valueWithooutWhiteSpaces" value="${fn:replace(string2,'/', '')}" />



<li id="selectedForCss<c:out value = "${valueWithooutWhiteSpaces}"/>" class="facet-option-list-item ">

<!-- selectedForCss -->
<%-- <a href="CatalogOfitems?categorySort=${listSection.value}"> --%>

<span class="actionByClickCategory${listSection.value}" id="actionByClickCategory<c:out value = "${valueWithooutWhiteSpaces}"/>">
<span class="facet-option-container">
<span class="c-facet c-facet-category v-small ">
<span class="c-facet-text">${listSection.value}</span>
</span></span>
<!-- </a> -->
</span>

<!-- path="subCategoriesOrSections" -->

 <c:if test="${not fn:containsIgnoreCase(listSection.key, 'ThatEmpty')}">


<div id="clickableValues<c:out value = "${valueWithooutWhiteSpaces}"/>">
<img class="DropArrowImg" src="${pageContext.request.contextPath}/resources/images/CatalogOfItems/grey-down-arrow-icon-png-1.png" alt="" />
</div>



<!-- sub elements -->

<!-- path="subCategoriesOrSections" -->
<div id="ShowOrHideSubMenu<c:out value = "${valueWithooutWhiteSpaces}"/>" class="hideClass">

<%-- <form:select path="subCategoriesOrSections"> --%>
<c:forEach  items="${listSection.key}" var="subMenu">	

<c:set var="string4" value="${subMenu}"/>
<c:set var="string5" value="${fn:replace(string4,' ', '')}" />
<c:set var="valueWithooutWhiteSpacesSubMenu" value="${fn:replace(string5,'/', '')}"/>

<div id="actionByClickCategory<c:out value = "${valueWithooutWhiteSpacesSubMenu}"/>">
<span class="SubList forCss" >
<%-- <a href="CatalogOfitems?categorySort=${subMenu}"> --%>
<a>


${subMenu}

</a>
</span>
</div>


<script>
$("#actionByClickCategory<c:out value = "${valueWithooutWhiteSpacesSubMenu}"/>").click(function(e) {

    var nameOfClickCategory = jQuery(this).attr("id");
    nameOfClickCategory = nameOfClickCategory.replace("actionByClickCategory", "");
	$( ".AssignToCategory").val(nameOfClickCategory);
	$("#formSelectMenu").submit();
		
});

</script>


</c:forEach>
<%-- </form:select> --%>


</div>

<!-- ... -->
</c:if>

<script>
$( "#clickableValues<c:out value = "${valueWithooutWhiteSpaces}"/>").click(function() {
// 	alert("Ok");
	
	$('#ShowOrHideSubMenu<c:out value = "${valueWithooutWhiteSpaces}"/>').toggleClass('showClass');
	$('#selectedForCss<c:out value = "${valueWithooutWhiteSpaces}"/>').toggleClass('selectedForCss');
	
	
});


$("#actionByClickCategory<c:out value = "${valueWithooutWhiteSpaces}"/>").click(function(e) {

	    var nameOfClickCategory = jQuery(this).attr("id");
	    nameOfClickCategory = nameOfClickCategory.replace("actionByClickCategory", "");
		$( ".AssignToCategory").val(nameOfClickCategory);
		$("#formSelectMenu").submit();
			
});

</script>

</li>
</c:forEach>



</ul>
</nav>

</fieldset>
</section>
</div>



<%-- <form:select path="subCategoriesOrSections" items="${listOfSectionsMain}" /> --%>







<!-- --------------------------------------------------------- -->
<!-- --------------------------------------------------------- -->
<!-- --------------------------------------------------------- -->
<!-- --------------------------------------------------------- -->
<!-- --------------------------------------------------------- -->
<!-- --------------------------------------------------------- -->



<!-- Start SideMenu --><!-- Start SideMenu --><!-- Start SideMenu --><!-- Start SideMenu --><!-- Start SideMenu --><!-- Start SideMenu -->
<!-- Start SideMenu --><!-- Start SideMenu --><!-- Start SideMenu --><!-- Start SideMenu -->
<!-- Start SideMenu --><!-- Start SideMenu --><!-- Start SideMenu --><!-- Start SideMenu -->
<!-- Start SideMenu --><!-- Start SideMenu --><!-- Start SideMenu --><!-- Start SideMenu -->
<!-- Start SideMenu --><!-- Start SideMenu --><!-- Start SideMenu --><!-- Start SideMenu -->
<!-- Start SideMenu --><!-- Start SideMenu --><!-- Start SideMenu --><!-- Start SideMenu -->




<div class="AllOtherSidesContainerOfMenuUnderHeadOfSideMenu">





<div class="OneFromSection">
<fieldset>
<legend style="padding-bottom: 10px;">
<span>Price</span>
</legend>




<div class="Brand Price">

<c:forEach items="${listOfPrice}" var="listPrice">	

<c:set var="getValue" value="${listPrice.key}"/>
<c:set var="getValue2" value="${fn:replace(getValue,'-', '')}" />
<c:set var="getValue3" value="${fn:replace(getValue2,'>', '')}" />
<c:set var="ProcessedById" value="${fn:replace(getValue3,'_', '')}" />

<label class="container" id="actionByClickPrice<c:out value = "${ProcessedById}"/>">
<input class="checkboxes"
<c:if test = "${fn:contains(priceSorting, ProcessedById )}">checked = "checked"</c:if>
 onchange="$('#formPriceMenu').submit();" type = "radio" name = "priceSorting" value = "${listPrice.key}"/>
<span class="checkmark ${listPrice.value}"></span>
<c:out value = "${listPrice.value}" />
<span class="NumberOfExistingItems ${listPrice.value} ">(5)</span>
</label>



<script>

$("#actionByClickPrice<c:out value = "${ProcessedById}"/>").click(function(e) {
	
// 	alert("Ok");
	    var nameOfClickCategory = jQuery(this).attr("id");
	    nameOfClickCategory = nameOfClickCategory.replace("actionByClickPrice", "");
		$(".AssignToPrice").val(nameOfClickCategory);
		$("#formSelectMenu").submit();
			
});

</script>

</c:forEach>

</div>



</fieldset>
</div>








































<div class="OneFromSection">
<fieldset>


<legend>
<span>Brand</span>
</legend>




<ul class="facet-option-list">

<li>
<div class="Brand">
<c:forEach items="${listOfBrands}" var="listBrands">	

<label class="container" id="actionByClickBrand${listBrands.key}">
<input class="checkboxes"
<c:if test = "${fn:contains(brandSort, listBrands.value)}">checked = "checked"</c:if>
 onchange="$('#formBrandMenu').submit();" type = "radio" name = "brand" value = "${listBrands.value}"  />
<span class="checkmark"></span>
<c:out value = "${listBrands.value}" />
<span class="NumberOfExistingItems">(5)</span>

</label>


<script>

$("#actionByClickBrand${listBrands.key}").click(function(e) {
	
	    var nameOfClickCategory = jQuery(this).attr("id");
	    nameOfClickCategory = nameOfClickCategory.replace("actionByClickBrand", "");
		$(".AssignToBrand").val(nameOfClickCategory);
		$("#formSelectMenu").submit();
			
});

</script>

</c:forEach>
</div>
</li>	
	

</ul>

</fieldset>
</div>








<!-- Str Sectn -->





<div class="OneFromSection">
<fieldset>
<legend style="padding-bottom: 10px;">
<span>Customer Rating</span>
</legend>








<div class="Brand Rating" >
<c:forEach items="${listOfRating}" var="listRatings">	

<label class="container" id="actionByClickRating${listRatings.value}">
<input class="checkboxes"
<c:if test = "${fn:contains(ratingSorting, listRatings.value)}">checked = "checked"</c:if>
 onchange="$('#formRatingMenu').submit();" type = "radio" name = "ratingSorting" value = "${listRatings.value}"  />
<span class="checkmark"></span>
<span class="Stars">
<span class="unfilled" style="margin-top: 4px;"></span>
<span class="filled" style="width: ${listRatings.key}px; margin-top: 4px;"></span>
</span>
<span class="SignRight" style="padding-left: 105px;">
<span class="">${listRatings.value}</span>
<span class="NumberOfExistingItems">(5)</span>
</span>
</label>

<script>

$("#actionByClickRating${listRatings.value}").click(function(e) {
	
	    var nameOfClickCategory = jQuery(this).attr("id");
	    nameOfClickCategory = nameOfClickCategory.replace("actionByClickRating", "");
		$(".AssignToRating").val(nameOfClickCategory);
		$("#formSelectMenu").submit();
			
});

</script>



</c:forEach>
</div>













</fieldset>
</div>








































<!-- End One From Section -->





</div>
<!-- End Other Container Under Sides Menu -->











</div>
</div>





</div>

<!-- End SideMenu --><!-- End SideMenu --><!-- End SideMenu --><!-- End SideMenu -->
<!-- End SideMenu --><!-- End SideMenu --><!-- End SideMenu --><!-- End SideMenu -->
<!-- End SideMenu --><!-- End SideMenu --><!-- End SideMenu --><!-- End SideMenu -->
<!-- End SideMenu --><!-- End SideMenu --><!-- End SideMenu --><!-- End SideMenu -->
<!-- End SideMenu --><!-- End SideMenu --><!-- End SideMenu --><!-- End SideMenu -->
<!-- End SideMenu --><!-- End SideMenu --><!-- End SideMenu --><!-- End SideMenu -->





<!-- Start Right Catalog Of Items --><!-- Start Right Catalog Of Items --><!-- Start Right Catalog Of Items -->
<!-- Start Right Catalog Of Items --><!-- Start Right Catalog Of Items --><!-- Start Right Catalog Of Items -->
<!-- Start Right Catalog Of Items --><!-- Start Right Catalog Of Items --><!-- Start Right Catalog Of Items -->
<!-- Start Right Catalog Of Items --><!-- Start Right Catalog Of Items --><!-- Start Right Catalog Of Items -->
<!-- Start Right Catalog Of Items --><!-- Start Right Catalog Of Items --><!-- Start Right Catalog Of Items -->
<!-- Start Right Catalog Of Items --><!-- Start Right Catalog Of Items --><!-- Start Right Catalog Of Items -->
<!-- Start Right Catalog Of Items --><!-- Start Right Catalog Of Items --><!-- Start Right Catalog Of Items -->








<div class="RightCatalogOfItem">











<!--Start TopSideOfRightMenu -->



<div class="">
<div class="banner-wrapper top-border">


<div class="banner-middle-column">

<span class="item-count" tabindex="-1" aria-live="polite">${paginationProducts.list.size()} items</span>

<span class="separator"></span>
</div>


<form:form  enctype="multipart/form-data" modelAttribute="SortingVariables" action="${pageContext.request.contextPath}/CatalogOfitems" method="GET" id="formSelectMenu" >


<!-- //sorting variables -->
<form:input path="categories" value="" style="display:none;" class="AssignToCategory"/>
<form:input path="prices" value="" style="display:none;" class="AssignToPrice"/>
<form:input path="brands" value="" style="display:none;" class="AssignToBrand"/>
<form:input path="ratings" value="" style="display:none;" class="AssignToRating"/>


<!-- .... -->

<div class="banner-right-column">
<label for="sort-by-select" class="sort-by-label">
<span class="sort-by-title">Sort By: </span>

  <form:select  path="sortBy" class="c-dropdown v-small sort-dropdown">
     <c:forEach items="${listOfSortingTypes}" var="category">
     
            <option
            <c:if test="${category.key eq sortBy}">selected="selected"</c:if>
            class="items" value="${category.key}">${category.value} </option>
         
        </c:forEach>
  </form:select>


</label>
</div>



</form:form>


</div>
</div>


<!--End TopSideOfRightMenu -->



</div>





















































































<%-- --%>
<!-- <div class="Absent">У нас нет предметов с такими фильтрами</div> -->
<%-- --%>



<ol class="BlockOfItems">

<c:if test="${paginationProducts.list.size() eq 0}"> 
<li style="list-style-type: none;"><span class="ThatSign"><span class="ThatFromTop">У нас нет предметов с такими фильтрами</span></span></li>
 </c:if>

<!-- Start That Container -->
<c:forEach items="${paginationProducts.list}" var="prodInfo">
<li class="sku-item" data-sku-id="6085502">
<div class="" data-track="[context:listRank=1]">
<div>
<div id="shop-sku-list-item-60f34f37-3c82-4f0a-b8c3-7d9b559e2340" data-version="2.13.1">		
<div class="shop-sku-list-item">
<div class="list-item lv " data-sku-id="6085502" data-reactroot="">
<div class="image-column">


<a class="image-link" href="ViewProduct?code=${prodInfo.code}" aria-hidden="true" tabindex="-1">
<img class="product-image" alt="" src="${pageContext.request.contextPath}/productImage?code=${prodInfo.code}">
</a>

<%-- <a href="${pageContext.request.contextPath}/DuplicatedbuyProduct?code=${prodInfo.code}&page=${paginationProducts.getCurrentPage()}"> --%>


<div class="detail-display-text">
<a href="#" data-track="See More Options">
See More Options
</a>
</div>
</div>


<div class="right-column">
<!-- Start information -->
<div class="information">
<div class="embedded-badge">
<div><div></div></div></div>


<div>
<div class="sku-title">
<h4 class="sku-header">
<a href="ViewProduct?code=${prodInfo.code}">${prodInfo.name}</a>
</h4></div>


<div class="sku-model" style="padding-top: 3px; padding-bottom: 10px;">

<security:authorize  access="hasRole('ROLE_ADMIN')">

<div class="sku-attribute-title">
<span class="sku-title">Create data:</span>
<span class="sku-value" style="font-size:15px;">
${prodInfo.createDate}
</span>
</div>

<div class="sku-attribute-title">
<span class="sku-title" style="font-size: 17px">Quantity:</span>
<span class="sku-value" style="font-size:15px">
${prodInfo.quantity}
</span>
</div>

<div class="sku-attribute-title">
<span class="sku-title" style="font-size: 17px">Category:</span>
<span class="sku-value" style="font-size:15px">
${prodInfo.category}
</span>
</div>

<div class="sku-attribute-title">
<span class="sku-title" style="font-size: 17px">Brand:</span>
<span class="sku-value" style="font-size:15px">
${prodInfo.brand}
</span>
</div>

<div class="sku-attribute-title">
<span class="sku-title" style="font-size: 17px">Code:</span>
<span class="sku-value" style="font-size:15px">
${prodInfo.code}
</span>
</div>
</security:authorize>
</div>
</div>



<c:if test="${prodInfo.rating==5.0}">
<span class="unfilledOfItemCatalog"></span>
<span class="filledOfItemCatalog"></span>
<div class="ForRatingValueOfItemCatalog">
<f:formatNumber type="number" pattern="0.00" value="${prodInfo.rating}"/>
</div>
</c:if>



<c:if test="${prodInfo.rating>=4.0}">
<c:if test="${prodInfo.rating<5.0}">
<span class="unfilledOfItemCatalog"></span>
<span class="filledOfItemCatalog" style="width:100px;"></span>
<div class="ForRatingValueOfItemCatalog">
<f:formatNumber type="number" pattern="0.00" value="${prodInfo.rating}"/>
</div>
</c:if>
</c:if>

<c:if test="${prodInfo.rating>=3.0}">
<c:if test="${prodInfo.rating<4.0}">
<span class="unfilledOfItemCatalog"></span>
<span class="filledOfItemCatalog" style="width:75px;"></span>
<div class="ForRatingValueOfItemCatalog">
<f:formatNumber type="number" pattern="0.00" value="${prodInfo.rating}"/>
</div>
</c:if>
</c:if>

<c:if test="${prodInfo.rating>=2.0}">
<c:if test="${prodInfo.rating<3.0}">
<span class="unfilledOfItemCatalog"></span>
<span class="filledOfItemCatalog"  style="width:50px;"></span>
<div class="ForRatingValueOfItemCatalog">
<f:formatNumber type="number" pattern="0.00" value="${prodInfo.rating}"/>
</div>
</c:if>
</c:if>

<c:if test="${prodInfo.rating>=1.0}">
<c:if test="${prodInfo.rating<2.0}">
<span class="unfilledOfItemCatalog"></span>
<span class="filledOfItemCatalog"  style="width:25px;"></span>
<div class="ForRatingValueOfItemCatalog">
<f:formatNumber type="number" pattern="0.00" value="${prodInfo.rating}"/>
</div>
</c:if>
</c:if>

<c:if test="${prodInfo.rating<1.0}">
<span class="unfilledOfItemCatalog"></span>
<span class="filledOfItemCatalog"  style="width:0px;"></span>
<div class="ForRatingValueOfItemCatalog">
<f:formatNumber type="number" pattern="0.00" value="${prodInfo.rating}"/>
</div>
</c:if>




<div class="sku-list-item-compare-checkbox">
<div class="sku-list-item-compare-and-save-container">
<div class="sku-list-item-compare-container">
<div>
<div id="shop-compare-checkbox-f02307a7-7185-4250-9955-a30634b8136d" data-version="1.0.3">
<div class="shop-compare-checkbox">
<div class="appContainer" data-reactroot="">
<div class="c-checkbox v-medium ">
<label for="6085502">
<span class="c-checkbox-brand">
<input type="checkbox" id="6085502" value="6085502">

<i class="c-checkbox-custom-input" aria-hidden="true"></i></span>Compare</label></div></div></div>

</div></div></div>

<div class="sku-list-item-save-container">
<div>
<div id="shop-save-for-later-43b28344-d1a7-4f99-ae3c-d4f2b7649e90" data-version="1.1.4">	



</div></div></div></div></div>
</div>
<!-- End Information -->


<div class="price-block">
<div class="sku-list-item-price">
<div>
<div id="pricing-price-60c74673-d3e0-4f8a-84a3-0111c3199130" data-version="1.6.0">	

<!-- Start pricing-price -->
<div class="pricing-price">
<div class="pricing-price" data-reactroot="">
<div data-version="4.7.1-rc.0" class="pricing-lib-price-4-7-1-rc-0  price-view-pb priceView-layout-medium">
<div data-version="4.7.1-rc.0" class="pricing-price pricing-lib-price-4-7-1-rc-0  priceView-price">


<div class="">

<div>
<div>
<div class="priceView-hero-price priceView-purchase-price">
<span aria-label="Your price for this item is $34.99">
<fmt:formatNumber currencySymbol="$"  value="${prodInfo.price}" type="currency" />
</span></div></div>
</div>

<div></div>

</div></div></div></div>
</div>
<!-- End pricing-price -->

</div></div>
</div>

<div><div></div></div>



<c:set var="QuantityForChooseOfButton" value="${prodInfo.quantity}"/>

<c:if test="${QuantityForChooseOfButton >= 1}">
<div  class="sku-list-item-button">
<div>
<div>
<div id="shop-add-to-cart-button-626d6ee0-ad7f-4086-9dac-dce85656bae2" data-version="1.9.1">
<div class="shop-add-to-cart-button">
<div data-reactroot="">
<a>
<!-- Ther -->
<%--  href="${pageContext.request.contextPath}/DuplicatedbuyProduct?code=${prodInfo.code}&page=${paginationProducts.currentPage}" --%>
<!-- Ther -->
<%-- ${pageContext.request.contextPath}/DuplicatedbuyProductFromViewPage?code=${prodInfo.code} --%>
<button id="clickScriptAddToCart${prodInfo.code}"  type="button" class="btn btn-primary btn-sm btn-block btn-leading-ficon add-to-cart-button">
<i class="ficon-cart" aria-hidden="true">
<img class="CartForItem" src="${pageContext.request.contextPath}/resources/images/CatalogOfItems/CartForItem.png" alt="cart" />
</i>
Add to Cart</button></a></div></div>
</div></div></div></div>
</c:if>
<div id="SuccessAddToCart${prodInfo.code}" style="color:green;margin-left: 20%;font-size:18px;">
Добавлено в корзину
</div>


            
 <security:authorize  access="hasRole('ROLE_ADMIN')">
<div class="sku-list-item-button">
<div>
<div>
<div id="shop-add-to-cart-button-626d6ee0-ad7f-4086-9dac-dce85656bae2" data-version="1.9.1">
<div class="shop-add-to-cart-button">
<div data-reactroot="">
<a href="${pageContext.request.contextPath}/shoppingListRemoveProductFromView?code=${prodInfo.code}">
<button type="button" class="btn btn-primary btn-sm btn-block btn-leading-ficon add-to-cart-button">
<i class="ficon-cart" aria-hidden="true">

<%-- <img class="CartForItem" src="${pageContext.request.contextPath}/resources/images/CatalogOfItems/CartForItem.png" alt="cart" /> --%>

</i>Remove</button></a></div></div>
 
</div></div></div></div>
</security:authorize>




 <security:authorize  access="hasRole('ROLE_ADMIN')">
<div class="sku-list-item-button">
<div>
<div>
<div id="shop-add-to-cart-button-626d6ee0-ad7f-4086-9dac-dce85656bae2" data-version="1.9.1">
<div class="shop-add-to-cart-button">
<div data-reactroot="">

<a href="${pageContext.request.contextPath}/productEdit?code=${prodInfo.code}">
<button type="button" class="btn btn-primary btn-sm btn-block btn-leading-ficon add-to-cart-button">
<i class="ficon-cart" aria-hidden="true">

<%-- <img class="CartForItem" src="${pageContext.request.contextPath}/resources/images/CatalogOfItems/CartForItem.png" alt="cart" /> --%>

</i>


Edit</button></a></div></div>
 
</div></div></div></div>
</security:authorize>















<c:if test="${QuantityForChooseOfButton < 1}">

<div class="shop-add-to-cart-button">
<div data-reactroot="">
<button disabled type="button" class="btnSoldOut btn-primary btn-sm btn-block btn-leading-ficon add-to-cart-button">
<i class="ficon-cart" aria-hidden="true">

<img class="CartForItem" src="${pageContext.request.contextPath}/resources/images/CatalogOfItems/CartForItem.png" alt="cart" />

</i>


Sold Out</button></div></div>
</c:if>




















<div></div>

<div class="buying-options-only">
<div>
<div id="pricing-price-957b7ea5-1235-4f5d-9c71-5e64fbbac78a" data-version="1.6.0">
<div class="pricing-price">
<div class="pricing-price" data-reactroot=""></div>
</div>
      

</div></div></div></div></div></div></div>


</div></div></div></li>

<script>
 $(document).ready(function() {
 $("#SuccessAddToCart${prodInfo.code}").hide();
});  
 
 $("#ShowOrHideSubMenu${listSection.value}").hide();
</script> 



<script>



$( "#clickScriptAddToCart${prodInfo.code}" ).click(function(e) {

	e.stopPropagation();

	var code = jQuery(this).attr("id");
 	code = code.replace("clickScriptAddToCart", "");
	var page = ${paginationProducts.currentPage};
	var getItemsOfCart = $('.number').text();
	var ItemsOfCart = $('.number').text();
	
	var empty = "";
	
	
	if(ItemsOfCart.trim() == empty){ItemsOfCart="0"}
// 	alert("---"++"--");		
	
	
	
// 	alert(page+"-p----c--"+code+"---itemsCart---"+getItemsOfCart);
	
	executeAJAXPlus(code,page,ItemsOfCart,e);

	 });
	 
	 
function executeAJAXPlus(code,page,ItemsOfCart,e) {

//     e.preventDefault();
    e.stopPropagation();
     
    $.ajax({
         type: "POST",
         dataType : 'json',
    contentType: "application/x-www-form-urlencoded; charset=UTF-8", // this is the default value, so it's optional
         url: "DuplicatedbuyProduct",
         data: "code=" + code + "&page=" + page + "&ItemsOfCart="+ItemsOfCart,
         success: function(msg){

        	 $('.number').text(msg.AmountItemsOfCartForTopMenu);    	 
        	 $("#SuccessAddToCart"+code).fadeIn('slow').animate({opacity: 1.0},1500).delay(5000).fadeOut('slow');
        	 
        	
//         	 $("#clickScriptAddToCart${prodInfo.code}").toggleFocus();
        	 $("#clickScriptAddToCart${prodInfo.code}").blur();
        	 document.activeElement.blur();
        	 
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
    
}
	

</script>

</c:forEach>
<!-- End That Container -->

</ol>










<div class="WordForPages">
  
	<c:if test="${paginationProducts.totalPages > 1}">
       <div class="page-navigator">

<c:set var="currentSPageleft" value="${paginationProducts.currentPage-3}"/>

<c:set var="ThatInForward" value="${paginationProducts.currentPage+1}"/>
<c:set var="ThatInBack" value="${paginationProducts.currentPage-1}"/>

<c:choose>
<c:when test="${currentSPageleft >= 1}">	  
<a class="nav-item" href="CatalogOfitems?ratingSorting=${ChoosenRating}&brand=${brandSort}&priceSorting=${ChoosenPrice}&page=${ThatInBack}&TransitTypeSorting=${AttributeTransitTypeSorting}&categorySort=${VariableForSideMenucategorySort}">
<img class="ArrowsBothSides" src="${pageContext.request.contextPath}/resources/images/CatalogOfItems/LeftArrow.png" alt="" />
<span class="Back">Back</span></a>
</c:when>	 
<c:otherwise></c:otherwise>
</c:choose>	


 <c:choose>
 		  <c:when test="${currentSPageleft >= 1}">
 		  		
 		  		<a href="CatalogOfitems?ratingSorting=${ChoosenRating}&brand=${brandSort}&priceSorting=${ChoosenPrice}&page=1&TransitTypeSorting=${AttributeTransitTypeSorting}&categorySort=${VariableForSideMenucategorySort}" class="nav-item">1</a>
 		  		<span class="dots"><a class="nav-item">...</a></span>
 		  </c:when>	 
 		 <c:otherwise>
		</c:otherwise>
	</c:choose>	






          <c:forEach items="${paginationProducts.navigationPages}" var = "page">
              <c:if test="${page != -1 }">
              <c:set var="currentSPagePlus" value="${paginationProducts.currentPage+3}"/>
              <c:set var="currentSPageMinus" value="${paginationProducts.currentPage-3}"/>
              
              
              
              
              
              
				<c:if test="${currentSPagePlus > page }"> 
				<c:if test="${currentSPageMinus < page }"> 
	<c:choose>
 		 <c:when test="${paginationProducts.totalPages == page }"></c:when>
 		 <c:otherwise>
			<a href="CatalogOfitems?ratingSorting=${ChoosenRating}&brand=${brandSort}&priceSorting=${ChoosenPrice}&page=${page}&TransitTypeSorting=${AttributeTransitTypeSorting}&categorySort=${VariableForSideMenucategorySort}" class="nav-item">${page}</a>
  		</c:otherwise>
	</c:choose>				       
                </c:if>
                </c:if>
              </c:if>
          </c:forEach>
          
<c:set var="totalPagesS" value="${paginationProducts.totalPages}"/>
<c:set var="currentSPage" value="${paginationProducts.currentPage+3}"/>
	<c:choose>
 		  <c:when test="${currentSPage >= totalPagesS}">
 		  		<a href="CatalogOfitems?ratingSorting=${ChoosenRating}&brand=${brandSort}&priceSorting=${ChoosenPrice}&page=${paginationProducts.totalPages}&TransitTypeSorting=${AttributeTransitTypeSorting}&categorySort=${VariableForSideMenucategorySort}" class="nav-item">${paginationProducts.totalPages}</a>
 		  </c:when>	 
 		 <c:otherwise>
			<span class="dots"><a class="nav-item">...</a></span>
			<a href="CatalogOfitems?ratingSorting=${ChoosenRating}&brand=${brandSort}&priceSorting=${ChoosenPrice}&page=${paginationProducts.totalPages}&TransitTypeSorting=${AttributeTransitTypeSorting}&categorySort=${VariableForSideMenucategorySort}" class="nav-item">${paginationProducts.totalPages}</a>		
  		</c:otherwise>
	</c:choose>		



<c:choose>
<c:when test="${currentSPageleft >= 1}">	  
<a class="nav-item" href="CatalogOfitems?ratingSorting=${ChoosenRating}&brand=${brandSort}&priceSorting=${ChoosenPrice}&page=${ThatInForward}&TransitTypeSorting=${AttributeTransitTypeSorting}&categorySort=${VariableForSideMenucategorySort}">
<img class="ArrowsBothSides" src="${pageContext.request.contextPath}/resources/images/CatalogOfItems/RightArrows.png" alt="" />
<span class="Next">Next</span></a></c:when>	 
<c:otherwise></c:otherwise>
</c:choose>	



          
       </div>
   </c:if>
   </div>









</div>


















































<!-- End Right Catalog Of Items --><!-- End Right Catalog Of Items --><!-- End Right Catalog Of Items -->
<!-- End Right Catalog Of Items --><!-- End Right Catalog Of Items --><!-- End Right Catalog Of Items -->
<!-- End Right Catalog Of Items --><!-- End Right Catalog Of Items --><!-- End Right Catalog Of Items -->
<!-- End Right Catalog Of Items --><!-- End Right Catalog Of Items --><!-- End Right Catalog Of Items -->
<!-- End Right Catalog Of Items --><!-- End Right Catalog Of Items --><!-- End Right Catalog Of Items -->
<!-- End Right Catalog Of Items --><!-- End Right Catalog Of Items --><!-- End Right Catalog Of Items -->
<!-- End Right Catalog Of Items --><!-- End Right Catalog Of Items --><!-- End Right Catalog Of Items -->
<!-- End Right Catalog Of Items --><!-- End Right Catalog Of Items --><!-- End Right Catalog Of Items -->



<script>



$( ".dropShowSumElemetns" ).click(function() {
	$(".ForSubList").toggleClass("ShowClass");
	$(".FirstPart").toggleClass("ChangeBackground");
	});
	
	
$( ".dropShowSumElemetns2" ).click(function() {
	$(".ForSubList2").toggleClass("ShowClass");
	$(".SecondPart").toggleClass("ChangeBackground");
	});
	

$( ".dropShowSumElemetns3" ).click(function() {
	$(".ForSubList3").toggleClass("ShowClass");
	$(".ThirdPart").toggleClass("ChangeBackground");
	});
	
$( ".dropShowSumElemetns4" ).click(function() {
	$(".ForSubList4").toggleClass("ShowClass");
	$(".FourthPart").toggleClass("ChangeBackground");
	});
	
$( ".dropShowSumElemetns5" ).click(function() {
	$(".ForSubList5").toggleClass("ShowClass");
	$(".FithPart").toggleClass("ChangeBackground");
	});
	
	
$( ".dropShowSumElemetns6" ).click(function() {
	$(".ForSubList6").toggleClass("ShowClass");
	$(".sixPart").toggleClass("ChangeBackground");
	});
	
$( ".dropShowSumElemetns7" ).click(function() {
	$(".ForSubList7").toggleClass("ShowClass");
	$(".seventhPart").toggleClass("ChangeBackground");
	});
	
$( ".dropShowSumElemetns8" ).click(function() {
	$(".ForSubList8").toggleClass("ShowClass");
	$(".EigthPart").toggleClass("ChangeBackground");
	});
	
$( ".dropShowSumElemetns9" ).click(function() {
	$(".ForSubList9").toggleClass("ShowClass");
	$(".NinthPart").toggleClass("ChangeBackground");
	});
	
$( ".dropShowSumElemetns10" ).click(function() {
	$(".ForSubList10").toggleClass("ShowClass");
	$(".TenthPart").toggleClass("ChangeBackground");
	});
	
$( ".dropShowSumElemetns11" ).click(function() {
	$(".ForSubList11").toggleClass("ShowClass");
	$(".EleventhPart").toggleClass("ChangeBackground");
	});

</script>








</div>
</div>
</div>



<script>
$( ".items" ).click(function() {$( "#formSelectMenu" ).submit();});
$( ".WithoutArrows" ).click(function() {$( "#formSelectMenu" ).submit();});

</script> 

</body>
</html>