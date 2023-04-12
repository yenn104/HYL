<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="css/dk.css">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css">
	<title>Đăng ký</title>
	<link rel="icon" href="./img/logo_hyl.png" type="image/x-icon">
</head>
<body>
<div id="wrapper">
	<form method="post" action="Dangky" id="from-login">
		<h1 class="form-heading">Đăng ký</h1>
		<div class="form-group">
			<input type="text" name="username" class="form-input" placeholder="Tên tài khoản: ">
		</div>
		<div class="form-group">
			<input type="text"  name="email" class="form-input" placeholder="Email: ">
		</div>
		<div class="form-group">
			<input type="password"  name="password" class="form-input" placeholder="Mật khẩu: ">
		</div>
		<input type="submit" value="Đăng ký" class="form-submit">
	</form>
</div>
</body>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</html>