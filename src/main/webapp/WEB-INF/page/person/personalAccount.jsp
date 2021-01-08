<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>账户信息</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/personal.css" >
</head>
<body>
	<jsp:include page="../navigationBar.jsp"></jsp:include>
	<div class="container">
		<div class="person-left">
			<span class="person-title">个人中心</span>
			<ul class="person-items">
				<li
					class="person-item <c:if test="${message eq 'userInfo'}">on</c:if>">
					<a href="<c:url value="/personalPage" />"><span
						class="item-name">账号信息</span></a>
				</li>
			
			<li
					class="person-item <c:if test="${message eq 'basicInfo'}">on</c:if>"><a
					href="<c:url value="/personalPage/infoPage" />"><span
						class="item-name">基本信息</span></a></li>
		
			
		
				<c:if
					test="${not empty sessionScope.user && sessionScope.user.identityId  eq 0  }">
					
					<li
						class="person-item <c:if test="${message eq 'workerHistory'}">on</c:if>"><a
						href="<c:url value="/personalPage/workHistoryInfoPage" />"><span
							class="item-name">浏览记录</span></a></li>
					<li
						class="person-item <c:if test="${message eq 'workerSignup'}">on</c:if>"><a
						href="<c:url value="/personalPage/requestInfoPage?tag=0" />"><span
							class="item-name">申请记录</span></a></li>
				</c:if>
				<!--老板的浏览记录-->
				<c:if
					test="${not empty sessionScope.user && sessionScope.user.identityId eq 1 }">
					
					<li
						class="person-item <c:if test="${message eq 'bossRelease'}">on</c:if>"><a
						href="<c:url value="/personalPage/releaseInfoPage?tag=3" />"><span
							class="item-name">发布记录</span></a></li>
							<li
						class="person-item <c:if test="${message eq 'bossCompany'}">on</c:if>"><a
						href="<c:url value="/personalPage/releaseInfoPage?tag=3" />"><span
							class="item-name">所属公司</span></a></li>
				</c:if>
			</ul>
		</div>
		<c:choose>

			<c:when test="${message eq 'workerHistory'}">
				<!--打工人浏览记录  person-right-active-->
				<div class="person-right ">
					<!--小标题-->
					<div class="person-right-title">
						<span class="person-right-title-name">浏览记录</span>
					</div>
					<div class="person-right-bottom">

						<div class="game-container">
							<ul>
							<c:forEach items="${workerHistory}" var="history">
								<li class="game-list">
									<div class="job-item">
										<div class="job-info">
											<div class="job-wrapper">
												<div class="primary-box">
													<div class="job-title">
														<span class="job-name"> <a href="<c:url value="/employmentPage/workDetailPage?id=${history.id}"/>">${history.jobName }</a>
														</span> <span class="job-area"> <span class="job-areaname">${history.city }</span>
														</span>
													</div>
													<div class="job-limit">
														<span class="red">${history.salary }</span>
														<p>
															 ${history.experience } <span class="vline"></span> ${history.education }
														</p>
														<div class="info-publish">
															<h3 class="name">${history.boss.lastName}
<c:if test="${history.boss.sex eq '男' }">先生</c:if><c:if test="${history.boss.sex eq '女' }">女士</c:if></h3>
														</div>
													</div>
												</div>
											</div>
											<div class="job-company">
												<div class="company-text">
													<h3 class="company-name">
														<a href="<c:url value="/companyPage/companyDetailPage?companyId=${history.company.id}"/>">${history.company.companyName}</a>
													</h3>
													<p>
														<a href="<c:url value="/companyPage/companyDetailPage?companyId=${history.company.id}"/>">${history.company.companyType}</a>
													</p>
												</div>
												<a href="<c:url value="/companyPage/companyDetailPage?companyId=${history.company.id}"/>"> <img class="company-logo"
													src="<c:url value="/resource/${history.company.companyLogo}"/>" alt="">
												</a>
											</div>
										</div>
										<div class="info-append">
											<div class="info-left">${history.jobDescription }</div>
											<div class="info-right">${history.browseJob.browseTime }</div>
										</div>
									</div>
								</li>
							</c:forEach>
							</ul>
						</div>
						
					</div>
				</div>
			</c:when>
			
			<c:when test="${message eq 'workerSignup'}">
				<!--打工人申请记录  person-right-active-->
				<div class="person-right  ">
					<!--小标题-->
					<div class="person-right-title">
						<span class="person-right-title-name">申请记录</span>
					</div>
					<div class="person-right-bottom">
						<!--工作类别-->
						<div class="game-nav">
							<div class="game-item <c:if test="${param.tag eq 0 }"> active</c:if>">
								<a href="<c:url value="/personalPage/requestInfoPage?tag=0" />">全部申请</a>
							</div>
							<div class="game-item <c:if test="${param.tag eq 1 }"> active</c:if>">
								<a href="<c:url value="/personalPage/requestInfoPage?tag=1" />">申请中</a>
							</div>
							<div class="game-item <c:if test="${param.tag eq 2 }"> active</c:if>">
								<a href="<c:url value="/personalPage/requestInfoPage?tag=2" />">申请通过</a>
							</div>
							<div class="game-item <c:if test="${param.tag eq 3 }"> active</c:if>" >
								<a href="<c:url value="/personalPage/requestInfoPage?tag=3" />">申请拒绝</a>
							</div>
						</div>
						<div class="game-container">
							<ul>
							<c:forEach items="${workerSignup}" var="signup">
								<li class="game-list">
									<div class="job-item">
										<div class="job-info">
											<div class="job-wrapper">
												<div class="primary-box">
													<div class="job-title">
														<span class="job-name"> <a href="<c:url value="/employmentPage/workDetailPage?id=${signup.id}"/>">${signup.jobName}</a>
														</span> <span class="job-area"> <span class="job-areaname">${signup.city}</span>
														</span>
													</div>
													<div class="job-limit">
														<span class="red">${signup.salary}</span>
														<p>
															${signup.experience} <span class="vline"></span> ${signup.education}
														</p>
														<div class="info-publish">
															<h3 class="name">${signup.boss.lastName}
