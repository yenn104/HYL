<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Tư vấn</title>
	<link rel="stylesheet" href="css/style.css">
	<link rel="icon" href="./img/logo_hyl.png" type="image/x-icon">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<style type="text/css">	
		
		.tclist {
		    width: 1440px;
		    height: 500px;
		    margin: 0px 50px;
		    display: grid;
		    justify-content: center;
		    font-size: 20px;
		    align-items: center;
		}
		

		.tclist input{
			margin: 10px 10px;
			padding: 0px 10px;
		}
		
		.kedon{
		   	margin: 10px;
	   	    margin-top:-289px;
		   	margin: 0px 300px;
		   	flex-wrap: nowrap;
		   	display: flex;
		   	padding: 10px 20px;
		   	justify-content: center;
		}
		
		.kedon input {
		    margin: 10px 10px;
		    padding: 10px 40px;
		    border: 1px solid rgb(118, 118, 118);
		    background-color: #91E9E9;
		    font-size:15px;
		 	font-family: courier new; 
		}
		
		input.checkTC{
			width: 16px;
            height: 16px;
		}
		
		.search-bar{
			margin-right: 150px;
		}
		
		.container-tuvan{
			width:1196px;
			margin:0  auto;
			font-family: courier new; 
		}
		
		
		#nav-header{
			display: flex;
	   	 	justify-content: right;
		}
		
		.find{
			display: flex;
		}
		
		.search-bar button{
		    background-color: white;
		    color: revert;
		    border: 1px solid rgb(118, 118, 118);
		}
		
		.search-bar input:hover
		{
			background-color: white;
		    color: revert;
		    border: 1px solid rgb(118, 118, 118);
		}
		
		
	</style>
</head>
<body>

	<div class="container-tuvan">
		<header>
			<a href="#"><img src ="img/logo1.png" alt=""></a>
			<div class="btn-group" role="group" aria-label="Basic example">
				<!-- <button type="button" class="btn btn-info">Đăng nhập</button>
				<button type="button" class="btn btn-light">Đăng kí</button> -->
				<!--<li><a href="Dangxuat">Đăng xuất</a></li> -->
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
	</div>			
	<div class="tclist">
	
		<form method="Get" action="KeDon">
			<div class="kedon" style=" margin-top: 50px;">
				<input type="submit" value="Kê đơn thuốc">
			</div>
			<ul class="symptom">
				<c:forEach items="${TCList}" var="tc" > 
					<li class="symptom-items">	
						<input type="checkbox" class="checkTC" name="tc_${tc.idTC}" value="${tc.idTC}">
						<label for="vehicle1">${tc.tenTC}</label><br>
					</li>
				</c:forEach>
			</ul>
			
		</form>		
	</div>


		
		
</body>

</html>