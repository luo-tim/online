<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>欢迎页面</title>
<link rel="stylesheet" href="<c:url value="/resource/index.css" />">
</head>
<body>

 <div class="welcom-container">
        <div class="img-box">
            <img class="img" src="<c:url value="/resource/worker.png"/>" alt="">
            <a href="<c:url value="/homePage" />" class="abtn">立即体验</a>
        </div>
        <div class="function">
            <div class="function-one">
                <img src="<c:url value="/resource/worker.png"/>" alt="">
                <div class="function-text">
                    <h3>打工人找工作</h3>
                    <p>在这里，可以看见各种工作</p>
                </div>
            </div>
            <div class="function-one">
                <img src="<c:url value="/resource/worker.png"/>" alt="">
                <div class="function-text">
                    <h3>老板找员工</h3>
                    <p>在这里老板可以找到各种各样的员工</p>
                </div>
            </div>
        </div>
    </div>
</body>
</html>