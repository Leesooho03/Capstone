package com.hy.capstone.schedule;

import java.util.List;


public interface CalendarService {
	
	List<CalendarVO> calendar_list(CalendarVO calendarVO) throws Exception;

	int calendar_insert(CalendarVO cVO) throws Exception;

	int calendar_update(CalendarVO cVO) throws Exception;

	CalendarVO calendar_event_content(CalendarVO calendarVO) throws Exception;

	int calendar_delete(CalendarVO cVO)  throws Exception;

	List<CalendarVO> calendar_list_h(CalendarVO calendarVO) throws Exception;

	CalendarVO calendar_event_content_h(CalendarVO calendarVO) throws Exception;

	int calendar_insert_h(CalendarVO cVO) throws Exception;

	int calendar_update_h(CalendarVO cVO) throws Exception;

	int calendar_delete_h(CalendarVO cVO) throws Exception;


}
