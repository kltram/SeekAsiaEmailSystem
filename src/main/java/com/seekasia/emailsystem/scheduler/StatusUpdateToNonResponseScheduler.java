package com.seekasia.emailsystem.scheduler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import com.seekasia.emailsystem.constant.CanditateConstant;
import com.seekasia.emailsystem.model.Candidate;
import com.seekasia.emailsystem.service.CandidateService;

public class StatusUpdateToNonResponseScheduler {
	
	@Autowired
	private CandidateService candidateSerive;
	
	public StatusUpdateToNonResponseScheduler() {
	}
	
	//Mark it as a candidate status to "Non Responsive", if the user is "Active" and user last login  was more than 4 days ago
		@Scheduled(cron = "0 0 9 */4 * *") //0 30 06 */3 * *  
		public void StatusUpdateAsNonResponseScheduler() {
			System.out.println("StatusUpdateScheduler  ");
			 candidateSerive.updateStatusJob(CanditateConstant.ACTIVE_STATUS,CanditateConstant.UPDATE_4DAYS_FREQUENCY,CanditateConstant.NON_RESPONSIVE);
		}
	
}
