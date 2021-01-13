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
<title>管理员管理</title>
 <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/pagebtn.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/userList.css">
</head>
<body>
	<jsp:include page="../navigationBar.jsp"></jsp:include>
	<div class="userList-container">
	 <div class="info-box-manager">
            <a class="info-btn-manager" href="<c:url value="/managerPage/managerListPage/addManagerPage" />">添加管理员</a>
        </div>
         <div class="result_num">
            饭碗为您找到相关结果约${pages.totalCount}个
        </div>
  <div class="game-container">
            <ul>
            <c:forEach items="${pages.items }" var="manager">
                <li class="game-list-person">
                    <div class="job-item-person">
                        <div class="job-info-person">
                            <div class="job-wrapper-person">
                                <div class="primary-box-person">
                                    <div class="job-title-person">
                                        <span class="job-name-person">
                                            <a href="<c:url value="/managerPage/managerListPage/managerAccountInfoPage?userId=${manager.id }" />">${manager. userName}</a>
                                        </span>
                                        <span class="job-area-person">
                                           <span class="job-name-person">  <a href="<c:url value="/managerPage/managerListPage/managerAccountInfoPage?userId=${manager.id }" /> ">${manager. lastName}${manager. firstName}</a></span>
                                        </span>
                                    </div>
                                </div>
                            </div>
                            <div class="job-company-person">
                                <h3 class="resume">
                                    <a href="#">管理员</a>
                                </h3>
                            </div>
                        </div>
                        <div class="info-append">
                      
                            <div class="info-left"> <a href="<c:url value="/managerPage/managerListPage/upManagerPage?userId=${manager. id }" />" class="a-red">升级为超级管理员</a></div>
                            <div class="info-right"> <a href="<c:url value="/managerPage/managerListPage/deleteManagerPage?userId=${manager. id }" />" class="a-red">删除</a></div>
                           
                        </div>
                    </div>
                </li>
               </c:forEach>
            </ul>
        </div>
        <mytag:managers  pages="${pages}"/>
        </div>
</body>
</html>