<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Department"%>  
<%@ page import="java.util.List"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CRUD DEPARTMENTS</title>
<link rel="stylesheet" type="text/css" href="departments.css" media="screen" />
</head>
<body>

	<%
		String msgInsertDepart = (String) request.getAttribute("msgInserDepartAttr");	
	%>
	
	<%
		String msgDeleteDepart = (String) request.getAttribute("msgDeleteAttr");	
	%>
		
	<%
		String msgUpdateDepart = (String) request.getAttribute("msgUpdateAttr");	
	%>
	
	<%
		Department depart = (Department) request.getAttribute("departAttr");
	%>
	
	<h1>Department Manager</h1>
	
	<a href="index.jsp"><span>Home</span></a>
	<br/>
	<br/>
	<!-- insert -->
	<div class="department">
	<h3>Insert Department</h3>
		<form method="get" action="${pageContext.request.contextPath}/departmentInsert" enctype="multipart/form-data">
			<label for="nome-id">Nome:</label>
			<input id="nome-id" type="text" name="nomeInsert"><br /><br />
			
			<input type="submit" value="Insert" />
		</form>
		<br />
		<span><%= msgInsertDepart %></span>
	</div>
	<br />
	
	<!-- update -->
	<div class="department">
	<h3>Update Department</h3>
		<form method="get" action="${pageContext.request.contextPath}/departmentUpdate" enctype="multipart/form-data">
			<label for="id">Id:</label>
			<input id="id" type="number" name="IdUpdate"><br /><br />
			
			<label for="nome-id1">Nome:</label>
			<input id="nome-id1" type="text" name="nomeUpdate"><br /><br />
			
			<input type="submit" value="Update" />
		</form>
		<br />
		<span><%= msgUpdateDepart %></span>
	</div>
	
	<br />
	
	<!-- deleteById -->
	<div class="department">
	<h3>Delete Department By Id:</h3>
		<form method="get" action="${pageContext.request.contextPath}/departmentDelete" enctype="multipart/form-data">
			<label for="id">Id:</label>
			<input id="id" type="number" name="IdDelete"><br /><br />
			
			<input type="submit" value="Delete" />
		</form>
		<br />
		<span><%= msgDeleteDepart %></span>
		
	</div>
	
	<br />
	
	<!-- findById -->
	<div class="department">
	<h3>Find Department By Id:</h3>
		<form method="get" action="${pageContext.request.contextPath}/departmentFindById" enctype="multipart/form-data">
			<label for="id">Id:</label>
			<input id="id" type="number" name="idFind"><br /><br />
			
			<input type="submit" value="Find" />
			<br /> 
		</form>
		<div class="item">
			<ul>	
				<li><%out.print(depart);%></li>
			</ul>
		</div>
	</div>
	
	<br />
	
	<!-- findAll -->
	<div class="department">
	<h3>List All Departments:</h3>
		<form method="get" action="${pageContext.request.contextPath}/departmentFindAll" enctype="multipart/form-data">

			<input type="submit" name="idFindAll" value="Listar-todos"><br /><br />
			<br /> 
		</form>
	</div>
		
</body>
</html>