package com.hy.capstone.schedule;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller

public class ScheduleController {

//	@Resource(name="CalendarService")
	@Autowired
	protected CalendarService calendarService;

	@RequestMapping(value= {"cal_1.do"} ,method={RequestMethod.POST,RequestMethod.GET})
	public String main(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception{
		/*HttpSession session;
		ModelAndView mav=new ModelAndView();
		String viewName=(String)request.getAttribute("viewName");
		mav.setViewName(viewName);
		
		session=request.getSession();
		session.setAttribute("side_menu", "user");
		Map<String,List<GoodsVO>> goodsMap=goodsService.listGoods();
		mav.addObject("goodsMap", goodsMap);*/
		
//		String aa = memberService.gettest();
//		
//		model.addAttribute("test",aa);
		String conDB = request.getParameter("conDB") == null ? "" : request.getParameter("conDB");
		model.addAttribute("conDB",conDB);
		
		return "/cal_1";
	}
	@RequestMapping(value= {"/H.do"} ,method={RequestMethod.POST,RequestMethod.GET})
	public String main_H(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception{
		/*HttpSession session;
		ModelAndView mav=new ModelAndView();
		String viewName=(String)request.getAttribute("viewName");
		mav.setViewName(viewName);
		
		session=request.getSession();
		session.setAttribute("side_menu", "user");
		Map<String,List<GoodsVO>> goodsMap=goodsService.listGoods();
		mav.addObject("goodsMap", goodsMap);*/
		
//		String aa = memberService.gettest();
//		
//		model.addAttribute("test",aa);
		String conDB = request.getParameter("conDB") == null ? "" : request.getParameter("conDB");
		model.addAttribute("conDB",conDB);
		
		return "/calendar/calendar_h";
	}
	@RequestMapping(value= "/calendar.do" )
	public String calendar(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception{
		/*HttpSession session;
		ModelAndView mav=new ModelAndView();
		String viewName=(String)request.getAttribute("viewName");
		mav.setViewName(viewName);
		
		session=request.getSession();
		session.setAttribute("side_menu", "user");r
		Map<String,List<GoodsVO>> goodsMap=goodsService.listGoods();
		mav.addObject("goodsMap", goodsMap);*/
		String conDB = request.getParameter("conDB") == null ? "" : request.getParameter("conDB");
		model.addAttribute("conDB",conDB);
		
		return "/calendar/calendar_h";
	}
	@RequestMapping(value= "/calendar_list.do" )
	public ModelAndView calendar_list(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception{
		
		ModelAndView mav = new ModelAndView("jsonView");
		CalendarVO calendarVO = new CalendarVO();
		
		String conDB = request.getParameter("conDB") == null ? "" : request.getParameter("conDB");
		calendarVO.setConDB(conDB);
		
		String HHH = request.getParameter("HHH") == null ? "" : request.getParameter("HHH");
		
		List<CalendarVO> c_list = null;
		if(HHH.equals("H")) {
			c_list = calendarService.calendar_list_h(calendarVO);
		}else {
			c_list = calendarService.calendar_list(calendarVO);
			
		}
		
//		String aa = memberService.gettest();
		
//		model.addAttribute("c_list",c_list);
//		System.out.println(c_list);
//		model.addAttribute("test","aa");
		mav.addObject("flag", true);
		mav.addObject("result", c_list);
		
		return mav;
	}
	
	@RequestMapping(value= "/calendar_event_content.do" )
	public ModelAndView calendar_event_content(@ModelAttribute CalendarVO calendarVO, HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception{
		
		ModelAndView mav = new ModelAndView("jsonView");
		String HHH = request.getParameter("HHH") == null ? "" : request.getParameter("HHH");
		
		CalendarVO cVO = new CalendarVO();
		
		if(HHH.equals("H")) {
			cVO = calendarService.calendar_event_content_h(calendarVO);
		}else {
			cVO = calendarService.calendar_event_content(calendarVO);
		}
		
//		String aa = memberService.gettest();
		
//		model.addAttribute("c_list",c_list);
//		System.out.println(c_list);
//		model.addAttribute("test","aa");
		mav.addObject("flag", true);
		mav.addObject("result", cVO);
		
		return mav;
	}
	
	@RequestMapping(value= "/calendar_insert.do" )
	public ModelAndView calendar_insert(CalendarVO cVO,HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception{
		
		ModelAndView mav = new ModelAndView("jsonView");
		String HHH = request.getParameter("HHH") == null ? "" : request.getParameter("HHH");
		int idx = 0;
		
		if(HHH.equals("H")) {
			idx = calendarService.calendar_insert_h(cVO);
		}else {
			idx = calendarService.calendar_insert(cVO);
		}
		mav.addObject("flag", true);
		mav.addObject("liidx", cVO.getIdx());
		
		return mav;
	}
	@RequestMapping(value= "/calendar_update.do" )
	public ModelAndView calendar_date_update(CalendarVO cVO,HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception{
		
		ModelAndView mav = new ModelAndView("jsonView");
		String HHH = request.getParameter("HHH") == null ? "" : request.getParameter("HHH");
		int idx = 0;
		
		if(HHH.equals("H")) {
			idx = calendarService.calendar_update_h(cVO);
		}else {
			idx = calendarService.calendar_update(cVO);
		}
//		String aa = memberService.gettest();
		
//		model.addAttribute("c_list",c_list);
//		System.out.println(c_list);
//		model.addAttribute("test","aa");
		mav.addObject("flag", true);
		
		return mav;
	}
	@RequestMapping(value= "/calendar_delete.do" )
	public ModelAndView calendar_delete(CalendarVO cVO,HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception{
		
		ModelAndView mav = new ModelAndView("jsonView");
		String HHH = request.getParameter("HHH") == null ? "" : request.getParameter("HHH");
		
		int flag = 0;
		
		if(HHH.equals("H")) {
			flag = calendarService.calendar_delete_h(cVO);
		}else {
			flag = calendarService.calendar_delete(cVO);
		}
//		String aa = memberService.gettest();
		
//		model.addAttribute("c_list",c_list);
//		System.out.println(c_list);
//		model.addAttribute("test","aa");
		mav.addObject("flag", true);
		
		return mav;
	}
}
