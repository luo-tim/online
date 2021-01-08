<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>公司列表</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/companys.css" >
</head>
<body>
<jsp:include page="../navigationBar.jsp"></jsp:include>
   <div class="hot-job">
        <ul class="cur">
        <c:forEach items="${companys}" var="company">
            <li class="cur-company">
                <div class="sub-li-company">
                   <a href="<c:url value="/companyPage/companyDetailPage?companyId=${company.id }" />" class="company-info">
                       <div class="img-box">
                           <img src="<c:url value="/resource/${company.companyLogo }" />" alt="${company.companyName }">
                       </div>
                       <div class="company-text">
                           <h4>${company.companyName }</h4>
                           <p>${company.companyType }</p>
                       </div>
                   </a> 
                   <a href="<c:url value="/companyPage/companyWorksPage?companyId=${company.id }" />" class="about-info">
                       <p>
                           <span class="text-blue">1</span>
                           个热招职位
                       </p>
                   </a>
                </div>
            </li>
            </c:forEach>
           
        </ul>
    </div>
</body>
</html>