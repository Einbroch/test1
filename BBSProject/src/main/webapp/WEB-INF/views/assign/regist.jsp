<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<script type="text/javascript" src="/BBSProject/js/jquery-3.2.1.min.js"></script>
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

<!-- jQuery -->
<script src="/bbs/resources/vendor/jquery/jquery.min.js"></script>
<!-- Bootstrap Core JavaScript -->
<script src="/bbs/resources/vendor/bootstrap/js/bootstrap.min.js"></script>
<!-- Metis Menu Plugin JavaScript -->
<script src="/bbs/resources/vendor/metisMenu/metisMenu.min.js"></script>
<!-- Custom Theme JavaScript -->
<script src="/bbs/resources/dist/js/sb-admin-2.js"></script>

<script type="text/javascript">
	$(function() {
		$("#id_check").click(function() {
			//var d = '{"id":' + $("#id").val() + '}'
			var d = {
				userid : $("userid").val()
			};
			/* d.id = $("#id").val(); */
			$.ajax({
				url : "/bbs/assign/check",
				type : "post",
				accept : "application/json",
				contentType : "application/json;charset=UTF-8",
				data : JSON.stringify(d),
				dataType : "json",
				success : function(data) {
					$("#chk_result").text(data["msg"])
					//$("#chk_result").css('color','green');
				},
				error : function(request, status, error) {
					$("#chk_result").text("사용가능한 ID가 아닙니다.")
					//$("#chk_result").css('color','red');
					/* console.log(
							"code:"+request.status+"\n"+
							"message:"+request.responseText+"\n"+
							"error:"+error); */
				}
			});

		});

		$("#btn").click(function() {
			var d = {
				userId : $("#userid").val(),
				password : $("#pw").val(),
				name : $("#name").val(),
				age : $("#age").val(),
				//gender:$(":input:radio[name=gender]:checked").val(),
				gender : $("#gender1").val(),
				addr : $("#addr").val(),
				//check:($('input:checkbox[id="alert"]').is(":checked") == true)?'Y':'N'
				check : $("#alert").val()
			};
			$.ajax({
				url : "/bbs/assign/setemp",
				type : "POST",
				//accept:"application/json",
				contentType : "application/json;charset=UTF-8",
				data : JSON.stringify(d),
				dataType : "json",
				success : function(data) {
					alert("가입에 성공하였습니다");
				},
				error : function(request, status, error) {
					alert("가입에 실패하였습니다")
				}
			});
		});
	});
</script>
</head>
<body>
	<div id="page-wrapper">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">회원가입</h1>
			</div>
			<!-- /.col-lg-12 -->
		</div>
		<!-- /.row -->
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">회원가입</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-lg-6">
								<form role="form">
									<div class="form-group">
										<label>ID</label> <input id="userid" name="userid"
											class="form-control">
										<button type="button" id="id_check" class="btn btn-primary">
										ID 중복확인</button>
										<p id="chk_result"></p>
									</div>
									<div class="form-group">
										<label>Password</label> <input id="pw" name="pw"
											class="form-control">
									</div>
									<div class="form-group">
										<label>Name</label> <input id="name" name="name"
											class="form-control">
									</div>
									<div class="form-group">
										<label>Age</label> <input id="age" name="age"
											class="form-control">
									</div>
									<div class="form-group">
										<label>Gender</label>
										<div class="radio">
											<label> <input type="radio" name="gender"
												id="gender1" value="남" checked>남
											</label>
										</div>
										<div class="radio">
											<label> <input type="radio" name="gender"
												id="gender2" value="여">여
											</label>
										</div>
									</div>
									<div class="form-group">
										<label>Address</label> <input id="addr" name="addr"
											class="form-control">
									</div>
									<div class="form-group">
										<label>Alert</label>
										<div class="checkbox">
											<label> <input type="checkbox" id="alert"
												name="alert" value="Y">이벤트
											</label>
										</div>
									</div>
									<button type="button" id="btn" name="btn"
										class="btn btn-primary">확인</button>
								</form>
							</div>
							<!-- /.col-lg-6 (nested) -->
						</div>
						<!-- /.row (nested) -->
					</div>
					<!-- /.panel-body -->
				</div>
				<!-- /.panel -->
			</div>
			<!-- /.col-lg-12 -->
		</div>
		<!-- /.row -->
	</div>
	<!-- /#page-wrapper -->
</body>
</html>