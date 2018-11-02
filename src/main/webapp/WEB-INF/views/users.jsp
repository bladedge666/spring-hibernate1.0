<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>Showing all users</h2>
	<table>
	
		<thead>
				<th>S.N.</th>
				<th>Email</th>
				<th>Username</th>
		</thead>
		
		<c:forEach var="user" items="${users}">
			
			<tr>
				<td>${user.id}</td>
				<td>${user.email}</td>
				<td>${user.username}</td>
				<td><a href="/user/${user.id}/delete"
					onclick="confirmDelete()">Delete</a></td>
			</tr>
			
		</c:forEach>
	</table>
	
	<hr>
	
	<form action="/addUser" method="post">
		<div>
			<label>Enter email: </label> <input type="text" name="email">
			<br>
			<br>
			<label>Enter password: </label> <input type="password" name="password">
			<br>
			<br>
			 <label>Enter username: </label> <input type="text"
				name="username"> <br>
			<br> <input type="submit">
		</div>
	</form>

	<script>
		function confirmDelete() {
			return confirm("Are you sure?");
		}
	</script>
</body>
</html>