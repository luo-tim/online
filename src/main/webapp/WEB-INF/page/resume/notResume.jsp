<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>没有简历</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/notFound.css">
</head>
<body>
<jsp:include page="../navigationBar.jsp"></jsp:include>
    <div class="notFound-container">
   
        <h1 style="text-align: center;">${notResume }</h1>
   
        <img src="<c:url value="/resource/404.png"/>" class="bg" alt="">
        <div class="notFound-btn">
		<c:if test="${sessionScope.identity eq 'worker' && not empty sessionScope.worker && not empty sessionScope.user}">
            <a href="<c:url value="/myResumePage/alterPage?workerId=${ sessionScope.worker.id}" />" class="go">立即填写</a>
            </c:if>
            <a href="<c:url value="/homePage" />" class="back">返回首页</a>
       
    
        </div>
    </div>
</body>
</html>