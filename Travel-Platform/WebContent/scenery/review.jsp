<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="review">
	<!-- 参与点评 -->
	<button type="button" class="btn btn-primary" data-toggle="modal"
		data-target="#myModal">参与点评</button>
	<br>
	<!-- 点评发布模态框S -->
	<div class="modal fade" id="myModal">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<!-- 模态框头部 -->
				<div class="modal-header">
					<h1>景点名称</h1>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<!-- 模态框主体 -->
				<div class="modal-body">
					<p class="dtl">
						<span class="necessary">*</span>为必填项目
					</p>
					<form>
						<div class="radio">
							<span class="necessary">*</span><label for="review">景点评分</label>
							<br>&emsp;
							<label><input type="radio" name="optradio" hidden checked></label>
							<label><input type="radio" name="optradio" value="1">★&emsp;</label>
							<label><input type="radio" name="optradio" value="2">★★&emsp;</label>
							<label><input type="radio" name="optradio" value="3">★★★&emsp;</label>
							<label><input type="radio" name="optradio" value="4">★★★★&emsp;</label>
							<label><input type="radio" name="optradio" value="5">★★★★★&emsp;</label>
						</div>
						<div>
							<span class="necessary">*</span><label for="review">点评内容</label>
							<textarea class="form-control" rows="6" id="review"
								placeholder="写下你的旅途感受吧"></textarea>
						</div>
						<br>
						<button type="submit" class="btn btn-primary">提交</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- 点评发布模态框E -->
	<!-- 点评列表S -->
	<h1>景点点评</h1>
	<p class="dtl">共有x条点评</p>
	<ul class="list-group">
		<li class="list-group-item">
			<div class="showreview">
				<div class="userscore">5分</div>
				<div class="username">用户名1</div>
				<div class="userreview">
					北京故宫是中国明清两代的皇家宫殿，旧称为紫禁城，位于北京中轴线的中心，是中国古代宫廷建筑之精华。是世界上现存规模最大、保存最为完整的木质结构古建筑之一。北京故宫被誉为世界五大宫之首，并被联合国科教文组织列为“世界文化遗产”。故宫之大难以言表，几次进入故宫均未走完。
				</div>
			</div>
		</li>
		<li class="list-group-item">
			<div class="showreview">
				<div class="userscore">5分</div>
				<div class="username">用户名2</div>
				<div class="userreview">点评2</div>
			</div>
		</li>
	</ul>
	<!-- 点评列表E -->
</div>