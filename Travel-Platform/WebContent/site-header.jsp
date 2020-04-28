<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="ms-Grid" dir="ltr" id="header">
	<div class="ms-Grid-row">
		<div class="ms-Grid-col ms-sm6 ms-md4 ms-lg2">
			<div class="ms-ContextualMenu-basic">
				<button class="ms-Button ms-Button--primary">
					<span class="ms-Button-label"> <i
						class="ms-Icon ms-Icon--ExpandMenu" aria-hidden="true"></i>&nbsp;&nbsp;选择功能
					</span>
				</button>
				<ul class="ms-ContextualMenu is-hidden">
					<li class="ms-ContextualMenu-item"><a
						class="ms-ContextualMenu-link" tabindex="1" href="/Travle-Platform/signup.jsp">注册</a></li>
					<li class="ms-ContextualMenu-item"><a
						class="ms-ContextualMenu-link" tabindex="1" href="/Travle-Platform/signin.jsp">登录</a></li>
					<li class="ms-ContextualMenu-item"><a
						class="ms-ContextualMenu-link" tabindex="1"
						href="/Travle-Platform/studentsManagement/studentsManagement.jsp">管理</a></li>
				</ul>
			</div>
		</div>
		<div class="ms-Grid-col ms-sm6 ms-md8 ms-lg10 ms-Link"
			id="header-right">
			<i class="ms-Icon ms-Icon--CoffeeScript" aria-hidden="true"></i>&nbsp;
			<a href="/Travle-Platform/index.jsp" title="首页" class="">旅游平台</a>
		</div>
	</div>
</div>