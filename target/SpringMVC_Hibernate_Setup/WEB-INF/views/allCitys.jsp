<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>All Citys</title>
</head>
<body>
	<br>
	<br>
	<br>
	<a href="${pageContext.request.contextPath}/addCity">Add City</a>
	<br>
	<h3>List of all Citys</h3>
	${message}
	<br>
	<br>
	<table border="1px" cellpadding="0" cellspacing="0">
		<thead>
			<tr>
				<th>ID</th>
				<th>Ciudad</th>
				<th>estado id</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach var="city" items="${cityList}">
				<tr>
					<td>${city.city_id}</td>
					<td>${city.description}</td>
					<td>${city.state_id}</td>
					<td><a
						href="${pageContext.request.contextPath}/editCity/${city.city_id}">Edit</a></td>
					<td><a
						href="${pageContext.request.contextPath}/deleteCity/${city.city_id}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>


	</table>
</body>
</html>