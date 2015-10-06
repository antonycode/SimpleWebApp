<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home page</title>
</head>
<body>
	<jsp:include page="_header.jsp"></jsp:include>
	<jsp:include page="_menu.jsp"></jsp:include>
	<h1>Home Page</h1>
	this webapp using JSP/ SERVLET/ JDBC.
	
	<h4>It include flowing some functions: </h4>
	<ul>
		<li>Login</li>
		<li>Produc List</li>
		<li>Create Products</li>
		<li>Edit Products</li>
		<li>Delete Products</li>
	</ul>
	<jsp:include page="_footer.jsp"></jsp:include>

</body>
</html>