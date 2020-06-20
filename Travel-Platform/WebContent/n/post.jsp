<%@page import="cn.edu.bitzh.tp.service.INoteService"%>
<%@page import="cn.edu.bitzh.tp.service.impl.NoteService"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="cn.edu.bitzh.tp.model.Note"%>
<%@page import="cn.edu.bitzh.tp.model.Region"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Set"%>
<%@page
	import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" info="游记"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String noteId = request.getParameter("noteId");
	System.out.println(noteId);
	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
	INoteService ns = (NoteService) applicationContext.getBean("noteService");
	Note note = ns.get(Integer.parseInt(noteId));
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
%>
<!DOCTYPE html>
<html>

<head>
<%--导入站点全局首部--%>
<%@ include file="/site-head.jsp"%>
</head>

<body>
	<header>
		<%@ include file="/site-header.jsp"%>
	</header>
	<div class="container-fluid">
		<div class="row align-items-start">
			<img src="<%="/Travel-Platform/_img/青岛_樱花.png"%>" class="img-fluid"
				alt="头图">
		</div>
		<hr>
		<div class="row">
			<div class="col-sm-1"></div>
			<div class="col-6 col-lg-8">
				<%
					if (note != null) {
				%>
				<div class="jumbotron jumbotron-fluid"
					style="background-color: <%="#F0EDE5"%>;">
					<div class="container">
						<h1 class="display-4"><%=note.getNoteDtl().getNoteHeader()%></h1>
						<p class="lead"></p>
						<hr class="my-4">
						<div id="note-content">
							<%=note.getNoteDtl().getNoteContent()%>
						</div>
					</div>
				</div>
				<%
					;
					}
				%>
			</div>
			<div class="col-3 col-lg-3" id="cards-flows">
				<%
					Set<Region> regions = note.getRegions();
					Iterator<Region> it = regions.iterator();
					while (it.hasNext()) {
						Region region = it.next();
						String regionName = region.getName();
						String pRegionName;
				%>
				<div class="card" style="width: 18rem;">
					<img src="<%="/Travel-Platform/_img/青岛_樱花.png"%>"
						class="card-img-top" alt="<%=regionName%>">
					<div class="card-body">
						<h5 class="card-title"><%=regionName%></h5>
						<p class="card-text"><%="描述"%></p>
						<a href="#" class="btn btn-primary">查看景点</a>
					</div>
				</div>
				<hr>
				<%
					;
					}
				%>
				<!-- 				<div class="card text-white bg-info mb-3" style="max-width: 18rem;"> -->
				<%-- 					<div class="card-header"><%="景点"%></div> --%>
				<!-- 					<div class="card-body"> -->
				<!-- 						<h5 class="card-title">景点1</h5> -->
				<!-- 						<p class="card-text">描述</p> -->
				<!-- 					</div> -->
				<!-- 					<div class="card-body"> -->
				<!-- 						<h5 class="card-title">景点2</h5> -->
				<!-- 						<p class="card-text">描述</p> -->
				<!-- 					</div> -->
				<!-- 				</div> -->
				<%
					if (note.getTravelDate() != null) {
				%>
				<div class="card text-white bg-info mb-3" style="max-width: 18rem;">
					<div class="card-header">开始时间</div>
					<div class="card-body" id="">
						<h5 class="card-title" id="">
							<%=sdf.format(note.getTravelDate())%>
						</h5>
					</div>
				</div>
				<%
					;
					}
					if (note.getEndDate() != null) {
				%>
				<div class="card text-white bg-info mb-3" style="max-width: 18rem;">
					<div class="card-header">结束时间</div>
					<div class="card-body" id="">
						<h5 class="card-title" id="">
							<%=sdf.format(note.getEndDate())%>
						</h5>
					</div>
				</div>
				<%
					;
					}
					if (note.getApplicable() != null) {
				%>
				<div class="card text-white bg-info mb-3" style="max-width: 18rem;">
					<div class="card-header">适宜人群</div>
					<div class="card-body" id="">
						<h5 class="card-title" id=""><%=note.getApplicable()%></h5>
					</div>
				</div>
				<%
					;
					}
				%>
			</div>
		</div>
	</div>
	<button id="like-button" type="button" class="btn btn-light float-left"
		onclick="like()">
		<img alt="like" src="/Travel-Platform/_img/like.svg">
	</button>
	<button id="favourites-button" type="button"
		class="btn btn-light float-left" onclick="favourites()">
		<img alt="like" src="/Travel-Platform/_img/favourites.svg">
	</button>
	<footer>
		<%@ include file="/site-footer.jsp"%>
	</footer>
</body>
</html>