<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Prescription</title>
<link rel="icon" href="./img/logo_hyl.png" type="image/x-icon">
	
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
        }
        p {
        	text-align:center
        }
        
    </style>
</head>


<body>
<div class="container">

	<p style="font-size:xx-large"><a href="#" class="text-info">PRESCRIPTION</a></p>
	<p style="font-size:medium"><a href="#" class="text-dark">Diagnostic: ${benh.tenB}</a></p>
	<p style="font-size:medium"><a href="#" class="text-dark">Probability: ${benh.xs}% </a></p>
	<p style="font-size:medium"><a href="#" class="text-dark">Date of issue: ${date}</a></p>


<table class="table table-hover">
	<thead>
		<tr>
			<th scope="col">Numberical Order</th>
			<th scope="col">Medicine Name</th>
			<th scope="col">Amount</th>
			<th scope="col">Unit</th>
		
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${ds}" var="ds" > 
		<c:forEach items="${all}" var="all" >
			<c:if test="${ds.idThuoc == all.id}">
				<tr>
					<th scope="row"> 
						<c:set var="count" value="${count + 1}" scope="page"/>
      					<c:out value = "${count}"/> 
					</th>
					<td>${all.tenthuoc}</td>
					<td>${ds.slg}</td>
					<td>${all.dvt}</td>
				</tr>
			</c:if>
		</c:forEach>
	</c:forEach>

	</tbody>
</table>

<script>
	
 	   	<c:set var="count" value="0" scope="page" />
 	

 </script>





</div>
</body>
</html>