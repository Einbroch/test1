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
<!-- DataTables CSS -->
<link href="/bbs/resources/vendor/datatables-plugins/dataTables.bootstrap.css"
   rel="stylesheet">
<!-- DataTables Responsive CSS -->
<link href="/bbs/resources/vendor/datatables-responsive/dataTables.responsive.css"
   rel="stylesheet">
<!-- Custom CSS -->
<link href="/bbs/resources/dist/css/sb-admin-2.css" rel="stylesheet">
<!-- Custom Fonts -->
<link href="/bbs/resources/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

</head>
<body>
	<div>
		<table id="myTable" class="table table-bordered">
			<thead>
				<tr>
					<td>
						<p>NO</p>
					</td>
					<td>
						<p>Title</p>
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
	</div>
	<!-- jQuery -->
	<script src="/bbs/resources/vendor/jquery/jquery.min.js"></script>
	<!-- Bootstrap Core JavaScript -->
	<script src="/bbs/resources/vendor/bootstrap/js/bootstrap.min.js"></script>
	<!-- Metis Menu Plugin JavaScript -->
	<script src="/bbs/resources/vendor/metisMenu/metisMenu.min.js"></script>
	<!-- DataTables JavaScript -->
	<script src="/bbs/resources/vendor/datatables/js/jquery.dataTables.min.js"></script>
    <script src="/bbs/resources/vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
    <script src="/bbs/resources/vendor/datatables-responsive/dataTables.responsive.js"></script>
	<!-- Custom Theme JavaScript -->
	<script src="/bbs/resources/dist/js/sb-admin-2.js"></script>
	
	<script type="text/javascript">
		$(function(){
			$("#myTable").dataTable();
		});
	</script>
</body>
</html>