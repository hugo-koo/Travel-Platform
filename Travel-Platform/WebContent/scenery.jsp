<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" info="Hello"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>

<head>
    <%--导入站点全局首部--%>
    <%@ include file="/site-head.jsp"%>
</head>

<body>
    <%@ include file="/site-header.jsp"%>

	    <h6><a	class="" href="/Travel-Platform/scenerylist.jsp">地区</a></h6>
	    <h1>景点1</h1>
	    <p>总体评分，点击量，发布时间</p>
	    <p>景点内容</p>
	    <p>地址信息</p>
		<p>发布子景点（X）</p>
	    <ul>
			<li class="ms-ContextualMenu-item"><a
				class="ms-ContextualMenu-link" tabindex="1" href="/Travel-Platform/scenery.jsp">子景点</a></li>
		</ul>
		<p>联系方式</p>
		<p>收藏</p>
		<a	class="" href="#review">参与点评</a>
		<p>点评1<br>点评2<br>点评3</p>
</body>

</html>