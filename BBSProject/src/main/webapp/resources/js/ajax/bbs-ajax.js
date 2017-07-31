/**
 * BBS onload 처리 부분
 */
/*$.ajax({
	url : "/bbs/list/data",	
	type : "post",
	dataType : "json",
	success : function(data) {
		eachFunc(data);
	},
	complete : function() {
		pageFunc(0, 10);
	}
});*/

callAjax(0);

$(document).on("change",".page",function(){
	var start = $(this).attr("startrow"); 
	var end = $(this).attr("endrow");
	console.log(start+":"+end);
	pageFunc(start,end);
});

$(document).on("click","#leftblock, #rightblock",function(){
	var block = $(this).attr("moveblock");
	callAjax(block);
});

/*$(document).on("clcick","#rightblock",function(){
	var block = $(this).attr("moveblock");
	callAjax(block);
});*/