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
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/companyFB.css">
</head>
<body>
	<jsp:include page="../navigationBar.jsp"></jsp:include>
 <div class="FB-container">
    <h1 class="submitSuccess">${success }</h1>
  </div>

</body>
</html>