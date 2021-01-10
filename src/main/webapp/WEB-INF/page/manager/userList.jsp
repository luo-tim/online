<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="MyTag" prefix="mytag"%>
<%@ page isELIgnored="false"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户管理</title>
 <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/pagebtn.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/userList.css" >
</head>
<body>
<jsp:include page="../navigationBar.jsp"></jsp:include>
	<div class="userList-container">
        <div class="item">
            <div class="sex">
                <label class="radio">
                    <input type="radio" class="radio-btn" name="identity" <c:if test="${param.tag eq 'all' }"> checked</c:if> value="all">
                    <a href="<c:url value="/managerPage/userListPage?tag=all" />" class="radio-text">全部</a>
                </label>
                <label class="radio">
                    <input class="radio-btn" type="radio" name="identity" <c:if test="${param.tag eq '0' }"> checked</c:if> value="worker">
                     <a href="<c:url value="/managerPage/userListPage?tag=0" />" class="radio-text">打工人</a>
                </label>
                <label class="radio">
                    <input class="radio-btn" type="radio" name="identity" <c:if test="${param.tag eq '1' }"> checked</c:if> value="boss">
                  
                    <a href="<c:url value="/managerPage/userListPage?tag=1" />" class="radio-text">老板</a>
                </label>
              
            </div>
        </div>
        <div class="game-container">
            <ul>
                 <c:forEach items="${pages.items }" var="user">
                                    <li class="game-list-person">
                                        <div class="job-item-person">
                                            <div class="job-info-person">
                                                <div class="job-wrapper-person">
                                                    <div class="primary-box-person">
                                                        <div class="job-title-person">
                                                            <span class="job-name-person">
                                                                <a href="<c:url value="/managerPage/userListPage/userAccountPage?userId=${user.id}" />">${user.userName }</a>
                                                            </span>
                                                            <span class="job-area-person">
                                                                <span class="job-name-person">
                                                                <a href="<c:url value="/managerPage/userListPage/userAccountPage?userId=${user.id}" />">详情信息</a></span>
                                                            </span>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="job-company-person">
                                                    <h3 class="resume">
                                                        <a href="#" ><c:choose><c:when test="${user.identityId eq 0}">工人</c:when><c:when test="${user.identityId eq 1}">HR</c:when><c:when test="${user.identityId eq 2}">管理员</c:when><c:when test="${user.identityId eq 3}">超级管理员</c:when></c:choose></a>
                                                    </h3>
                                                </div>
                                            </div>
                                            <div class="info-append">
                                               
                                                <div class="info-right"><a href="<c:url value="/managerPage/userListPage/deleteUserPage?userId=${user.id}" />" class="a-green">删除</a> </div>
                                            </div>
                                        </div>
                                    </li>
                                    </c:forEach>
            </ul>
        </div>
        <mytag:users/>
    </div>

</body>
</html>