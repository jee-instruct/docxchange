package com.vamsee.spring.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.vamsee.spring.controllers.beans.RegistrationForm;
import com.vamsee.spring.properties.AppProperties;
import com.vamsee.spring.services.RegistrationService;

@Controller
public class AppController {
	
	
	@Autowired
	private RegistrationService registrationService;
	
	@Autowired
	private AppProperties appProperties;
	
	
	private static final Logger LOGGER = Logger.getLogger(AppController.class);
	
	@RequestMapping(value = "/", method = { RequestMethod.GET,RequestMethod.POST })
	public ModelAndView indexPage(){
		return new ModelAndView("index");
	}
	
	
	@RequestMapping(value = "/dashboard", method = { RequestMethod.GET,RequestMethod.POST })
	public ModelAndView dashboardPage(){
		return new ModelAndView("dashboard");
	}
	
	@RequestMapping(value = "/autosuggest", method = { RequestMethod.GET,RequestMethod.POST })
	public ModelAndView autosuggestPage(){
		return new ModelAndView("autosuggest");
	}
	
	
	@RequestMapping(value = "/upload", method = { RequestMethod.GET })
	public ModelAndView uploadPage(){
		return new ModelAndView("upload");
	}
	
	
	@RequestMapping(value = "/search", method = { RequestMethod.GET,RequestMethod.POST })
	public ModelAndView searchPage(){
		return new ModelAndView("search");
	}
	
	
	@RequestMapping(value = "/error", method = { RequestMethod.GET})
	public ModelAndView errorPage(){
		return new ModelAndView("error");
	}
	
	@RequestMapping(value = "/contact", method = { RequestMethod.GET,RequestMethod.POST })
	public ModelAndView contactusPage() {
		return new ModelAndView("contact");
	}
	
	@RequestMapping(value = "/signin", method = { RequestMethod.GET})
	public ModelAndView signinPage() {
		return new ModelAndView("signin").addObject("forgotPasswordURL", appProperties.getForgotPasswordURL());
	}
	
	@RequestMapping(value = "/registration", method = { RequestMethod.GET })
	public ModelAndView registrationPage() {
		return new ModelAndView("registration","registrationForm", new RegistrationForm(registrationService.getRefUserTypes()));
	}
	
	@RequestMapping(value = "/registration", method = { RequestMethod.POST })
	public ModelAndView registrationSubmitPage(@ModelAttribute("registrationForm")RegistrationForm registrationForm) {
		if(registrationService.checkIfUserAlreadyRegistered(registrationForm.getEmailId())){
			return new ModelAndView("emailAlreadyRegistered");
		}else{
			registrationService.saveNewRegistration(registrationForm);
		}
		return new ModelAndView("registrationSubmitted");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
