package com.hy.capstone.schedule;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("CalendarService")
public class CalendarServiceImpl implements CalendarService{
	
	@Resource(name="CalendarDao")
    private CalendarDao calendarDao;

	@Override
	public List<CalendarVO> calendar_list(CalendarVO calendarVO) throws Exception {
		// TODO Auto-generated method stub
		List<CalendarVO> c_list = calendarDao.calendar_list(calendarVO);
		return c_list;
	}

	@Override
	public int calendar_insert(CalendarVO cVO) throws Exception {
		// TODO Auto-generated method stub
		return calendarDao.calendar_insert(cVO);
	}

	@Override
	public int calendar_update(CalendarVO cVO) throws Exception {
		// TODO Auto-generated method stub
		return calendarDao.calendar_update(cVO);
	}

	@Override
	public CalendarVO calendar_event_content(CalendarVO calendarVO) throws Exception {
		// TODO Auto-generated method stub
		return calendarDao.calendar_event_content(calendarVO);
	}

	@Override
	public int calendar_delete(CalendarVO cVO) throws Exception {
		// TODO Auto-generated method stub
		return calendarDao.calendar_delete(cVO);
	}

	@Override
	public List<CalendarVO> calendar_list_h(CalendarVO calendarVO) throws Exception {
		// TODO Auto-generated method stub
		List<CalendarVO> c_list = calendarDao.calendar_list_h(calendarVO);
		return c_list;
	}

	@Override
	public CalendarVO calendar_event_content_h(CalendarVO calendarVO) throws Exception {
		// TODO Auto-generated method stub
		return calendarDao.calendar_event_content_h(calendarVO);
	}

	@Override
	public int calendar_insert_h(CalendarVO cVO) throws Exception {
		// TODO Auto-generated method stub
		return calendarDao.calendar_insert_h(cVO);
	}

	@Override
	public int calendar_update_h(CalendarVO cVO) throws Exception {
		// TODO Auto-generated method stub
		return calendarDao.calendar_update_h(cVO);
	}

	@Override
	public int calendar_delete_h(CalendarVO cVO) throws Exception {
		// TODO Auto-generated method stub
		return calendarDao.calendar_delete_h(cVO);
	}

}