package com.seekasia.emailsystem.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import com.seekasia.emailsystem.constant.CanditateConstant;
import com.seekasia.emailsystem.service.CandidateService;

public class StatusUpdateToActiveScheduler {
	
	@Autowired
	private CandidateService candidateSerive;
	
	public StatusUpdateToActiveScheduler() {
	}
	
	//Mark it as a candidate status to "Non Responsive", if the user is "Active" and user last login  was more than 2 days ago
	@Scheduled(cron = "0 30 09 */2 * *") //0 30 06 */3 * *  
	public void StatusUpdateToActiveScheduler() {
		System.out.println("StatusUpdateToActiveScheduler  ");
		 candidateSerive.updateStatusJob(CanditateConstant.NON_RESPONSIVE,CanditateConstant.UPDATE_2DAYS_FREQUENCY,CanditateConstant.ACTIVE_STATUS);
	}
}
