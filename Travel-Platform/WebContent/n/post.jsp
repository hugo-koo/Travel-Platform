<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" info="游记"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>

<head>
<%--导入站点全局首部--%>
<%@ include file="/site-head.jsp"%>
</head>

<body>
	<header>
		<%@ include file="/site-header.jsp"%>
	</header>
	<div class="container-fluid">
		<div class="row align-items-start">
			<img src="<%="/Travel-Platform/_img/青岛_樱花.png"%>" class="img-fluid"
				alt="头图">
		</div>
		<hr>
		<div class="row">
			<div class="col-sm-1"></div>
			<div class="col-6 col-lg-8">
				<div class="jumbotron jumbotron-fluid"
					style="background-color: <%="#F0EDE5"%>;">
					<div class="container">
						<h1 class="display-4"><%="游记标题"%></h1>
						<p class="lead"></p>
						<hr class="my-4">
						<div id="note-content">
							<%="游记内容"%>
						</div>
					</div>
				</div>
			</div>
			<div class="col-3 col-lg-3" id="cards-flows">
				<div class="card" style="width: 18rem;">
					<img src="<%="/Travel-Platform/_img/青岛_樱花.png"%>"
						class="card-img-top" alt="<%="目的地"%>">
					<div class="card-body">
						<h5 class="card-title"><%="目的地"%></h5>
						<p class="card-text"><%="描述" %></p>
						<a href="#" class="btn btn-primary">Go</a>
					</div>
				</div>
				<hr>
				<div class="card text-white bg-info mb-3" style="max-width: 18rem;">
					<div class="card-header"><%="景点"%></div>
					<div class="card-body">
						<h5 class="card-title">景点1</h5>
						<p class="card-text">描述</p>
					</div>
					<div class="card-body">
						<h5 class="card-title">景点2</h5>
						<p class="card-text">描述</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<button id="like-button" type="button" class="btn btn-light float-left"
        onclick="like()">
        <img alt="like" src="/Travel-Platform/_img/like.svg">
    </button>
    <button id="favourites-button" type="button" class="btn btn-light float-left"
        onclick="favourites()">
        <img alt="like" src="/Travel-Platform/_img/favourites.svg">
    </button>
	<footer>
		<%@ include file="/site-footer.jsp"%>
	</footer>
</body>
</html>