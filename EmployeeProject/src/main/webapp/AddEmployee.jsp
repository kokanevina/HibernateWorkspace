<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AddEmployee</title>
</head>
<body>
<h2>Enter Employee Details to store</h2>
<form action="EmployeeServlet" method="post">
<label>Enter id:</label>
<input type="number" name="empId"> 
<label>Enter name:</label>
<input type="text" name="empName"> 
<label>Enter salary:</label>
<input type="number" name="empSalary"> 
<label>Enter qualification:</label>
<input type="text" name="qual"> 
<input type="submit"> 
<input type="hidden" name="act" value="add">
</form>
</body>
</html>