<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div class="tagFormcontainer">
      <form class="tagForm" action="${pageContext.request.contextPath}/admin/tag" method="post">
        <label for="tag">Tag Name</label>
        <input type="text" name="tag" value="">
        <button type="submit" name="button">Add Tag</button>
        </form>
    </div>

</body>
</html>