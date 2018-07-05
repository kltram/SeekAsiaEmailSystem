SeekAsiaEmailSystem  (Application Screenshot are placed inside the /resources/doc folder )
===========
## Technologies Used:
 Java 1.8
 
 Apache Tomcat 9.0
 
 Spring MVC
 
 Hibernet
 
 Java E-mail API
 
 Spring Scheduler
 
 Cron Job
 
 MySQL
 
 Maven
 
 JSP
 
 JSTL 1.2
 
 HTML
 
 CSS

## System Step-up
  First Install required softwares in your machine

## MySql
 
 1. Install MySQL 
 
 2. Create Schema - Using the below Comment,
 	CREATE SCHEMA IF NOT EXISTS emailsystem;
 		 
 3. Create table "CandidateEmails",
 
 		 CREATE TABLE IF NOT EXISTS `CandidateEmails` (
			  `id` int(6) NOT NULL AUTO_INCREMENT,
			  `email` char(50) NOT NULL,
			  `emailStatus` char(50) NOT NULL,
			  `emailMessage` varchar(500) DEFAULT NULL,
			  `recuriterEmailSendDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
			  `candidateEmailViewedDate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
			  PRIMARY KEY (`id`),
			  UNIQUE KEY `email` (`email`)
			) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8
			
4.Table is created successfully.

## Setup the project in Eclipse
==================================

 	1. Open the Eclipse
 	2. Import the "SeekAsiaEmailSystem" Maven Project into eclipse below steps "

	  	2.1		Click "File" Menu --> select "Import" --> Select "Existing Maven Project "
	  	2.2		Select Root Directory "SeekAsiaEmailSystem"
	  	2.3		Select "pom.xml" 
	  	2.4		Click "Finish" button.
	  	
	3. Refresh  the project
	4. Clean the project (Select "Project" menu --> select "clean")
	
	
## Build and  Run the Project.
	
	1. Right Click the project "SeekAsiaEmailSystem"
	2. Select "Run As"
	3. Select "Run As Server" ---> Select "Finish"

## Go to Browser
	1. Open the browser
	2.  Enter "http://localhost:8080/SeekAsiaEmailSystem/"
	3. Application "SeekAsiaEmailSystem" is Started
	
# Project work flow
----------------------
  
## Project High Lights

   	 1. Email Setup
    
   	 2. Recruiter Login page -Adding each/new candidate details are stored in to table with the status is "Active"
    
   	 3. Candidate Login Page -User login using with existing login
    
   	 4. Backend Batch job - <b>Batch job will run/update /send emdil to candidate based on existing candidate data.</b>
    
   	 5. Backend Scheduler - <b>The job schedular will automatically send the email and update table status based on duration as per the  requirement.</b>
   	 
   	 6. Admin Page
   	 
   	 
   	 
   	 7. <b>The  table "CandidateEmails" status will keep update automatically on everyday(As per the requirement) with help of batch job execution.</b>
    
<u>In this application have 4 main pages</u>
    
	 1. "Home" Page -In this contain information about all the functionality of  "SeekAsiaEmailSystem" application. 
	 2. "Send-E-mail to Candidate Page" - Recruiter sent emails to candidate any time and all the details are updated "CandidateEmails" table.
	 3. "Admin" Page (For Recruiter reference) - Here listout all the candidate details with the status, email_Created_Date,Email_status, Email_Message , Email and last_updated_date.
	 4. "Candidate - Login" Page - After candidate receiving the email ,he/her will login using the same emailID.
	 
	 
	 
	 ![alt tag](http://url/to/img.png)
