<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div id="header" class="container">
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="/Travel-Platform/index.jsp"> <img
			src="/Travel-Platform/_img/TP-logo.svg" alt="" width="32" height="32"
			title="TP"> <%="旅游平台"%>
		</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link"
					href="/Travel-Platform/index.jsp">首页 <span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="#">目的地</a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false">社区</a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="#">问答</a>
                        <a class="dropdown-item" href="#">点评</a>
						<div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="#">游记</a> 
					</div>
				</li>
				<li class="nav-item"><a class="nav-link" href="#">去旅行</a></li>
				<li class="nav-item"><a class="nav-link" href="#">我的</a></li>
			</ul>
			<form class="form-inline my-2 my-lg-0">
				<input class="form-control mr-sm-2" type="search"
					placeholder="在想什么……" aria-label="Search">
				<button class="btn btn-outline-primary my-2 my-sm-0" type="submit">搜索</button>
			</form>
		</div>
	</nav>
</div>