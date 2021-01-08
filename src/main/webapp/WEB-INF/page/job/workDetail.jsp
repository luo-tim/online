<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>工作详情</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/employInfo.css" />">
</head>
<body>
<jsp:include page="../navigationBar.jsp"></jsp:include>
 <div class="employInfo-container">
        <div class="job-banner">
            <div class="inner">
                <div class="job-primary">
                    <div class="info-primary">
                        <div class="job-status">
                        <c:if test="${job.flag eq 0}">
                            <span>招聘中</span>
                            </c:if>
                            <c:if test="${job.flag eq 1}">
                            <span class="redspan">招聘结束</span>
                            </c:if>
                        </div>
                        <div class="job-name">
                            <h1>${job.jobName}</h1>
                            <span class="salary">${job.salary }</span>
                        </div>
                        <p>
                            <a href="#" class="text-city">${job.city }</a>
                            <em class="dolt"></em>
                            ${job.experience }
                            <em class="dolt"></em>
                           ${job.education }
                        </p>
                    </div>
                    <div class="job-op">
                        <div class="communicate-btn">
                        <c:choose>
                      		<c:when test="${not empty sessionScope.worker&& flag eq 1 }">
                             <a href="#" class="job-btn">审核中</a>
                             </c:when>
                             <c:when test="${not empty sessionScope.worker&& flag eq 2 }">
                              <a href="#" class="job-btn">审核通过</a>
                              </c:when>
                              <c:when test="${not empty sessionScope.worker&& flag eq 3 }">
                               <a href="#" class="red">审核失败</a>
                               </c:when>
                               <c:otherwise>
                           <a href="<c:url value="/employmentPage/signupWorkPage?id=${job.id}&f=${job.flag}" />" class="job-btn">立即申请</a>
                           </c:otherwise>
                             </c:choose>
                        </div>
                    </div>
                </div>

            </div>
        </div>
        <div class="job-box">
            <div class="job-box-inner">

                <div class="job-company">
                    <div class="right-company">
                        <p class="company-title">公司基本信息</p>
                        <div class="company-info">
                            <a href="<c:url value="/companyPage/companyDetailPage?companyId=${job.companyId}"/>" class="company-logo">
                                <img src="<c:url value="/resource/${job.companyLogo }"/>" alt="华为">
                            </a>
                            <a href="<c:url value="/companyPage/companyDetailPage?companyId=${job.companyId}" />" class="company-name">
                                ${job.companyName }
                            </a>
                        </div>
                        <p>${job.companyType }</p>
                    </div>
                </div>

                <div class="job-detail">
                    <div class="detail-op">
                        <div class="detail-figure">
                            <img src="<c:url value="/resource/${job.companyLogo }"/>" alt="">
                        </div>
                        <h2 class="detail-personname">${job.lastName}
<c:if test="${job.sex eq '男' }">先生</c:if><c:if test="${job.sex eq '女' }">女士</c:if></h2>
                        <p class="grey">
                            资深HR
                        </p>

                    </div>
                    <div class="detail-content">
                        <div class="job-sec">
                            <h3>职位描述</h3>
                            <div class="line"></div>
                            <div class="job-sec-text">
                               ${job.jobDescription }
                            </div>
                        </div>
                        <div class="job-sec">
                            <h3>工作要求</h3>
                            <div class="line"></div>
                            <div class="job-sec-text">
                                 ${job.jobRequest }
                            </div>
                        </div>
                        <div class="job-sec">
                            <h3>工作地址</h3>
                            <div class="line"></div>
                            <div class="job-sec-text">
                                 ${job.workaddress }
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>