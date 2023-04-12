<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title> ADMIN </title>
	<link rel="icon" href="./img/logo_hyl.png" type="image/x-icon">
	</style>
	<link rel="stylesheet" type="text/css" href="./css/style.css" />
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" 
		integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" 
		crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" 
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" 
		crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" 
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" 
		crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" 
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" 
		crossorigin="anonymous"></script>
		
		<style type="text/css">
		nav{
			justify-content: center;
		    display: flex;
		    align-items: center;
		    height: 45px;
			width: 1196px;
			background:#91E1E1;
			margin-bottom:5px;
			font-size: 15px;
			font-family:"Roboto",sans-serif;
		}
	</style>
</head>
<body>
	<div class="container">
		<header>
			<a href="#"><img src ="img/logo1.png" alt=""></a>
		<div class="btn-group" role="group" aria-label="Basic example">

		</div>
		</header>
		
		<nav>
			<div class = "menu">
				<ul>
					<li><a href="/HYL">Trang chủ </a></li>
					<li class="dropdown">
					<li><a href="Thuoc">Quản lý thuốc </a></li>
					<li><a href="TrieuChung">Quản lý triệu chứng </a></li>
					<li><a href="Benh">Quản lý bệnh</a></li>
					
				</ul>
			</div>
			
		</nav>
			<div id="slide" >
				<a href="/admin.jsp"><img src ="img/nen1.jpg" alt="HYL" style="width: 1196px;"></a>
				
			</div>
			
		
	</div>

</body>
</html>