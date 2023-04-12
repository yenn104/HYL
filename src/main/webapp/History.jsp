<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title> History </title>
	<link rel="icon" href="./img/logo_hyl.png" type="image/x-icon">
	<link rel="stylesheet" type="text/css" href="./css/style.css" />
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
		
		.viewdtt{
			width: 900px;
   			margin: 50px 14%;
		}
		
		.viewdtt table{
			width: 900px;
			text-align: center;
		}
		
		.tieudee{
			text-align:center;
			font-family: Courier New, sans-serif;
			font-weight: bold;
			margin: 50px;
		}
	</style>
</head>
<body>
<body>
	<div class="container">
		<header>
			<a href="#"><img src ="img/logo1.png" alt=""></a>
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
		
		
<div class="viewdtt">
 	<div class="tieudee">
 	<h3 style="font-weight: bold;">Lịch sử đơn thuốc của bạn</h3>
 	</div>
	  <c:if test="${lsd.isEmpty() }" >
		<p class="error">${errorString}</p>	
	</c:if>	
 
	 <table border="1" cellpadding="5" cellspacing="1"  class="table table-hover">
	 <thead>
		 <tr>
		 	<th>STT</th>
			<th>Mã đơn thuốc</th>
			<th>Tên bệnh</th>
			<th>Ngày</th>
			<th>Khách hàng</th>
			<th>Xem chi tiết</th>
		 </tr>
		</thead>
		 <c:forEach items="${lsd}" var="ds" >
		 <c:forEach items="${all}" var="all" >
		 <c:if test="${ds.idBenh == all.idB}">
			 <tr>
			 	 <th scope="row"> 
					<c:set var="count" value="${count + 1}" scope="page"/>
	     			<c:out value = "${count}"/> 
				 </th>
				 <td>#${ds.idDon}</td>
				 <td>${all.tenB}</td>
				 <td>${ds.date}</td>
				 <td>${ds.userName}</td>
				 <td>
					 <a href="ChiTiet?idDon=${ds.idDon}&userName=${name}"> <i class="fa fa-eye dropbtn" style="font-size:16px; color:black"></i> </a>
				 </td>
			</tr>
			</c:if>
			</c:forEach>
		 </c:forEach>
	 </table>
	 <br>
	 <br>
 </div>
		
<script>
 	   	<c:set var="count" value="0" scope="page" />
</script>	
		
	</div>
</body>
</html>