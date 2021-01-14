<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理员</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/manager.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/弯曲文本.css">
</head>
<body>
<jsp:include page="../navigationBar.jsp"></jsp:include>

  <div class="text-container">
        <%--每个字符后的span不能有间隔--%>
        <span>欢</span><span>迎</span><span>来</span><span>到</span><span>管</span><span>理</span><span>界</span><span>面</span>
    </div>
<div class="box">
    <div class="box1">
    <c:choose>
    <c:when test="${sessionScope.user.identityId eq 3 && not empty sessionScope.user.account && not empty sessionScope.user}">
      <a href="<c:url value="/managerPage/managerListPage"/>" target="_blank"><img src="${pageContext.request.contextPath}/static/image/黄全3.png" alt=""></a>
    </c:when>
    <c:otherwise>
		<img src="${pageContext.request.contextPath}/static/image/黄全3.png" alt="管理员管理">
        <p class="details">
                您暂无权限访问此内容
            </p>
    </c:otherwise>
    
    </c:choose>
      
    </div>
    <div class="box2">
        <a  href="<c:url value="/managerPage/userListPage?tag=all"/>" target="_blank"><img src="${pageContext.request.contextPath}/static/image/红全4.png" alt="用户管理"></a>
    </div>
    <div class="box3">
        <a  href="<c:url value="/managerPage/checkRecruitmentPage?tag=all"/>" target="_blank"><img src="${pageContext.request.contextPath}/static/image/蓝全3.png" alt="工作管理"></a>
    </div>
    <div class="box4">
        <a  href="<c:url value="/managerPage/checkCompanyPage?tag=all"/>" target="_blank"><img src="${pageContext.request.contextPath}/static/image/绿全4.png" alt="公司管理" ></a>
    </div>
    </div>
    
      <script>
        // 写个脚本控制鼠标移入效果

        // 找到所有span标签
        let spans = document.querySelectorAll('span');
        // console.log(spans);

        // 为所有的标签增加绑定鼠标移入、移除的事件，并处理相关增加或移除样式操作
        for (const key in spans) {
            if (spans.hasOwnProperty(key)) {
                const element = spans[key];

                // key为字符类型，需要转数字。
                let index = parseInt(key);

                // 增加鼠标移入事件
                element.addEventListener("mouseover", (e) => {
                    element.classList.add('flat');

                    // 联动操作，控制前后span同时增加样式


                    // 判断奇数、偶数（spans 是从0开始数的）
                    if (index % 2 == 0) {
                        // 偶数后一个联动
                        spans[index + 1].classList.add('flat');
                    } else {
                        // 奇数前一个联动
                        spans[index - 1].classList.add('flat');
                    }


                });
                // 增加鼠标移出事件
                element.addEventListener("mouseout", (e) => {
                    element.classList.remove('flat');

                    // 联动操作，控制前后span同时移除样式

                    // 判断奇数、偶数（spans 是从0开始数的）
                    if (index % 2 == 0) {
                        // 偶数后一个联动
                        spans[index + 1].classList.remove('flat');
                    } else {
                        // 奇数前一个联动
                        spans[index - 1].classList.remove('flat');
                    }
                });



            }
        }




    </script>
</body>
</html>