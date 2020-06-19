<%@page import="cn.edu.bitzh.tp.model.Scenery"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" info="景点"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page import="org.apache.struts2.ServletActionContext"%>
<!DOCTYPE html>
<html>

<head>
    <%--导入站点全局首部--%>
    <%@ include file="/site-head.jsp"%>
    <style>
    	.breadcrumb{
    		background-color: #e0ddd4;
    	}
    
    	.overview img{
    		margin: 0 auto;
    		width: 100%
    	}
    	.dtl{
			font-size: 14px;
			color: #707070
    	}
    	.necessary{
    		color: red;
    	}
    	
    	.username{
    		line-height: 36px;
    	}
    	.userscore{
    		position: absolute;
    		top: 20px;
    		left: 200px;
    	}
    	.userreview{
    	}
    </style>
</head>

<body>
    <%@ include file="/site-header.jsp"%>
	
	<div class="container-fluid">
		<div class="row">
			<div class="col-2">左</div>
			<div class="col-8" style="border: 1px solid #e0ddd4">
				<!-- 景点概述S -->
				<div id="scenery">
					<table>
					<div>
						<h1 class="display-4">${scenery.sceneryContent.scenery_content_name}</h1>
						<p class="dtl">总体评分x.x</p>
					</div>
					<hr>
					<div class="overview">
					    <p>景点内容信息<br>
					    	${scenery.sceneryContent.scenery_content_dtl}
						</p>
					</div><hr>
					<div>
						景点位置
						<p class="dtl">${scenery.sceneryContent.scenery_content_location }</p>
					</div><hr>
					<div>
						联系方式
					    <p class="dtl">电话：${scenery.sceneryContent.scenery_content_phone}
						<p class="dtl">邮箱：${scenery.sceneryContent.scenery_content_email}
				    </div><hr>
					<div>
						<p>发布子景点（X）</p>
					    <ul>
							<li class="ms-ContextualMenu-item"><a
								class="ms-ContextualMenu-link" tabindex="1" href="#">子景点</a></li>
						</ul>
					</div><hr>
					</table>
				</div>
				<!-- 景点概述E -->
				<!-- 点评S -->
				<%@ include file="/scenery/review.jsp"%>
				<!-- 点评E -->
			<br>
			</div>
			<div class="col-2">右</div>
		</div>
	</div>
	<footer>
		<%@ include file="/site-footer.jsp"%>
	</footer>
</body>

</html>