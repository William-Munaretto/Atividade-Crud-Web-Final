<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Seller"%>  
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CRUD SELLERS</title>
<link rel="stylesheet" type="text/css" href="sellers.css" media="screen" />
</head>
<body>

	<%
		String msgInsert = (String) request.getAttribute("msgInserSellertAttr");	
	%>
	
	<%
		String msgUpdateSeller = (String) request.getAttribute("msgUpdateSellertAttr");	
	%>
	
	<%
		Seller seller = (Seller) request.getAttribute("sellertAttr");
	%>
	
	
	
	<h1>Seller Manager</h1>
	
	<a href="index.jsp"><span>Home</span></a>
	<br/>
	<br/>
	
	<!-- insert -->
	<div class="seller">
	<h3>Insert Seller</h3>
		<form method="get" action="${pageContext.request.contextPath}/sellerInsert" enctype="multipart/form-data">
			
			<label for="nome">Nome:</label>
			<input id="nome" type="text" name="nomeInsert"><br /><br />
			
			
			<label for="email">Email:</label>
			<input id="email" type="email" name="mailInsert"><br /><br />
			
			
			<label for="dataNascimento">BirthDate:</label>
			<input id="dataNascimento" type="date" name="dataInsert"><br /><br />
			
			
			<label for="BaseSalary">Base Salary:</label>
			<input id="BaseSalary" type="number" name="SalaryInsert"><br /><br />
			
			<label for="id">Department Id:</label>
			<input id="id" type="number" name="DepartmentId"><br /><br />
			
			<input type="submit" value="Insert" />
		</form>
		<br/>
		<span style="color: red"><%= msgInsert %></span>
		
	</div>
	
	<br />
	
	<!-- update -->
	<div class="seller">
	<h3>Update Seller</h3>
		<form method="get" action="${pageContext.request.contextPath}/sellerUpdate" enctype="multipart/form-data">
			
			
			<label for="id">Id:</label>
			<input id="id" type="number" name="idUpdate"><br /><br />

			<label for="nome">Nome:</label>
			<input id="nome" type="text" name="nomeUpdate"><br /><br />
			
			
			<label for="email">Email:</label>
			<input id="email" type="email" name="mailUpdate"><br /><br />
			
			
			<label for="dataNascimento">BirthDate:</label>
			<input id="dataNascimento" type="date" name="dataUpdate"><br /><br />
			
			
			<label for="BaseSalary">Base Salary:</label>
			<input id="BaseSalary" type="number" name="SalaryUpdate"><br /><br />
			
			<label for="id">Department Id:</label>
			<input id="id" type="number" name="DepartmentIdUpdate"><br /><br />
			
			<input type="submit" value="Update" />
			<br />
		</form>
		<span><%= msgUpdateSeller %></span>
	</div>
	
	<br />
	
	<!-- deleteById -->
	<div class="seller">
	<h3>Delete Seller By Id:</h3>
		<form method="get" action="${pageContext.request.contextPath}/sellerDelete" enctype="multipart/form-data">
			<label for="id">Id:</label>
			<input id="id" type="number" name="IdDeleteSeller"><br /><br />
			
			<input type="submit" value="Delete" />
		</form>
	</div>
	
	<br />
	
	
	<!-- findById -->
	<div class="seller">
	<h3>Find Seller By Id:</h3>
		<form method="get" action="${pageContext.request.contextPath}/sellerFindById" enctype="multipart/form-data">
			<label for="id">Id:</label>
			<input id="id" type="number" name="idFindSeller"><br /><br />
			
			<input type="submit" value="Find" />
			<br /> 
		</form>
		<div class="item">
			<ul>	
				<li><%out.print(seller);%></li>
			</ul>
		</div>
	</div>
	
	<br />
	
	<!-- findAll -->
	<div class="seller">
	<h3>List All Sellers:</h3>
		<form method="get" action="${pageContext.request.contextPath}/sellerFindAll" enctype="multipart/form-data">

			<input type="submit" name="idFindAll" value="Listar-todos"><br /><br />
			<br /> 
		</form>
		
	</div>
	
		<br />
		
	<!-- findByDepartment -->
	<div class="seller">
	<h3>List Sellers by Department:</h3>
		<form method="get" action="${pageContext.request.contextPath}/sellerFindByDepartment" enctype="multipart/form-data">
			<label for="id">Id:</label>
			<input id="id" type="number" name="idDepart"><br /><br />
			
			<input type="submit" value="Listar"><br /><br />
		</form>
		<br /> 
	</div>

</body>
</html>