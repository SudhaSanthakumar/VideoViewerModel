<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <div class="newVideo">
      <form class="videoForm" action="video" method="post">
        <ol>
      <li>  <label for="videoName">Video Name</label></li>
      <li>  <input type="text" name="videoName" value=""></li>
      <li>  <label for="tags">Tags</label></li>
    <li>    <input type="text" name="tags" value=""></li>
    <li>    <label for="channel">Channel</label></li>
    <li>    <input type="text" name="channel" value=""></li>
    <li>    <label for="fileName">File Name</label></li>
    <li>    <input type="text" name="fileName" value=""></li>
    <li>    <button type="submit" name="button">Upload</button></li>
    </ol>
      </form>
    </div>
</body>
</html>