<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div id="header" class="">
	<nav class="navbar navbar-expand-lg navbar-light">
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
				<li class="nav-item"><a class="nav-link"
					href="/Travel-Platform/scenery/scenery.jsp">目的地</a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false">社区</a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="#">问答</a> <a class="dropdown-item"
							href="#">点评</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="#">游记</a>
					</div></li>
				<li class="nav-item"><a class="nav-link" href="#">去旅行</a></li>
				<li class="nav-item"><a class="nav-link" href="#">我的</a></li>
			</ul>
			<form class="form-inline my-2 my-lg-0">
				<input class="form-control mr-sm-2" type="search"
					placeholder="在想什么……" aria-label="Search">
				<button class="btn btn-outline-primary my-2 my-sm-0" type="submit">
					<svg class="bi bi-search" width="1em" height="1em"
						viewBox="0 0 16 16" fill="currentColor"
						xmlns="http://www.w3.org/2000/svg">
  <path fill-rule="evenodd"
							d="M10.442 10.442a1 1 0 0 1 1.415 0l3.85 3.85a1 1 0 0 1-1.414 1.415l-3.85-3.85a1 1 0 0 1 0-1.415z" />
  <path fill-rule="evenodd"
							d="M6.5 12a5.5 5.5 0 1 0 0-11 5.5 5.5 0 0 0 0 11zM13 6.5a6.5 6.5 0 1 1-13 0 6.5 6.5 0 0 1 13 0z" />
</svg>
				</button>
			</form>
		</div>
	</nav>
</div>