<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>账号注册</title>
 <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/userInfo.css" >
</head>
<body>
<jsp:include page="../navigationBar.jsp"></jsp:include>
 <div class="registerSteps">
        <!--第一步-->
        <div class="step currentstep">
          
            <div class="number"></div>
             <!--直线-->
            <div class="line"></div>
           
        </div>
        <!--第二步-->
        <div class="step currentstep">
            <div class="number"></div>
            <div class="line"></div>
 
        </div>
        <!--第三步-->
        <div class="step">
            <div class="number"></div>
         
        </div>
    </div>
    <div class="userInfo-container">
        <div class="box-title">
            账号填写
        </div>
        <form method="POST" class="userInfo-form" name="userForm">
        <div class="item">
                <label class="info-text">昵称: </label>
                <input name="userName" type="text" autocomplete="off" placeholder="你的昵称" maxlength="20" class="info-input">
            </div>
            <div class="item">
                <label class="info-text">账号: </label>
                <input name="account" type="text" autocomplete="off" placeholder="你的账号" maxlength="20" class="info-input">
            </div>
            <div class="item">
                <label class="info-text">密码: </label>
                <input name="password" type="password" autocomplete="off" placeholder="你的密码" maxlength="20" class="info-input">
          
            </div>
            <div class="item">
                <div class="info-line"></div>
                <div class="info-btn-box">
                    <input type="submit" class="info-btn" value="提    交" onclick="return postUser();">
                </div>
            </div>
        </form>
    </div>
      <script src="${pageContext.request.contextPath}/static/js/basicInfo.js"></script>
</body>
</html>