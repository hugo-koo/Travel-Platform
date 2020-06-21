/**
 * @author 古学懂_Victor
 */
var cookies = document.cookie;
var noteId = 0;
var likeCount = 0;
$(() => {
	checkLiked();
});
/** 判断此游记是否已点赞并动作 */
var checkLiked = ()=>{
	if(isLiked(noteId)){
		 $("#liked-icon").css("display", "inline-block");
		 $("#like-icon").css("display", "none");
	}else{
		 $("#like-icon").css("display", "inline-block");
		 $("#liked-icon").css("display", "none");
	}
}
/** 点赞方法 */
var like = ()=>{
	$.ajax({
        type: "post",
        url: "/Travel-Platform/note_like.action",
        data: {
        	"noteId": noteId
        },
        success: (data) => {
        	likeCount = data.likeCount;
        	checkLiked();
        	$("#like-count").text(likeCount);
        },
        error: () => {
            alert("点赞失败");
        }
    });
}
var setNoteId = (id) => {
	noteId = id;
}
/** 获取对应Cookie */
var getCookieVal = (cName) => {
  var name = cName + "=";
  var ca = document.cookie.split(';');
  for(var i=0; i<ca.length; i++){
    var c = ca[i].trim();
    if (c.indexOf(name)==0) return c.substring(name.length,c.length);
  }
  return "";
}
/** 判断是否已点赞该游记 */
var isLiked = (id) =>{
	var likes = getCookieVal("LIKE");
	var notes = likes.split('|');
	for(var i=0; i<notes.length; i++){
		if(id==notes[i]) return true;
	}
	return false;
}