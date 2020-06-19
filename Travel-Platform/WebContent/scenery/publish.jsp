<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" info="发布景点"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>

<head>
<%--导入站点全局首部--%>
<%@ include file="/site-head.jsp"%>
<script type="text/javascript" src="/Travel-Platform/_scripts/scenery-publish.js"></script>
<style>
.tip {
	font-size: 14px;
	color: #707070
}

.necessary {
	color: red;
}
</style>
</head>

<body>
	<%@ include file="/site-header.jsp"%>

	<div class="container-fluid">
		<div class="row">
			<div class="col-2">左</div>
			<div class="col-8" style="border: 1px solid black">
				<h1 class="display-4">发布景点</h1>
				<p class="tip">
					<span class="necessary">*</span>为必填项目
				</p>
				<hr>
				<s:form method="post" action="scenerypublish_publishScenery" namespace="/" enctype="multipart/form-data">
					<!-- 景点基本信息S -->
					<h4><span class="necessary">基础信息</span></h4>
						<div>
							<span class="necessary">*</span><label for="sceneryname">景点名称</label>
							<input class="form-control col-8" id="publish_scenery_name" name="publish_scenery_name"
								placeholder="填写景点名称" ></input>
						</div>
						<div>
							<span class="necessary">*</span><label for="scenerydtl">景点内容介绍</label>
							<textarea class="form-control" rows="14" id="publish_scenery_dtl" name="publish_scenery_dtl"
								placeholder="请客观地介绍景点，自己的感受可以在发布后写在景点点评中"></textarea>
						</div>
					<!-- 景点基本信息E --><hr>
					<!-- 景点地址信息S -->
					<h4><span class="necessary">地址信息</span></h4>
						<div>
							<span class="necessary">*</span><label for="scenerylocation">景点地区</label>
							<!-- 地区初始化 -->
							<script type="text/javascript">regionInit();</script>
							<div class="col-4" id="region-list">
								<p class="tip">（选择到相应的地点即可）</p>
								<h5 class="card-title" id="region-name">地区</h5>
								<select class="form-control my-2" id="region-1" name="publish_scenery_region_1"
									onchange="regionChange(1)">
									<option selected="selected" value="-1">请选择...</option>
								</select>
							</div>
						</div>
						<div>
							<span class="necessary">*</span><label for="scenerylocation">景点位置</label>
							<textarea class="form-control col-8" rows="4" id="publish_scenery_location" name="publish_scenery_location"
								placeholder="尽量填写完整，最好使用当地语言"></textarea>
						</div>
					<!-- 景点地址信息E --><hr>
					<!-- 景点联系信息S -->
					<h4><span class="necessary">联系信息</span></h4>
						<div>
							<label for="sceneryphone">联系电话</label> <input type="text"
								class="form-control col-6" id="publish_scenery_phone" name="publish_scenery_phone"
								placeholder="填写手机号或8位座机短号">
						</div>
						<div>
							<label for="sceneryemail">联系邮箱</label> <input type="text"
								class="form-control col-6" id="publish_scenery_email" name="publish_scenery_email"
								placeholder="请填写可用的邮箱">
						</div>
					<!-- 景点联系信息E --><br>
					<button type="submit" class="btn btn-primary" onclick="publish()">提交</button>
				</s:form>
				<br>
			</div>
			<div class="col-2">右</div>
		</div>
	</div>
	<footer>
		<%@ include file="/site-footer.jsp"%>
	</footer>
</body>

</html>