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
			<label>
				제목 : <input type="text" id="title" name="title">
			</label>
		</div>
		<div>
			<textarea name="editor1" id="editor1" rows="10" cols="80">
		
			</textarea>
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
		// Replace the <textarea id="editor1"> with a CKEditor
	    // instance, using default configuration.
	    CKEDITOR.replace("editor1");	
	</script>
	<script type="text/javascript">
		$("#btn").click(function(){
			var l = CKEDITOR.instances.editor1.getData();
			var d = {title:$("#title").val(), content:l};
			$.ajax({
				url : "/bbs/list/inputResult",
				headers : {
					'Accept' : 'application/json',
					'Content-Type' : 'application/json'
				},
				dataType : "text",
				type : "post",
				data : JSON.stringify(d),
				success : function(data){
					alert("입력에 성공하였습니다.")
				}
			});
		});
	</script>

</body>
</html>