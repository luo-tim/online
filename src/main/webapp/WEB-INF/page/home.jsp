<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>首页</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/home.css" />
</head>
<body>
	<jsp:include page="navigationBar.jsp"></jsp:include>
	<div class="index-container">
		<div class="search-box">
			<div class="search">
				 <form method="POST">
                <input type="text" name="query" class="search-input" autocomplete="off" placeholder="搜索职业，公司">
                <input class="search-btn" type="submit" value="搜索">
            </form>
			</div>
			<div class="search-hot">
				<b>热门职位:</b> <a href="<c:url value="/employmentPage?pro=省份&city=城市&type=工作类型&query=" />">Java</a> <a href="<c:url value="/employmentPage?pro=省份&city=城市&type=工作类型&query=" />">产品经理</a> <a href="<c:url value="/employmentPage?pro=省份&city=城市&type=工作类型&query=" />">web前端</a>
				<a href="<c:url value="/employmentPage?pro=省份&city=城市&type=工作类型&query=" />">项目经理</a> <a href="<c:url value="/employmentPage?pro=省份&city=城市&type=工作类型&query=" />">测试工程师</a> <a href="<c:url value="/employmentPage?pro=省份&city=城市&type=工作类型&query=" />">运维工程师</a> <a
					href="<c:url value="/employmentPage?pro=省份&city=城市&type=工作类型&query=" />">C++</a> <a href="<c:url value="/employmentPage?pro=省份&city=城市&type=工作类型&query=" />">数据分析师</a> <a href="<c:url value="/employmentPage?pro=省份&city=城市&type=工作类型&query=" />">平面设计</a>
			</div>
		</div>
		<div class="main">
			<!--左侧职位选择-->
			<div class="home-left">
				<div class="job-menu">
					<dl class="dl">
						<dd>
							<b>技术</b> <a href="<c:url value="/employmentPage?type=技术&pro=省份&city=城市&query=" />">Java</a> <a href="#">PHP</a> <a href="<c:url value="/employmentPage?type=技术&pro=省份&city=城市&query=" />">web前端</a>
							<a href="<c:url value="/employmentPage?type=技术&pro=省份&city=城市&query=" />">算法工程师</a>
						</dd>
					</dl>
					<dl class="dl">
						<dd>
							<b>产品</b> <a href="<c:url value="/employmentPage?type=产品&pro=省份&city=城市&query=" />">产品经理</a> <a href="<c:url value="/employmentPage?type=产品&pro=省份&city=城市&query=" />">产品总监</a> <a href="<c:url value="/employmentPage?type=产品&pro=省份&city=城市&query=" />">数据产品经理</a>

						</dd>
					</dl>
					<dl class="dl">
						<dd>
							<b>设计</b> <a href="<c:url value="/employmentPage?type=设计&pro=省份&city=城市&query=" />">UI设计师</a> <a href="<c:url value="/employmentPage?type=设计&pro=省份&city=城市&query=" />">平面设计师</a> <a href="<c:url value="/employmentPage?type=设计&pro=省份&city=城市&query=" />">交互设计师</a>
						</dd>
					</dl>
					<dl class="dl">
						<dd>
							<b>运营</b> <a href="<c:url value="/employmentPage?type=运营&pro=省份&city=城市&query=" />">新媒体运营</a> <a href="<c:url value="/employmentPage?type=运营&pro=省份&city=城市&query=" />">产品运营</a> <a href="<c:url value="/employmentPage?type=运营&pro=省份&city=城市&query=" />">网络推广</a>

						</dd>
					</dl>
					<dl class="dl">
						<dd>
							<b>市场</b> <a href="<c:url value="/employmentPage?type=市场&pro=省份&city=城市&query=" />">市场营销</a> <a href="<c:url value="/employmentPage?type=市场&pro=省份&city=城市&query=" />">市场推广</a> <a href="<c:url value="/employmentPage?type=市场&pro=省份&city=城市&query=" />">品牌公关</a>
							<a href="<c:url value="/employmentPage?type=市场&pro=省份&city=城市&query=" />">策划经理</a>
						</dd>
					</dl>
					<dl class="dl">
						<dd>
							<b>高级管理</b> <a href="<c:url value="/employmentPage?type=高级管理&pro=省份&city=城市&query=" />">总裁/总经理/CEO</a> <a href="<c:url value="/employmentPage?type=高级管理&pro=省份&city=城市&query=" />">分公司/代表处负责人</a>

						</dd>
					</dl>
					<dl class="dl">
						<dd>
							<b>人事/财务/行政</b> <a href="<c:url value="/employmentPage?type=人事&pro=省份&city=城市&query=" />">人力资源专员/助理</a> <a href="<c:url value="/employmentPage?type=人事&pro=省份&city=城市&query=" />">行政主管</a>

						</dd>
					</dl>
					<div class="show-all" style="display: block;">显示全部职位</div>
				</div>
			</div>
			<div class="home-right">
				<div class="slide-box">
					<table>
						<tbody>
							<tr class="first-row">
								<td valign="top" rowspan="2" colspan="2"
									style="word-break: break-all;"><a href="<c:url value="/employmentPage?pro=省份&city=城市&type=工作类型&query=" />" target="_blank">
										<img src="${pageContext.request.contextPath}/static/image/1.jpg" alt="">
								</a></td>
								<td width="307" valign="top" rowspan="2" colspan="1"
									style="word-break: break-all;"><a href="<c:url value="/employmentPage?pro=省份&city=城市&type=工作类型&query=" />" target="_blank">
										<img src="${pageContext.request.contextPath}/static/image/2.jpg" alt="">
								</a></td>
							</tr>
							<tr></tr>
							<tr>
								<td valign="top" rowspan="1" colspan="2"
									style="word-break: break-all;"><a href="<c:url value="/employmentPage?pro=省份&city=城市&type=工作类型&query=" />" target="_blank">
										<img src="${pageContext.request.contextPath}/static/image/3.jpg"  alt="">
								</a></td>
								<td width="307" valign="top" style="word-break: break-all;">
									<a href="<c:url value="/employmentPage?pro=省份&city=城市&type=工作类型&query=" />" target="_blank"> <img src="${pageContext.request.contextPath}/static/image/4.jpg" alt="">
								</a>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div class="hot-job">
				<div class="box-title">热招职位</div>
				<ul class="cur">
					<li class="cur-job">
						<div class="sub-li">
							<a href="#" class="job-info">
								<div class="sub-li-top">
									<p class="hotjob-name">通用软件开发工程师</p>
									<p class="hotjob-salary">15-30K·15薪</p>
								</div>
								<p class="hotjob-text">
									西安 <span class="vline"></span> 3-5年 <span class="vline"></span>
									本科
								</p>
							</a>
							<div class="sub-li-bottom">
								<a href="#" class="hotjob-company">
									<p>
										<img src="${pageContext.request.contextPath}/static/companyLogo/华为.jpg" alt="">
									</p>
								</a> <a href="#" class="hotjob-company-info"> <span
									class="hotjob-name">华为</span> <span class="company-type">计算机软件</span>
								</a>
							</div>
						</div>
					</li>
					<li class="cur-job">
						<div class="sub-li">
							<a href="#" class="job-info">
								<div class="sub-li-top">
									<p class="hotjob-name">高级Java开发工程师</p>
									<p class="hotjob-salary">15-25K·14薪</p>
								</div>
								<p class="hotjob-text">
									西安 <span class="vline"></span> 3-5年 <span class="vline"></span>
									本科
								</p>
							</a>
							<div class="sub-li-bottom">
								<a href="#" class="hotjob-company">
									<p>
										<img src="${pageContext.request.contextPath}/static/companyLogo/奇安信集团.jpg" alt="">
									</p>
								</a> <a href="#" class="hotjob-company-info"> <span
									class="hotjob-name">奇安信集团</span> <span class="company-type">信息安全</span>
								</a>
							</div>
						</div>
					</li>
					<li class="cur-job">
						<div class="sub-li">
							<a href="#" class="job-info">
								<div class="sub-li-top">
									<p class="hotjob-name">急招C++/Java/Python</p>
									<p class="hotjob-salary">13-26K·15薪</p>
								</div>
								<p class="hotjob-text">
									西安 <span class="vline"></span> 经验不限 <span class="vline"></span>
									本科
								</p>
							</a>
							<div class="sub-li-bottom">
								<a href="#" class="hotjob-company">
									<p>
										<img src="${pageContext.request.contextPath}/static/companyLogo/华为.jpg" alt="">
									</p>
								</a> <a href="#" class="hotjob-company-info"> <span
									class="hotjob-name">华为</span> <span class="company-type">计算机软件</span>
								</a>
							</div>
						</div>
					</li>
					<li class="cur-job">
						<div class="sub-li">
							<a href="#" class="job-info">
								<div class="sub-li-top">
									<p class="hotjob-name">智慧城市方案售前经理</p>
									<p class="hotjob-salary">12-24K·14薪</p>
								</div>
								<p class="hotjob-text">
									西安 <span class="vline"></span> 1-3年 <span class="vline"></span>
									本科
								</p>
							</a>
							<div class="sub-li-bottom">
								<a href="#" class="hotjob-company">
									<p>
										<img src="${pageContext.request.contextPath}/static/companyLogo/新华三技术有限公司.jpg" alt="">
									</p>
								</a> <a href="#" class="hotjob-company-info"> <span
									class="hotjob-name">新华三技术有限公司</span> <span class="company-type">计算机软件</span>
								</a>
							</div>
						</div>
					</li>
					<li class="cur-job">
						<div class="sub-li">
							<a href="#" class="job-info">
								<div class="sub-li-top">
									<p class="hotjob-name">IOS平台高级开发管理岗</p>
									<p class="hotjob-salary">20-35K·16薪</p>
								</div>
								<p class="hotjob-text">
									西安 <span class="vline"></span> 3-5年 <span class="vline"></span>
									硕士
								</p>
							</a>
							<div class="sub-li-bottom">
								<a href="#" class="hotjob-company">
									<p>
										<img src="${pageContext.request.contextPath}/static/companyLogo/中信建投证券.jpg" alt="">
									</p>
								</a> <a href="#" class="hotjob-company-info"> <span
									class="hotjob-name">中信建投证券</span> <span class="company-type">互联网金融</span>
								</a>
							</div>
						</div>
					</li>
					<li class="cur-job">
						<div class="sub-li">
							<a href="#" class="job-info">
								<div class="sub-li-top">
									<p class="hotjob-name">后台开发工程师（腾讯云全资子公司）</p>
									<p class="hotjob-salary">15-30K·16薪</p>
								</div>
								<p class="hotjob-text">
									西安 <span class="vline"></span> 1-3年 <span class="vline"></span>
									本科
								</p>
							</a>
							<div class="sub-li-bottom">
								<a href="#" class="hotjob-company">
									<p>
										<img src="${pageContext.request.contextPath}/static/companyLogo/腾讯.jpg" alt="">
									</p>
								</a> <a href="#" class="hotjob-company-info"> <span
									class="hotjob-name">腾讯</span> <span class="company-type">互联网</span>
								</a>
							</div>
						</div>
					</li>
					<li class="cur-job">
						<div class="sub-li">
							<a href="#" class="job-info">
								<div class="sub-li-top">
									<p class="hotjob-name">Python</p>
									<p class="hotjob-salary">15-30K·16薪</p>
								</div>
								<p class="hotjob-text">
									西安 <span class="vline"></span> 1-3年 <span class="vline"></span>
									本科
								</p>
							</a>
							<div class="sub-li-bottom">
								<a href="#" class="hotjob-company">
									<p>
										<img src="${pageContext.request.contextPath}/static/companyLogo/腾讯.jpg" alt="">
									</p>
								</a> <a href="#" class="hotjob-company-info"> <span
									class="hotjob-name">腾讯</span> <span class="company-type">互联网</span>
								</a>
							</div>
						</div>
					</li>
					<li class="cur-job">
						<div class="sub-li">
							<a href="#" class="job-info">
								<div class="sub-li-top">
									<p class="hotjob-name">C/C++研发工程师</p>
									<p class="hotjob-salary">18-30K</p>
								</div>
								<p class="hotjob-text">
									西安 <span class="vline"></span> 经验不限 <span class="vline"></span>
									本科
								</p>
							</a>
							<div class="sub-li-bottom">
								<a href="#" class="hotjob-company">
									<p>
										<img src="${pageContext.request.contextPath}/static/companyLogo/华为.jpg" alt="">
									</p>
								</a> <a href="#" class="hotjob-company-info"> <span
									class="hotjob-name">华为</span> <span class="company-type">计算机软件</span>
								</a>
							</div>
						</div>
					</li>
					<li class="cur-job">
						<div class="sub-li">
							<a href="#" class="job-info">
								<div class="sub-li-top">
									<p class="hotjob-name">Java开发工程师</p>
									<p class="hotjob-salary">15-30K</p>
								</div>
								<p class="hotjob-text">
									西安 <span class="vline"></span> 1-3年 <span class="vline"></span>
									本科
								</p>
							</a>
							<div class="sub-li-bottom">
								<a href="#" class="hotjob-company">
									<p>
										<img src="${pageContext.request.contextPath}/static/companyLogo/华为.jpg" alt="">
									</p>
								</a> <a href="#" class="hotjob-company-info"> <span
									class="hotjob-name">华为</span> <span class="company-type">计算机软件</span>
								</a>
							</div>
						</div>
					</li>


				</ul>
				<p class="common-tab-more">
					<a href="#" class="btn-outline">查看更多</a>
				</p>
			</div>
			<div class="hot-job">
				<div class="box-title">热门企业</div>
				<ul class="cur">
					<li class="cur-company">
						<div class="sub-li-company">
							<a href="#" class="company-info">
								<div class="img-box">
									<img src="${pageContext.request.contextPath}/static/companyLogo/腾讯.jpg" alt="腾讯">
								</div>
								<div class="company-text">
									<h4>腾讯</h4>
									<p>互联网</p>
								</div>
							</a> <a href="#" class="about-info">
								<p>
									<span class="text-blue">1</span> 个热招职位
								</p>
							</a>
						</div>
					</li>
					<li class="cur-company">
						<div class="sub-li-company">
							<a href="#" class="company-info">
								<div class="img-box">
									<img src="${pageContext.request.contextPath}/static/companyLogo/蚂蚁金服.jpg" alt="蚂蚁金服">
								</div>
								<div class="company-text">
									<h4>蚂蚁金服</h4>
									<p>互联网</p>
								</div>
							</a> <a href="#" class="about-info">
								<p>
									<span class="text-blue">1</span> 个热招职位
								</p>
							</a>
						</div>
					</li>
					<li class="cur-company">
						<div class="sub-li-company">
							<a href="#" class="company-info">
								<div class="img-box">
									<img src="${pageContext.request.contextPath}/static/companyLogo/华为.jpg" alt="华为">
								</div>
								<div class="company-text">
									<h4>华为</h4>
									<p>计算机软件</p>
								</div>
							</a> <a href="#" class="about-info">
								<p>
									<span class="text-blue">1</span> 个热招职位
								</p>
							</a>
						</div>
					</li>
					<li class="cur-company">
						<div class="sub-li-company">
							<a href="#" class="company-info">
								<div class="img-box">
									<img src="${pageContext.request.contextPath}/static/companyLogo/奇安信集团.jpg" alt="奇安信集团">
								</div>
								<div class="company-text">
									<h4>奇安信集团</h4>
									<p>信息安全</p>
								</div>
							</a> <a href="#" class="about-info">
								<p>
									<span class="text-blue">1</span> 个热招职位
								</p>
							</a>
						</div>
					</li>
					<li class="cur-company">
						<div class="sub-li-company">
							<a href="#" class="company-info">
								<div class="img-box">
									<img src="${pageContext.request.contextPath}/static/companyLogo/新华三技术有限公司.jpg" alt="新华三技术有限公司">
								</div>
								<div class="company-text">
									<h4>新华三技术有限公司</h4>
									<p>计算机软件</p>
								</div>
							</a> <a href="#" class="about-info">
								<p>
									<span class="text-blue">1</span> 个热招职位
								</p>
							</a>
						</div>
					</li>
					<li class="cur-company">
						<div class="sub-li-company">
							<a href="#" class="company-info">
								<div class="img-box">
									<img src="${pageContext.request.contextPath}/static/companyLogo/中信建投证券.jpg" alt="中信建投证券">
								</div>
								<div class="company-text">
									<h4>中信建投证券</h4>
									<p>互联网金融</p>
								</div>
							</a> <a href="#" class="about-info">
								<p>
									<span class="text-blue">1</span> 个热招职位
								</p>
							</a>
						</div>
					</li>
				</ul>
				<p class="common-tab-more">
					<a href="#" class="btn-outline">查看更多</a>
				</p>
			</div>

		</div>
		<div class="footer">
			<center>联系我们</center>
		</div>
	</div>
</body>
</html>