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
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="login-panel panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Please Sign In</h3>
					</div>
					<div class="panel-body">
						<form action="/bbs/login/result" role="form">
							<fieldset>
								<div class="form-group">
									<input class="form-control" placeholder="userid" name="userid"
										id="userid"
										type="text" value="${id}" autofocus>
								</div>
								<div class="form-group">
									<input class="form-control" placeholder="Password"
										id="password"
										name="password" type="password" value="">
								</div>
								<div class="checkbox">
									<label> <input name="remember" type="checkbox"
										value="Remember Me">Remember Me
									</label>
								</div>
								<!-- Change this to a button or input when using this as a form -->
								<button class="btn btn-lg btn-success btn-block"
								id="btn"
								type="button">Login</button>
							</fieldset>
						</form>
					</div>
				</div>
			</div>
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
	<script type="text/javascript">
	$("#btn").click(function(){
		var i = {userid : $("#userid").val(),
		password : $("#password").val()};
		
		$.ajax({
			url : "result2",
			headers: { 
		        'Accept': 'application/json',
		        'Content-Type': 'application/json' 
		    },
			dataType:"text",
			type:"post",
			data:JSON.stringify(i),
			success:function(data){
				alert('성공');
			},
			error : function(data){
				alert('실패');
			}
		})
	});
	</script>
</body>
</html>



