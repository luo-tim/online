<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改密码</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/alterPw.css" />
</head>
<body>
	<jsp:include page="../navigationBar.jsp"></jsp:include>
  <div class="login-container">
        <div class="box-title">
                设置新密码
        </div>
        <div class="login-box">
            <form class="login-form" method="POST" name="accountForm">
            <div class="login-item">
                    <input  name="account" type="text" class="login-input" placeholder="账号">		
                </div>
                <div class="login-item">
                    <input  name="oldPassword" type="text" class="login-input" placeholder="旧密码">		
                </div>
                 <div class="login-item">
                    <input  name="password" type="text" class="login-input" placeholder="新密码,必须为6-18位，包括字母、数字">		
                </div>
                <div class="login-item">
                    <input name="confirmPassword" type="text" class="login-input" placeholder="确认密码，必须为6-18位，包括字母、数字">
                </div>
                <div class="login-btn">
                    <input type="submit" class="login-submit"  value="修改" onclick="return postAccount();">
                </div>
            </form>
        </div>
    </div>
    
<script src="${pageContext.request.contextPath}/static/js/basicInfo.js"></script>
</body>
</html>