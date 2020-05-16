<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<meta charset="utf-8">
<!-- jQuery -->
<script src="https://ajax.aspnetcdn.com/ajax/jquery/jquery-2.2.1.min.js"></script>
<!-- site common scripts -->
<script type="text/javascript"
	src="/Travel-Platform/_scripts/site-js.js"></script>
<!-- fabric ui -->
<script type="text/javascript"
	src="/Travel-Platform/_scripts/fabric.min.js"></script>
<script type="text/javascript" src="/Travel-Platform/_scripts/picker.js"></script>
<script type="text/javascript"
	src="/Travel-Platform/_scripts/picker.date.js"></script>
<script type="text/javascript"
	src="/Travel-Platform/_scripts/picker.time.js"></script>
<script type="text/javascript" src="/Travel-Platform/_scripts/legacy.js"></script>
<!-- logo -->
<link rel="icon" href="/Travel-Platform/TPlogo.svg">
<!-- fabric ui style -->
<link rel="stylesheet" href="/Travel-Platform/_style/site-style.css">
<link rel="stylesheet"
	href="/Travel-Platform/_style/fabric.components.min.css">
<link rel="stylesheet" href="/Travel-Platform/_style/fabric.min.css">
<!-- material ui cdn -->
<meta name="viewport"
	content="minimum-scale=1, initial-scale=1, width=device-width" />
<script src="https://unpkg.com/react@latest/umd/react.development.js"
	crossorigin="anonymous"></script>
<script
	src="https://unpkg.com/react-dom@latest/umd/react-dom.development.js"></script>
<script
	src="https://unpkg.com/@material-ui/core@latest/umd/material-ui.development.js"
	crossorigin="anonymous"></script>
<script src="https://unpkg.com/babel-standalone@latest/babel.min.js"
	crossorigin="anonymous"></script>
<!-- Fonts to support Material Design -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap" />
<!-- Icons to support Material Design -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons" />
<!-- BootstrapCDN-CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<!-- BootstrapCDN-JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
<!-- BootstrapCDN-Popper.js -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<title>
	<%
		out.print(getServletInfo() + "&nbsp;-&nbsp;");
	%>旅游平台
</title>