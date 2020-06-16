<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" info="发布景点"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>

<head>
<%--导入站点全局首部--%>
<%@ include file="/site-head.jsp"%>

<style>
.dtl {
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
				<p class="dtl">
					<span class="necessary">*</span>为必填项目
				</p>
				<hr>
				<s:form method="post" action="scenery_publishScenery" namespace="/" enctype="multipart/form-data">
					<!-- 景点基本信息 -->
					<h4><span class="necessary">基础信息</span></h4>
					<div class="form-group">
						<span class="necessary">*</span><label for="region">地区</label>
						<input type="text" class="form-control col-3" id="scenery_region" name="scenery_region"
							placeholder="填写所属地区">
					</div>
					<div class="form-group">
						<span class="necessary">*</span><label for="sceneryname">景点名称</label>
						<input type="text" class="form-control col-5" id="scenery_content_name" name="scenery.scenery_content.scenery_content_name"
							placeholder="填写景点名称">
					</div>
					<hr>
					<!-- 景点详细信息 -->
					<h4><span class="necessary">详细信息</span></h4>
					<div>
						<span class="necessary">*</span><label for="scenerydtl">景点内容介绍</label>
						<textarea class="form-control col-10" rows="14" id="scenery_content_dtl" name="scenery_content_dtl"
							placeholder="请客观地介绍景点，自己的感受可以在发布后写在景点点评中"></textarea>
					</div>
					<div>
						<span class="necessary">*</span><label for="scenerylocation">景点位置</label>
						<textarea class="form-control col-6" rows="3" id="scenery_content_location" name="scenery_content_location"
							placeholder="尽量填写完整，最好使用当地语言"></textarea>
					</div>
					<hr>
					<!-- 景点联系信息 -->
					<h4><span class="necessary">联系信息</span></h4>
					<div>
						<label for="sceneryphone">联系电话</label> <input type="text"
							class="form-control col-5" id="scenery_content_phone" name="scenery_content_phone"
							placeholder="国内 例：010-12345678 国外 例：(86-010)12345678">
					</div>
					<div>
						<label for="sceneryemail">联系邮箱</label> <input type="text"
							class="form-control col-5" id="scenery_content_email" name="scenery_content_email"
							placeholder="例：123@abc.com">
					</div>
					<br>
					<button type="submit" class="btn btn-primary">提交</button>
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