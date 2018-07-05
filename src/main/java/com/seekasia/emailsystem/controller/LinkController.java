package com.seekasia.emailsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.seekasia.emailsystem.constant.CanditateConstant;

@Controller
public class LinkController {
	
	@RequestMapping(value="/")
	public ModelAndView mainPage() {
		return new ModelAndView(CanditateConstant.HOME_MSG);
	}
	
	@RequestMapping(value="/index")
	public ModelAndView indexPage() {
		return new ModelAndView(CanditateConstant.HOME_MSG);
	}
}
