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
<title>公司注册</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css//companyRegister.css" >
</head>
<body>
<jsp:include page="../navigationBar.jsp"></jsp:include>
<div class="container">
        <div class="box-title">
            公司注册
        </div> 
        <div class="info-container">
            <!--打工人的基本信息-->
            <form method="POST" class="info-form" name="companyForm" enctype="multipart/form-data">
               <div class="item">
                    <label class="info-text"> 公司名称：</label>
                    <input name="name" type="text" autocomplete="off" placeholder="公司名称" maxlength="20" class="info-input">
                </div>
                <div class="item">
                    <label class="info-text"> 高管介绍：</label>
                    <textarea  class="info-textarea"  name="leader" placeholder="公司介绍" ></textarea>
                </div>
                <div class="item">
                    <label class="info-text">公司介绍：</label>
                    <textarea  class="info-textarea"  name="introduce" placeholder="公司介绍" ></textarea>
                </div>
                <div class="item">
                    <label class="info-text"> 公司地址：</label>
                    <textarea  class="info-textarea"  name="address" placeholder="公司地址" ></textarea>
                </div>
            
                <div class="item">
                    <label class="info-text"> 公司类型：</label>
                    <input name="type" type="text" autocomplete="off" placeholder="公司类型" maxlength="20" class="info-input">
                </div>
                <div class="item">
                    <label class="info-text"> 公司福利：</label>
                    <textarea  class="info-textarea"  name="treatment" placeholder="公司福利" ></textarea>
                </div>
                <div class="item">
                    <label class="info-text">公司logo：</label>
                    <input name="file" type="file" id="file" accept="image/png, image/jpeg" onchange="selectImage()"  class="info-file">
                    <img id="image" src="" class="file-img" />
                </div>
   
                <div class="item">
                    <div class="info-line"></div>
                    <div class="info-btn-box">
                        <input type="submit" class="info-btn" value="提    交"  onclick="return postCompany();">
                    </div>

                </div>
            </form>
        </div>
        </div>
<script src="${pageContext.request.contextPath}/static/js/company.js"></script>
</body>
</html>