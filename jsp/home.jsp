<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@page import="java.util.List" %>
<%@page import="com.youtube.model.Video" %>
${name} welcome to Home Page!!!
<a href="videos">get Videos</a>
<table>

    <c:forEach items="${videos}" var="video">
        <tr>
            <td>video name: <c:out value="${video.videoName}"/></td>
            <div class="card-img">
            <a href="youTubePlay">
              <video width="270" height="200" controls autoplay>
                <source src="https://assets.mixkit.co/videos/${video.fileName}" type=video/mp4>
              </video>
			</a>
            </div>
            
        </tr>
    </c:forEach>
</table>

<a href="newVideo">insertVideo</a><br>
<a href="channel">insertChannel</a><br>
<a href="user">insertUser</a><br>
<a href="comment">insertComment</a><br>
<a href="reply">insertReply</a><br>
<a href="history">insertHistory</a><br>
<a href="${pageContext.request.contextPath}/admin/tagPage">insertTag</a><br>
</body>
</html>