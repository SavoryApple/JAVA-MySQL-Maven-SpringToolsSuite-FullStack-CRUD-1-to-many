<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>Ninjas</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	
		<div class="container w-25 border border-secondary p-3">
		<h1>New Ninja</h1>
		<form:form action="/ninjas/create" method="post"
			modelAttribute="ninja">
			<p>
				<form:label path="dojo">Dojo</form:label>
				<form:select path="dojo">
					<c:forEach var="oneDojo" items="${dojos}">
						<!--- Each option VALUE is the id of the person --->
						<form:option value="${oneDojo.id}">
							<!--- This is what shows to the user as the option --->
							<c:out value="${oneDojo.name}" />:
							<c:out value="${oneDojo.location}" />
						</form:option>
					</c:forEach>
				</form:select>
			</p>
			<p>
				<form:label path="firstName">Ninja First Name</form:label>
				<form:errors path="firstName" />
				<form:input path="firstName" />
			</p>
			<p>
				<form:label path="lastName">Last Name</form:label>
				<form:errors path="lastName" />
				<form:input path="lastName" />
			</p>
			<p>
				<form:label path="age">Age</form:label>
				<form:errors path="age" />
				<form:input path="age" type="number"/>
			</p>
			<input type="submit" value="Submit" />
		</form:form>
	</div>
</body>
</html>