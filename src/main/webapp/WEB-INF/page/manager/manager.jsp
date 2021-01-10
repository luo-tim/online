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
 <div class="function-text1">
    <h3>写点东西</h3>
</div>
<div class="function-text2">
    <h3>写点东西</h3>
</div>



<div class="box">
    <div class="box1">
    <c:choose>
    <c:when test="${sessionScope.user.identityId eq 3 && not empty sessionScope.user.account && not empty sessionScope.user}">
      <a href="<c:url value="/managerPage/managerListPage"/>" target="_blank"><img src="${pageContext.request.contextPath}/static/image/黄全3.png" alt=""></a>
    </c:when>
    <c:otherwise>
		<img src="${pageContext.request.contextPath}/static/image/黄全3.png" alt="">
        <p class="details">
                您暂无权限访问此内容
            </p>
    </c:otherwise>
    
    </c:choose>
      
    </div>
    <div class="box2">
        <a  href="<c:url value="/managerPage/userListPage"/>" target="_blank"><img src="${pageContext.request.contextPath}/static/image/红全4.png" alt=""></a>
    </div>
    <div class="box3">
        <a  href="<c:url value="/managerPage/checkRecruitmentPage"/>" target="_blank"><img src="${pageContext.request.contextPath}/static/image/蓝全3.png" alt=""></a>
    </div>
    <div class="box4">
        <a  href="<c:url value="/managerPage/checkCompanyPage"/>" target="_blank"><img src="${pageContext.request.contextPath}/static/image/绿全4.png" alt="" ></a>
    </div>
    </div>
</body>
</html>