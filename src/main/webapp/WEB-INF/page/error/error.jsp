<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>错误提醒</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/image/notFound.css" >
</head>
<body>
<jsp:include page="../navigationBar.jsp"></jsp:include>
	<h1 style="text-align: center;">${error}</h1>
 <div class="notFound-container">
   <img src="${pageContext.request.contextPath}/static/image/404.png" class="bg" alt="">
 </div>
</body>
</html>