<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">  
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

<!DOCTYPE html>
<html>
	<head>
	<%--后台管理员举报中心界面--%>
	</head>
	<body>
		<%-- 界面顶部（菜单栏） --%>
		<%@ include file="/admin_interface/site-header.jsp" %>
		<%-- 界面主体 --%>
		<div style="margin: 0 auto;background-color:rgb(232, 230, 232);width: 80%;height: 800px ">
			<div class="panel panel-default">
					<div class="panel-heading">举报处理</div>
					<s:form>
						<table class="table">
							<th>举报者</th><th>被举报用户</th><th>举报原因</th><th>状态</th><th>处理</th><th>驳回</th>
							<tr>
								<td>用户 Z</td>
								<td>用户 A</td>
								<td>涉嫌伪造评论</td>
								<td>未处理</td>
								<td><input type="button" value="#" name="通过"></td>
								<td><input type="button" value="#" name="驳回"></td>
							</tr>
							<tr>
								<td>用户 Z</td>
								<td>用户 B</td>
								<td>发布不良评论</td>
								<td>未处理</td>
								<td><input type="button" value="#" name="通过"></td>
								<td><input type="button" value="#" name="驳回"></td>
							</tr>
							<tr>
								<td>用户 Z</td>
								<td>用户 C</td>
								<td>涉嫌非法交易</td>
								<td>未处理</td>
								<td><input type="button" value="#" name="通过"></td>
								<td><input type="button" value="#" name="驳回"></td>
							</tr>
						</table>
					</s:form>
				</div>
		</div>

		
		
		
	</body>
</html>