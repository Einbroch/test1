<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<script type="text/javascript" src="/BBSProject/js/jquery-3.2.1.min.js"></script>
<title>JSP</title>
</head>
<body>

	<div class="col-lg-11">
		<div>
			제목 : <p id="title"></p>
		</div>
		<div>
			내용 : <div id="content"></div>
		</div>
		<div>
			<button class="btn btn-primary" id="btn">확인</button>
		</div>
	</div>
	<!-- jQuery -->
	<script src="/bbs/resources/vendor/jquery/jquery.min.js"></script>
	<!-- Bootstrap Core JavaScript -->
	<script src="/bbs/resources/vendor/bootstrap/js/bootstrap.min.js"></script>
	<!-- Metis Menu Plugin JavaScript -->
	<script src="/bbs/resources/vendor/metisMenu/metisMenu.min.js"></script>
	<!-- Custom Theme JavaScript -->
	<script src="/bbs/resources/dist/js/sb-admin-2.js"></script>
	
	<!-- CKEditor -->
	<script src="/bbs/resources/ckeditor/ckeditor.js"></script>
	<script type="text/javascript">
		$("#btn").click(function(){
			var id = 'BBFDA00200020014';
			var d = {id:id};
			console.log(d);
			$.ajax({
				url : "/bbs/list/detail",
				headers : {
					'Accept' : 'application/json',
					'Content-Type' : 'application/json'
				},
				dataType : "json",
				type : "post",
				data : JSON.stringify(d),
				success : function(data){
					console.log(data);
					$("#title").append(data.title);
					$("#content").append(data.content);
				}
			});
		});
	</script>

</body>
</html>