<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" info="Hello"%>
<!DOCTYPE html>
<html>
<head>
<%-- 导入站点全局首部--%>
<%@ include file="/site-head.jsp"%>
</head>
<body>
<%@ include file="/site-header.jsp"%>
	<h1>
		<%
			out.println("欢迎访问旅游服务平台，这里是测试页面");
		%>
	</h1>
</body>
</html>