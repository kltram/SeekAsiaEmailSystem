package com.seekasia.emailsystem.dao;

import java.util.List;

import com.seekasia.emailsystem.model.Candidate;

public interface CandidateDAO {
	
	public String addCandidate(Candidate candidate);
	public void updateCandidate(Candidate candidate);
	public Candidate getCandidate(int id);
	public void deleteCandidate(int id);
	public List<Candidate> getCandidates();
	public List<Candidate> getActiveUserList();
	public List<Candidate> getNonResponsiveUserList();
	public List<Candidate> verifyCandidateLoginbyEmail(String loginEmailID);
	
	public void updateStatusJob(String currentStatys,int lastLoginDaysBefore,String newStatus);
}
