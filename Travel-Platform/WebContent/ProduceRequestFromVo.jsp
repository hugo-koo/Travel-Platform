<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
</style>
<script type="text/javascript">
	var i = 0;
	function addDay() {

		i = document.getElementById("costday").value;
		var ch = document.getElementById("activities_div");
		//ch.innerHTML = "<div class='col-12'>

		alert(ch.value);

	}
</script>






<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/site-head.jsp"%>

<title>Insert title here</title>
</head>
<body>
	<%@ include file="/site-header.jsp"%>

	<div class="row">

		<div class="col-md-1 col-lg-2 col-xl-3">right</div>
		<div class="col-md-10 col-lg-8 col-xl-6 border bg-light ">

			<s:form method="post" action="produce_request" namespace="/"
				enctype="multipart/form-data">
				<!--基本信息栏  -->
				<h5>基本信息</h5>
				<div class="row" id="">

					<div class="col-6">
						<div class="form-group">
							<label for="produceTitle">产品标题：</label> <input type="text"
								class="form-control" id="produceTitle" name="produceTitle"></input>

						</div>
					</div>

					<div class="col-6">
						<div class="form-group pl-0">
							<label for="produceTelephone">订票电话：</label> <input type="text"
								class="form-control" id="produceTelephone"
								name="produceTelephone"></input>

						</div>
					</div>


				</div>




				<div class="row">
					<div class="col-6">
						<div class="form-group">
							<label>价格区间： </label> <input type="text" class="form-control"
								id="produceMinPrice" name="produceMinPrice" placeholder="min">
						</div>
					</div>
					<div class="col-6">
						<div class="form-group">
							<label> ￥</label> <input type="text" class="form-control"
								id="produceMaxPrice" name="produceMaxPrice" placeholder="max">
						</div>


					</div>
				</div>

				<div class="row">
					<div class="col-6">
						<div class="form-group">

							<label for="sel1"> 旅行天数:</label> <select class="form-control"
								id="produceCostDay" name="produceCostDay" onchange="addDay()">
								<option>0</option>
								<option>1</option>
								<option>2</option>
								<option>3</option>
								<option>4</option>
								<option>5</option>
								<option>6</option>
								<option>7</option>
								<option>8</option>
								<option>9</option>
								<option>10</option>
								<option>11</option>
								<option>12</option>
								<option>13</option>
								<option>14</option>
								<option>15</option>
								<option>16</option>
								<option>17</option>
								<option>18</option>
								<option>19</option>
								<option>20</option>
								<option>21</option>
								<option>23</option>
								<option>24</option>
								<option>25</option>
								<option>26</option>
								<option>27</option>
								<option>28</option>
								<option>29</option>
								<option>30</option>
							</select>



						</div>
					</div>
					<div class="col-6">
						<label> 始发地</label> <input type="text" class="form-control"
							id="produceLindisfarne" name="produceLindisfarne" placeholder="">
					</div>

				</div>
				<br>
				<br>
				<!--基本信息栏  -->

				<!-- 行程安排 -->


				<!-- 费用说明 -->
				<h5>费用说明</h5>
				<div class="row">
					<div class="col-12 ">
						<div class="row">
							<div class="col-3">
								<label>餐食费用：</label>
							</div>
							<div class="col-3">
								<input type="radio" name="mealsCost" value="0" class="mr-3">不包含
							</div>
							<div class="col-3">
								<input type="radio" name="mealsCost" value="1" class="mr-3">全包含
							</div>
							<div class="col-3">
								<input type="radio" name="mealsCost" value="2" class="mr-3">部分包含
							</div>
						</div>
					</div>

					<div class="col-12">
						<div class="row">
							<div class="col-3">
								<label>住宿费用：</label>
							</div>
							<div class="col-3">
								<input type="radio" name="accommodationFee" value="0"
									class="mr-3">补偿房差
							</div>
							<div class="col-3">
								<input type="radio" name="accommodationFee" value="1"
									class="mr-3">不补房差
							</div>
						</div>
					</div>
					<div class="col-12">
						<div class="row">
							<div class="col-3">
								<label>景点门票：</label>
							</div>
							<div class="col-3">
								<input type="radio" name="landmarkTicket" value="0" class="mr-3">只含门票&nbsp;&nbsp;&nbsp;&nbsp;
							</div>
							<div class="col-3">
								<input type="radio" name="landmarkTicket" value="1" class="mr-3">含娱乐项目&nbsp;&nbsp;&nbsp;&nbsp;
							</div>
						</div>
					</div>

					<div class="col-12">
						<div class="row">
							<div class="col-3">
								<label>往来交通：</label>
							</div>
							<div class="col-3">
								<input type="radio" name="carFare" value="0" class="mr-3">不包含&nbsp;&nbsp;&nbsp;&nbsp;
							</div>
							<div class="col-3">
								<input type="radio" name="carFare" value="1" class="mr-3">含往返交通&nbsp;&nbsp;&nbsp;&nbsp;
							</div>
							<div class="col-3">
								<input type="radio" name="carFare" value="2" class="mr-3">含单程返程
							</div>
						</div>
					</div>
					<div class="col-12">
						<div class="row">
							<div class="col-3">
								<label>导游服务：</label>
							</div>
							<div class="col-3">
								<input type="radio" name="guideFee" value="0" class="mr-3">含景点讲解&nbsp;&nbsp;&nbsp;&nbsp;
							</div>
							<div class="col-3">
								<input type="radio" name="guideFee" value="1" class="mr-3">不含讲解&nbsp;&nbsp;&nbsp;&nbsp;
							</div>
						</div>


					</div>
				</div>
				<!-- 费用说明 -->
				<br>
				<br>
				<!-- 图文介绍 -->
				<div class="row">
					<div class="col-6" id="">
						<h5>图文介绍</h5>
						<input type="file" id="graphicIntroduction"
							name="graphicIntroduction" multiple="multiple">


					</div>
					<div class="col-6" id="">
						<h5>宣传图</h5>
						<input type="file" id="advertisingMap" name="advertisingMap"
							multiple="multiple">


					</div>
				</div>







				<br>
				<br>
				<br>
				<div class="row">
					<div class="col-6 text-right">
						<input type="reset" class="btn btn-info " value="重置">
					</div>
					<div class="col-6">
						<input type="submit" class="btn btn-info" value="提交">
					</div>


				</div>

			</s:form>

		</div>
		<!-- 中间图层结束div -->








		<!-- 行程安排 -->








		<div class="col-md-1 col-lg-2 col-xl-3">left</div>


		<br> <br> <br>
	</div>

	<%@ include file="/site-footer.jsp"%>






</body>
</html>