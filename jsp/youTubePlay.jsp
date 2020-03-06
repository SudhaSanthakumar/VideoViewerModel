<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@ taglib prefix = "fn" 
   uri = "http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>

<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title></title>
    <meta name="viewport" content="width=device-width, initial=scale=1.0"> 
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/youTubeHome.css"> 
    <style type="text/css">    </style>
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
      <div class="mainc">
        <div class="main-video">
          <video width="270" height="200" controls autoplay>
            <source src="https://assets.mixkit.co/videos/${video.fileName}" type=video/mp4>
          </video>
        </div>
        <div class="video-infor">
          <div class="left-bar">
${video.videoName }
          </div>
          <div class="right-bar">
          <a href="youTubePlay/like?f=${video.fileName}"> Likes</a>${video.likes }
          
 			<a href="">Dislikes</a> ${video.dislikes }
 			<a href="">Shares</a>${video.shares }
          </div>

        </div>
        <div class="rule">
          <hr>
        </div>
        <div class="channel-infor">
          <div class="left-bar">
        ${video.channel.channelName }
          </div>
          <div class="right-bar">
            <button type="submit" name="button">Subscribe</button>
          </div>
        </div>
        <div class="rule">
          <hr>
        </div>
        <div class="commentsHeader">
          <h4>comments</h4>
        </div>
        <div class="comments">

          
          <div class="replies">

          </div>
        </div>
      </div>
      <div class="right-sidebar">
        <div class="col">
        <a href="youTubePlay?filename=${nVideo.fileName}">
        <div class="side-card">
          <div class="card-img-toside">
            <video class="actual-video" width="270" height="200" controls >
              <source src="https://assets.mixkit.co/videos/${nVideo.fileName }" type=video/mp4>
            </video>
          </div>
          <div class="video-text-toside">

              
              ${nVideo.videoName }<br>

               ${nVideo.channel.channelName}<br>
               Views${nVideo.views}<br>
          </div>


        </div>
        </a>
         <div class="rule">
          <hr>
        </div>
       
           <c:forEach items="${relatedVideos}" var="rVideo">
           <c:set var="mainVideo" value="${video.fileName }"/>
            <c:set var="nextVideo" value="${nVideo.fileName }"/>
            <c:if test="${rVideo.fileName != nextVideo }">
             <c:if test="${rVideo.fileName != mainVideo }">
           <a href="${pageContext.request.contextPath}/youTubePlay?filename=${rVideo.fileName}">
       		 <div class="side-card">
	          <div class="card-img-toside">
	            <video class="actual-video" width="270" height="200" controls>
	              <source src="https://assets.mixkit.co/videos/${rVideo.fileName }" type=video/mp4>
	            </video>
	          </div>
	        	  <div class="video-text-toside">

              ${rVideo.videoName }<br>

               ${rVideo.channel.channelName}<br>
               Views${rVideo.views}<br>
          </div>


        </div>
         </a>
        </c:if>
        </c:if>
      </c:forEach>
       
        </div>

      </div>
      </div>

  </body>
</html>
