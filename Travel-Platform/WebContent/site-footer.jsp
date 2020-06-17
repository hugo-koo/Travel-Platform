<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="jumbotron jumbotron-fluid" id="footer">
	<button id="goto-top" type="button" class="btn btn-light float-right"
		onclick="$('html').animate({scrollTop:'0px'},300);">
		<svg t="1591710373306" class="icon" viewBox="0 0 1024 1024"
			version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="3229"
			width="32" height="32">
                        <path
				d="M122.545664 559.36a72.0384 72.0384 0 0 1-101.376 0 70.7072 70.7072 0 0 1 0-100.8128L461.489664 20.8384a72.0896 72.0896 0 0 1 101.376 0l440.32 437.7088a70.7072 70.7072 0 0 1 0 100.8128 72.0384 72.0384 0 0 1-101.376 0L512.177664 172.0832z m389.632 56.32l389.632 387.2768a71.936 71.936 0 0 0 101.376 0 70.7072 70.7072 0 0 0 0-100.8128l-440.32-437.7088a72.0896 72.0896 0 0 0-101.376 0L21.169664 902.144a70.7072 70.7072 0 0 0 0 100.8128 71.936 71.936 0 0 0 101.376 0z m0 0"
				p-id="3230" fill="#0f4c81"></path></svg>
	</button>
	<div class="container">
		<h1 class="display-4">
			<img src="/Travel-Platform/_img/TP-logo.svg" alt="" width="64"
				height="64" title="TP"><%="旅游平台"%></h1>
		<p class="lead"></p>
		<hr class="my-4">
		<div class="row">
			<dl class="nav flex-column col">
				<dd class="nav-item">
					<a class="nav-link active" href="#">首页</a>
				</dd>
				<dd class="nav-item">
					<a class="nav-link" href="/Travel-Platform/scenery/scenery.jsp">目的地</a>
				</dd>
				<dd>
					<a class="nav-link" href="#">去旅行</a>
				</dd>
			</dl>
			<div></div>
			<dl class="nav flex-column col">
				<dt class="display-5">社区</dt>
				<dd class="nav-item">
					<a class="nav-link" href="#">问答</a>
				</dd>
				<dd class="nav-item">
					<a class="nav-link" href="#">点评</a>
				</dd>
				<dd class="nav-item">
					<a class="nav-link" href="#">游记</a>
				</dd>
			</dl>
			<div class="col"></div>
		</div>
	</div>
</div>