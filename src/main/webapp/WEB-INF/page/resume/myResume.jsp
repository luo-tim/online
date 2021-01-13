<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的简历</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/resume.css" >
</head>
<body>
	<jsp:include page="../navigationBar.jsp"></jsp:include>
   <!--卡片-->
    <div class="resume">
        <!--卡片正面-->
        <div class="front-resume"></div>
        <!--卡片背面-->
        <div class="back-resume">
            <table align="center" border=1 cellpadding=12 cellspacing=0>
                <caption>个人简历</caption>
                <tr align=center>
                    <td colspan="5">基本信息</td>
                </tr>
                <tr align=center>
                    <td>姓名:</td>
                    <td>${resume.name }</td>
                    <td>性别:</td>
                    <td>${resume.sex }</td>
                    <td rowspan="5"  style="background: url(${pageContext.request.contextPath}/static/photo/${resume.photo }) no-repeat; background-size: 100%  100%; "></td>
                </tr>
                <tr align=center>
                    <td>毕业院校:</td>
                    <td>${resume.school }</td>
                    <td>民族:</td>
                    <td>${resume.nation }</td>
                </tr>
                <tr align=center>
                    <td>学历:</td>
                    <td>${resume.education }</td>
                    <td>政治面貌:</td>
                    <td>${resume.politicsStatus }</td>
                </tr>
                <tr align=center>
                    <td>手机号码:</td>
                    <td>${resume.phone }</td>
                    <td>出生年月:</td>
                    <td>${resume.dateOfBirth }</td>
                </tr>

                <tr align=center>
                    <td>邮箱:</td>
                    <td colspan="3">${resume.email }</td>
                </tr>
                <tr align=center>
                    <td>地址:</td>
                    <td colspan="4">${resume.address }</td>
                </tr>
                <tr align=center>
                    <td colspan="5">教育背景</td>
                </tr>
                <tr align=center>
                    <td colspan="5" style="height:100px">${resume.educationBg }</td>
                </tr>
                <tr align=center>
                    <td colspan="5">实习经历</td>
                </tr>
                <tr>
                    <td colspan="5" style="height:100px">${resume.iexperience}</td>
                </tr>
                <tr align=center>
                    <td colspan="5">校园经历</td>
                </tr>
                <tr>
                    <td colspan="5" style="height:100px">${resume.sexperience }</td>
                </tr>
                <tr align=center>
                    <td colspan="5">技能证书</td>
                </tr>
                <tr>
                    <td colspan="5" style="height:100px">${resume.skills }</td>
                </tr>
                <tr align=center>
                    <td colspan="5">自我评价</td>
                </tr>
                <tr>
                    <td colspan="5" style="height:100px">${resume.self }</td>
                </tr>

            </table>
            <c:if test="${sessionScope.user.identityId eq 0 && not empty sessionScope.user.account && not empty sessionScope.user}">
            <div class="item">

                <div class="info-btn-box">
                     <a  class="info-btn" href="<c:url value="/myResumePage/alterPage?workerId=${resume.userId }" />" >修改</a>
                </div>
            </div>
            </c:if>
        </div>
    </div>
</body>
</html>