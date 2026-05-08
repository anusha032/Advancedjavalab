<%@ page import="java.sql.*" %>

<html>
<head>
<title>Salary Report</title>

<style>

body{
    font-family:Arial;
    margin:40px;
}

.report{
    width:500px;
    border:2px solid black;
    padding:20px;
}

</style>

</head>

<body>

<%

String ch = request.getParameter("ch");

Class.forName("com.mysql.cj.jdbc.Driver");

Connection con = DriverManager.getConnection(
"jdbc:mysql://localhost:3306/Employee",
"root",
"Anusha@12");

// DELETE QUERY
PreparedStatement pst1 = con.prepareStatement(
"DELETE FROM Emp WHERE Emp_Name LIKE ?");

pst1.setString(1, ch + "%");

pst1.executeUpdate();

// SELECT REMAINING RECORDS
PreparedStatement pst2 = con.prepareStatement(
"SELECT * FROM Emp");

ResultSet rs = pst2.executeQuery();

%>

<div class="report">

<h2 align="center">Salary Report</h2>

<hr>

<%

while(rs.next())
{

%>

<p>
Emp_No : <%= rs.getInt("Emp_No") %>
</p>

<p>
Emp_Name : <%= rs.getString("Emp_Name") %>
</p>

<p>
Basic : <%= rs.getInt("BasicSalary") %>
</p>

<hr>

<%
}
%>

</div>

</body>
</html>