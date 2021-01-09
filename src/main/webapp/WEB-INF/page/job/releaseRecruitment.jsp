<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>发布工作</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/createWork.css" >
</head>
<body>
<jsp:include page="../navigationBar.jsp"></jsp:include>
  <div class="container">
        <div class="box-title">
            发布工作
        </div> 
        <div class="info-container">
            <!--打工人的基本信息-->
            <form method="POST" class="info-form" name="workerForm">
                <div class="item">
                    <label class="info-text"> 职位：</label>
                    <input name="jobName" type="text" autocomplete="off" placeholder="职位" maxlength="20" class="info-input">
                </div>
                <div class="item">
                    <label class="info-text"> 工作类型：</label>
                    <select name="jobType" class="info-input">
                        <option value="技术">技术</option>
                        <option value="产品">产品</option>
                        <option value="运营">运营</option>
                        <option value="市场">市场</option>
                        <option value="人事">人事/财务/行政</option>
                        <option  value="高级管理">高级管理</option>
                    </select>
                </div>
                <div class="item">
                    <label class="info-text">工作介绍：</label>
                    <textarea  class="info-textarea"  name="jobIntroduce" placeholder="工作介绍" value=""></textarea>
                </div>
              
            
                <div class="item">
                    <label class="info-text"> 薪水：</label>
                    <input name="jobSalary" type="text" autocomplete="off" placeholder="薪水" maxlength="20" class="info-input">
                </div>
                <div class="item">
                    <label class="info-text">城市：</label>
                    <select id="pro" name="pro" class="info-input">
                        <option>省份</option>
                        <option>北京市</option>
                        <option>上海市</option>
                        <option>天津市</option>
                        <option>重庆市</option>
                        <option>河北省</option>
                        <option">山西省</option>
                        <option>内蒙古自治区</option>
                        <option>辽宁省</option>
                        <option>吉林省</option>
                        <option>黑龙江省</option>
                        <option">江苏省</option>
                        <option">浙江省</option>
                        <option>安徽省</option>
                        <option">福建省</option>
                        <option">江西省</option>
                        <option>山东省</option>
                        <option>河南省</option>
                        <option>湖北省</option>
                        <option>湖南省</option>
                        <option>广东省</option>
                        <option">广西壮族自治区</option>
                        <option>海南省</option>
                        <option>四川省</option>
                        <option>贵州省</option>
                        <option>云南省</option>
                        <option>西藏自治区</option>
                        <option">陕西省</option>
                        <option">甘肃省</option>
                        <option>宁夏回族自治区</option>
                        <option>青海省</option>
                        <option">新疆维吾尔族自治区</option>
                        <option>香港特别行政区</option>
                        <option>澳门特别行政区</option>
                        <option>台湾省</option>
                        <option>其它</option>
                    </select>
                    <select id="city" name="city" class="info-input">
                        <option>城市</option>
                    </select>
                </div>
                <div class="item">
                    <label class="info-text"> 工作地址：</label>
                    <textarea  class="info-textarea"  name="jobAddress" placeholder="工作地址" ></textarea>
                </div>
                <div class="item">
                    <label class="info-text"> 工作要求：</label>
                    <textarea  class="info-textarea"  name="jobRequest" placeholder="工作要求" ></textarea>
                </div>
                <div class="item">
                    <label class="info-text"> 工作经验：</label>
                    <input name="experience" type="text" autocomplete="off" placeholder="工作经验" maxlength="20" class="info-input">
                </div>
                <div class="item">
                    <label class="info-text"> 学历要求：</label>
                    <input name="education" type="text" autocomplete="off" placeholder="学历要求" maxlength="20" class="info-input">
                </div>
                <div class="item">
                    <div class="info-line"></div>
                    <div class="info-btn-box">
                        <input type="submit" class="info-btn" value="发    布" onclick="return postWorkerForm();")>
                    </div>

                </div>
            </form>
        </div>
        </div>
        <script src="${pageContext.request.contextPath}/static/js/jquery-3.5.1.min.js"></script> 
        <script src="${pageContext.request.contextPath}/static/js/city.js"></script> 
</body>
</html>