package com.seekasia.emailsystem.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CandidateEmails")
public class Candidate {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String email;
	
	private String emailStatus;
	
	private String emailMessage;
	
	private Date recuriterEmailSendDate;
	
	private Date candidateEmailViewedDate;
	

	public String getEmailMessage() {
		return emailMessage;
	}
	
	public void setEmailMessage(String emailMessage) {
		this.emailMessage = emailMessage;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmailStatus() {
		return emailStatus;
	}
	public void setEmailStatus(String emailStatus) {
		this.emailStatus = emailStatus;
	}
	
	public Date getRecuriterEmailSendDate() {
		return recuriterEmailSendDate;
	}
	public void setRecuriterEmailSendDate(Date recuriterEmailSendDate) {
		this.recuriterEmailSendDate = recuriterEmailSendDate;
	}
	
	public Date getCandidateEmailViewedDate() {
		return candidateEmailViewedDate;
	}
	public void setCandidateEmailViewedDate(Date candidateEmailViewedDate) {
		this.candidateEmailViewedDate = candidateEmailViewedDate;
	}
	
	/*public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}*/

}
