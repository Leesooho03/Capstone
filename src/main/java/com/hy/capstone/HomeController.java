package com.hy.capstone;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
			
		return "login";
	}
	@RequestMapping(value = "/index.do", method = RequestMethod.GET)
	public String home2(Locale locale, Model model) {
		
		return "index";
	}
	
	@RequestMapping(value = "/org.do", method = RequestMethod.GET)
	public String ui_buttons(Locale locale, Model model) {
		
		return "org";
	}
	
	@RequestMapping(value = "/ui-alerts.do", method = RequestMethod.GET)
	public String ui_alerts(Locale locale, Model model) {
		
		return "ui-alerts";
	}
	
	@RequestMapping(value = "/ui-forms.do", method = RequestMethod.GET)
	public String forms(Locale locale, Model model) {
		
		return "ui-forms";
	}
	
	@RequestMapping(value = "/ui-typography.do", method = RequestMethod.GET)
	public String typography(Locale locale, Model model) {
		
		return "ui-typography";
	}
	
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {
		
		return "login";
	}
	
	@RequestMapping(value = "/register.do", method = RequestMethod.GET)
	public String register(Locale locale, Model model) {
		
		return "register";
	}
	
	@RequestMapping(value = "/icon-tabler.do", method = RequestMethod.GET)
	public String table(Locale locale, Model model) {
		
		return "icon-tabler";
	}
	@RequestMapping(value = "/sample-page.do", method = RequestMethod.GET)
	public String sample_page(Locale locale, Model model) {
		
		return "sample-page";
	}
	@RequestMapping(value = "/cal.do", method = RequestMethod.GET)
	public String cal(Locale locale, Model model) {
		
		return "cal";
	}
	
/*	@RequestMapping(value = "/cal_1.do", method = RequestMethod.GET)
	public String cal1(Locale locale, Model model) {
		
		return "cal_1";
	}*/
	@RequestMapping(value = "/calendar.do", method = RequestMethod.GET)
	public String calendar(Locale locale, Model model) {
		
		return "calendar";
	}
}
