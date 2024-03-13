<%@page import="com.entity.Student"%>
<%@page import="com.conn.DBconnect"%>
<%@page import="com.DAO.StudentDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body class="bg-light">
<%@include file="allCSS.jsp" %>
<%@include file="navbar.jsp" %>

<div class="container p-4">
<div class="row">
<div class="col-md-6 offset-md-4">
<div class="card">
<div class="card-body">
<p class="fs-3 text-center">Edit Student</p>

<%
int id= Integer.parseInt(request.getParameter("id"));
StudentDAO dao=new StudentDAO(DBconnect.getConn());
Student s=dao.getStudentID(id);
%>
<form action="update" method="post">

 <div class="mb-3">
    <label class="form-label">Full Name</label>
    <input type="text" name="name" class="form-control" value="<%=s.getFullname()%>">
</div>
  <div class="mb-3">
    <label class="form-label">Date of Birth</label>
    <input type="date" name="dob"form-control" value="<%=s.getDob()%>"></div>
    
 <div class="mb-3">
    <label class="form-label">Address</label>
    <input type="text" name="address"form-control" value="<%=s.getAddress()%>"></div>
    
    <div class="mb-3">
    <label class="form-label">Qualification </label>
    <input type="text" name="qualification" class="form-control" value="<%=s.getQualification()%>"></div>
  
  <div class="mb-3">
    <label class="form-label">Email address</label>
    <input type="email" name="email" class="form-control" value="<%=s.getEmail()%>"></div>
      <input type="hidden" name="id" value="<%=s.getId()%>">
  
  <button type="submit" class="btn btn-primary col-md-12">Update</button>
</form>
</div>
</div>
</div>
</div>
</div>

</body>
</html>