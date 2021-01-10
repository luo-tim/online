<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户账号信息</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/userAccount.css" >
</head>
<body>
	<jsp:include page="../navigationBar.jsp"></jsp:include>
  <div class="userAccount-container">
           <!--账户信息-->
           <div class="person-right">
            <!--小标题-->
            <div class="person-right-title">
                <span class="person-right-title-name">账户信息</span>
            </div>
            <div class="student-info">
                
                    <div class="info-box">
                        <span class="info-text">昵称: </span>
                        <span class="info-value">${userAccount.userName}</span>
                    </div>
                    <div class="info-box">
                        <span class="info-text">账号: </span>
                        <span class="info-value">${userAccount.account}</span>
                    </div>
                    <div class="info-box">
                        <span class="info-text">身份: </span>
                        <span class="info-value"><c:choose><c:when test="${userAccount.identityId eq 0}">工人</c:when><c:when test="${userAccount.identityId eq 1}">HR</c:when><c:when test="${userAccount.identityId eq 2}">管理员</c:when><c:when test="${userAccount.identityId eq 3}">超级管理员</c:when></c:choose></span>
                    </div>
                    <div class="info-box">
                        <span class="info-text">信誉度: </span>
                        <span class="info-value">${userAccount.credit}</span>
                    </div>
           
            </div>
        </div>
    </div>
</body>
</html>