<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" info="发布成功"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>

<head>
<%--导入站点全局首部--%>
<%@ include file="/site-head.jsp"%>

</head>

<body>
	<!-- 头部 -->
	<%@ include file="/site-header.jsp"%>
	
	<div class="text-center">
		<h1>发布成功</h1>
		<a class="nav-link" href="/Travel-Platform/scenerylist_getSceneryList.action">返回目的地首页</a>
	</div>
	
	<footer>
		<%@ include file="/site-footer.jsp"%>
	</footer>
</body>

</html>