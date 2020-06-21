/**
 * @author 古学懂_Victor
 */
/** 总页数 */
var totalPages = 1;
/** 每页项数 */
var itemsPerPage = 5;
/** 当前页码 */
var page = 1;
/** 生成卡片 */
var noteCard = (
    noteId = 0,
    postDate = 0,
    commentCount = 0,
    favoriteCount = 0,
    likeCount = 0,
    noteHeader = '',
    summary = '',
    toppic = ''
) => {
    var likeIcon = '<svg style="vertical-align: baseline;" t="1591709280779" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="2611" width="16" height="16" xmlns:xlink="http://www.w3.org/1999/xlink"><defs><style type="text/css"></style></defs><path d="M939.358266 410.159945H666.684894C772.374573 19.898057 593.892003 0 593.892003 0c-75.592618 0-59.994141 59.794161-65.693585 69.793184 0 190.781369-202.680207 340.366761-202.680207 340.366761v541.147154c0 53.394786 72.792891 72.692901 101.390099 72.692901h409.659994c38.596231 0 69.993165-101.090128 69.993165-101.090128C1007.951567 578.243531 1007.951567 475.75354 1007.951567 475.75354c-0.09999-71.293038-68.593301-65.593594-68.593301-65.593595zM213.629138 410.259936H50.345083c-33.696709 0-34.19666 33.096768-34.19666 33.096767l33.696709 545.746705c0 34.696612 34.796602 34.696612 34.796602 34.696612h141.286203c29.397129 0 29.197149-22.997754 29.197148-22.997755V451.655893c0-41.895909-41.495948-41.395957-41.495947-41.395957z" p-id="2612" fill="#0f4c81"></path></svg>';
    var commentIcon = '<svg style="vertical-align: baseline;" t="1592318387213" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="2685" xmlns:xlink="http://www.w3.org/1999/xlink" width="16" height="16"><defs><style type="text/css"></style></defs><path d="M844.8 73.6H179.2c-63.6 0-115.1 51.6-115.2 115.2v454.9c0 63.5 51.7 115.2 115.2 115.2h352l180.3 180.3c7.5 7.5 17.3 11.2 27.2 11.2 9.8 0 19.7-3.7 27.2-11.2 15-15 15-39.3 0-54.3l-184-184c-12-12.1-28.3-18.8-45.3-18.8H179.2c-21.2 0-38.4-17.2-38.4-38.4V188.8c0-21.2 17.2-38.4 38.4-38.4h665.6c21.2 0 38.4 17.2 38.4 38.4v454.9c0 21.2-17.2 38.4-38.4 38.4h-87c-21.2 0-38.4 17.2-38.4 38.4s17.2 38.4 38.4 38.4h87c63.5 0 115.2-51.7 115.2-115.2V188.8c0-63.5-51.7-115.2-115.2-115.2z" p-id="2686" fill="#0f4c81"></path></svg>';
    var favouritesIcon = '<svg style="vertical-align: baseline;" t="1591709368340" class="icon" viewBox="0 0 1082 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="3444" xmlns:xlink="http://www.w3.org/1999/xlink" width="16.9" height="16"><defs><style type="text/css"></style></defs><path d="M1078.385778 389.063111C1061.888 337.863111 970.638222 326.087111 874.097778 313.400889 821.134222 306.631111 761.002667 298.723556 742.855111 285.525333 724.48 272.327111 699.050667 217.998222 676.522667 169.927111 635.448889 82.659556 596.707556 0.227556 542.435556-0.056889L541.354667-0.056889C487.594667 0.853333 448.341333 82.261333 406.698667 168.618667 383.772444 216.405333 357.546667 270.506667 339.342222 283.420444 320.910222 296.561778 260.721778 303.843556 207.644444 310.272 111.047111 321.877333 19.797333 332.743111 2.673778 383.658667-14.222222 434.744889 52.394667 497.379556 122.993778 563.655111 161.792 600.064 205.710222 641.308444 212.593778 662.528 219.477333 683.804444 207.758222 742.684444 197.632 794.567111 178.858667 888.945778 161.223111 978.318222 204.970667 1010.176 215.381333 1017.628444 228.522667 1021.383111 244.110222 1021.098667 288.824889 1020.302222 353.052444 985.998222 415.175111 952.661333 461.653333 927.459556 514.389333 899.185778 537.941333 898.787556 560.696889 898.901333 613.546667 928.028444 660.252444 953.685333 723.683556 988.615111 789.504 1024.739556 834.218667 1024 848.213333 1023.772444 860.046222 1020.188444 869.774222 1013.304889 913.806222 981.959111 897.080889 892.700444 879.331556 797.923556 869.546667 745.984 858.624 686.990222 865.621333 665.770667 872.675556 644.608 917.162667 603.761778 956.302222 567.694222 1027.527111 502.044444 1094.826667 440.263111 1078.385778 389.063111Z" p-id="3445" fill="#0f4c81"></path></svg>';
    if (noteHeader == 'null') {
        noteHeader = "未命名游记";
    }
    if (toppic == '') {
    	toppic = '/Travel-Platform/_img/Test_1.jpg';
    }
    return '<div class="card mb-3" style="max-width: 715px;"><div class="row no-gutters"><div class="col-md-4"><img src="'+toppic+'" class="card-img" alt="首图"></div><div class="col-md-8"><div class="card-body"><a href="/Travel-Platform/note/' + noteId + '"><h5 class="card-title">' + noteHeader + '</h5></a><p class="card-text">' + summary + '</p><p class="card-text"><small class="text-muted">发布于' + postDate + '  ' + likeIcon + likeCount + ' ' + commentIcon + commentCount + ' ' + favouritesIcon + favoriteCount + ' </small></p></div></div></div></div><hr>'
}
/** 生成页面 */
var createPage = (page = 1, method = "listHotestNotes") => {
    var target;
    switch (method) {
        case "listHotestNotes":
            target = "#hotlist";
            break;
        default:
            target = "#latest";
            break;
    }
    // 显示加载中图标
    $("#note-loding").css("display", "inline-block");
    $.ajax({
        type: "post",
        url: "/Travel-Platform/note_" + method + ".action",
        data: {
            // 当前页码
            "page": page,
            // 每页项数
            "itemsPerPage": itemsPerPage
        },
        success: (data) => {
            console.log(data);
            for (var i = 0; i < data.notes.length; i++) {
                var noteId = data.notes[i].noteId;
                var postDate = data.notes[i].postDateStr;
                var commentCount = data.notes[i].commentCount;
                var favoriteCount = data.notes[i].favoriteCount;
                var likeCount = data.notes[i].likeCount;
                var noteHeader = '' + data.notes[i].noteDtl.noteHeader;
                var summary = '' + (data.notes[i].noteDtl.noteContent).substring(0, 10) + '...';
                var toppic = '' + data.notes[i].noteDtl.noteToppic;
                totalPages = data.totalPages;
                itemsPerPage = data.itemsPerPage;
                $(target).append(noteCard(
                    noteId,
                    postDate,
                    commentCount,
                    favoriteCount,
                    likeCount,
                    noteHeader,
                    summary,
                    toppic
                ));
            }
            // 停止显示加载中图标
            $("#note-loding").css("display", "none");
            $("#paginav").empty();
            $("#paginav").append(pageNav(page, totalPages, method));
            // 更新流转图片
            $("#note-toppic-1").eq(0).attr("src", $("#hotlist").find("img")[0].src);
            $("#note-link-1").html($("#hotlist").find("a")[0]);
            $("#note-toppic-2").eq(0).attr("src", $("#hotlist").find("img")[1].src);
            $("#note-link-2").html($("#hotlist").find("a")[1]);
            $("#note-toppic-3").eq(0).attr("src", $("#hotlist").find("img")[2].src);
            $("#note-link-3").html($("#hotlist").find("a")[2]);
        },
        error: () => {
            alert("游记获取失败");
        }
    });
}
/** 生成热门游记列表 */
var listHotestNotes = (page = 1) => {
    $("#hotlist").empty();
    createPage(page, "listHotestNotes");
    $('html').animate({ scrollTop: '0px' }, 300);
}
/** 生成最新游记列表 */
var listLatestNotes = (page = 1) => {
    $("#latest").empty();
    createPage(page, "listLatestNotes");
    $('html').animate({ scrollTop: '0px' }, 300);
}
/** 生成页面导航键 */
var pageNav = (page = 1, total = 1, method = "listHotestNotes") => {
    var items = "";
    var prev = "";
    var next = "";
    // 添加省略号前缀
    if (page > 5) {
        items += '<li class="page-item disabled"><a class="page-link" href="javascript: void(0)">...</a></li>';
    }
    // 页码选项
    for (var i = 1; i <= total; i++) {
        var active = "";
        if (i <= page + 4 && i >= page - 4) {
            if (page == i) active = "active";
            items += '<li class="page-item ' + active + '"><a class="page-link" href="javascript: ' + method + '(' + i + ')">' + i + '</a></li>';
        }
    }
    // 添加省略号后缀
    if (page <= total - 5) {
        items += '<li class="page-item disabled"><a class="page-link" href="javascript: void(0)">...</a></li>';
    }
    // 上一页按钮
    if (page == 1) {
        prev = '<li class="page-item disabled"><a class="page-link" href="javascript:void(0)">上一页</a></li>';
    } else {
        prev = '<li class="page-item"><a class="page-link" href="javascript:' + method + '(' + page + ')">上一页</a></li>';
    }
    // 下一页按钮
    if (page == total) {
        next = '<li class="page-item disabled"><a class="page-link" href="javascript:void(0)">下一页</a></li>';
    } else {
        next = '<li class="page-item"><a class="page-link" href="javascript:' + method + '(' + (page + 1) + ')">下一页</a></li>';
    }
    return '<nav aria-label="Page navigation example"><ul class="pagination">' + prev + items + next + '</ul></nav>';
}
// $("#hotlist-tab").click(function(){listHotestNotes()});
// $("#latest-tab").click(function(){listLatestNotes()});
$(() => {
    listHotestNotes();
    listLatestNotes();
});