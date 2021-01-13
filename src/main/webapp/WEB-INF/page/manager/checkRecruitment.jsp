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
<title>审查工作</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/pagebtn.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/checkJob.css" >
</head>
<body>
<jsp:include page="../navigationBar.jsp"></jsp:include>
 <div class="userList-container">
     
        <div class="item">
            <div class="sex">
                <label class="radio">
                    <input type="radio" checked class="radio-btn" name="identity" <c:if test="${param.tag eq 'all' }">checked</c:if> value="全部">
                    <a href="<c:url value="/managerPage/checkRecruitmentPage?tag=all" />" class="radio-text">全部</a>
                </label>
                <label class="radio">
                    <input class="radio-btn"  type="radio" name="identity" <c:if test="${param.tag eq '1' }">checked</c:if> value="招聘中">
                    <a href="<c:url value="/managerPage/checkRecruitmentPage?tag=1" />" class="radio-text">招聘中</a>
                </label>
                
                <label class="radio">
                    <input class="radio-btn" type="radio" name="identity" <c:if test="${param.tag eq '0' }">checked</c:if> value="审核中">
                    
                    <a href="<c:url value="/managerPage/checkRecruitmentPage?tag=0" />" class="radio-text">审核中</a>
                </label>
                 <label class="radio">
                    <input class="radio-btn"  type="radio" name="identity" <c:if test="${param.tag eq '2' }">checked</c:if> value="招聘结束">
                    <a href="<c:url value="/managerPage/checkRecruitmentPage?tag=2" />" class="radio-text">招聘结束</a>
                </label>
            </div>
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
											href="<c:url value="/managerPage/checkRecruitmentPage/recruitmentDetailPage?id=${job.id }"/> ">${job.jobName}</a>
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
									src="${pageContext.request.contextPath}/static/companyLogo/${job.company.companyLogo}" alt="">
								</a>
							</div>
						</div>
						<div class="info-append">
							<div class="info-left">
			<c:if test="${job.flag eq  0 }"><span class="info-left-green">审核中</span></c:if>
												<c:if test="${job.flag eq 1 }"><span class="info-left-green">进行中</span></c:if>
												<c:if test="${job.flag eq 2 }"><span class="info-left-red">已结束</span></c:if>
</div>
							<div class="info-right">${job.jobType }</div>
						</div>
					</div>
				</li>
				</c:forEach>
			</ul>
		</div>
		<mytag:jobs  tag="${param.tag }" pages="${pages}"/>
    </div>
</body>
</html>