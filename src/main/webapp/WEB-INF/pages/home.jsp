<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Home page</title>
<%-- <link type="text/css" href="<c:url value='/resources/css/style.css' />" rel="stylesheet" /> --%>
 <link type="text/css" href="assets/css/style.css" rel="stylesheet" />

</head>
<body>
 

<%-- <a href="${pageContext.request.contextPath}/candidate/add.html">Recruiter: Send email  to candidate</a><br/><br/>
<a href="${pageContext.request.contextPath}/candidate/list.html">Admin : Candidate Details</a><br/><br/>
<a href="${pageContext.request.contextPath}/candidate/login.html">Candidate : Login Page</a><br/><br/> --%>


<!-- </p> -->

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
			<li class="nav_root active">
				<a href="${pageContext.request.contextPath}/" class="nav_link" >Home</a>
			</li>
			<li class="nav_root ">
				<a href="${pageContext.request.contextPath}/candidate/add.html" class="nav_link" >Send E-mail to candidate</a>
			</li>
			<li class="nav_root ">
				<a href="${pageContext.request.contextPath}/candidate/list.html" class="nav_link" >Admin</a>
			</li>
			<li class="nav_root ">
				<a href="${pageContext.request.contextPath}/candidate/login.html" class="nav_link" >Candidate - Login</a>
			</li>
	</div>
</div>

<div class="contentbase">
	<p class='pageTitle'>Welcome to Seek Asia Emailing System</p>
	<p class='pagesub'>Technologies Used:</p>
	<ul class='pageul'>
		<li>Java 1.8</li>
		<li>Apache Tomcat 9.0</li>
		<li>Spring MVC</li>
		<li>Hibernet</li>
		<li>Java E-mail API</li>
		<li>Spring Scheduler</li>
		<li>Cron Job</li>
		<li>MySQL</li>
		<li>Maven</li>
		<li>JSP</li>
		<li>JSTL 1.2</li>
		<li>HTML</li>
		<li>CSS</li>
	</ul>
	
</div>

<div class="contentbase">
	<p class='pagesub'>Functionality Description:</p>
			
	<p class = "subTitle"> Batch Jobs Details</p>
	<ul class='pageul'>
		<li>Batch Job 1: SendEmailToActiveUser - Schedule time on everyday at 6 AM 
			<ul> 	<li> In this scheduler will sent email to all user(Candidate) on everyday when candidate status is "Active".</li>
					<li>This scheduler will send the email  to  "Active" user(Candidate) on  every days at 6 AM.</li>
			</ul>
			<br></br>
		</li>
		
		<li>Batch Job 2: SendEmailToNonResponsiveUser - Schedule time on  3 days once at 6.30 AM
			<ul>
				<li>In this scheduler will sent the email to all user(Candidate) on every 3 days once when candidate status is "Not Responsive". </li>
				<li>This scheduler will send the email  to "Non Responsive" candidate on  every days at 6 AM.</li>
			</ul>
			<br></br>
		</li>
		
		<li>Batch Update 3: Update to "Not Responsive"
			<ul>
				<li>In this Batch job will update the status to "Not Responsive"  when user status is "Active" and user login was more than 4 days </li>
				<li>This scheduler will run the batch job to update the status "Non Responsive" on everyday at 6 AM.</li>
			</ul>
			<br></br>
		</li>
		
		<li>Batch Update 4: Update to "Active"
			<ul>
				<li>In this Batch job will update the status to "Active"  when user status is "Non Responsive" and user login during the past 2 days </li>
			</ul>
			<br></br>
		</li>
				
	</ul>
	<p class = "subTitle"> UI Description</p>
		<ul class='pageul'>
			<li> Home
				<ul>
					<li> In this "Home" page will give you detailed information about this "EMailing System" <br/>implementation and how this applications is working.</li>
				</ul>
			</li>
			
			<li> Send E-mail to candidate
				<ul>
					<li>In this page, the recruiter will send the email to new candidate, after successfully sent<br/> email to  candidate these records will
						updating to database and the status will be "Active".
					</li>
				</ul>
			</li>
			
			<li> Admin -(Display All Candidate List)
				<ul>
					<li> This page only for Recruiter -Admin use only. Here will display all the candidate details for admin reference <br/>. The admin have 
					right to edit the new candidate info/.
					</li>
				</ul>
			</li>
			
				<li> Candidate - Login
				<ul>
					<li> The candidate will login  our system using  registered email email-id.
					</li>
				</ul>
			</li>
			
		</ul>
	
	<p class='rightHeader'>Developed by: RAMESH D.</p>
</div>
</body>
</html>