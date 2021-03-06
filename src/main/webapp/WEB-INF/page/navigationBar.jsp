<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>导航栏</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/navigationBar.css">
</head>
<body>
 <div class="nav">
        <nav class="nav-bar">
            <%--logo--%>
            <div class="nav-logo">
                <a href="<c:url value="/homePage" />"> <img class="nav-logo-img" src="${pageContext.request.contextPath}/static/image/logo.jpg" alt=""> </a>
             </div>
            <ul class="nav-items">
                <li> <a href="<c:url value="/homePage" />" class="nav-item">首页</a></li>
                <li> <a href="<c:url value="/employmentPage?pro=省份&city=城市&type=工作类型&query=" />" class="nav-item">职位</a></li>
                <li> <a href="<c:url value="/companyPage" />" class="nav-item">公司</a></li>
                 <li> <a href="<c:url value="/companyPage/companyRegisterPage" />" class="nav-item">公司注册</a></li>
                   <c:if test="${ not empty sessionScope.user.account&& not empty sessionScope.user}">
                <li> <a href="<c:url value="/newsPage?index=0" />" class="nav-item">消息</a></li>
                </c:if>
                <c:if test="${sessionScope.user.identityId eq 1 && not empty sessionScope.user.account&& not empty sessionScope.user}">
                <li> <a href="<c:url value="/releaseRecruitmentPage" />" class="nav-item">招聘</a></li>
                </c:if>
                <c:if test="${sessionScope.user.identityId eq 0 && not empty sessionScope.user.account && not empty sessionScope.user}">
                <li> <a href="<c:url value="/myResumePage?workerId=${sessionScope.worker.id }" />" class="nav-item">简历</a></li>
                </c:if>
                <c:if test="${sessionScope.user.identityId ge 2 && not empty sessionScope.user.account && not empty sessionScope.user}">
                <li> <a href="<c:url value="/managerPage" />" class="nav-item">管理</a></li>
                </c:if>
            </ul>
            <div class="nav-btn">
            <c:choose>
            	<c:when test="${not empty sessionScope.user && not empty sessionScope.user.account}">
            	<a href="<c:url value="/personalPage" />" class="nav-item">${sessionScope.user.userName }</a>
                <a href="<c:url value="/logoutPage" />" class="nav-item btn">退出</a>
                </c:when>
                <c:otherwise>
                 <a href="<c:url value="/loginPage" />" class="nav-item btn">登录</a>
                <a href="<c:url value="/registerPage" />" class="nav-item btn">注册</a>
                </c:otherwise>
                </c:choose>
            </div>
        </nav>
    </div>
</body>
</html>