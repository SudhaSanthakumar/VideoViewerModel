<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>youTube Model</title>
  <meta name="viewport" content="width=device-width, initial=scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/youTubeHome.css" />
<style></style>
  </head>
  <body>
    <div class="body-container">
      <div class="headerc">
        <div class="website-logo">
          <h4>YouTubeModel</h4>
        </div>
        <div class="search">
          <input type="search" name="" value="">
          <button type="submit" name="button">search</button>
        </div>
        <div class="login">
          <ol>
            <li><a href="#">Login</a></li>
            <li><a href="#">Logout</a></li>
          </ol>
        </div>
      </div>
      <div class="sidebar">
        <ol>
          <li><a href="${pageContext.request.contextPath}/youTubeHome">Home</a></li>
          <li><a href="${pageContext.request.contextPath}/subscriptions">Subscriptions</a></li>
          <li><a href="${pageContext.request.contextPath}/likedVideos">Liked Videos</a></li>
          <li><a href="${pageContext.request.contextPath}/historyPage">History</a></li>
        </ol>
      </div>
      <div class="main-section">

        <div class="row">
         <c:forEach items="${videos}" var="video">
         
         <a href="youTubePlay?filename=${video.fileName}">
          <div class="card">
 			<div class="card-img">
              <video width="270" height="200" controls>
                <source src="https://assets.mixkit.co/videos/${video.fileName}" type=video/mp4>
              </video>
            </div>
            <div class="video-text">
            <div class="logo">
              logo here
            </div>

              <div class="video-name">
                ${video.videoName}
              </div>
              <div class="video-info">
               ${video.channel}
                ${video.likes}
              </div>
            </div>

          </div>
          </a>
         </c:forEach>
        </div>

        
 
          

      </div>
    </div>


   


</body>
</html>