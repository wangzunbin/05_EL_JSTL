<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 主要是消除java代码  -->
	<!-- 根据指定的年龄判断是否未成年人观看 -->
	<!-- Java代码 -->
	<%
		Integer age = 17;
		request.setAttribute("age", age);
	%>
	<c:if test="${age >= 18 }" var="ret" scope="page">
	</c:if>
	判断的结果: ${ret}
	<c:if test="${age >= 18 }" var="ret" scope="page">
		满足条件
	</c:if>
</body>
</html>