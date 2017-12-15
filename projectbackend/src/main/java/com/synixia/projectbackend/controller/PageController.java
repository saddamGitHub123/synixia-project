package com.synixia.projectbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.synixia.projectbackend.dao.UserDAO;

@Controller
public class PageController {
	
	
	@Autowired
	UserDAO userDAO;
	
	//private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting", "welcome to spring web mvc new way to done ");
		return mv;
	}
	
	
	
	@RequestMapping(value = "/add/userList", method = RequestMethod.GET)
	public  ModelAndView listUser() {
		//logger.info("Entered addUserList()  - Add all user ");
		
		System.out.println("Entering list user method");
		userDAO.list();
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting", "This is list of value  ");
		return mv;
	}
}
