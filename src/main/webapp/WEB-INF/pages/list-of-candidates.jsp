<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>List of Job ooking Persons</title>
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
			<li class="nav_root active">
				<a href="${pageContext.request.contextPath}/candidate/list.html" class="nav_link" >Admin</a>
			</li>
			<li class="nav_root ">
				<a href="${pageContext.request.contextPath}/candidate/login.html" class="nav_link" >Candidate - Login</a>
			</li>
	</div>
</div>

<div class="contentbase">
<h1>Candidate List</h1>
<p>Here you can see the list of candidate(his/her) email and email status - Perform edit/remove/update candidate details by recruiter.</p>
<table border="1px" cellpadding="0" cellspacing="0" >
<thead>
<tr>
<th width="10%">id</th><th width="15%">Email</th><th width="10%">Email Status</th><th width="10%">System Email Send Date</th><th width="10%">Job Searcher Email Viewed Date</th>
<th width="10%">Email Message</th>
</tr>
</thead>
<tbody>
<c:forEach var="candidate" items="${candidate}">
<tr>
	<td>${candidate.id}</td>
	<td>${candidate.email}</td>
	<td>${candidate.emailStatus}</td>
	<td>${candidate.recuriterEmailSendDate}</td>
	<td>${candidate.candidateEmailViewedDate}</td>
	<td>
	<a href="${pageContext.request.contextPath}/candidate/edit/${candidate.id}.html">Edit</a><br/>
	<%-- <a href="${pageContext.request.contextPath}/candidate/delete/${candidate.id}.html">Delete</a><br/> --%>
	</td>
</tr>
</c:forEach>
</tbody>
</table>

<div><p class='message'><br/> ${message}<br/> </p></div>
</div>
</body>
</html>