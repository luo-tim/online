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
<title>审查公司</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/pagebtn.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/checkCompany.css" >
</head>
<body>
	<jsp:include page="../navigationBar.jsp"></jsp:include>
<div class="userList-container">
     
        <div class="item">
            <div class="sex">
                <label class="radio">
                    <input type="radio" checked class="radio-btn" name="identity" <c:if test="${param.tag eq 'all' }">checked</c:if> value="全部">
                    <a href="<c:url value="/managerPage/checkCompanyPage?tag=all" />" class="radio-text">全部</a>
                </label>
                <label class="radio">
                    <input class="radio-btn"  type="radio" name="identity" <c:if test="${param.tag eq '1' }">checked</c:if> value="审核通过">
                    <a href="<c:url value="/managerPage/checkCompanyPage?tag=1" />" class="radio-text">审核通过</a>
                </label>
                <label class="radio">
                    <input class="radio-btn" type="radio" name="identity" <c:if test="${param.tag eq '0' }">checked</c:if> value="审核中">
                    
                    <a href="<c:url value="/managerPage/checkCompanyPage?tag=0" />" class="radio-text">审核中</a>
                </label>
               
            </div>
        </div>
       
        <div class="hot-job">
            <ul class="cur">
            <c:forEach items="${pages.items }" var="company">
                <li class="cur-company">
                    <div class="sub-li-company">
                       <a href="<c:url value="/managerPage/checkCompanyPage/companyDetailPage?companyId=${company.id }" />" class="company-info">
                           <div class="img-box">
                               <img src="<c:url value="/resource/${company.companyLogo }" />" alt="${company.companyName }">
                           </div>
                           <div class="company-text">
                               <h4>${company.companyName }</h4>
                               <p>${company.companyType }</p>
                           </div>
                       </a> 
                       <span class="about-info">
                       <c:if test="${company.flag eq 0 }">
                           <p class="check-blue">
                               审核中
                           </p>
                           </c:if>
                            <c:if test="${company.flag eq 1 }">
                           <p class="check-green">
                               审核通过
                           </p>
                           </c:if>
                       </span>
                    </div>
                </li>
             </c:forEach>
            </ul>
        </div>
        <mytag:companys/>
    </div>
</body>
</html>