/**
 * @author 古学懂_Victor
 */
var getNoteHtml = function () {
	var x = document.getElementsByTagName("iframe")[0].contentWindow;
	var noteHtml = x.document.getElementById("editor").innerHTML;
	return noteHtml;
}

// 最终的地区ID
var regionId = 0;
// 从大洲列表开始初始化
var regionInit = function () {
	// 清除子列表
	for (var i = 2; i <= 5; i++) {
		if ($("#region-" + i).length > 0)
			$("#region-" + i).remove();
	}
	$.ajax({
		type: "post",
		url: "/Travel-Platform/region_listContinents.action",
		data: {},
		success: function (data) {
			for (var i = 0; i < data.regions.length; i++) {
				$('#region-1').append(
					"<option value='" + data.regions[i].id + "' >"
					+ data.regions[i].name + "</option>");
			}
		},
		error: function () {
			alert("加载地区失败");
		}
	});
}
// 获取各级子地区列表
var regionChange = function (rank) {
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
	regionId = pId;
	$.ajax({
		type: "post",
		url: "/Travel-Platform/region_listChildren.action",
		data: {
			"pid": pId
		},
		success: function (data) {
			// 如果子列表不存在，即最终级地区
			if (data.regions <= 0) {
				regionId = pId;
				$("#region-name").text(pName);
				console.log(regionId);
				return;
			}
			console.log(pName);
			$("#region-list").append(
				"<select class=\"form-control my-2\" id=\"region-"
				+ rank + "\" name=\"region-" + rank
				+ "\" onchange=\"regionChange(" + rank
				+ ")\"></select>");
			$("#region-" + rank).append(
				"<option selected=\"selected\" value=\"-1\">请选择...</option>");
			for (var i = 0; i < data.regions.length; i++) {
				$('#region-' + rank).append(
					"<option value='" + data.regions[i].id + "' >"
					+ data.regions[i].name + "</option>");
			}
		},
		error: function () {
			alert("加载地区失败");
		}
	});
}
/** 保存游记 */
var post = function () {
	$("#post-spinner").css("display", "inline-block");
	$("#post-success").css("display", "none");
	// 将地区id值注入表单
	$("#regionId").val(regionId);
	// 将内容注入表单
	$("#noteContent").val(getNoteHtml());
	if ($("#noteHeader").text() == null) {
		$("#noteHeader").text('未命名游记');
	}
	console.log($("#regionId").val());
	$.ajax({
		type: "POST",
		dataType: "json",
		url: "/Travel-Platform/note_insert.action",
		data: $('#note').serialize(),
		success: function (data) {
			$("#post-spinner").css("display", "none");
			$("#post-success").css("display", "inline-block");
			console.log(data);
			window.location.href = "/Travel-Platform/n/post.jsp?noteId="
				+ data.noteId;
		},
		error: function () {
			$("#post-spinner").css("display", "none");
			alert("发布失败！");
		}
	});
}
var saveDraft = function () {
	alert("功能未完善");
}

$(function () {
	var date = '';
	/**开始日期 */
	$("#date").datepicker({
		format: "yyyy-mm-dd",
		maxViewMode: 2,
		todayBtn: "linked",
		clearBtn: true,
		language: "zh-CN"
	}).on(
		"changeDate",
		function (e) {
			if (e.date) {
				$("#endDate").datepicker('setStartDate',
					new Date(e.date.valueOf()))
			} else {
				$("#endDate").datepicker('setStartDate', null);
			}
		});
	/**结束日期，在开始日期之后 */
	$("#endDate").datepicker({
		format: "yyyy-mm-dd",
		maxViewMode: 2,
		todayBtn: "linked",
		clearBtn: true,
		language: "zh-CN"
	}).on(
		"changeDate",
		function (e) {
			if (e.date) {
				$("#startDate").datepicker('setEndDate',
					new Date(e.date.valueOf()))
			} else {
				$("#startDate").datepicker('setEndDate', new Date());
			}
		});
});