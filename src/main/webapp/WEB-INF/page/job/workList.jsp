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
<title>工作列表</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/pagebtn.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/position.css" >
</head>
<body>
<jsp:include page="../navigationBar.jsp"></jsp:include>
	<div class="position-container">
	  <div class="search">
            <form method="POST">
                <select id="type" name="type" class="info-input">
                    <option value="工作类型">工作类型</option>
                    <option value="技术">技术</option>
                    <option value="产品">产品</option>
                    <option value="运营">运营</option>
                    <option value="市场">市场</option>
                    <option value="人事">人事/财务/行政</option>
                    <option value="高级管理">高级管理</option>
                </select>
                <select id="pro" name="pro" class="info-input">
                    <option value="省份">省份</option>
                    <option value="北京市">北京市</option>
                    <option value="上海市">上海市</option>
                    <option value="天津市">天津市</option>
                    <option value="重庆市">重庆市</option>
                    <option value="河北省">河北省</option>
                    <option value="山西省">山西省</option>
                    <option value="内蒙古自治区">内蒙古自治区</option>
                    <option value="辽宁省">辽宁省</option>
                    <option value="吉林省">吉林省</option>
                    <option value="黑龙江省">黑龙江省</option>
                    <option value="江苏省">江苏省</option>
                    <option value="浙江省">浙江省</option>
                    <option value="安徽省">安徽省</option>
                    <option value="福建省">福建省</option>
                    <option value="江西省">江西省</option>
                    <option value="山东省">山东省</option>
                    <option value="河南省">河南省</option>
                    <option value="湖北省">湖北省</option>
                    <option value="湖南省">湖南省</option>
                    <option value="广东省">广东省</option>
                    <option value="广西壮族自治区">广西壮族自治区</option>
                    <option value="海南省">海南省</option>
                    <option value="四川省">四川省</option>
                    <option value="贵州省">贵州省</option>
                    <option value="云南省">云南省</option>
                    <option value="西藏自治区">西藏自治区</option>
                    <option value="陕西省">陕西省</option>
                    <option value="甘肃省">甘肃省</option>
                    <option value="宁夏回族自治区">宁夏回族自治区</option>
                    <option value="青海省">青海省</option>
                    <option value="新疆维吾尔族自治区">新疆维吾尔族自治区</option>
                    <option value="香港特别行政区">香港特别行政区</option>
                    <option value="澳门特别行政区">澳门特别行政区</option>
                    <option value="台湾省">台湾省</option>
                    <option value="其它">其它</option>
                </select>
                <select id="city" name="city" class="info-input">
                    <option>城市</option>
                </select>   
            <input type="text" id="query" name="query" class="search-input" autocomplete="off" placeholder="搜索职业，公司">
            <input class="search-btn" type="submit" value="搜索">
        </form>
        </div>
		 <div class="result_num">
            饭碗为您找到相关结果约${pages.totalCount}个
        </div>
		<div class="job-lists">
			<ul>
			<c:forEach items="${pages.items}" var="job">
				<li>
					<div class="job-item">
						<div class="job-info">
							<div class="job-wrapper">
								<div class="primary-box">
									<div class="job-title">
										<span class="job-name"> <a
											href="<c:url value="/employmentPage/workDetailPage?id=${job.id }"/> ">${job.jobName}</a>
										</span> <span class="job-area"> <span class="job-areaname">${job.city }</span>
										</span>
									</div>
									<div class="job-limit">
										<span class="red">${job.salary}</span>
										<p>
											${job.experience} <span class="vline"></span> ${job.education }
										</p>
										<div class="info-publish">
											<h3 class="name">${job.boss.lastName}
<c:if test="${job.boss.sex eq '男' }">先生</c:if><c:if test="${job.boss.sex eq '女' }">女士</c:if>
</h3>
										</div>
									</div>
								</div>
							</div>
							<div class="job-company">
								<div class="company-text">
									<h3 class="company-name">
										<a href="#">${job.company.companyName }</a>
									</h3>
									<p>
										<a href="#">${job.company.companyType }</a>
									</p>
								</div>
								<a href="#"> <img class="company-logo"
									src="${pageContext.request.contextPath}/static/companyLogo/${job.company.companyLogo}"/>" alt="">
								</a>
							</div>
						</div>
						<div class="info-append">
							<div class="info-left">${job.jobType }</div>
							<div class="info-right">${job.company.treatment }</div>
						</div>
					</div>
				</li>
				</c:forEach>
			</ul>
		</div>
		<mytag:works query="${param.query}" city="${param.city }" pro="${param.pro }" type="${param.type }"  pages="${pages }"/>
	</div>
	   <script src="${pageContext.request.contextPath}/static/js/jquery-3.5.1.min.js"></script> 
        <script src="${pageContext.request.contextPath}/static/js/city.js"></script> 
</body>
</html>