<c:if test="${signup.boss.sex eq '男' }">先生</c:if><c:if test="${signup.boss.sex eq '女' }">女士</c:if></h3>
														</div>
													</div>
												</div>
											</div>
											<div class="job-company">
												<div class="company-text">
													<h3 class="company-name">
														<a href="<c:url value="/companyPage/companyDetailPage?companyId=${signup.company.id}"/>">${signup.company.companyName }</a>
													</h3>
													<p>
														<a href="<c:url value="/companyPage/companyDetailPage?companyId=${signup.company.id}"/>">${signup.company.companyType}</a>
													</p>
												</div>
												<a href="<c:url value="/companyPage/companyDetailPage?companyId=${signup.company.id}"/>"> <img class="company-logo"
													src="<c:url value="/resource/${signup.company.companyLogo}"/>" alt="">
												</a>
											</div>
										</div>
										<div class="info-append">
											<div class="info-left">
												<c:if test="${signup.signUpJob.flag eq 1}"><span class="info-left-blue">申请中</span></c:if>
												<c:if test="${signup.signUpJob.flag eq 2}"><span class="info-left-green">申请通过</span></c:if>
												<c:if test="${signup.signUpJob.flag eq 3}"><span class="info-left-red">申请失败</span></c:if>
											</div>
											<div class="info-right">${signup.jobDescription}</div>
										</div>
									</div>
								</li>
								</c:forEach>
							</ul>
						</div>
			
					</div>
				</div>
			</c:when>
			<c:when test="${message eq 'bossRelease'}">
				<!--老板发布记录-->
				<div class="person-right">
					<!--小标题-->
					<div class="person-right-title">
						<span class="person-right-title-name">发布记录</span>
					</div>
					<div class="person-right-bottom">
						<!--比赛类别-->
						<div class="game-nav">
							<div class="game-item <c:if test="${param.tag eq 3 }"> active</c:if>">
								<a href="<c:url value="/personalPage/releaseInfoPage?tag=3" />">全部招聘</a>
							</div>
							<div class="game-item <c:if test="${param.tag eq 0 }"> active</c:if>">
								<a href="<c:url value="/personalPage/releaseInfoPage?tag=0" />">正在进行</a>
							</div>
							<div class="game-item <c:if test="${param.tag eq 1 }"> active</c:if>">
								<a href="<c:url value="/personalPage/releaseInfoPage?tag=1" />">已经结束</a>
							</div>
								<div class="game-item <c:if test="${param.tag eq 5 }"> active</c:if>">
								<a href="<c:url value="/personalPage/releaseInfoPage?tag=5" />">审核中</a>
							</div>
						</div>
						<div class="game-container">
							<ul>
								<c:forEach items="${bossRelease}" var="release">
								<li class="game-list">
									<div class="job-item">
										<div class="job-info">
											<div class="job-wrapper">
												<div class="primary-box">
													<div class="job-title">
														<span class="job-name"> <a href="<c:url value="/releaseRecruitmentPage/bossWorkDetailPage?id=${release.id}"/>">${release.jobName }</a>
														</span> <span class="job-area"> <span class="job-areaname">${release.city }</span>
														</span>
													</div>
													<div class="job-limit">
														<span class="red">${release.salary }</span>
														<p>
															${release.experience } <span class="vline"></span> ${release.education }
														</p>

													</div>
												</div>
											</div>
											<div class="job-company">
												<div class="company-text">
													<h3 class="company-name">
														<a href="<c:url value="/companyPage/companyDetailPage?companyId=${release.company.id}"/>">${release.company.companyName }</a>
													</h3>
													<p>
														<a href="<c:url value="/companyPage/companyDetailPage?companyId=${release.company.id}"/>">${release.company.companyType }</a>
													</p>
												</div>
												<a href="<c:url value="/companyPage/companyDetailPage?companyId=${release.company.id}"/>"> <img class="company-logo"
													src="<c:url value="/resource/${release.company.companyLogo}"/>" alt="">
												</a>
											</div>
										</div>
										<div class="info-append">
											<div class="info-left">
											<c:if test="${release.flag eq  5 }"><span class="info-left-green">审核中</span></c:if>
												<c:if test="${release.flag eq 0 }"><span class="info-left-green">进行中</span></c:if>
												<c:if test="${release.flag eq 1 }"><span class="info-left-red">已结束</span></c:if>
											</div>
											<div class="info-right">${release.jobDescription }</div>
										</div>
									</div>
								</li>
								</c:forEach>
							</ul>
						</div>
			
					</div>
				</div>
			</c:when>
			<c:when test="${message eq 'basicInfo'}">
				<!--个人基本信息-->
				<div class="person-right">
					<!--小标题-->
					<div class="person-right-title">
						<span class="person-right-title-name">个人信息</span>
					</div>
					
					
						<div class="sponsor-info">
							<form method="POST"class="sponsor-form" name="workerForm">
								<div class="info-box">
									<span class="info-text">姓: </span> <input name="lastName" type="text"
										autocomplete="off" placeholder="你的姓" maxlength="20"
										class="info-input" value="${sessionScope.user.lastName}">
								</div>
								<div class="info-box">
									<span class="info-text">名: </span> <input name="firstName" type="text"
										autocomplete="off" placeholder="你的名" maxlength="20"
										class="info-input" value="${sessionScope.user.firstName}">
								</div>
								<div class="info-box">
									<span class="info-text">出生日期: </span> <input   name="birth" type="date"
										autocomplete="off" placeholder="你的出生日期" maxlength="20"
										class="info-input" value="${sessionScope.user.dateOfBirth}">
								</div>
								<div class="info-box">
									<span class="info-text">身份证号: </span> <input name="IDNumber" type="text"
										autocomplete="off" placeholder="你的身份证号" maxlength="20"
										class="info-input" value="${sessionScope.user.IDNumber}">
								</div>
								<div class="info-box">
									<span class="info-text">手机号: </span> <input name="phone" type="text"
										autocomplete="off" placeholder="你的手机号" maxlength="20"
										class="info-input" value="${sessionScope.user.phoneNumber}">
								</div>
							
								<div class="info-box">
									<span class="info-text">邮箱: </span> <input name="email" type="text"
										autocomplete="off" placeholder="你的邮箱" maxlength="20"
										class="info-input" value="${sessionScope.user.email}">
								</div>
								<div class="info-box">
									<span class="info-text">性别: </span>
									<div class="sex">
										<label class="radio"> <input type="radio"
											class="radio-btn" name="sex" value="男" <c:if test="${sessionScope.user.sex eq '男' }">checked</c:if> > <span
											class="radio-text">男</span>
										</label> <label class="radio"> <input class="radio-btn"
											type="radio" name="sex" value="女" <c:if test="${sessionScope.user.sex eq '女' }">checked</c:if> > <span
											class="radio-text">女</span>
										</label>
									</div>
								</div>
								<div class="info-box">
									<div class="info-line"></div>
									<div class="info-btn-box">
										<input type="submit" class="info-btn" value="保    存"  onclick="return postWorker();">
									</div>

								</div>
							
							</form>
						</div>
				
				</div>

			</c:when>
			<%-- 所属公司 --%>
			<c:when test="${message eq 'bossComapny'}">
			<p>公司</p>
			</c:when>
			<c:otherwise>
				<!--账户信息-->
				<div class="person-right">
					<!--小标题-->
					<div class="person-right-title">
						<span class="person-right-title-name">账户信息</span>
					</div>
					<div class="student-info">
						<form method="POST" class="student-form" name="userForm">
							<div class="info-box">
								<span class="info-text">昵称: </span> <input name="userName" type="text"
									autocomplete="off" placeholder="你的昵称" maxlength="20"
									class="info-input" value="${sessionScope.user.userName }">
							</div>
							<div class="info-box">
								<span class="info-text">账号: </span> 
								<span class="info-value">${sessionScope.user.account }</span>
								
							</div>
							<div class="info-box">
								<span class="info-text">身份: </span> <span class="info-value"><c:choose><c:when test="${sessionScope.user.identityId eq 0}">工人</c:when><c:when test="${sessionScope.user.identityId eq 1}">HR</c:when><c:when test="${sessionScope.user.identityId eq 2}">管理员</c:when><c:when test="${sessionScope.user.identityId eq 3}">超级管理员</c:when></c:choose></span>
							</div>
							<div class="info-box">
								<span class="info-text">信誉度: </span> <span class="info-value">${sessionScope.user.credit }</span>
							</div>
							<div class="info-box">
								<div class="info-line"></div>
								<div class="info-btn-box">
									<input type="submit" class="info-btn" value="保    存" onclick="return postUser();">
								</div>

							</div>
						</form>
					</div>
				</div>
			</c:otherwise>
		</c:choose>
	</div>
	 <script src="${pageContext.request.contextPath}/static/js/basicInfo.js"></script>
</body>
</html>