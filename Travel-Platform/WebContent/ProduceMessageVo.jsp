<%@ page language="java" import="java.util.*" pageEncoding="utf-8" info="产品详情"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<link rel="stylesheet" href=".\CSS\test.css" type="text/css">
  <head>
   
    
<!--     <title>My JSP 'messagetest.jsp' starting page</title> -->
    <style type="text/css">
    	li{ list-style-type:none }
    	div{padding:3px;}
    	
    	
    </style>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<%@ include file="/site-head.jsp"%>
  </head>
  
  <body >
 	<%@ include file="/site-header.jsp"%>
 	
 	
 	<div class="row">
 		<div class="col-md-1 col-lg-2 col-xl-3 " style="">
<!--  			<pre>left</pre> -->
 		
 		
 		</div>
 		
 		
 		<!--中间信息图层 start  -->
 		<div class="col-md-10 col-lg-8 col-xl-6 border " >
 			
 			
 			
 			<!-- 产品基本信息div -->
 			<div class="row ">
 				<div id="demo" class="col-6 carousel slide" data-ride="carousel" style="text-ai"> 
 					
 					<ul class="carousel-indicators">
    					
    					<%	
    						for(int i=0;i<(int)session.getAttribute("demo_num");i++){//打印<li>以达到轮播效果
    						
    						if(i == 0){
    							out.println("<li data-target='#demo' data-slide-to='"+i+"' class='active'></li>");
    						}else{
    							out.println("<li data-target='#demo' data-slide-to='"+i+"'></li>");
    						}
    		
    						
    						}
    					%>
    					
    					
 					 </ul>
 					
 					<div class="carousel-inner">
 						
 						<%	
    						for(int i=0;i<(int)session.getAttribute("demo_num");i++){//打印<img>以显示轮播图片
    						
    							if(i == 0){
    								out.println("<div class='carousel-item active'>");
    								out.println("<img id='' class='rounded mh-75 mw-100' src=\""+session.getAttribute("advertisingMapContent"+i)+"\" >");
    								out.println("</div>");
    							}else{
    								out.println("<div class='carousel-item'>");
        							out.println("<img id='' class='rounded mh-75 mw-100' src=\""+session.getAttribute("advertisingMapContent"+i)+"\" >");
        							out.println("</div>");
    							
    							
    							}
    		
    						
    						}
    					%>
    					
    					
    				
    					
 					</div>
 				</div>
 				<div class="col-6 card">
 					
 							<div class="card-body">
 								<div class="card-title">
 									<h5><span class="badge badge-primary"> 推广</span><s:property value="produce.getProduceTitle()"/></h5>
 								</div>
 							
 								<div class="card-text">
 									<h3 class="text-danger">￥<s:property value="produce.getProduceMinPrice()"/>~<s:property value="produce.getProduceMaxPrice()"/></h3>
 								</div>
 							</div>
 				</div>
 			</div>
 			
 			<div class="row"><!---->
 				<div class="col"><!--产品内容菜单-->
 					<nav id='navbar' class="navbar text-black text-left" >
 						<ul class="nav nav-tabs" id="produce_content">
 							<li  class="nav-item"><a class="nav-link active" href="#graphic_introduction">图文介绍 </a></li>
 							<li  class="nav-item"><a class="nav-link" href="#activity_arrangement">行程路线 </a></li>
 							<li  class="nav-item"><a class="nav-link " href="#produce_cost">费用说明 </a></li>
 							<li  class="nav-item"><a class="nav-link " href="#">购买须知 </a></li>
 							<li  class="nav-item"><a class="nav-link " href="#">用户点评 </a></li>
 						</ul>
 					</nav>	
 				</div>
 			</div>
 			
 			<!--菜单跟随 start  -->
 			<div id="pro_message" data-spy="scroll" data-target="#navbar" data-offset="50" class="Scrollspy">
 			
 			
 			<!-- 图文介绍 -->
 				<div class="row" id="graphic_introduction">
 				<div class="mw-0.5"  style="background-color: #1D4E89; height:1.5rem;">&nbsp;&nbsp;</div>
 				<h5>图文介绍</h5>
 				<%	
    						for(int i=0;i<(int)session.getAttribute("carousel_num");i++){//打印<img>以显示图文介绍
    							
    							out.println("<img id='' class='w-100 h-100' src=\""+session.getAttribute("graphicIntroductionContent"+i)+"\" >");
    						
    						
    		
    						
    						}
    			%>
 			
 				
 				
 				<br>
 				<br>
 			</div>
 			<br><br>
 			<!-- 图文介绍 -->
 			
 			
 	
 				
 				
 				
 				
 				
 				
 			
 			<!-- 行程路线 -->
 			
 			<!--费用说明  -->	
 			<div class="row" id="produce_cost">
 				<div class="mw-0.5"  style="background-color: #1D4E89; height:1.5rem;">&nbsp;&nbsp;</div>
 				<h5>费用说明</h5>
 				<div class="col-12">
 				
 				
 				<!--费用包含  -->
 				<div class="row">
 					
 					
 					<div class="col text-muted ">
 						<h6>费用包含</h6>
 						<span class=""><small>大交通</small></span>
 						<ul>
 							<%	//打印费用内容
 								if(((int)session.getAttribute("carFare")) == 1){
 									
 									out.println("<li><small>来往返回交通工具票</small></li>");
 									
 								}
 								if(((int)session.getAttribute("carFare")) == 2){
 									
 									out.println("<li><small>单程返回交通工具票</small></li>");
 								}
 								if(((int)session.getAttribute("carFare")) == 2){
 									
 									out.println("<li><small>此次旅程不包含来回交通费用，敬请注意</small></li>");
 								}
 								
 							
 							%>
 							
 						</ul>
 						<br>
 						<span class=""><small>住宿</small></span>
 						<ul>
 							<li><small>行程所列酒店住宿费用</small></li>
 							
 							<%
 								if(((int)session.getAttribute("accommodationFee")) == 0){
									
									out.println("<li><small>如报名人数无法安排相应客房，我们会安排拼房，且如果拼房不成功房差无需您自理；</small></li>");
								}
 								if(((int)session.getAttribute("accommodationFee")) == 1){
 									out.println("<li><small>如报名人数无法安排相应客房，我们会安排拼房，且如果拼房不成功房差需您自理；</small></li>");
 								
 								}
 							
 							%>
 						
 							
 							<li><small>附加费</small></li>
 						</ul>
 						<br>
 						
 						<span class=""><small>景点门票</small></span>
 						<ul>
 							
 							<li><small>行程中所列景点门票 </small></li>
 							<li><small>行程中所列景点首道门票、区间车。</small></li>
 							<%
 								if(((int)session.getAttribute("accommodationFee")) == 1){
 									out.println("<li><small>行程中所列景点娱乐项目门票 </small></li>");
 								}
 							 %>
 							
 							
 						</ul>
 						<br>
 						
 						<span class=""><small>导游服务</small></span>
 						<ul>
 							<% 
 								if(((int)session.getAttribute("guideFee")) == 1){
 							
 								out.println("<li><small>优秀老司机兼职导游（帮忙安排住宿、门票、推荐美食等，进景区讲解）</small> </li>");
 								}
 								else{
 									out.println("<li><small>优秀老司机兼职导游（帮忙安排住宿、门票、推荐美食等，不进景区讲解）</small> </li>");
 								}
 							
 							%>
 						</ul>
 						<br>
 						
 						
 						
 					</div>
 					
 				
 				
 				
 				
 				
 				</div>
 				<!--费用包含  -->
 				
 				
 				<!--费用不含  -->
 				<div class="row"><div class="col text-muted ">
 					<h6>费用不含</h6>
 					<span class=""><small>杂费</small></span>
 					<ul>
 						<li><small>因交通延阻、罢工、天气、飞机、机器故障、航班取消或更改时间等不可抗力原因所导致的额外费用</small></li>
 						<li><small>酒店内洗衣、理发、电话、传真、收费电视、饮品、烟酒等个人消费</small></li>
 						<li><small>一切个人消费及费用包含中未提及的任何费用</small></li>
 					</ul>
 					<br>
 					<%
 						if((int)session.getAttribute("landmarkTicket") == 0){
 							
 							out.println("<span class=''><small>景点门票</small></span>");
 		 					out.println("<ul>");
 							out.println("<li><small>不含所有娱乐项目 </small></li>");
 							out.println("<//ul>");
 							out.println("<br>");
 		 						
 		 					
 		 					
 							
 						}
 					
 					
 					%>
 					<span class=""><small>餐食</small></span>
 					<ul>
 						<%if((int)session.getAttribute("mealsCost") == 0){
 							out.println("<li><small>全程不含用餐，敬请自理。</small></li>");
 						
 						
 						}
 						else if((int)session.getAttribute("mealsCost") == 1){
 							out.println("<li><small>全程含用餐</small></li>");
 							
 							
 						}
 						else{
 							out.println("<li><small>全程部分含用餐，敬请注意</small></li>");
 							
 						}
 						
 						
 						
 						%>
 						
 						
 					</ul>
 					<br>
 				</div></div>
 				<!--费用不含  -->
 				
 				
 				
 			</div>
 			
 			
 			
 			
 		
 			
 		
 		
 		
 		</div>
 		<!--费用说明  -->	
 		
 		
 		<!-- 购买须知  -->
 		<div class="row" id="purchase_note">
 					<div class="mw-0.5"  style="background-color: #1D4E89; height:1.5rem;">&nbsp;&nbsp;</div>
 					<h5>购买须知</h5>
 					
 					<div class="col-12 text-muted" id="test " style="margin-left:1rem">
 						<h6>取消政策</h6>
 						<p><small>不可退</small></p>
 						<p><small>此商品预订成功后不可取消，敬请谅解。</small></p> 
 					
 					
 					</div>
 					<div class="col-12 text-muted">
 						<h6>产品服务信息</h6>
 						
 						<p><small>该旅游产品由 张家界观世界国际旅行社有限公司 提供</small></p> 
 					
 					
 					</div>
 		
 		 </div>
 		<!-- 购买须知  -->
 		
 		
 		
 		
 		
 		
 		</div>
 		</div>
 		
 		<!--菜单跟随 end -->
 		
 		</div>
 		<!--中间信息图层 end  -->
 		
 		
 		
 		
 		
 		<div class="col-md-1 col-lg-2 col-xl-3">
<!-- 		<pre>right</pre>	 -->
		</div>
		
		
 	</div>
 	
 	
 	<!--网页页脚  -->
 	<div class="row bg-primary">
 		<div class="col-12">
 			<%@ include file="/site-footer.jsp"%>
 			
 			
 		</div>
 	</div>
 	<!--网页页脚  -->
 	
  
  </body>
</html>
