<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>消息</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/news.css">
</head>
<body>
<jsp:include page="../navigationBar.jsp"></jsp:include>
<div class="news-container">
        <div class="news-view">
            <div class="news-box">
                <div class="news-inner">
                    <div class="news-left">
                        <div class="title">
                            <span>近期消息</span>
                        </div>
                        <div class="list-container">
                            <div class="list">
                            <c:forEach items="${users}" var="user" varStatus="s">
                              <a href="<c:url value="/newsPage?index=${s.index }"/>">
                                <div class="list-item <c:if test="${s.index eq param.index }">active</c:if>">
                                    <div class="item1-img"></div>
                                    <div class="item1-name">
                                        <div class="name">${user.userName }</div>
                                        <div class="last-word"><c:choose><c:when test="${user.identityId eq 0}">工人</c:when><c:when test="${user.identityId eq 1}">HR</c:when><c:when test="${user.identityId eq 2}">管理员</c:when><c:when test="${user.identityId eq 3}">超级管理员</c:when></c:choose></div>
                                    </div>
                                </div>
                                </a>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                    <div class="news-right">
                        <div class="dialog">
                            <div class="dialog-title">
                                <span>${userName}</span>
                            </div>
                            <div class="message-list">
                                <div class="message-list-content">
                                
                                <c:forEach items="${news}" var="neww">
                                    <div class="msg-time">
                                        <span class="time">${neww.postTime}</span>
                                    </div>
                                    <div class="msg-item">
                                        <div class="msg-item-img"></div>
                                        <div class="message">
                                            <div class="message-content">
                                                ${neww.context }
                                            </div>
                                        </div>
                                    </div>
                                   </c:forEach>
                                </div>
                            </div>
                            <div class="send-box">

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>