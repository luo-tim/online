<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>身份选择页面</title>
 <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/identity.css"  >
</head>
<body>
<jsp:include page="../navigationBar.jsp"></jsp:include>
  <div class="registerSteps">
        <%--第一步--%>
        <div class="step">
          
            <div class="number"></div>
             <%--直线--%>
            <div class="line"></div>
           
        </div>
        <%--第二步--%>
        <div class="step">
            <div class="number"></div>
            <div class="line"></div>
 
        </div>
        <%--第三步--%>
        <div class="step">
            <div class="number"></div>
         
        </div>
    </div>
   <div class="box-title">
        身份选择
    </div>
    <%--身份选择卡片--%>
    <div class="identity">
        <%--打工人卡片--%>
        <div class="worker-card">
            <%--正面卡片--%>
            <div class="worker-before">

            </div>
            <%--背面卡片--%>
            <div class="worker-after">
				<a href=" <c:url value="/registerPage/workerBasicInfo" /> "></a>
            </div>
        </div>
        <%--老板卡片--%>
        <div class="boss-card">
            <%--正面卡片--%>
            <div class="boss-before">

            </div>
            <%--背面卡片--%>
            <div class="boss-after">
				<a  href="<c:url value="/registerPage/bossBasicInfo" /> "></a>
            </div>
        </div>
    </div>
</body>
</html>