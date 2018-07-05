package com.seekasia.emailsystem.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import com.seekasia.emailsystem.constant.CanditateConstant;
import com.seekasia.emailsystem.service.CandidateService;

public class StatusUpdateToInactiveScheduler {
	
	@Autowired
	private CandidateService candidateSerive;
	
	public StatusUpdateToInactiveScheduler() {
	}
	
	//Mark it as a candidate status to "Inactive", if the user is "Non Responsive" and user last login  was more than 2 days ago
	@Scheduled(cron = "0 15 09 */2 *") //0 30 06 */3 * *  
	public void StatusUpdateAsInactiveScheduler() {
		System.out.println("StatusUpdateScheduler  ");
		 candidateSerive.updateStatusJob(CanditateConstant.NON_RESPONSIVE,CanditateConstant.UPDATE_2DAYS_FREQUENCY,CanditateConstant.INACTIVE);
	}
}
