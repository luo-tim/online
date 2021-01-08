<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>公司注册提醒页面</title>
</head>
<body>
	<jsp:include page="../navigationBar.jsp"></jsp:include>
<h1>${companyTip }</h1>
<c:if test="${not empty id }">
<a href="<c:url value="/releaseRecruitmentPage/bossWorkDetailPage?id=${id }" />">查看详情</a>
</c:if>
</body>
</html>