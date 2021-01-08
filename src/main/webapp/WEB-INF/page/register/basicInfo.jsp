<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ page isELIgnored="false" %>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>基本信息填写</title>
 <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/basicInfo.css"  >
</head>
<body>
<jsp:include page="../navigationBar.jsp"></jsp:include>
  <div class="registerSteps">
        <!--第一步-->
        <div class="step currentstep">
          
            <div class="number"></div>
             <!--直线-->
            <div class="line"></div>
           
        </div>
        <!--第二步-->
        <div class="step">
            <div class="number"></div>
            <div class="line"></div>
 
        </div>
        <!--第三步-->
        <div class="step">
            <div class="number"></div>
         
        </div>
    </div>
	   <div class="container">
	   <div class="box-title">
            信息填写
        </div>
	   <c:if test="${sessionScope.newUser.identityId eq 0 }">
        <div class="info-container">
            <!--打工人的基本信息-->
              <form method="POST" class="info-form" name="workerForm">
                <div class="item">
                    <label class="info-text">姓：</label>
                    <input name="lastName" type="text" autocomplete="off" placeholder="你的姓" maxlength="20" class="info-input">
                </div>
                <div class="item">
                    <label class="info-text"> 名：</label>
                    <input name="firstName" type="text" autocomplete="off" placeholder="你的名" maxlength="20" class="info-input">
                </div>
                
                <div class="item">
                    <label class="info-text"> 出生日期：</label>
                    <input name="birth" type="date" class="info-input">

                </div>
                <div class="item">
                    <label class="info-text"> 身份证号：</label>
                    <input name="IDNumber" type="text" autocomplete="off" placeholder="你的身份证号" maxlength="20" class="info-input">
                </div>
                <div class="item">
                    <label class="info-text"> 手机号：</label>
                    <input name="phone" type="text" autocomplete="off" placeholder="你的手机号" maxlength="20" class="info-input">
                </div>
                <div class="item">
                    <label class="info-text"> 电子邮箱：</label>
                    <input name="email" type="text" autocomplete="off" placeholder="你的电子邮箱" maxlength="20" class="info-input">
                </div>
                <div class="item">
                    <label class="info-text"> 性别：</label>
                    <div class="sex">
                        <label class="radio">
                            <input  type="radio" class="radio-btn" name="sex" value="男">
                            <span class="radio-text">男</span>
                        </label>
                        <label class="radio">
                            <input  class="radio-btn" type="radio" name="sex" value="女">
                            <span class="radio-text">女</span>
                        </label>
                    </div>
                </div>
                <div class="item">
                    <div class="info-line"></div>
                    <div class="info-btn-box">
                        <input type="submit" class="info-btn" value="提    交" onclick="return postWorker();">
                    </div>
                </div>
            </form>
     </div>
        </c:if>
        <c:if test="${sessionScope.newUser.identityId eq 1 }">
        <div class="info-container">
            <!--老板的基本信息-->
            <form method="POST" class="info-form" name="bossForm">
                <div class="item">
                    <label class="info-text">姓：</label>
                    <input name="lastName" type="text" autocomplete="off" placeholder="你的姓" maxlength="20" class="info-input">
                </div>
                <div class="item">
                    <label class="info-text"> 名：</label>
                    <input name="firstName" type="text" autocomplete="off" placeholder="你的名" maxlength="20" class="info-input">
                </div>
                <div class="item">
                    <label class="info-text"> 出生日期：</label>
                    <input name="birth" class="info-input" type="date"></input>
                </div>
                <div class="item">
                    <label class="info-text"> 身份证号：</label>
                    <input name="IDNumber" type="text" autocomplete="off" placeholder="你的身份证号" maxlength="20" class="info-input">
                </div>
                <div class="item">
                    <label class="info-text"> 手机号：</label>
                    <input name="phone" type="text" autocomplete="off" placeholder="你的手机号" maxlength="20" class="info-input">
                </div>
                <div class="item">
                    <label class="info-text"> 电子邮箱：</label>
                    <input name="email" type="text" autocomplete="off" placeholder="你的电子邮箱" maxlength="20" class="info-input">
                </div>
                <div class="item">
                    <label class="info-text"> 公司：</label>
                    <input name="company" type="text" autocomplete="off" placeholder="你的公司" maxlength="20" class="info-input">
                </div>
                <div class="item">
                    <label class="info-text"> 性别：</label>
                    <div class="sex">
                        <label class="radio">
                            <input type="radio" class="radio-btn" name="sex" value="男">
                            <span class="radio-text">男</span>
                        </label>
                        <label class="radio">
                            <input class="radio-btn" type="radio" name="sex" value="女">
                            <span class="radio-text">女</span>
                        </label>
                    </div>
                </div>
                <div class="item">
                    <div class="info-line"></div>
                    <div class="info-btn-box">
                        <input type="submit" class="info-btn" value="提    交" onclick="return postBoss();">
                    </div>

                </div>
            </form>
        </div>
        </c:if>
           <c:if test="${sessionScope.newUser.identityId eq 2 }">
        <div class="info-container">
            <!--打工人的基本信息-->
              <form method="POST" class="info-form" name="workerForm">
                <div class="item">
                    <label class="info-text">姓：</label>
                    <input name="lastName" type="text" autocomplete="off" placeholder="你的姓" maxlength="20" class="info-input">
                </div>
                <div class="item">
                    <label class="info-text"> 名：</label>
                    <input name="firstName" type="text" autocomplete="off" placeholder="你的名" maxlength="20" class="info-input">
                </div>
                
                <div class="item">
                    <label class="info-text"> 出生日期：</label>
                    <input name="birth" type="date" class="info-input">

                </div>
                <div class="item">
                    <label class="info-text"> 身份证号：</label>
                    <input name="IDNumber" type="text" autocomplete="off" placeholder="你的身份证号" maxlength="20" class="info-input">
                </div>
                <div class="item">
                    <label class="info-text"> 手机号：</label>
                    <input name="phone" type="text" autocomplete="off" placeholder="你的手机号" maxlength="20" class="info-input">
                </div>
                <div class="item">
                    <label class="info-text"> 电子邮箱：</label>
                    <input name="email" type="text" autocomplete="off" placeholder="你的电子邮箱" maxlength="20" class="info-input">
                </div>
                <div class="item">
                    <label class="info-text"> 性别：</label>
                    <div class="sex">
                        <label class="radio">
                            <input  type="radio" class="radio-btn" name="sex" value="男">
                            <span class="radio-text">男</span>
                        </label>
                        <label class="radio">
                            <input  class="radio-btn" type="radio" name="sex" value="女">
                            <span class="radio-text">女</span>
                        </label>
                    </div>
                </div>
                <div class="item">
                    <div class="info-line"></div>
                    <div class="info-btn-box">
                        <input type="submit" class="info-btn" value="提    交" onclick="return postWorker();">
                    </div>
                </div>
            </form>
     </div>
        </c:if>
    </div>
      <script src="<c:url value="/resource/basicInfo.js"/>"></script>
</body>
</html>