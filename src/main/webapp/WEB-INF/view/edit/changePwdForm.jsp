<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="edit.changePwd" /></title>
</head>
<body>
	<form:form>
		<p>
			<label>
				<spring:message code="edit.currentPwd" /> : <br>
				<form:input path="currentPassword"/>
				<form:errors path="currentPassword"/>
			</label>
		</p>
		<p>
			<label>
				<spring:message code="edit.newPwd" /> : <br>
				<form:password path="newPassword"/>
				<form:errors path="newPassword" />
			</label>
		</p>
		<input type="submit" value='<spring:message code="edit.change.btn"/>'>
	</form:form>
</body>
</html>