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
           <%--账户信息--%>
           <div class="person-right">
            <%--小标题--%>
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

	    <div class="userAccount-container">
        <%--账户信息--%>
        <div class="person-right">
         <%--小标题--%>
         <div class="person-right-title">
             <span class="person-right-title-name">个人信息</span>
         </div>
         <div class="student-info">
             
                 <div class="info-box">
                     <span class="info-text">姓: </span>
                     <span class="info-value">${userAccount.lastName }</span>
                 </div>
                 <div class="info-box">
                     <span class="info-text">名: </span>
                     <span class="info-value">${userAccount.firstName }</span>
                 </div>
                 <div class="info-box">
                     <span class="info-text">出生日期: </span>
                     <span class="info-value">${userAccount.dateOfBirth }</span>
                 </div>
                 <div class="info-box">
                     <span class="info-text">身份证号: </span>
                     <span class="info-value">${userAccount.IDNumber }</span>
                 </div>
                 <div class="info-box">
                    <span class="info-text">手机号: </span>
                    <span class="info-value">${userAccount.phoneNumber }</span>
                </div>
                <div class="info-box">
                    <span class="info-text">电子邮箱: </span>
                    <span class="info-value">${userAccount.email }</span>
                </div>
                <div class="info-box">
                    <span class="info-text">性别: </span>
                    <span class="info-value">${userAccount.sex}</span>
                </div>
                <c:if test="${userAccount.identityId eq 1 }">
                <div class="info-box">
                    <span class="info-text">公司: </span>
                    <span class="info-value">${companyName}</span>
                </div>
                </c:if>
                <c:if test="${sessionScope.user.identityId ge 2 && not empty sessionScope.user.account && not empty sessionScope.user && userAccount.identityId eq 0}">
                <div class="info-box">
                    <a class="info-btn" href="<c:url value="/myResumePage?workerId=${userAccount.id}"/>">简历</a>
                </div>
                </c:if>
         </div>
     </div>
 </div>
</body>
</html>