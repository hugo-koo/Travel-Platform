<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" info="地区"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>

<head>
    <%--导入站点全局首部--%>
    <%@ include file="/site-head.jsp"%>
    <style>
    	.breadcrumb{
    		background-color: #e0ddd4;
    	}
    
		.scenery{
			height:140px;
		}    
    
    	.pic{
			position: absolute;
			left: 20px;
			top: 20px;
    	}
		.pic img{
			width: 190px;
			height: 125px;
		}
		
		.txt{
			position: absolute;
			left: 250px;
			top: 22px;
			width: 200px;
			font-size: 14px
		}
		.name{
			font-size: 24px;
		}
		
		.overview{
			position: absolute;
			left: 450px;
			top: 22px;
		}
	</style>
</head>

<body>
    <%@ include file="/site-header.jsp"%>
	
	<div class="container-fluid">
		<div class="row">
			<div class="col-2">左</div>
			<div class="col-8" style="border: 1px solid #e0ddd4">
				<h1 class="display-4">地区</h1>
				<h7>找到相关结果x个</h7><br>
				<!-- 景点列表S -->
				<a href="/Travel-Platform/scenery/info.jsp" class="list-group-item list-group-item-action">
					<div class="scenery">
						<div class="pic">
							<img src="/Travel-Platform/_img/青岛_樱花.png">
						</div>
						<div class="txt">
							<div class="name">景点名称</div>
							<div class="grade">总体评分:x.x&emsp;x条点评</div>
							<div class="location">某省某市某区某地点</div>
						</div>
						<div class="overview">概述</div>
					</div>
				</a>
				<a href="/Travel-Platform/scenery/info.jsp" class="list-group-item list-group-item-action">
					<div class="scenery">
						<div class="pic">
							<img src="/Travel-Platform/_img/青岛_樱花.png">
						</div>
						<div class="txt">
							<div class="name">景点名称</div>
							<div class="grade">总体评分:x.x&emsp;x条点评</div>
							<div class="location">某省某市某区某地点</div>
						</div>
						<div class="overview">概述</div>
					</div>
				</a><br>
				<!-- 景点列表E -->
				<!-- 分页 -->
				<div class="mx-auto" style=" width:150px">
					<ul class="pagination">
						<li class="page-item"><a class="page-link" href="#">Previous</a></li>
						<li class="page-item active"><a class="page-link" href="#">1</a></li>
						<li class="page-item"><a class="page-link" href="#">Next</a></li>
					</ul>
				</div>

			</div>
			<div class="col-2">右</div>
		</div>
	</div>
	<footer>
		<%@ include file="/site-footer.jsp"%>
	</footer>
</body>

</html>