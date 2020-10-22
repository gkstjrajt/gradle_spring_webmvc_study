<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 타입</title>
</head>
<body>
	<form:form modelAttribute="login" action="result">
		<p>
			<label for="loginType">로그인타입 : </label>
			<form:select path="loginType" items = "${loginTypes}" />
		</p>
		<p>
			<label for="jobCode">상태 : </label>
			<form:select path="jobCode">
				<option value="">-- 선택하세요 --</option>
				<form:options items="${jobCodes}" itemLabel="label" itemValue="code"/>
			</form:select>
		</p>
		<p>
			<label for="tool">개발 툴 : </label>
			<form:radiobuttons path="tool" items="${tools}"/>
		</p>
		<p>
			<label for="favorite">선호 OS : </label>
			<form:checkboxes path="favorite" items="${favorites}" delimiter="  "/>
		</p>
		<p>
			<label for="codes">공부 : </label>
				<c:forEach items="${codes}" var="subject" varStatus="vs">
					<form:checkbox name="subject[${vs.index}].code" value="subject[${vs.index}].${codes.code}" path="codes"/>
				</c:forEach>
		</p>
			<input type="submit" value="결과보기">
	</form:form>
</body>
</html>