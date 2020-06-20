<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">  
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

<!DOCTYPE html>
<html>
	<head>
	<%--后台管理员景区和旅游产品管理中心界面--%>
	</head>
	<body>
		<%-- 界面顶部（菜单栏） --%>
		<%@ include file="/admin_interface/site-header.jsp" %>
		<%-- 界面主体 --%>
		<div style="margin: 0 auto;background-color:rgb(232, 230, 232);width: 80%;height: 800px ">
			<%-- 处理景区请求 --%>
			<div style="width: 45%;height: 800px;float: left">
				<div class="panel panel-default">
					<div class="panel-heading">景区请求处理</div>
					<s:form>
						<table class="table">
							<th>用户名</th><th>状态</th><th>处理</th>
							<tr>
								<td>景区官方 A</td>
								<td>未处理</td>
								<td><input type="button" value="#" name="处理"></td>
							</tr>
							<tr>
								<td>景区官方  B</td>
								<td>未处理</td>
								<td><input type="button" value="#" name="处理"></td>
							</tr>
							<tr>
								<td>景区官方 C</td>
								<td>未处理</td>
								<td><input type="button" value="#" name="处理"></td>
							</tr>
						</table>
					</s:form>
				</div>
			</div>
			<div style="width: 10%;height: 800px;background-color: white;float: left">
				<p class="text-center"></p>
			</div>
			<%-- 处理旅游产品请求 --%>
			<div style="width: 45%;height: 800px;float: left;">
				<div class="panel panel-default">
					<div class="panel-heading">景区请求处理</div>
					<s:form>
						<table class="table">
							<th>产品名</th><th>状态</th><th>处理</th>
							<tr>
								<td>产品 A</td>
								<td>未处理</td>
								<td><input type="button" value="#" name="处理"></td>
							</tr>
							<tr>
								<td>产品  B</td>
								<td>未处理</td>
								<td><input type="button" value="#" name="处理"></td>
							</tr>
							<tr>
								<td>产品 C</td>
								<td>未处理</td>
								<td><input type="button" value="#" name="处理"></td>
							</tr>
						</table>
					</s:form>
				</div>
			</div>
			
		</div>
		
	</body>
</html>