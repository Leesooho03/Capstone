package com.hy.capstone.schedule;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository("CalendarDao")
public class CalendarDao {
	
	@Autowired
	private SqlSession sqlSession;	
	
	public List<CalendarVO> calendar_list(CalendarVO calendarVO) {
		// TODO Auto-generated method stub
		List<CalendarVO> c_list =  sqlSession.selectList("calendarSQL.calendar_list",calendarVO);
		return c_list;
	}

	public int calendar_insert(CalendarVO cVO) {
		// TODO Auto-generated method stub
		return sqlSession.insert("calendarSQL.calendar_insert",cVO);
	}

	public int calendar_update(CalendarVO cVO) {
		// TODO Auto-generated method stub
		return sqlSession.update("calendarSQL.calendar_update",cVO);
	}

	public CalendarVO calendar_event_content(CalendarVO calendarVO) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("calendar_event_content", calendarVO);
	}

	public int calendar_delete(CalendarVO cVO) {
		// TODO Auto-generated method stub
		return sqlSession.update("calendarSQL.calendar_delete",cVO);
	}

	public List<CalendarVO> calendar_list_h(CalendarVO calendarVO) {
		// TODO Auto-generated method stub
		List<CalendarVO> c_list =  sqlSession.selectList("calendarSQL.calendar_list_h",calendarVO);
		return c_list;
	}

	public int calendar_insert_h(CalendarVO cVO) {
		// TODO Auto-generated method stub
		return sqlSession.insert("calendarSQL.calendar_insert_h",cVO);
	}

	public CalendarVO calendar_event_content_h(CalendarVO calendarVO) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("calendar_event_content_h", calendarVO);
	}

	public int calendar_update_h(CalendarVO cVO) {
		// TODO Auto-generated method stub
		return sqlSession.update("calendarSQL.calendar_update_h",cVO);
	}

	public int calendar_delete_h(CalendarVO cVO) {
		// TODO Auto-generated method stub
		return sqlSession.update("calendarSQL.calendar_delete_h",cVO);
	}

}