<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 

 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product List</title>
 
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles.css">
 
<style>

.page-title {
font-size: 15px;

margin-left: auto;

margin-right: auto;

text-align: center;

font-size: 25px;

color: white;

background-color: #4976e6;

margin-top: 10px;
}


.page_title_totalOrder {
margin-left: auto;
margin-right: auto;
text-align: center;
font-size: 25px;
color: white;
background-color: #4976e6;
margin-top: 10px;
margin-bottom: 5px;
}

</style>

</head>
<body>


 
   <fmt:setLocale value="en_US" scope="session"/>
  
   <div class="page-title">Order List</div>
 
   <div class="page_title_totalOrder">Total Order Count: ${paginationResult.totalRecords}</div>
  
   <table border="1" style="width:100%">
       <tr>
           <th>Order Num</th>
           <th>Order Date</th>
           <th>Customer Name</th>
           <th>Customer Address</th>
           <th>Customer Email</th>
           <th>Customer Phone</th>
           <th>Customer Town</th>
           <th>Amount</th>
           <th>Send message</th>
           <th>Solded</th>
           <th>View</th>
           <th>Delete</th>
       </tr>
       <c:forEach items="${paginationResult.list}" var="orderInfo">
           <tr>
               <td>${orderInfo.orderNum}</td>
               <td>
                  <fmt:formatDate value="${orderInfo.orderDate}" pattern="dd-MM-yyyy HH:mm"/>
               </td>
               <td>${orderInfo.customerName}</td>
               <td>${orderInfo.customerAddress}</td>
               <td>${orderInfo.customerEmail}</td>
               <td>${orderInfo.customerPhone}</td>
               <td>${orderInfo.customerTown}</td>
               <td style="color:red;">
                  <fmt:formatNumber currencySymbol="$"  value="${orderInfo.amount}" type="currency"/>
               </td>
                <td><a href="${pageContext.request.contextPath}/SendMessageByPhone?orderId=${orderInfo.id}">
                  Send msg</a></td>
                 <td><a href="${pageContext.request.contextPath}/solded?orderId=${orderInfo.id}">
                  Solded</a></td>
               <td><a href="${pageContext.request.contextPath}/order?orderId=${orderInfo.id}">
                  View</a></td>
               <td><a href="${pageContext.request.contextPath}/deleteOrder?orderId=${orderInfo.id}">
                  Delete</a></td>
           </tr>
       </c:forEach>
   </table>
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
 
 
 
</body>
</html>