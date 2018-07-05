package com.seekasia.emailsystem.scheduler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import com.seekasia.emailsystem.constant.CanditateConstant;
import com.seekasia.emailsystem.model.Candidate;
import com.seekasia.emailsystem.service.CandidateService;
import com.seekasia.emailsystem.util.SendEmailUtil;

public class SendEmailToActiveUserScheduler {
	

	@Autowired
	private CandidateService candidateSerive;

	private SendEmailUtil emailUtil = new SendEmailUtil();

	public SendEmailToActiveUserScheduler() {
	}
	  // This scheduler will send the email  to active user every days at 6 AM
	@Scheduled(cron = "0 0 6 ? * *")//"0 0 6 ? * *"
	public void SendEmailToActiveUserScheduler() {
		List<Candidate> listOfActiveEmails = candidateSerive.getActiveUserList();
		for (Candidate candidate : listOfActiveEmails) {
			String emailStauts = emailUtil.sendEmail(candidate.getEmail(), CanditateConstant.ACTIVE_EMAIL_SUBJECT, CanditateConstant.ACTIVE_EMAIL_MESSAGE);
			System.out.println("SendEmailToActiveUserScheduler -- Active user email status-----"+emailStauts);
		}
	}
	
}
