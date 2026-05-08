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

int empno =
Integer.parseInt(request.getParameter("empno"));

String empname =
request.getParameter("empname");

int salary =
Integer.parseInt(request.getParameter("salary"));

Class.forName("com.mysql.cj.jdbc.Driver");

Connection con = DriverManager.getConnection(
"jdbc:mysql://localhost:3306/Employee",
"root",
"Anusha@12");

// INSERT RECORD
PreparedStatement pst = con.prepareStatement(
"insert into Emp values(?,?,?)");

pst.setInt(1, empno);
pst.setString(2, empname);
pst.setInt(3, salary);

try{

pst.executeUpdate();

}
catch(Exception e){

out.println("<h3>Employee Number Already Exists!</h3>");

}

// DISPLAY REPORT
Statement st = con.createStatement();

ResultSet rs = st.executeQuery(
"select * from Emp");

int grandSalary = 0;

%>

<div class="report">

<h2 align="center">
Salary Report
</h2>

<hr>

<%

while(rs.next())
{

grandSalary =
grandSalary + rs.getInt("BasicSalary");

%>

<p>
Emp_No :
<%= rs.getInt("Emp_No") %>
</p>

<p>
Emp_Name :
<%= rs.getString("Emp_Name") %>
</p>

<p>
Basic :
<%= rs.getInt("BasicSalary") %>
</p>

<hr>

<%
}
%>

<h3>
Grand Salary :
<%= grandSalary %>
</h3>

</div>

</body>
</html>