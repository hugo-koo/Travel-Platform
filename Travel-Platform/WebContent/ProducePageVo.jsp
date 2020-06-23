<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" info="去旅行" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/site-head.jsp"%>
<title>旅游产品展示</title>
</head>
<body>
	<%@ include file="/site-header.jsp"%>
	<div class="row">
		<div class="col-md-1 col-lg-2 col-xl-3"><pre> </pre></div>

		<div class="col-md-10 col-lg-8 col-xl-6 border bg-light ">

			<br> <br>
			 <a href="${pageContext.request.contextPath}/ProduceRequestFromVo.jsp" class="btn btn-primary">产品申请</a>
			<hr class="bg-warning">
			<div class="row">

				<div class="col-12">
					<!-- 根据当前页数据量打印产品展示 card-->
					<%!int z;%>
					<%!int pageNum; %>
					<%!int flag; %>
					<%	pageNum=(int) session.getAttribute("pageNum");
						for (z = 0; z < (int) session.getAttribute("onePageSize"); z++) {
							flag=pageNum*(z+1);
							System.out.println("flag为"+flag);
					%>
					<%
						if (z == 0) {	
							
					%>

					<div class="col-12">
						<div class="card">
							<div class="row no-gutters">

								<div class="col-4">
									<!-- 打印产品展示 信息-->
									<img
										src="<s:property value='producePage.getAdvertisingMap().get(0)'/>"
										alt="..." class="card-img">
								</div>
								<div class="col-8">
									<div class="card-body">
										<h5 class="card-title">
											<a class="text-dark"
												href="produce_show.action?produceIdIn=<%=flag %>"> <s:property
													value="producePage.getPageList().get(0).getProduceTitle()" />

											</a>
										</h5>

										<p class="card-text text-warning">
											￥
											<s:property
												value="producePage.getPageList().get(0).getProduceMinPrice" />
											起
										</p>

									</div>
								</div>
							</div>
						</div>

					</div>
					<%
						;
							}
					%>
					<%
						if (z == 1) {
					%>

					<div class="col-12">
						<div class="card">
							<div class="row no-gutters">

								<div class="col-4">

									<img
										src="<s:property value='producePage.getAdvertisingMap().get(1)'/>"
										alt="..." class="card-img">
								</div>
								<div class="col-8">
									<div class="card-body">
										<h5 class="card-title">
											<a class="text-dark"
												href="produce_show.action?produceIdIn=<%=flag%>"> <s:property
													value="producePage.getPageList().get(1).getProduceTitle()" />
											</a>
										</h5>
										<p class="card-text text-warning">
											￥
											<s:property
												value="producePage.getPageList().get(1).getProduceMinPrice" />
											起
										</p>
									</div>
								</div>
							</div>
						</div>
					</div>
					<%
						;
							}
					%>
					<%
						if (z == 2) {
					%>
					<div class="col-12">
						<div class="card">
							<div class="row no-gutters">

								<div class="col-4">

									<img
										src="<s:property value='producePage.getAdvertisingMap().get(2)'/>"
										alt="..." class="card-img">
								</div>
								<div class="col-8">
									<div class="card-body">
										<h5 class="card-title">
											<a class="text-dark"
												href="produce_show.action?produceIdIn=<%=flag%>"> <s:property
													value="producePage.getPageList().get(2).getProduceTitle()" />

											</a>
										</h5>

										<p class="card-text text-warning">
											￥
											<s:property
												value="producePage.getPageList().get(2).getProduceMinPrice" />
											起
										</p>

									</div>
								</div>
							</div>
						</div>

					</div>
					<%
						;
							}
					%>
					<%
						if (z == 3) {
					%>

					<div class="col-12">
						<div class="card">
							<div class="row no-gutters">

								<div class="col-4">

									<img
										src="<s:property value='producePage.getAdvertisingMap().get(3)'/>"
										alt="..." class="card-img">
								</div>
								<div class="col-8">
									<div class="card-body">
										<h5 class="card-title">
											<a class="text-dark"
												href="produce_show.action?produceIdIn=<%=flag%>"> <s:property
													value="producePage.getPageList().get(3).getProduceTitle()" />

											</a>
										</h5>

										<p class="card-text text-warning">
											￥
											<s:property
												value="producePage.getPageList().get(3).getProduceMinPrice" />
											起
										</p>

									</div>
								</div>
							</div>
						</div>

					</div>
					<%
						;
							}
					%>
					<%
						if (z == 4) {
					%>
					<div class="col-12">
						<div class="card">
							<div class="row no-gutters">

								<div class="col-4">

									<img
										src="<s:property value='producePage.getAdvertisingMap().get(4)'/>"
										alt="..." class="card-img">
								</div>
								<div class="col-8">
									<div class="card-body">
										<h5 class="card-title">
											<a class="text-dark"
												href="produce_show.action?produceIdIn=<%=flag%>"> <s:property
													value="producePage.getPageList().get(4).getProduceTitle()" />

											</a>
										</h5>

										<p class="card-text text-warning">
											￥
											<s:property
												value="producePage.getPageList().get(4).getProduceMinPrice" />
											起
										</p>

									</div>
								</div>
							</div>
						</div>

					</div>
					<%
						;
							}
							;
						}
					%>
				</div>
			</div>
			<br> <br>
			<div class="row">
				<div class="col-12">
					<ul class="pagination">
						<li class="page-item"><a class="page-link"
							href=" ${pageContext.request.contextPath}/produce_page.action?currPage=1 ">首页</a>
						</li>
						<%!int j = 0;%>
						<%!int k;%>
						<%
							k = (int) session.getAttribute("pageNum");
						%>
						<li class="page-item">
							<!-- 根据当前页码打印上一页链接-->
							<!-- 如果当前页码小于等于一，上一页跳转到第一页-->
							<%if (k<=1) {%>
								<a class="page-link" href=" ${pageContext.request.contextPath}/produce_page.action?currPage=1 ">上一页</a>
							<%} %>
							<!-- 如果当前页码大于一，上一页正常跳转-->
							<%if (k>1) {%>
								<a class="page-link" href=" ${pageContext.request.contextPath}/produce_page.action?currPage=<%=k-1%> ">上一页</a>
							<% }%>
						</li>
						<!-- 打印页面跳转链接-->
						<%
							for (j = 1; j < (int) session.getAttribute("totalPage") + 1; j++) {
						%>
						<li class="page-item">
							<a class="page-link" href="${pageContext.request.contextPath}/produce_page.action?currPage=<%= j%> "><%= j%></a>
						</li>
						<%
							}
						%>
						<!-- 根据当前页码打印下一页链接-->

						<li class="page-item">
							<%if (k<(int)session.getAttribute("totalPage")) {%>
								<a class="page-link" href=" ${pageContext.request.contextPath}/produce_page.action?currPage=<%=k+1%>">下一页</a>
							<%} %>
							<%if (k==(int)session.getAttribute("totalPage")) {%>
								<a class="page-link" href=" ${pageContext.request.contextPath}/produce_page.action?currPage=<%=k%> ">下一页</a>
							<% }%>
							<%if (k>(int)session.getAttribute("totalPage")) {%>
								<a class="page-link" href=" ${pageContext.request.contextPath}/produce_page.action?currPage=<%=(int)session.getAttribute("totalPage")%> ">下一页</a>
							<% }%> 
							
						</li>
						<li class="page-item"><a class="page-link"
							href=" ${pageContext.request.contextPath}/produce_page.action?currPage=<s:property value='producePage.getTotalPage()'/> ">尾页</a>
						</li>
					</ul>
				</div>
			</div>
		</div>
		<div class="col-md-1 col-lg-2 col-xl-3"><pre> </pre></div>
	</div>
	<%@ include file="/site-footer.jsp"%>
</body>
</html>