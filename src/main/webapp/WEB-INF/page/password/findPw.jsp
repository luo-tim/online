<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>找回密码</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/findpassword.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/title.css">
</head>
<body>
<jsp:include page="../navigationBar.jsp"></jsp:include>
<div class="title">
		<div class="step <c:if test="${index gt 1 }"> passed </c:if> <c:if test="${index eq 1 }"> currentstep</c:if>">
			<div class="number">
				<div>1</div>
			</div>
			<i class="line"></i>
			<p class="step-text">填写账号</p>
		</div>
		<div class=" step <c:if test="${index gt 2 }"> passed </c:if> <c:if test="${index eq 2 }"> currentstep</c:if>">
			<div class="number">
				<div>2</div>
			</div>
			<i class="line"></i>
			<p class="step-text">身份验证</p>
		</div>
		<div class="step <c:if test="${index gt 3 }"> passed </c:if> <c:if test="${index eq 3 }"> currentstep</c:if>">
			<div class="number">
				<div>3</div>
			</div>
			<i class="line"></i>
			<p class="step-text">设置密码</p>
		</div>
		<div class="step <c:if test="${index gt 4 }"> passed </c:if> <c:if test="${index eq 4 }"> currentstep</c:if>">
			<div class="number">
				<div>4</div>
			</div>
			<p class="step-text">完成</p>
		</div>
	</div>
	<div class="login-container">
		<div <c:if test="${index ne 1 }">class="isShow"</c:if> >
			<div class="box-title">
				输入账号
			</div>
			<div class="login-box">
				<form method="POST" class="login-form" name="form1">
					<div class="login-item">
						<input name="account"  type="text" class="login-input" placeholder="账号">
					</div>
					<div class="login-btn">
						<input type="submit" class="login-submit" value="提交"  onclick="return postform1();">
					</div>
				</form>
			</div>
		</div>
		<div <c:if test="${index ne 2 }">class="isShow"</c:if> >
			<div class="box-title">
				输入验证码
			</div>
			<div class="alert-text">
				我们已经将验证码发送给${email}邮箱，请在下方输入验证码进行身份验证。
			</div>
			<div class="login-box">
				<form method="POST" class="login-form"  name="form2">
					<div class="login-item">
						<input name="identifyingCode" type="text" class="login-input" placeholder="验证码">
					</div>
					<div class="login-btn">
						<input type="submit" class="login-submit" value="提交"  onclick="return postform2();">
					</div>
				</form>
			</div>
		</div>
		<div <c:if test="${index ne 3 }">class="isShow"</c:if>>
			<div class="box-title">
				设置新密码
			</div>
			<div class="login-box ">
				<form method="POST" class="login-form"  name="form3">
					<div class="login-item">
						<input name="newPassword" type="text" class="login-input" placeholder="新密码，必须为6-18位，包括字母、数字">
					</div>
					<div class="login-item">
						<input name="confirmPassword" type="text" class="login-input" placeholder="确认密码">
					</div>
					<div class="login-btn">
						<input type="submit" class="login-submit" value="提交"  onclick="return postform3();">
					</div>
				</form>
			</div>
		</div>
		<div <c:if test="${index ne 4 }">class="isShow"</c:if> >
			<div class="box-title">
				修改成功
			</div>
			<div class="login-box">
				<span class="login-text">密码修改成功!</span>
			</div>
		</div>
	</div>
<script src="${pageContext.request.contextPath}/static/js/basicInfo.js"></script>
</body>
</html>