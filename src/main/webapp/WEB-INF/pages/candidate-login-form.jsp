<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Add candidate page</title>
<link type="text/css" href="../assets/css/style.css" rel="stylesheet" />
</head>
<body>

<header class="header">
			
	<div class="header_logo">
		<div class="header_inner">
			
			<a href="https://www.seekasia.com/" >
				<img src='https://www.seekasia.com/img/logo-seekasia.png'>
			</a>
		</div>
	</div>
</header>

<div class="navigationBar">
	<div class="nav_inner">
		<ul>
			<li class="nav_root ">
				<a href="${pageContext.request.contextPath}/" class="nav_link" >Home</a>
			</li>
			<li class="nav_root ">
				<a href="${pageContext.request.contextPath}/candidate/add.html" class="nav_link" >Send E-mail to candidate</a>
			</li>
			<li class="nav_root ">
				<a href="${pageContext.request.contextPath}/candidate/list.html" class="nav_link" >Admin</a>
			</li>
			<li class="nav_root active">
				<a href="${pageContext.request.contextPath}/candidate/login.html" class="nav_link" >Candidate - Login</a>
			</li>
	</div>
</div>

<div class="contentbase">
<h1>Candidate Login</h1>
<p>Please use your registered e-mail to login.</p>
<form:form method="POST" commandName="candidate" action="${pageContext.request.contextPath}/candidate/login.html">
<table>
<tbody>
	<tr class = "lineText">
		<td>Email To:</td>
		<td><form:input path="email" size="64" /></td>
	</tr>
	
	<tr class = "lineText">
		<td><input type="submit" value="Login" /></td>
		<td></td>
	</tr>
</tbody>
</table>
</form:form>
<div><p class='message'><br/> ${message}<br/> </p></div>
</div>
</body>
</html>