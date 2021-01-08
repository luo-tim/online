<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录页面</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/login.css" >
</head>
<body>
<jsp:include page="navigationBar.jsp"></jsp:include>
    <div class="login-container">
    <c:if test="${not empty loginError}">
     <h1 class="loginError">${loginError}</h1>
     </c:if>
        <div class="box-title">
                账号密码登录
        </div>
        <div class="login-box">
            <form method="POST" class="login-form">
                <div class="login-item">
                    <input type="text" class="login-input" name="account" placeholder="账号">
                </div>
                <div class="login-item">
                    <input type="text" class="login-input" name="password" placeholder="密码">
                </div>
                <div class="login-btn">
                    <button type="submit" class="login-submit">登录</button>
                </div>
            </form>
        </div>
    </div>
</body>
</html>