<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product List</title>
<link href="<c:url value="/resources/css/Admin/Order List/ExtraCss.css" />" rel="stylesheet">
</head>
<body>
 
<%--    <jsp:include page="_header.jsp" /> --%>
<%--    <jsp:include page="_menu.jsp" /> --%>
    
   <fmt:setLocale value="en_US" scope="session"/>
 
 <div class="ForAlignOfTwoContainer">
 
    
<div class="FisrtForAlignOfTwoContainer"> 
<div class="page-titleLeft">Order Info</div>
 
 <div class="ThatForLineAround">
 
   <div class="customer-info-container">
       <h3>Customer Information:</h3>
       <ul>
           <li>Name: ${orderInfo.customerName}</li>
           <li>Email: ${orderInfo.customerEmail}</li>
           <li>Phone: ${orderInfo.customerPhone}</li>
           <li>Address: ${orderInfo.customerAddress}</li>
           <li>Town: ${orderInfo.customerTown}</li>
       </ul>
       <h3>Order Summary:</h3>
       <ul>
           <li>Total:
           <span class="total">
           <fmt:formatNumber currencySymbol="$"  value="${orderInfo.amount}" type="currency"/>
           </span></li>
       </ul>
   </div>
   </div>
    </div>
   <br/>
    
    <div class="SecondForAlignOfTwoContainer">
   <div class="page-titleRight">Ordered items</div>
   <table border="1" style="width:100%">
       <tr>
           <th>Product Code</th>
           <th>Product Name</th>
           <th>Quantity</th>
           <th>Price</th>
           <th>Amount</th>
       </tr>
       <c:forEach items="${orderInfo.details}" var="orderDetailInfo">
           <tr>
               <td>${orderDetailInfo.productCode}</td>
               <td>${orderDetailInfo.productName}</td>
               <td>${orderDetailInfo.quanity}</td>
               <td>
                <fmt:formatNumber currencySymbol="$"  value="${orderDetailInfo.price}" type="currency"/>
               </td>
               <td>
                <fmt:formatNumber currencySymbol="$"  value="${orderDetailInfo.amount}" type="currency"/>
               </td>  
           </tr>
       </c:forEach>
   </table>
   </div>
   
   
   </div>

   <c:if test="${paginationResult.totalPages > 1}">
       <div class="page-navigator">
          <c:forEach items="${paginationResult.navigationPages}" var = "page">
              <c:if test="${page != -1 }">
                <a href="orderList?page=${page}" class="nav-item">${page}</a>
              </c:if>
              <c:if test="${page == -1 }">
                <span class="nav-item"> ... </span>
              </c:if>
          </c:forEach>
            
       </div>
   </c:if>
 
 
 
 
<%--    <jsp:include page="_footer.jsp" /> --%>
 
</body>
</html>