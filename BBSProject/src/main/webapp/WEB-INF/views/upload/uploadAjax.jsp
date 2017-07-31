<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
<style>
.fileDrop {
width:100%;
height:200px;
border: 1px dotted blue;
}
small{
	margin-left : 3px;
	font-weight: bold;
	color:gray;
}
</style>
</head>
<body>
	<h1>Ajax 파일 업로드</h1>
	<div class="fileDrop"></div>
	<div class="uploadedList"></div>

<!-- jQuery -->
<script src="/bbs/resources/vendor/jquery/jquery.js"></script>
<script type="text/javascript">
/* 파일의 확장자를 통해 타입을 체크 */
function checkImageType(filename){
	var pattern = /jpg|gif|png|jpeg/i;
	return filename.match(pattern);
}
/* 파일의 이름을 재설정 */
function getOriginalName(fileName){
	if(checkImageType(fileName)){
		return;
	}
	var idx = fileName.indexOf("_")+1;
	console.log(fileName.substr(idx));
	return fileName.substr(idx);
}

/* 이미지 링크를 제공하는 함수 */
function getImageLink(fileName){
	if(!checkImageType(fileName)){
		return;	
	}
	var front = fileName.substr(0,12);
	var end = fileName.substr(14);
	
	console.log(front+end);
	
	return front+end;
}

$(".fileDrop").on("dragenter dragover",function(event){
	event.preventDefault();
});
$(".fileDrop").on("drop",function(event){
	event.preventDefault();
	var files = event.originalEvent.dataTransfer.files;
	var file = files[0];
	//console.log(file);
	var formData = new FormData();
	formData.append("file", file);
	$.ajax({
		url:'/bbs/upload/uploadAjaxResult',
		data : formData,
		dataType:'text',
		type:'post',
		processData:false,
		contentType:false,
		success:function(data){
			//alert(data);
			var str ="";
			
			if(checkImageType(data)){
				str = "<div>"
					+ "<a href='displayFile?fileName="
							+getImageLink(data)+"'>"
					+ "<img src='displayFile?fileName="+data+"'/>"
					+ getOriginalName(data) + "</a>"
					+"<small data-src="+data
					+">X</small></div>";
			}else{
				str = "<div>"
					+ "<a href='displayFile?fileName="
					+ data +"'>"
					+ getOriginalName(data) + "</a></div>";
			}
			$(".uploadedList").append(str);
		}
	});
	
	$(".uploadedList").on("click","small",function(event){
		var that = $(this);
		
		$.ajax({
			url:"deleteFile",
			type:"post",
			data:{fileName:$(this).attr("data-src")},
			dataType:"text",
			success:function(result){
				if(result=='deleted'){
					that.parent("div").remove();
				}
			}
		});
	});
});
</script> 
</body>
</html>