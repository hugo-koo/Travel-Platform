<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" info="景点"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>

<head>
    <%--导入站点全局首部--%>
    <%@ include file="/site-head.jsp"%>
    <style>
    	.breadcrumb{
    		background-color: #e0ddd4;
    	}
    
    	.overview img{
    		margin: 0 auto;
    		width: 100%
    	}
    	.dtl{
			font-size: 14px;
			color: #707070
    	}
    	.necessary{
    		color: red;
    	}
    	
    	.username{
    		line-height: 36px;
    	}
    	.userscore{
    		position: absolute;
    		top: 20px;
    		left: 200px;
    	}
    	.userreview{
    	}
    </style>
</head>

<body>
    <%@ include file="/site-header.jsp"%>
	
	<div class="container-fluid">
		<div class="row">
			<div class="col-2">左</div>
			<div class="col-8" style="border: 1px solid #e0ddd4">
				<!-- 景点概述S -->
				<div id="scenery">
					<table>
					<div>
						<h1 class="display-4"><%="故宫2"%></h1>
						<p class="dtl">总体评分x.x</p>
					</div>
					<hr>
					<div class="overview">
					    <p>景点内容信息<br>
					    	·又名紫禁城，是中国乃至世界上保存最完整，规模最大的木质结构古建筑群，被誉为“世界五大宫之首”。<br>
							·内廷以乾清宫、交泰殿、坤宁宫后三宫为中心，以及东西两侧的东六宫和西六宫，是封建帝王与后妃居住之所，也就是俗称的“三宫六院”。<br>
							<img src="/Travel-Platform/_img/青岛_樱花.png"><br>
							·故宫内珍藏有大量珍贵文物，据统计有上百万件，占全国文物总数的六分之一。钟表馆每天11点和14点有钟表演示，不可错过。<br>
							·故宫需要从南到北参观，午门是唯一的入口，出口是东华门和神武门。<br>
						</p>
					</div><hr>
					<div>
						景点位置
						<p class="dtl">某省某市某区某地点</p>
					</div><hr>
					<div>
						联系方式
					    <p class="dtl">电话：12341234123
						<p class="dtl">邮箱：123_abc@qq.com
				    </div><hr>
					<div>
						<p>发布子景点（X）</p>
					    <ul>
							<li class="ms-ContextualMenu-item"><a
								class="ms-ContextualMenu-link" tabindex="1" href="#">子景点</a></li>
						</ul>
					</div><hr>
					</table>
				</div>
				<!-- 景点概述E -->
				<!-- 点评S -->
				<%@ include file="/scenery/review.jsp"%>
				<!-- 点评E -->
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