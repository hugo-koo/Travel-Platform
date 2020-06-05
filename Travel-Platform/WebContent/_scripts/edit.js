/**
 * 
 */
var getNoteHtml = function () {
    var x = document.getElementsByTagName("iframe")[0].contentWindow;
    var noteHtml = x.document.getElementById("editor").innerHTML;
    return noteHtml;
}