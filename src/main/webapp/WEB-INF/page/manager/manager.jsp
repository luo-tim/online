<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理员</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/manager.css">
</head>
<body>
<jsp:include page="../navigationBar.jsp"></jsp:include>
 <div class="manager-container">
        <div class="function">
            <div class="function-one">
            <a href="<c:url value="/managerPage/userListPage?tag=all"/>">
                <img src="<c:url value="/resource/worker.png"/>" alt="">
                <div class="function-text">
                    <h3>用户管理</h3>
                 
                </div>
                </a>
            </div>
            <c:if test="${sessionScope.identity eq 'manager' && not empty sessionScope.manager && not empty sessionScope.user && sessionScope.manager.level eq 1}">
            <div class="function-one">
            <a href="<c:url value="/managerPage/managerListPage"/>">
                <img src="<c:url value="/resource/worker.png"/>" alt="">
                <div class="function-text">
                    <h3>管理员管理</h3>
                </div>
                </a>
                
            </div>
            </c:if>
            <div class="function-one">
            <a href="<c:url value="/managerPage/checkCompanyPage?tag=3"/>">
                <img src="<c:url value="/resource/worker.png"/>" alt="">
                <div class="function-text">
                    <h3>公司管理</h3>
                </div>
                </a>
                
            </div>
            <div class="function-one">
            <a href="<c:url value="/managerPage/checkRecruitmentPage?tag=3"/>">
                <img src="<c:url value="/resource/worker.png"/>" alt="">
                <div class="function-text">
                    <h3>工作管理</h3>
                </div>
                </a>
                
            </div>
        </div>
    </div>
</body>
</html>