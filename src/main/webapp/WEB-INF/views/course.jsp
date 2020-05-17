
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Courses</h1>
	<table>
		<tr>
			<th>Course Id</th>
			<th>Course Name</th>
			<th>Course Description</th>
			<th></th>
		</tr>
		<c:forEach var="course" items="${courses}">
			<tr>
				<td>${course.courseId}></td>
				<td>${course.name}</td>
				<td>${course.description}</td>
				<td><a href="/course/${course.id}">view</a></td>
			</tr>
		</c:forEach>
	</table>
	<hr/>
	<form action="/courses" method="post">
		<div>
			Course Id: <input name="courseId" />
		</div>
		<div>
			Course Name: <input name="courseName" />
		</div>
		<div>
			Course Description: <input name="courseDescription" />
		</div>
		<div>
			<input type="submit" value="Add Course" name="button"/>
		</div>
	</form>

</body>
</html>