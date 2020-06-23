/**
 * @author 古学懂_Victor（原作者）
 * @author 陈君锐
 */
var getNoteHtml = function() {
	var x = document.getElementsByTagName("iframe")[0].contentWindow;
	var noteHtml = x.document.getElementById("editor").innerHTML;
	return noteHtml;
}

// 最终的地区ID
var regionId = 0;
// 从大洲列表开始初始化
var regionInit = function() {
	// 清除子列表
	for (var i = 2; i <= 5; i++) {
		if ($("#region-" + i).length > 0)
			$("#region-" + i).remove();
	}
	$.ajax({
		type : "post",
		url : "/Travel-Platform/region_listContinents.action",
		data : {},
		success : function(data) {
			for (var i = 0; i < data.regions.length; i++) {
				$('#region-1').append(
						"<option value='" + data.regions[i].id + "' >"
								+ data.regions[i].name + "</option>");
			}
		},
		error : function() {
			alert("加载地区失败");
		}
	});
}
// 获取各级子地区列表
var regionChange = function(rank) {
	rank += 1;
	console.log(rank);
	// 获取父级地区ID
	var pId = $("#region-" + (rank - 1) + "").val();
	// 获取父级地区名
	var pName = $("#region-" + (rank - 1) + "").find("option:selected").text();
	// 清除子列表
	for (var i = rank; i <= 5; i++) {
		if ($("#region-" + i).length > 0)
			$("#region-" + i).remove();
	}
	$.ajax({
		type : "post",
		url : "/Travel-Platform/region_listChildren.action",
		data : {
			"pid" : pId
		},
		success : function(data) {
			if (data.regions <= 0) {
				regionId = pId;
				//$("#region-name").text(pName);
				console.log(regionId);
				return;
			}
			console.log(pName);
			$("#region-list").append(
					"<select class=\"form-control my-2\" id=\"region-" + rank
							+ "\" name=\"publish_scenery_region_" + rank
							+ "\" onchange=\"regionChange(" + rank + ")\"></select>");
			$("#region-" + rank).append(
					"<option selected=\"selected\" value=\"-1\">请选择...</option>");
			for (var i = 0; i < data.regions.length; i++) {
				$('#region-' + rank).append(
						"<option value='" + data.regions[i].id + "' >"
								+ data.regions[i].name + "</option>");
			}
		},
		error : function() {
			alert("加载地区失败");
		}
	});
}

function publishScenery(){
	var name = document.getElementById("publish_scenery_name").value.trim();
	var dtl = document.getElementById("publish_scenery_dtl").value.trim();
	var region = document.getElementById("region-1").value.trim();
	var location = document.getElementById("publish_scenery_location").value.trim();
	if(name == ""){
		alert("请填写景点名称");
		return false;
	}
	if(dtl == ""){
		alert("请填写景点内容");
		return false;
	}
	if(region == -1){
		alert("请选择景点地区");
		return false;
	}
	if(location == ""){
		alert("请填写景点位置");
		return false;
	}

	var nameIsN = Number(name);
	var dtlIsN = Number(dtl);
	var locationIsN = Number(location);
	if( !isNaN(nameIsN) ){
		alert("景点名称不能只为数字");
		return false;
	}
	if( !isNaN(dtlIsN) ){
		alert("景点内容不能只为数字");
		return false;
	}
	if( !isNaN(locationIsN) ){
		alert("景点位置不能只为数字");
		return false;
	}
	
	var phone = document.getElementById("publish_scenery_phone").value.trim();
	if ( phone != ""){
		if ( isNaN(phone)){
			var phoneValidation = /^([0-9])+-+([0-9]{1,8})$/;
			if ( phoneValidation.test(phone) == false){
				alert("手机填写错误");
				return false;
			}
		}else{
			if( phone.toString().length > 11 )
				alert("手机填写错误");
				return false;
		}
	}
		
	var email = document.getElementById("publish_scenery_email").value.trim();
	var emailValidation = /^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/;
	if( email != ""){
		if( emailValidation.test(email) == false ){
			alert("邮箱填写错误");
			return false;
		}
	}
	alert("发布成功");
	return true;
}
