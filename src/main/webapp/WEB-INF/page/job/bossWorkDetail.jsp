<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>发布工作详情</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/employInfo.css" >
</head>
<body>
<jsp:include page="../navigationBar.jsp"></jsp:include>
 <div class="employInfo-container">
        <div class="job-banner">
            <div class="inner">
                <div class="job-primary">
                    <div class="info-primary">
                        <div class="job-status">
                        <c:if test="${job.flag eq 1}">
                            <span>招聘中</span>
                            </c:if>
                            <c:if test="${job.flag eq 2}">
                            <span class="redspan">招聘结束</span>
                            </c:if>
                            <c:if test="${job.flag eq 0}">
                            <span class="redspan">审核中</span>
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
                      		<c:when test="${not empty sessionScope.user &&  sessionScope.user.identityId eq 1 }">
                             <c:if  test="${job.flag eq 0 }"><a href="#" class="job-btn">审核中</a></c:if>
                             <c:if test="${ job.flag eq 1}"> <a href="<c:url value="/releaseRecruitmentPage/finishRecruitmentPage?workId=${job.id}" />" class="red">结束招聘</a></c:if>
                             <c:if test="${job.flag eq 2 }">   <a href="#" class="a-grey">招聘结束</a></c:if>
                             </c:when>
                             <c:when test="${not empty sessionScope.user &&  sessionScope.user.identityId ge 2   }">
                             <c:if  test="${job.flag eq 0 }"><a href="<c:url value="/managerPage/checkRecruitmentPage/successRecruitmentPage?workId=${job.id}" />" class="half-green">通过</a><a href="<c:url value="/managerPage/checkRecruitmentPage/failRecruitmentPage?workId=${job.id}" />" class="half-red">拒绝</a></c:if>
                             <c:if test="${ job.flag eq 1}"> <a href="<c:url value="/managerPage/checkRecruitmentPage/deleteRecruitmentPage?workId=${job.id}&tag=${ job.flag}" />" class="red">删除</a></c:if>
                             <c:if test="${job.flag eq 2 }">   <a href="<c:url value="/managerPage/checkRecruitmentPage/deleteRecruitmentPage?workId=${job.id}&tag=${ job.flag}" />" class="red">删除</a></c:if>
                              </c:when>
                              
                             
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
                            <a href="<c:url value="/companyPage/companyDetailPage?id=${job.company.id}" />" class="company-logo">
                                <img src="${pageContext.request.contextPath}/static/companyLogo/${job.company.companyLogo }" alt="华为">
                            </a>
                            <a href="<c:url value="/companyPage/companyDetailPage?id=${job.company.id}" />" class="company-name">
                                ${job.company.companyName }
                            </a>
                        </div>
                        <p>${job.company.companyType }</p>
                    </div>
                </div>

                <div class="job-detail">
                    <div class="detail-op">
                        <div class="detail-figure">
                            <img src="${pageContext.request.contextPath}/static/companyLogo/${job.company.companyLogo }" alt="">
                        </div>
                        <h2 class="detail-personname">${job.boss.lastName}
<c:if test="${job.boss.sex eq '男' }">先生</c:if><c:if test="${job.boss.sex eq '女' }">女士</c:if></h2>
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
                                 ${job.workAddress }
                            </div>
                        </div>
                        <c:if test="${not empty sessionScope.user &&  sessionScope.user.identityId eq 1 }">
                          <div class="job-sec">
                            <h3>申请列表</h3>
                            <div class="line"></div>
                            <div class="game-container">
                                <ul>
                                <c:forEach items="${workers }" var="worker">
                                    <li class="game-list-person">
                                        <div class="job-item-person">
                                            <div class="job-info-person">
                                                <div class="job-wrapper-person">
                                                    <div class="primary-box-person">
                                                        <div class="job-title-person">
                                                            <span class="job-name-person">
                                                                <a href="<c:url value="/personalPage/workerAccountPage?userId=${worker.id}" />">${worker.userName }</a>
                                                            </span>
                                                            <span class="job-area-person">
                                                                <span class="job-name-person">
                                                                <a href="<c:url value="/personalPage/userbasicInfoPage?workerId=${worker.id}" />">${worker.lastName }${worker.firstName }</a></span>
                                                            </span>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="job-company-person">
                                                    <h3 class="resume">
                                                        <a href="<c:url value="/myResumePage?workerId=${worker.id}" />">简历</a>
                                                    </h3>
                                                </div>
                                            </div>
                                            <div class="info-append">
                                                <div class="info-left">${worker.signUpJob.signUpTime }</div>
                                                <c:if test="${worker.signUpJob.flag eq 0 }">
                                                  <div class="info-right"><a href="<c:url value="/releaseRecruitmentPage/passSignupPage?workerId=${worker.id}&employId=${param.id }" />" class="a-green">通过</a> <a href="<c:url value="/releaseRecruitmentPage/refuseSignupPage?workerId=${worker.id}&employId=${param.id }" />" class="a-red">拒绝</a></div>
                                                </c:if>
                                              
                                                 <c:if test="${worker.signUpJob.flag eq 1 }">
                                                  <div class="info-right"> <a href="#" class="a-green">审核通过 </a> </div>
                                                 </c:if>
                                                  <c:if test="${worker.signUpJob.flag eq 2 }">
                                                  <div class="info-right"> <a href="#" class="a-red">审核不通过 </a> </div>
                                                 </c:if>
                                            </div>
                                        </div>
                                    </li>
                                    </c:forEach>
                                </ul>
                            </div>
                        </div>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>