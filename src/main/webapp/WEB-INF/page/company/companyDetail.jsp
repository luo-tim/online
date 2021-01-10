<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>公司详情</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/companyDetail.css">
</head>
<body>
<jsp:include page="../navigationBar.jsp"></jsp:include>
    <div class="companyDetail-container">
        <div class="company-banner">
            <div class="company-inner">
                <div>
                    <div class="company-stat">
                      <c:if test="${company.flag eq 0}">
                       <span class="span-green"> 
                            <a href="<c:url value="/managerPage/checkCompanyPage/successCompanyPage?companyId=${company.id }"/>" >
                  通过
                            </a>
                        </span>
                      <span class="span-red">
                            <a href="<c:url value="/managerPage/checkCompanyPage/failCompanyPage?companyId=${company.id }"/> ">
                               不通过
                            </a>
                        </span>
					</c:if>
                    <c:if test="${company.flag eq 1}">
                        <span>
                            <a href="#">
                                <b>company.jobNum</b>
                                在招职位
                            </a>
                        </span>
                        <span class="span">
                            <a href="#">
                                <b>company.bossNum</b>
                                位boss
                            </a>
                        </span>
					</c:if>
                    </div>
                    <div class="info-primary">
                        <img src="<c:url value="/resource/${company.companyLogo }"/>" alt="">
                        <div class="info">
                            <h1 class="name">${company.companyName }</h1>
                            <p>${company.companyType }</p>
                        </div>
                    </div>
                </div>
                <div class="company-tab">
                    <a href="<c:url value="/managerPage/checkCompanyPage/companyDetailPage?companyId=${company.id }"/>" <c:if test="${index eq 0 }"> class="cur"</c:if> >公司简介</a>
                    <a href="<c:url value="/managerPage/checkCompanyPage/jobsDetailPage?companyId=${company.id }"/>" <c:if test="${index eq 1 }"> class="cur"</c:if> >招聘职位</a>
                </div>
            </div>
        </div>
        <c:if test="${index eq 0 }">
        <div class="job-box">
            <div class="job-box-inner">
                <div class="job-detail">
                    <div class="detail-content">
                        <div class="job-sec">
                            <h3>高管介绍</h3>
                            <div class="line"></div>
                            <div class="job-sec-text">
${company. leaderIntroduce}
                            </div>
                        </div>
                        <div class="job-sec">
                            <h3>公司介绍</h3>
                            <div class="line"></div>
                            <div class="job-sec-text">
${company. companyDescription}
                            </div>
                        </div>
                        <div class="job-sec">
                            <h3>工作地址</h3>
                            <div class="line"></div>
                            <div class="job-sec-text">
${company.address}
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        </c:if>
        <c:if test="${index eq 1 }">
        <div class="work-box">
            <div class="work-list">
                <ul>
                <c:forEach items="${jobs}" var="job">
                    <li>
                        <a href="#">

                            <div class="work-primary">
                                <div class="work-info">
                                    <h3 class="work-name">
                                        <div class="work-title-box">
                                            <span class="work-title">
                                                ${job.jobName }
                                            </span>
                                            <span class="work-area">
                                                [${job.city }]
                                            </span>
                                        </div>
                                    </h3>
                                    <p><span class="red">${job.salary }</span>${job.education }</p>
                                </div>
                                <div class="work-publish">
                                    <h3 class="bossname">
                                        <img src="<c:url value="/resource/勾.png"/>" alt="">
                                        ${job.boss.lastName}
<c:if test="${job.boss.sex eq '男' }">先生</c:if><c:if test="${job.boss.sex eq '女' }">女士</c:if>
                                        <em class="vline"></em>
                                        高级HR
                                    </h3>
                                </div>
                            </div>
                        </a>
                    </li>
        </c:forEach>
                </ul>
            </div>
        </div>
    </c:if>
    </div>
</body>
</html>