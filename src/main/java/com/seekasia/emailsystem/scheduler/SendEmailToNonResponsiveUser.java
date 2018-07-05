package com.seekasia.emailsystem.scheduler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import com.seekasia.emailsystem.constant.CanditateConstant;
import com.seekasia.emailsystem.model.Candidate;
import com.seekasia.emailsystem.service.CandidateService;
import com.seekasia.emailsystem.util.SendEmailUtil;
/***
 * 
 */
public class SendEmailToNonResponsiveUser {



	@Autowired
	private CandidateService candidateSerive;

	private SendEmailUtil emailUtil = new SendEmailUtil();
	
	public SendEmailToNonResponsiveUser() {
	}
  // This scheduler will send the email  to Non Responsive user every 3 days one at 6.30 AM
	@Scheduled(cron = "0 30 06 */3 * *") //0 4 11 ? * *   
	public void SendEmailToNonResponsiveUser() {
		List<Candidate> listOfActiveEmails = candidateSerive.getNonResponsiveUserList();
		for (Candidate candidate : listOfActiveEmails) {
			String emailStauts = emailUtil.sendEmail(candidate.getEmail(), CanditateConstant.ACTIVE_EMAIL_SUBJECT, CanditateConstant.ACTIVE_EMAIL_MESSAGE);
			System.out.println("SendEmailToActiveUserScheduler--" + candidate.getEmail() + "---Not responsive user email status-----"+emailStauts);
		}
	}
}
