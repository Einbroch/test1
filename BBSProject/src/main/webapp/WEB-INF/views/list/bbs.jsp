<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
<!-- Bootstrap Core CSS -->
<link href="/bbs/resources/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<!-- MetisMenu CSS -->
<link href="/bbs/resources/vendor/metisMenu/metisMenu.min.css"
	rel="stylesheet">
<!-- Custom CSS -->
<link href="/bbs/resources/dist/css/sb-admin-2.css" rel="stylesheet">
<!-- Custom Fonts -->
<link href="/bbs/resources/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<script type="text/javascript">
	/* var pageFunc = function(s, e){
	 var v;
	 for (var i = 0; i < 100; i++) {
	 var v = "#con"+i;
	 if(i>=s && i<e){
	 $(v).show();
	 }else{
	 $(v).hide();
	 }
	 }
	 }
	 var eachFunc = function(data){
	 $.each(data,function(i,d){
	 //console.log(d);
	 $("#contents").append(
	 "<tr id='con"+i+"'>"
	 +"<td>"+d["num"]+"</td>"
	 +"<td>"+d["title"]+"</td>"
	 +"<td>"+d["ownerName"]+"</td>"
	 +"<td>"+d["registData"]+"</td>"
	 +"</tr>");
	 });	
	 } */
</script>
<script type="text/javascript">
	/* $(function(){
	 var init = {value:0};
	 $.ajax({
	 url:"/bbs/list/data",
	 type:"post",
	 dataType:"json",
	 success:function(data){
	 eachFunc(data);
	 },
	 complete:function(){
	 pageFunc(0,10);
	 }
	 });
	
	 }); */
</script>
</head>
<body>
	<div>
		<table class="table table-bordered">
			<thead>
				<tr>
					<td>
						<p>NO</p>
					</td>
					<td>
						<p>제목</p>
					</td>
					<td>
						<p>작성자</p>
					</td>
					<td>
						<p>작성일</p>
					</td>
				<tr>
			</thead>
			<tbody id="contents">

			</tbody>
			<tfoot>

			</tfoot>
		</table>
		<div class="btn-group" data-toggle="buttons" id="page"></div>
	</div>
	<!-- jQuery -->
	<script src="/bbs/resources/vendor/jquery/jquery.min.js"></script>
	<!-- Bootstrap Core JavaScript -->
	<script src="/bbs/resources/vendor/bootstrap/js/bootstrap.min.js"></script>
	<!-- Metis Menu Plugin JavaScript -->
	<script src="/bbs/resources/vendor/metisMenu/metisMenu.min.js"></script>
	<!-- Custom Theme JavaScript -->
	<script src="/bbs/resources/dist/js/sb-admin-2.js"></script>
	<!-- Utility -->
	<script src="/bbs/resources/js/util/list-bbs.js"></script>
	<!-- Onload Event -->
	<script src="/bbs/resources/js/ajax/bbs-ajax.js"></script>
</body>
</html>
