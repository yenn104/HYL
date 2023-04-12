<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title> HYL </title>
	<link rel="icon" href="./img/logo_hyl.png" type="image/x-icon">
	<link rel="stylesheet" type="text/css" href="./css/style.css" />
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
			<a href="/HYL"><img src ="img/logo1.png" alt=""></a>
			<div class="btn-group" role="group" aria-label="Basic example">
				<c:if test="${name.length() > 0}" >
					<a href="Dangxuat"><button type="button" class="btn btn-info"><i class="fa fa-sign-out" style="font-size:18px; color:black;"></i></button></a>
				</c:if>
				<c:if test="${name.length() == null }" >
					<a href="Dangnhap.jsp"><button type="button" class="btn btn-info">Đăng nhập</button></a>
					<a href="Dangky.jsp"><button type="button" class="btn btn-light">Đăng kí</button></a>
				</c:if>
			</div>
		</header>
		
		<nav>
			<div class = "menu">
				<ul>
					<li><a href="/HYL">Trang chủ </a></li>
					<li class="dropdown">
					<li><a href="TrieuChungList?dn=${name}">Tư vấn </a></li>
					<li><a href="Lienhe.jsp">Liên hệ </a></li>
					<li><a href="Mota.jsp">Thông tin về HYL </a></li>
					<c:if test="${admin.admin == 1 }">
						<li><a href="admin.jsp">Quản lý hệ thống</a></li>
						<li><a href="LSD?username=${name}">Lịch sử đơn thuốc</a></li>
					</c:if>
					<c:if test="${admin.admin == 0 }">
						<li><a href="LSD?username=${name}">Lịch sử đơn thuốc</a></li>
					</c:if>
				</ul>
			</div>
			
		
		</nav>
		<div id="carouselExampleControls" class="carousel slide" data-ride="carousel" style="width: 1196px;">
			  <div class="carousel-inner">
				    <div class="carousel-item active">
				      	<img class="d-block w-100" src="./img/benhnhan.png" alt="First slide">
				    </div>
				    <div class="carousel-item">
				      	<img class="d-block w-100" src="./img/nen1.jpg" alt="Second slide">
				    </div>
				    <div class="carousel-item">
				      	<img class="d-block w-100" src="./img/nen2.jpg" alt="Third slide">
				    </div>
			  </div>
			  <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
				    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
				    <span class="sr-only">Previous</span>
			  </a>
			  <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
				    <span class="carousel-control-next-icon" aria-hidden="true"></span>
				    <span class="sr-only">Next</span>
			  </a>
		</div>
					
		
	</div>
	<script src="https://uhchat.net/code.php?f=dbb683"></script>
</body>
</html>