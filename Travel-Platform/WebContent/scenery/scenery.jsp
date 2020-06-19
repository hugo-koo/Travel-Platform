<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" info="目的地"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>

<head>
<%--导入站点全局首部--%>
<%@ include file="/site-head.jsp"%>

<style>

.carousel-inner img {
	width: 1920px;
	height: 200px;
}

.scenery {
	height: 140px;
}

.pic {
	position: absolute;
	left: 20px;
	top: 20px;
}
.pic img {
	width: 190px;
	height: 125px;
}

.txt {
	position: absolute;
	left: 250px;
	top: 22px;
	width: 200px;
	font-size: 14px;
	text-align: left;
}
.name {
	font-size: 24px;
}
.overview {
	position: absolute;
	left: 450px;
	top: 22px;
}

</style>
</head>

<body>
	<!-- 头部 -->
	<%@ include file="/site-header.jsp"%>
	<!-- 横幅 -->
	<%@ include file="/scenery/banner.jsp"%>

	<div class="container-fluid text-center">
		<!-- 测试用按钮 -->
		<a href="/Travel-Platform/scenery/publish.jsp">发布页面</a><br>
		<!-- 最新景点S -->
		<h1 class="display-4">最新景点</h1>
		<div class="row">
			<div class="col-2"></div>
			<div class="col-8">
			<table>
				<s:iterator value="scenerys" var="scenery">
				<a href="/Travel-Platform/scenerydtl_getSceneryDtl.action?scenery.scenery_id= ${scenery.scenery_id}"
					class="list-group-item list-group-item-action">
					<div class="scenery">
						<div class="pic">
							<img src="/Travel-Platform/_img/青岛_樱花.png">
						</div>
						<div class="txt">
							<div class="name">${scenery.sceneryContent.scenery_content_name}</div>
							<div class="grade">总体评分:x.x&emsp;x条点评</div>
							<div class="location">${scenery.sceneryContent.scenery_content_location}</div>
						</div>
						<div class="overview"></div>
					</div>
				</a>
				</s:iterator>
			</table>
			</div>
		</div>
		<!-- 最新景点E --><hr>
		<!-- 热门景点S -->
		<div class="text-center">
			<h1 class="display-4">热门景点</h1>
		</div>
		<div class="row">
			<div class="col-2"></div>
			<div class="col-8">
				<a href="/Travel-Platform/scenery/info.jsp"
					class="list-group-item list-group-item-action">
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
			</div>
		</div>
		<!-- 热门景点E --><hr>
		<!-- 全球目的地S  -->
		<div class="text-center">
			<ul class="nav nav-pills mb-3 " id="pills-tab" role="tablist">
				<li class="nav-item" role="presentation"><a
					class="nav-link active" id="pills-Inland-tab" data-toggle="pill"
					href="#pills-Inland" role="tab" aria-controls="pills-home"
					aria-selected="true">国内</a></li>
				<li class="nav-item" role="presentation"><a class="nav-link"
					id="pills-Asia-tab" data-toggle="pill" href="#pills-Asia"
					role="tab" aria-controls="pills-profile" aria-selected="false">亚洲</a>
				</li>
				<li class="nav-item" role="presentation"><a class="nav-link"
					id="pills-Europe-tab" data-toggle="pill" href="#pills-Europe"
					role="tab" aria-controls="pills-contact" aria-selected="false">欧洲</a>
				</li>
				<li class="nav-item" role="presentation"><a class="nav-link"
					id="pills-America-tab" data-toggle="pill" href="#pills-America"
					role="tab" aria-controls="pills-contact" aria-selected="false">美洲</a>
				</li>
				<li class="nav-item" role="presentation"><a class="nav-link"
					id="pills-Africa-tab" data-toggle="pill" href="#pills-Africa"
					role="tab" aria-controls="pills-contact" aria-selected="false">非洲</a>
				</li>
				<li class="nav-item" role="presentation"><a class="nav-link"
					id="pills-Australia-tab" data-toggle="pill" href="#pills-Australia"
					role="tab" aria-controls="pills-contact" aria-selected="false">大洋洲</a>
				</li>
			</ul>
			<div class="tab-content" id="pills-tabContent">
				<div class="tab-pane fade show active" id="pills-Inland"
					role="tabpanel" aria-labelledby="pills-home-tab"><a href="/Travel-Platform/scenery/list.jsp">测试用</a></div>
				<div class="tab-pane fade" id="pills-Asia" role="tabpanel"
					aria-labelledby="pills-profile-tab">亚洲</div>
				<div class="tab-pane fade" id="pills-Europe" role="tabpanel"
					aria-labelledby="pills-contact-tab">欧洲</div>
				<div class="tab-pane fade" id="pills-America" role="tabpanel"
					aria-labelledby="pills-contact-tab">美洲</div>
				<div class="tab-pane fade" id="pills-Africa" role="tabpanel"
					aria-labelledby="pills-contact-tab">非洲</div>
				<div class="tab-pane fade" id="pills-Australia" role="tabpanel"
					aria-labelledby="pills-contact-tab">大洋洲</div>
			</div>

		</div>
		<!-- 全球目的地E  --><hr>
	</div>
	<footer>
		<%@ include file="/site-footer.jsp"%>
	</footer>
</body>

</html>