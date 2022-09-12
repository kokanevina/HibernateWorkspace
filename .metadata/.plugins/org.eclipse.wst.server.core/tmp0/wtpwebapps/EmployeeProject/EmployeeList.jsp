<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/sql"  prefix="sql"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Emplist</title>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>

${successMessage}
<table>
<c:forEach items="${eList}" var="emp">
<tr>
	<td>${emp.empId}</td>
	<td>${emp.empName}</td>
	<td>${emp.empSalary}</td>
	<td>${emp.qualification}</td>
	<td><a href="EmployeeServlet?act=delete&id=${emp.empId}">delete</a></td>
	<td><a href="EmployeeServlet?act=get&id=${emp.empId}">update</a>
	<td><a href="CartServlet?act=addtocart&id=${emp.empId}">ADD to CART</a>
</tr>
</c:forEach>
</table>
</body>
</html>