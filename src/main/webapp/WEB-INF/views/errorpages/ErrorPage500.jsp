<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% response.setStatus(404); %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
 "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>404 error</title>
<%--     <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/.css"> --%>
    <link href="<c:url value="/resources/css/errorpages/ErrorPage.css" />" rel="stylesheet">
    
  </head>
  <body>
    
    <div class="layout">
    	<div class="FirstLevel">
    		<div class="SecondLevel">
    			<div class="ThirdLevel">
<!--     						message 									-->
    					<div class="message">
    					
    					<div class="Text"> Неполадки на сервере. </div>
    					<div class="UseSearch"><a href="StartingPage">Перейти на главную страницу</a></div>
    					
    					</div>
    			
<!--     			Page not found!!!404 -->
    						
<!--     							... 									-->
    			</div>
    		</div>
    	</div>
    </div>
  </body>
</html>