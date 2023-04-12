<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="stylesheet" href="css/dn.css">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css">
	<title>Đăng nhập</title>
	<link rel="icon" href="./img/logo_hyl.png" type="image/x-icon">
</head>
<body>
	<div id="wrapper">
		<form method="post" action="Dangnhap" id="from-login">
			<h1 class="form-heading">Đăng nhập</h1>
			<div class="form-group">
				<i class="far fa-user"></i>
				<input type="text" name="username" class="form-input" placeholder="Tài khoản: ">
			</div>
			<div class="form-group">
				<i class="fas fa-key"></i>
				<input type="password" name="password" class="form-input" placeholder="Mật khẩu: ">
				<div id="eye">
					<i class="far fa-eye"></i>
				</div>
			</div>
			<input type="submit"  name="submit" value="Đăng nhập" class="form-submit">
		</form>
	</div>
</body>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="js/dn.js"></script>
</html>