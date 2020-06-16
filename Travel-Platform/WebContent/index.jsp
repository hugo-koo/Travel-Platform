<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" info="首页"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>

<head>
<%--导入站点全局首部--%>
<%@ include file="/site-head.jsp"%>
<script type="text/javascript" src="/Travel-Platform/_scripts/index.js"></script>
</head>

<body>
	<header>
		<%@ include file="/site-header.jsp"%>
	</header>
	<div class="container-fluid">
		<div class="row align-items-start">
			<div id="carouselExampleCaptions" class="carousel slide"
				data-ride="carousel">
				<ol class="carousel-indicators">
					<li data-target="#carouselExampleCaptions" data-slide-to="0"
						class="active"></li>
					<li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
					<li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
				</ol>
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img src="<%=" /Travel-Platform/_img/page_bg.jpg "%>"
							class="d-block w-100" alt="...">
						<div class="carousel-caption d-none d-md-block">
							<h5></h5>
							<p></p>
						</div>
					</div>
					<div class="carousel-item">
						<img src="<%=" /Travel-Platform/_img/page_bg.jpg "%>"
							class="d-block w-100" alt="...">
						<div class="carousel-caption d-none d-md-block">
							<h5></h5>
							<p></p>
						</div>
					</div>
					<div class="carousel-item">
						<img src="<%=" /Travel-Platform/_img/page_bg.jpg "%>"
							class="d-block w-100" alt="...">
						<div class="carousel-caption d-none d-md-block">
							<h5></h5>
							<p></p>
						</div>
					</div>
				</div>
				<a class="carousel-control-prev" href="#carouselExampleCaptions"
					role="button" data-slide="prev"> <span
					class="carousel-control-prev-icon" aria-hidden="true"></span> <span
					class="sr-only">Previous</span>
				</a> <a class="carousel-control-next" href="#carouselExampleCaptions"
					role="button" data-slide="next"> <span
					class="carousel-control-next-icon" aria-hidden="true"></span> <span
					class="sr-only">Next</span>
				</a>
			</div>
		</div>
		<hr>
		<div class="row" id="mainBlock">
			<div class="col-sm-1"></div>
			<div class="col-6 col-lg-8">
				<ul class="nav nav-tabs" id="mainTab" role="tablist">
					<li class="nav-item" role="presentation"><a
						class="nav-link active" id="hotlist-tab" data-toggle="tab"
						href="#hotlist" role="tab">热门游记</a></li>
					<li class="nav-item" role="presentation"><a class="nav-link"
						id="latest-tab" data-toggle="tab" href="#latest" role="tab">最新推荐</a>
					</li>
				</ul>
				<br>
				<div class="tab-content" id="mainTabContent">
					<div class="text-center">
						<div class="spinner-grow text-primary" role="status"
							id="note-loding" style="display: none;">
							<span class="sr-only">载入中...</span>
						</div>
					</div>
					<!-- 热门 -->
					<div class="tab-pane fade show active" id="hotlist" role="tabpanel">
					</div>
					<!-- 最新 -->
					<div class="tab-pane fade" id="latest" role="tabpanel"></div>
					<div id="paginav"></div>
				</div>
			</div>
			<div class="col-3 col-lg-3" id="cards-flows">
				<ul class="nav nav-pills mb-3" id="scondaryTab" role="tablist">
					<li class="nav-item" role="presentation"><a
						class="nav-link active" id="hotscenery-tab" data-toggle="tab"
						href="#hotscenery" role="tab">产品推荐</a></li>
					<li class="nav-item" role="presentation"><a class="nav-link"
						id="hotscenery-tab" data-toggle="tab" href="#hotscenery"
						role="tab">热门景点</a></li>
				</ul>
				<br>
				<div class="tab-content" id="scondaryTabContent">
					<div class="tab-pane fade show active" id="hotscenery"
						role="tabpanel">...</div>
					<div class="tab-pane fade" id="hotscenery" role="tabpanel">...</div>
				</div>
			</div>
		</div>
	</div>
	<footer>
		<%@ include file="/site-footer.jsp"%>
	</footer>
</body>

</html>