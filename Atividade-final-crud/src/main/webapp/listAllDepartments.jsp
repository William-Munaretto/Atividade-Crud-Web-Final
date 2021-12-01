<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Department"%>  
<%@ page import="java.util.List"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<%
		List<Department> depart2 = (List<Department>) request.getAttribute("listDepartAttr");
	%>
	
	<a href="department.jsp">Department Sistem</a>
			<% for(Department d : depart2){ %>
			<ul>
				<li>Id: <%out.println(d.getId()); %>
				<li>Nome: <%out.println(d.getName());%></li>
			</ul>
			<% } %>
			
	

</body>
</html>