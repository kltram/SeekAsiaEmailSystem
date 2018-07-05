package com.seekasia.emailsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.seekasia.emailsystem.constant.CanditateConstant;
import com.seekasia.emailsystem.model.Candidate;
import com.seekasia.emailsystem.service.CandidateService;

@Controller
@RequestMapping(value = "/candidate")
public class CandidateController {

	@Autowired
	private CandidateService candidateService;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addCandidatePage() {
		ModelAndView modelAndView = new ModelAndView(CanditateConstant.ADD_VIEW_FORM);
		modelAndView.addObject(CanditateConstant.CANDIDATE, new Candidate());
		return modelAndView;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView addingCandidateDetails(@ModelAttribute Candidate candidate) {
		String message = "";
		ModelAndView modelAndView = new ModelAndView(CanditateConstant.ADD_VIEW_FORM);
		String status = candidateService.sendEmailToCandidate(candidate.getEmail(), candidate.getEmailStatus(),
				candidate.getEmailMessage());
		if (status.equals(CanditateConstant.SUCCESS)) {
			String addObj = candidateService.addCandidate(candidate);
			System.out.println("Added to DB"+addObj);
			message = CanditateConstant.EMAIL_SUCCESS_MSG;
		} else {
			message = status;
		}
		modelAndView.addObject(CanditateConstant.MESSAGE, message);

		return modelAndView;
	}

	@RequestMapping(value = "/list")
	public ModelAndView listOfCandidates() {
		ModelAndView modelAndView = new ModelAndView(CanditateConstant.CANDIDATE_LIST_FORM);

		List<Candidate> candidate = candidateService.getCandidates();
		modelAndView.addObject(CanditateConstant.CANDIDATE, candidate);

		return modelAndView;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editCandidatePage(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView(CanditateConstant.CANDIDATE_EDIT_FORM);
		Candidate candidate = candidateService.getCandidate(id);
		modelAndView.addObject(CanditateConstant.CANDIDATE, candidate);
		return modelAndView;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public ModelAndView edditingCandidate(@ModelAttribute Candidate candidate, @PathVariable Integer id) {

		ModelAndView modelAndView = new ModelAndView(CanditateConstant.CANDIDATE_EDIT_FORM);

		candidateService.updateCandidate(candidate);

		modelAndView.addObject(CanditateConstant.MESSAGE, CanditateConstant.UPDATE_SUCCESS_MSG);

		return modelAndView;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteCandidate(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView(CanditateConstant.CANDIDATE_LIST_FORM);
		candidateService.deleteCandidate(id);
		modelAndView.addObject(CanditateConstant.MESSAGE, CanditateConstant.DELETE_SUCCESS_MSG);
		return modelAndView;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginPage() {
		ModelAndView modelAndView = new ModelAndView(CanditateConstant.CANDIDATE_LOGIN_FORM);

		modelAndView.addObject(CanditateConstant.CANDIDATE, new Candidate());
		return modelAndView;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginCandidate(@ModelAttribute Candidate candidate) {
		String message = "";
		ModelAndView modelAndView = new ModelAndView(CanditateConstant.CANDIDATE_LOGIN_FORM);

		List<Candidate> loginSuccess = candidateService.verifyCandidateLoginbyEmail(candidate.getEmail());

		if (loginSuccess.size() == 1) {
			candidateService.updateCandidate(loginSuccess.get(0));
			message = CanditateConstant.LOGIN_SUCCESS_MSG;
		} else {
			message = CanditateConstant.LOGIN_FAILED_MSG;
		}
		modelAndView.addObject(CanditateConstant.MESSAGE, message);

		return modelAndView;
	}

}
