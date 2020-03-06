<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial=scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/youTubeHome.css" />
<title>Insert title here</title>
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

Page Under Construction
</div>
</body>
</html>