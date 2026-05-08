<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Query</title>

<style>

body{
    font-family:Arial;
    background:#f2f2f2;
}

.container{
    width:350px;
    margin:100px auto;
    background:white;
    padding:20px;
    border-radius:10px;
    box-shadow:0px 0px 10px gray;
}

input{
    width:100%;
    padding:10px;
    margin-top:15px;
}

button{
    width:100%;
    padding:10px;
    margin-top:15px;
    background:blue;
    color:white;
    border:none;
}

</style>

</head>

<body>

<div class="container">

<h2 align="center">Employee Query Form</h2>

<form action="Employee.jsp" method="post">

<input type="text"
name="ch"
placeholder="Enter Starting Character"
required>

<button type="submit">
Generate Report
</button>

</form>

</div>

</body>
</html>