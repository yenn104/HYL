<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lý</title>
<link rel="icon" href="./img/logo_hyl.png" type="image/x-icon">
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
        
        div{
           border:3px solid #5F9EA0;
           margin:25px 300px 100px 50px;
           height:950px
        }
        
        p {
        	text-align:center
        }
        
        div.btn-group {
      		height: 50px;
    		margin-top: 660px;
    		border: 0px
        }
    </style>
</head>


<body>
<div class="container" style="max-width: 1300px; height: fit-content;">

<p style="font-size:xx-large"><a href="#" class="text-info">DANH SÁCH BỆNH</a></p>


<table class="table table-hover" style="text-align: center;">
  <thead>
    <tr>
      <th scope="col">Mã</th>
      <th scope="col" style="text-align: left;padding-left: 40px;">Tên</th>
      <th scope="col">Thông tin</th>
      <th scope="col" colspan="2">Thao tác</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach items="${all}" var="all">
	    <tr>
			<th scope="row" style="width: 150px; vertical-align: middle;">${all.idB}</th>
			<td style="text-align: left;width: 250px; vertical-align: middle;" >${all.tenB}</td>
			<td style="text-align: left;width: 600px;">${all.info}</td>
			<td style="vertical-align: middle;">
				<a href="SuaBenh?id=${all.idB}">
					<i class="fa fa-pencil-square-o" style="font-size:18px; color:black;"></i>
				</a>
			</td>
		    <td style="vertical-align: middle;">
		    	<a href="XoaBenh?id=${all.idB}">
			      	<i class="fa fa-times" style="font-size:18px; color:black;"></i>
			    </a>
			</td>
	    </tr>
	</c:forEach>
  </tbody>
</table>

<div class="btn-group" role="group" aria-label="Basic example" style="margin: 50px;">
  	<button onclick="location.href='Newbenh.jsp';" type="button" class="btn btn-info">Thêm bệnh mới</button>
   	<button onclick="location.href='admin.jsp';" style="margin-left: 50px;" type="button" class="btn btn-info"> Quay lại </button>
</div>

</div>

</body>
</html>