package com.seekasia.emailsystem.dao;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.seekasia.emailsystem.constant.CanditateConstant;
import com.seekasia.emailsystem.dao.CandidateDAO;
import com.seekasia.emailsystem.model.Candidate;
@Repository
public class CandidateDAOImpl implements CandidateDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	Date date = new Date();
	Timestamp timestamp = new Timestamp(date.getTime());
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public String addCandidate(Candidate candidate) {
		candidate.setEmailStatus(CanditateConstant.ACTIVE_STATUS);
		candidate.setCandidateEmailViewedDate(timestamp);
		try{
			 getCurrentSession().save(candidate);
			 return CanditateConstant.SUCCESS;
		}catch(Exception ex){
			System.out.println("ex-------"+ex.getMessage());
			return  CanditateConstant.FAILED_STATUS;
		}
		
	}

	public void updateCandidate(Candidate candidate) {
		
		Candidate candidateToUpdate = getCandidate(candidate.getId());
		candidateToUpdate.setEmail(candidate.getEmail());
		candidateToUpdate.setEmailStatus(candidate.getEmailStatus());
		candidateToUpdate.setEmailMessage(candidate.getEmailMessage());
		candidateToUpdate.setCandidateEmailViewedDate(timestamp);
		getCurrentSession().update(candidateToUpdate);
		
	}

	public Candidate getCandidate(int id) {
		Candidate candidate= (Candidate) getCurrentSession().get(Candidate.class, id);
		return candidate;
	}

	public void deleteCandidate(int id) {
		Candidate candidate = getCandidate(id);
		if (candidate != null)
			getCurrentSession().delete(candidate);
	}

	@SuppressWarnings("unchecked")
	public List<Candidate> getCandidates() {
		return getCurrentSession().createQuery(CanditateConstant.FROM_CANDIDATE).list();
	}

	@SuppressWarnings("unchecked")
	public List<Candidate> getActiveUserList() {
		return  getCurrentSession().createQuery(CanditateConstant.FROM_ACTIVE_CANDIDATE).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Candidate> getNonResponsiveUserList() {
		return  getCurrentSession().createQuery(CanditateConstant.FROM_NON_RESPONSIVE_CANDIDATE).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Candidate> verifyCandidateLoginbyEmail(String loginEmailID) {
			String sql = CanditateConstant.SELECT_QUERY;
		 	Query query = getCurrentSession().createQuery(sql);
		 	query.setParameter(CanditateConstant.EMAI_LBL, loginEmailID);  

			List<Candidate> results = query.list();
		 	return results ;
	}

	// If the user  is "Active" and user last login was  more than 4 days  ago, then mark as a "Not Responsive"
	// If the user  is "Non Responsive" and user last login was  more than 2 days  ago, then mark as a "Active"
	// If the user  is "Non Responsive" and user last login was  more than 2 days  ago, then mark as a "InActive"
	
	@Override
	public void updateStatusJob(String currentStatus,int lastLoginDaysBefore,String newStatus) {
		   Calendar cal = Calendar.getInstance();
		   cal.setTime(date);
		   cal.add(Calendar.DATE, lastLoginDaysBefore);
		   Date dateBefore4Day = cal.getTime();
		   Timestamp dateBefore4Days = new Timestamp(dateBefore4Day.getTime());
		   
		Query query = getCurrentSession()
                .createQuery(CanditateConstant.BATCH_UPDATE_QUERY);
        query.setParameter(CanditateConstant.STATUS_KEY, newStatus);
        query.setParameter(CanditateConstant.E_STATUS_KEY, currentStatus);
        query.setParameter(CanditateConstant.E_SEND_DATE_KEY, dateBefore4Days);
		int result = query.executeUpdate();
		System.out.println("Batch update status -->"+result);
	}

}
