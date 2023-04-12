<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lý</title>
<link rel="icon" href="./img/logo_hyl.png" type="image/x-icon">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" >
	<style type="text/css">
	
		div .btn-group{
			margin-top:20px;
			margin-right:100px
		 }
	 </style>

</head>
<body>
<div align="center" class="container" style="margin-top: 130px;">
	<h1 align="center" style="color: #5F9EA0">Thêm triệu chứng</h1>
	<form method="POST" action="ThemTC">
		<table>
			<tr>
				<td align="center" style="color: #5F9EA0">Tên triệu chứng</td>
				<td><input type="text" name="tenTC" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<div class="btn-group" role="group" aria-label="Basic example" style="margin-left: 200px;">
					  	<button type="submit" class="btn btn-info">Thêm</button>
					  	<button type="reset" class="btn btn-info">Đặt lại</button>
					</div>
				</td>
			</tr>
		</table>
	</form>
	</div>
</body>
</html>