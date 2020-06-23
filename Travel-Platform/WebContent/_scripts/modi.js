/**
 * @author 古学懂_Victor
 */
var noteId = 0;
var note;
var content = "";

$(()=>{
	$.ajax({
        type: "post",
        url: "/Travel-Platform/note_get.action",
        data: {
        	"noteId": noteId
        },
        success: (data) => {
        	note = data.note;
        	content = data.noteContent;
        	if(note!=undefined){
        		inject();
        	}else{
        		alert("原文获取失败");
        	}
        },
        error: () => {
            alert("原文获取失败");
        }
    });
});

var inject = ()=>{
	$("#noteHeader")[0].value = note.noteDtl.noteHeader;
	setNoteHtml(content);
	$("#date")[0].value = note.travelDate.substring(0,10);
	$("#endDate")[0].value = note.endDate.substring(0,10);
	$("#applicable")[0].value = note.applicable;
	$("#toppic-show").attr("src", note.noteDtl.noteToppic); 
	toppic = note.noteDtl.noteToppic;
	$("#region-name").text(note.regions[0].name);
	$("#regionId").val(note.regions[0].id);
	regionId=note.regions[0].id;
}
