package com.hy.capstone.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/reg.do")
	public String reg(@ModelAttribute("UserVO")UserVO vo, HttpServletRequest request)throws Exception{
		
		int reg = userService.reg(vo);
		return "login";
	}

	@RequestMapping(value="/login.do")
	public ModelAndView login(@ModelAttribute("UserVO")UserVO uvo, HttpSession session, HttpServletRequest request) {
		UserVO login_chk = userService.login(uvo, session);
		ModelAndView mav = new ModelAndView();
		if(login_chk!=null) {
			request.getSession().setAttribute("login_chk", login_chk);
			mav.setViewName("redirect:/index.do");
		}else {
			mav.setViewName("login");
			mav.addObject("error", "아이디 혹은 패스워드가 잘못되었습니다");
		}
		return mav;
	}
}
