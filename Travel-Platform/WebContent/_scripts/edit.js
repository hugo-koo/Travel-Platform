/**
 * @author 古学懂_Victor
 */
/** 头图 */
var toppic = '';

var getNoteHtml = () => {
	var x = document.getElementsByTagName("iframe")[0].contentWindow;
	var noteHtml = x.document.getElementById("editor").innerHTML;
	return noteHtml;
}

/** 最终的地区ID */
var regionId = 0;
/** 从大洲列表开始初始化 */
var regionInit = () => {
	/** 清除子列表 */
	for (var i = 2; i <= 5; i++) {
		if ($("#region-" + i).length > 0)
			$("#region-" + i).remove();
	}
	$.ajax({
		type: "post",
		url: "/Travel-Platform/region_listContinents.action",
		data: {},
		success: (data) => {
			for (var i = 0; i < data.regions.length; i++) {
				$('#region-1').append(
					"<option value='" + data.regions[i].id + "' >"
					+ data.regions[i].name + "</option>");
			}
		},
		error: () => {
			alert("加载地区失败");
		}
	});
}

/** 获取各级子地区列表 */
var regionChange = (rank) => {
	rank += 1;
	console.log(rank);
	/** 获取父级地区ID */
	var pId = $("#region-" + (rank - 1) + "").val();
	/** 获取父级地区名 */
	var pName = $("#region-" + (rank - 1) + "").find("option:selected").text();
	/** 清除子列表 */
	for (var i = rank; i <= 5; i++) {
		if ($("#region-" + i).length > 0)
			$("#region-" + i).remove();
	}
	$("#region-name").text(pName);
	regionId = pId;
	$.ajax({
		type: "post",
		url: "/Travel-Platform/region_listChildren.action",
		data: {
			"pid": pId
		},
		success: (data) => {
			/** 如果子列表不存在，即最终级地区 */
			if (data.regions <= 0) {
				regionId = pId;
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
				"<option selected=\"selected\" value=\"-1\">选择地区（非必选）...</option>");
			for (var i = 0; i < data.regions.length; i++) {
				$('#region-' + rank).append(
					"<option value='" + data.regions[i].id + "' >"
					+ data.regions[i].name + "</option>");
			}
		},
		error: () => {
			alert("加载地区失败");
		}
	});
}

/** 保存游记 */
var post = () => {
	// 将地区id值注入表单
	$("#regionId").val(regionId);
	// 将内容注入表单
	$("#noteContent").val(getNoteHtml());
	if ($("#noteHeader").text() == "") {
		$("#noteHeader").text('未命名游记');
	}
	// 注入头图文件
	$("#toppic-input").val(toppic);
	var toppicElm = document.getElementById('toppic');
	// 构建FormData对象
	var noteForm = document.getElementById("note");
	var noteFormData = new FormData(noteForm);
	// 校验数据并进入待保存状态
	if (validate()){
		$("#post-spinner").css("display", "inline-block");
		$("#post-success").css("display", "none");
		$.ajax({
			type: "POST",
			dataType: "json",
			url: "/Travel-Platform/note_insert.action",
            // data: $('#note').serialize(),
			data: noteFormData,
			contentType: false,
			processData: false,
			success: (data) => {
				$("#post-spinner").css("display", "none");
				$("#post-success").css("display", "inline-block");
				console.log(data);
				window.location.href = "/Travel-Platform/note/" + data.noteId;
			},
			error: () => {
				$("#post-spinner").css("display", "none");
				alert("发布失败！");
			}
		});
	}
}

/** 校验器 */
var validate = () => {
	var finish = true;
	if ($("#date").val() == "") {
		$("#date").after('<div class="error" id="date-error">--开始时间未填写--</div>');
		finish = false;
	}
	if ($("#endDate").val() == "") {
		$("#endDate").after('<div class="error" id="end-date-error">--结束时间未填写--</div>');
		finish = false;
	}
	if ($("#noteHeader").val() == "") {
		$("#noteHeader").after('<div class="error" id="header-error">--标题未填写--</div>');
		finish = false;
	}
	return finish;
}

var saveDraft = () => {
	alert("功能未完善");
}

$(() => {
	var date = '';
	// 开始日期
	$("#date").datepicker({
		format: "yyyy-mm-dd",
		maxViewMode: 2,
		todayBtn: "linked",
		clearBtn: true,
		language: "zh-CN"
	}).on(
		"changeDate",
		(e) => {
			if (e.date) {
				$("#endDate").datepicker('setStartDate',
					new Date(e.date.valueOf()))
			} else {
				$("#endDate").datepicker('setStartDate', null);
			}
		});
	// 结束日期，在开始日期之后
	$("#endDate").datepicker({
		format: "yyyy-mm-dd",
		maxViewMode: 2,
		todayBtn: "linked",
		clearBtn: true,
		language: "zh-CN"
	}).on(
		"changeDate",
		(e) => {
			if (e.date) {
				$("#startDate").datepicker('setEndDate',
					new Date(e.date.valueOf()))
			} else {
				$("#startDate").datepicker('setEndDate', new Date());
			}
		});
	
	$("input").focus(() => {
		$(".error").remove();
	});
	
	// 转换图片数据
    $("#toppic").change(function() {
        var oFile = this.files[0];
        console.log("oFile")
//        console.log(oFile)
        var reader = new FileReader();
        // 调用自带方法进行转换
        reader.readAsDataURL(oFile); 
        reader.onload = function(e) {
        	// 将转换后的编码存入src完成预览
            $("#toppic-show").attr("src", this.result); 
            toppic = this.result;
            $("#toppic-tip").html('修改头图');
            var rFilter = /^(image\/bmp|image\/gif|image\/jpeg|image\/png|image\/tiff)$/i;
//            console.log(oFile.type);
            if(!rFilter.test(oFile.type)) {
                alert("文件格式必须为图片");
                return;
            }
            console.log(toppic);
        };
    });
});
