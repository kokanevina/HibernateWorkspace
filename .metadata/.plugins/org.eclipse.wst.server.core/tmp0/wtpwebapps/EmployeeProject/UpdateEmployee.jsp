<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UpdateForm</title>
</head>
<body>
<h2>Update Employee Details</h2>
<form action="EmployeeServlet" method="post">
<label>Enter id:</label> 
<input type="number" name="empId"  value="${employee.empId}" readonly="readonly"> 
<label>Enter name:</label>
<input type="text" name="empName"  value="${employee.empName}"> 
<label>Enter salary:</label>
<input type="number" name="empSalary"  value="${employee.empSalary}"> 
<label>Enter qualification:</label>
<input type="text" name="qual"  value="${employee.qualification}"> 
<input type="submit" value="update"> 
<input type="hidden" name="act" value="update">
</form>
</body>
</html>