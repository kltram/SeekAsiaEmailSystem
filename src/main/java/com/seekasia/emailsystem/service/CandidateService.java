package com.seekasia.emailsystem.service;

import java.util.List;

import com.seekasia.emailsystem.model.Candidate;

public interface CandidateService {
	// Add new Candidate
	public String addCandidate(Candidate candidate);
	public void updateCandidate(Candidate candidate);
	public Candidate getCandidate(int id);
	public void deleteCandidate(int id);
	// List out all candidate details
	public List<Candidate> getCandidates();
	//Send Email to new candidate  by Recuriter
	public String sendEmailToCandidate(String emailTo, String emailSub, String emailMeg);
	// Get all "Active" user list - To send a email this user  every day at 6 AM
	public List<Candidate> getActiveUserList();
	
	//Send a email to all "Non Responsive" candidate to every 3 days once
	public List<Candidate> getNonResponsiveUserList();
	
	// If the user  is "Active" and user last login was  more than 4 days  ago, then mark as a "Not Responsive"
	// If the user  is "Non Responsive" and user last login was  more than 2 days  ago, then mark as a "Active"
	// If the user  is "Non Responsive" and user last login was  more than 2 days  ago, then mark as a "InActive"
	public void updateStatusJob(String currentStatus,int lastLoginDaysBefore,String newStatus);
	
	//Candidate Login
	public List<Candidate> verifyCandidateLoginbyEmail(String loginEmailID);
}
