<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Quản lý</title>
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
		
		ul.symptomm li{
			flex-basis: 24%;
		}
		
	</style>
</head>
<body>

	<div class="container-tuvan">
		<header>
			<a href="#"><img src ="img/logo1.png" alt=""></a>
			<div class="btn-group" role="group" aria-label="Basic example">
			</div>
		</header>
		<nav>
			<div class = "menu">
				<ul>
					<li style="font-family: courier new;font-style: up;text-transform: uppercase;font-weight: bold;color: rgb(0, 44, 99);">Bệnh: ${tenB}</li>
				</ul>
			</div>
		</nav>
	</div>			
	<div class="tclist">
	
		<form method="Post" action="BenhThuocServlet">
		<input type="hidden" value="${idB}" name="idB"/>
			<div class="kedon">
				<input type="submit" value="Cập nhật thuốc">
			</div>
			<ul class="symptom symptomm">
				<c:forEach items="${thuoc}" var="t" > 
					<li class="symptom-items" style="display: flex;display: flex; align-items: center; ">	
						<input type="checkbox" class="checkTC" name="t_${t.id}" value="${t.id}">
						<label for="vehicle1">${t.tenthuoc}</label><br>
						<input type="number" class="checkTC" name="slg_${t.id}" placeholder="slg" style="width: 35px;">
					</li>
				</c:forEach>
			</ul>
			
		</form>		
	</div>


		
		
</body>

</html>