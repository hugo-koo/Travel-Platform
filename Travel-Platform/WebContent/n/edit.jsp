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
			<img src="<%="/Travel-Platform/_img/page_bg.jpg"%>"
				class="img-fluid" alt="头图"> <input type="file"
				class="inner-text" name="toppic"
				accept="image/jpeg,.JPEG,image/png,image/gif" id=""
				style="z-index: 11; opacity: 0;">
			<div class="inner-text" style="">
				<svg t="1591593080866" class="icon" viewBox="0 0 1028 1024"
					version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="2579"
					width="64" height="64">
					<path
						d="M512.277 954.412c-118.89 0-230.659-46.078-314.73-129.73S67.12 629.666 67.12 511.222s46.327-229.744 130.398-313.427 195.82-129.73 314.73-129.73 230.659 46.078 314.72 129.73S957.397 392.81 957.397 511.183 911.078 740.96 826.97 824.642s-195.8 129.77-314.692 129.77z m0-822.784c-101.972 0-197.809 39.494-269.865 111.222s-111.7 166.997-111.7 268.373 39.653 196.695 111.67 268.335S410.246 890.78 512.248 890.78s197.809-39.484 269.865-111.222 111.7-166.998 111.67-268.374c-0.03-101.375-39.654-196.665-111.67-268.303S614.22 131.628 512.277 131.628z m222.585 347.8H544.073V288.64c-0.76-17.561-15.613-31.18-33.173-30.419-16.495 0.714-29.704 13.924-30.419 30.419v190.787H289.703c-17.56 0.761-31.179 15.614-30.419 33.174 0.715 16.494 13.924 29.703 30.42 30.418H480.48v190.788c0.761 17.56 15.614 31.179 33.174 30.419 16.494-0.715 29.703-13.925 30.418-30.42V543.02h190.788c17.56 0.762 32.413-12.857 33.173-30.418 0.762-17.561-12.858-32.414-30.419-33.174a31.683 31.683 0 0 0-2.753 0z"
						p-id="2580" fill="#8a8a8a"></path></svg>
				添加头图
			</div>
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