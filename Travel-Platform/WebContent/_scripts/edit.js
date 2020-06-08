/**
 * @author 古学懂_Victor
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
		url : "/Travel-Platform/region.action",
		data : {
			"type" : "listContinents"
		},
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
		url : "/Travel-Platform/region.action",
		data : {
			"type" : "listChildren",
			"pid" : pId
		},
		success : function(data) {
			if (data.regions <= 0) {
				regionId = pId;
				$("#region-name").text(pName);
				console.log(regionId);
				return;
			}
			console.log(pName);
			$("#region-list").append(
					"<select class=\"form-control my-2\" id=\"region-" + rank
							+ "\" name=\"region-" + rank
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