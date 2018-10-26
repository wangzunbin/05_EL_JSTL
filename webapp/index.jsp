<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 		<% 
 			pageContext.setAttribute("msg", "pageContext");
 			request.setAttribute("msg", "request");
 			session.setAttribute("msg", "session");
 			application.setAttribute("msg", "application");
 		%>
 		pageContext:<%=pageContext.getAttribute("msg") %><br>
 		request:<%=request.getAttribute("msg") %><br>
 		session:<%=session.getAttribute("msg") %><br>
 		application:<%=application.getAttribute("msg") %><br>
</body>
</html>