<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改简历</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/write_resume.css"/>
</head>
<body>
<jsp:include page="../navigationBar.jsp"></jsp:include>
 <div class="container">
        <div class="box-title">
            简历填写
        </div>
        <div class="info-container">
         
            <!--打工人的基本信息-->
            <form method="POST" class="info-form" name="resumeForm"  enctype="multipart/form-data">
                <div class="item">
                    <label class="info-text">姓名：</label>
                    <input type="text" name="name" autocomplete="off"  placeholder="你的姓名" maxlength="20" value="<c:if test="${not empty resume }">${resume.name }</c:if>" class="info-input">
                </div>
                  <div class="item">
                    <label class="info-text">照片：</label>
                    <input type="file" name="photo" accept="image/png, image/jpeg"  class="info-file">
                </div>
                <div class="item">
                    <label class="info-text">民族：</label>
                    <input type="text" name="nation" autocomplete="off" placeholder="民族" maxlength="20" class="info-input" value="<c:if test="${not empty resume }">${resume.nation }</c:if>">
                </div>
                <div class="item">
                    <label class="info-text">学历：</label>
                    <input type="text" name="education" autocomplete="off" placeholder="你的学历" maxlength="20" class="info-input" value="<c:if test="${not empty resume }">${resume.education }</c:if>">
                </div>
                <div class="item">
                    <label  class="info-text"> 出生日期：</label>
                    <input type="date" name="birth" class="info-input" value="<c:if test="${not empty resume }">${resume.dateOfBirth }</c:if>">
                   
                </div>
               <div class="item">
                    <label class="info-text">身高：</label>
                    <input type="text" name="height" autocomplete="off" placeholder="你的身高" maxlength="20" class="info-input" value="<c:if test="${not empty resume }">${resume.height }</c:if>">
                </div>
                <div class="item">
                    <label  class="info-text"> 性别：</label>
                    <div class="sex">
                        <label class="radio">
                            <input type="radio" class="radio-btn" name="sex" value="男" <c:if test="${not empty resume && resume.sex eq '男' }">checked</c:if> >
                            <span class="radio-text">男</span>
                        </label>
                        <label class="radio">
                            <input class="radio-btn" type="radio" name="sex" value="女" <c:if test="${not empty resume && resume.sex eq '女' }">checked</c:if> >
                            <span class="radio-text">女</span>
                        </label>
                    </div>
                </div>
                <div class="item">
                    <label class="info-text"> 毕业院校：</label>
                    <input type="text" name="school" autocomplete="off" placeholder="你的毕业院校" maxlength="20" class="info-input" value="<c:if test="${not empty resume }">${resume.school }</c:if>">
                </div>
                <div class="item">
                    <label class="info-text">政治面貌：</label>
                    <input type="text" name="politic" autocomplete="off" placeholder="你的政治面貌" maxlength="20" class="info-input" value="<c:if test="${not empty resume }">${resume.politicsStatus }</c:if>">
                </div>
                <div class="item">
                    <label  class="info-text"> 手机号：</label>
                    <input type="text" name="phone" autocomplete="off" placeholder="你的手机号" maxlength="20" class="info-input" value="<c:if test="${not empty resume }">${resume.phone }</c:if>">
                </div>
                <div class="item">
                    <label  class="info-text"> 电子邮箱：</label>
                    <input type="text" name="email" autocomplete="off" placeholder="你的电子邮箱" maxlength="20" class="info-input" value="<c:if test="${not empty resume }">${resume.email }</c:if>">
                </div>
                <div class="item">
                    <label class="info-text">住址：</label>
                    <textarea  class="info-textarea"  name="address" placeholder="家庭住址" ><c:if test="${not empty resume }">${resume.address }</c:if></textarea>
                </div>
                <div class="item">
                    <label class="info-text">教育背景：</label>
                    <textarea  class="info-textarea" name="educationbg"  placeholder="教育背景" ><c:if test="${not empty resume }">${resume.educationBg }</c:if></textarea>
                </div>
                <div class="item">
                    <label class="info-text">实习经历：</label>
                    <textarea  class="info-textarea" name="practice" placeholder="实习经历" ><c:if test="${not empty resume }">${resume.iexperience}</c:if></textarea>
                </div>
                <div class="item">
                    <label class="info-text">校园经历：</label>
                    <textarea  class="info-textarea" name="campus" placeholder="校园经历" ><c:if test="${not empty resume }">${resume.sexperience }</c:if></textarea>
                </div>
                <div class="item">
                    <label class="info-text">技能证书：</label>
                    <textarea  class="info-textarea" name="skills" placeholder="技能证书" ><c:if test="${not empty resume }">${resume.skills }</c:if></textarea>
                </div>
                <div class="item">
                    <label class="info-text">自我评价：</label>
                    <textarea  class="info-textarea" name="self" placeholder="自我评价" ><c:if test="${not empty resume }">${resume.self }</c:if></textarea>
                </div>
                <div class="item">
                    <div class="info-line"></div>
                    <div class="info-btn-box">
                        <input type="submit" class="info-btn" value="提    交" onclick="return postResume();">
                    </div>
                </div>
            </form>
        </div>
    </div>
          <script src="<c:url value="/resource/basicInfo.js"/>"></script>
</body>
</html>