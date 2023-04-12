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
 }</style>

</head>
<body>
	<div align="center" class="container" style="margin-top: 130px;">
		<h1 align="center" style="color: #5F9EA0">Chỉnh sửa thông tin bệnh</h1>
		<form method="POST" action="SuaBenh">
			<table>
				<tr>
					<td align="center" style="color: #5F9EA0">Mã bệnh </td>
					<td><input type="text" name="id"  value="${id}" readonly/></td>
				</tr>
				<tr>
					<td align="center" style="color: #5F9EA0">Tên bệnh</td>
					<td><input type="text" name="ten" value="${ten}"/></td>
				</tr>
				<tr>
					<td align="center" style="color: #5F9EA0">Thông tin bệnh</td>
					<td><input type="text" name="info"  value="${info}"/></td>
				</tr>
				<tr>
					<td colspan="2">
						<div class="btn-group" role="group" aria-label="Basic example" style="margin-left: 40px;">
						  	<button type="submit" class="btn btn-info">Cập nhật</button>
						  	<button type="reset" class="btn btn-info">Đặt lại</button>
						</div>
					</td>
				</tr>
			</table>
		</form>
		<form  method="POST" action="BenhTC" style=" margin-top: -59px; width: 200px; margin-left: 230px;">
				<div class="btn-group" role="group" aria-label="Basic example" style="margin-left: 40px;">
					<input type="hidden" name="idB" value="${id}"/>
					<input type="hidden" name="tenB" value="${ten}"/>
					<button type="submit" class="btn btn-info" >Sửa triệu chứng</button>
				</div>
		</form>
		<form  method="POST" action="BenhThuoc" style=" width: 200px; margin-left: -40px;">
				<div class="btn-group" role="group" aria-label="Basic example" style="margin-left: 40px;">
					<input type="hidden" name="idB" value="${id}"/>
					<input type="hidden" name="tenB" value="${ten}"/>
					<button type="submit" class="btn btn-info" >Chỉnh sửa thuốc cho bệnh</button>
				</div>
		</form>
	
	</div>
</body>
</html>