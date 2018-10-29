<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

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
	<br/>
	
	<!-- if的判断语句 -->
	<!-- 示例2 -->
	<!-- 多条件判断语句 -->
	<c:choose>
		<c:when test="${age >= 80}">您很老咯</c:when>
		<c:when test="${age < 18}">您小...</c:when>
		<c:otherwise>你可以的,.....</c:otherwise>
	</c:choose>
	<br>
	<!-- 遍历 -->
	<% 
		List<String> list = Arrays.asList(new String[]{"neld", "stef", "will"});
		request.setAttribute("list", list);
	%>
	
	<c:forEach items="${list}" var="item" varStatus="vs">
		${vs.count}----->${pageScope.item}<br/>
	</c:forEach>
	<br>
	
	<!-- 在页面中输出一串数字 1到10 -->
	<c:forEach var="num" begin="1" end="10" step="1">
		${pageScope.num}
	</c:forEach>
	
	<!-- 国际化标签 -->
	<!-- 设置国际化资源文件的基本名称 -->
	<fmt:setBundle basename="app"/>
	<form action="#">
		<fmt:message key="username"/>:<input name="username"><br>
		<fmt:message key="password"/>:<input name="password"><br>
		<input type="submit" value="login"> <br>
	</form>
	
	<% 
		Date date = new Date();
		request.setAttribute("date", date);
		
	%>
	<fmt:formatDate value="${date}" pattern="yyyy-MM-dd HH:mm:ss SS"/>
</body>
</html>