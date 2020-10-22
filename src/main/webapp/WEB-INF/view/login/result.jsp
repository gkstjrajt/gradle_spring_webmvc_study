<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과 화면</title>
</head>
<body>
	로그인타입 : ${login.loginType}
	<br>
	상태 : ${login.jobCode}
	<br>
	개발 툴 : ${login.tool}
	<br>
	선호 OS : [${login.favorite}]
	<br>
	공부 : [${login.codes}]
</body>
</html>