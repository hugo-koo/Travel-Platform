<%@page import="org.dom4j.Document"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" info="游记编辑"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>

<head>
<%--导入站点全局首部--%>
<%@ include file="/site-head.jsp"%>
<script type="text/javascript" src="/Travel-Platform/_scripts/edit.js"></script>
</head>

<body>
	<header>
		<%@ include file="/site-header.jsp"%>
	</header>
	<div class="container-fluid">
		<div class="row align-items-start">
			<img src="<%=" /Travel-Platform/_img/page_bg.jpg "%>"
				class="img-fluid" alt="头图">
		</div>
		<hr>
		<div class="row">
			<div class="col-sm-1"></div>
			<div class="col-6 col-lg-8">
				<form class="form-horizontal container">
					<div class="form-group row">
						<input type="text" class="form-control" id="note-header"
							placeholder="游记标题">
					</div>
					<div class="form-row row">
						<div class="form-group col-sm-8">
							<button type="submit" class="btn btn-primary">保存至草稿</button>
							<button type="button" class="btn" onclick="">发布</button>
						</div>
						<div class="form-group col-sm-4">
							<select id="permission" class="form-control">
								<option selected value="public">公开</option>
								<option value="private">私享</option>
							</select>
						</div>
					</div>
					<input type="hidden" name="content" value="" id="input-content" />
					<input type="hidden" name="region" value="" id="input-region" />
				</form>
				<iframe class="border-0" id="editorFrame" title="Editor"
					width="100%" style="height: 750px"
					src="/Travel-Platform/n/editor.jsp?Type=note"> </iframe>
			</div>
			<div class="col-3 col-sm-3" id="cards-flows">
				<div class="card text-white bg-info mb-3" style="max-width: 18rem;">
					<div class="card-header">
						<%="选择地区"%>
					</div>
					<div class="card-body" id="region-list">
						<h5 class="card-title" id="region-name">地区</h5>
						<select class="form-control my-2" id="region-1" name="region-1"
							onchange="regionChange(1)">
							<option selected="selected" value="-1">请选择...</option>
						</select>
					</div>
					<script type="text/javascript">
						//从大洲列表开始初始化
						regionInit();
					</script>
				</div>
			</div>
		</div>
	</div>
	<footer>
		<%@ include file="/site-footer.jsp"%>
	</footer>
</body>

</html>