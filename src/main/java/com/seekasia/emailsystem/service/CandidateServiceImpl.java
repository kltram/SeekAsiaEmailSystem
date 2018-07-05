package com.seekasia.emailsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.seekasia.emailsystem.dao.CandidateDAO;
import com.seekasia.emailsystem.model.Candidate;
import com.seekasia.emailsystem.scheduler.SendEmailToActiveUserScheduler;
import com.seekasia.emailsystem.util.SendEmailUtil;

@Service
@Transactional
public class CandidateServiceImpl implements CandidateService {
	
	@Autowired
	private CandidateDAO candidateDAO;
	
	SendEmailUtil sendEmailUtil = new SendEmailUtil();
	SendEmailToActiveUserScheduler sendEmailTaskScheduler = new SendEmailToActiveUserScheduler();

	public String addCandidate(Candidate candidate) {
		return candidateDAO.addCandidate(candidate);		
	}

	public void updateCandidate(Candidate candidate) {
		candidateDAO.updateCandidate(candidate);
	}

	public Candidate getCandidate(int id) {
		return candidateDAO.getCandidate(id);
	}

	public void deleteCandidate(int id) {
		candidateDAO.deleteCandidate(id);
	}

	public List<Candidate> getCandidates() {
		return candidateDAO.getCandidates();
	}

	public String sendEmailToCandidate(String emailTo, String emailSub, String emailMeg) {
		 return sendEmailUtil.sendEmail(emailTo, emailSub, emailMeg);
	}
	
	public List<Candidate> getActiveUserList(){
		return candidateDAO.getActiveUserList();
	}
	
	public List<Candidate> getNonResponsiveUserList(){
		return candidateDAO.getNonResponsiveUserList();
	}

	@Override
	public List<Candidate> verifyCandidateLoginbyEmail(String loginEmailID) {
		return candidateDAO.verifyCandidateLoginbyEmail(loginEmailID);
	}

	
	public void updateStatusJob(String currentStatus,int lastLoginDaysBefore,String newStatus) {
		candidateDAO.updateStatusJob(currentStatus,lastLoginDaysBefore,newStatus);
	}

}
