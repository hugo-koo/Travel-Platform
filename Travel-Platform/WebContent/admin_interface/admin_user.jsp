<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" info="首页"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">  
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

<!DOCTYPE html>
<html>
	<head>
	<%--后台管理员用户管理中心界面--%>
	</head>
	<body>
		<%-- 界面顶部（菜单栏） --%>
		<%@ include file="/admin_interface/site-header.jsp" %>
		<%-- 界面主体 --%>
		<div style="margin: 0 auto;background-color:rgb(232, 230, 232);width: 80%;height: 800px ">
			<%-- 处理用户认证请求 --%>
			<div style="width: 45%;height: 800px;float: left">
				<div class="panel panel-default">
					<div class="panel-heading">用户认证</div>
					<s:form>
						<table class="table">
							<th>用户名</th><th>状态</th><th>认证</th><th>驳回</th>
							<tr>
								<td>用户 A</td>
								<td>未处理</td>
								<td><input type="button" value="#" name="通过"></td>
								<td><input type="button" value="#" name="驳回"></td>
							</tr>
							<tr>
								<td>用户  B</td>
								<td>未处理</td>
								<td><input type="button" value="#" name="通过"></td>
								<td><input type="button" value="#" name="驳回"></td>
							</tr>
							<tr>
								<td>用户 C</td>
								<td>未处理</td>
								<td><input type="button" value="#" name="通过"></td>
								<td><input type="button" value="#" name="驳回"></td>
							</tr>
						</table>
					</s:form>
				</div>
			</div>
			<div style="width: 10%;height: 800px;background-color: white;float: left">
				<p class="text-center"></p>
			</div>
			<%-- 处理用户修改请求 --%>
			<div style="width: 45%;height: 800px;float: left;">
				<p>partB</p>
			</div>
			
		</div>
		<%-- 界面底部 --%>
		<div style="margin: 0 auto;background-color:rgb(255, 220, 255);width: 80%;height: 40px ">
			<p class="text-center">XXXXXXXXXXXXXXXXXXXXXXXXXX</p>
		</div>
		
	</body>
</html>