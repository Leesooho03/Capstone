package com.hy.capstone.schedule;

import java.io.Serializable;

public class CalendarVO implements Serializable {
	
	private String idx = "";
	private String title = "";
	private String contents = "";
	private String start = "";
	private String end = "";
	private String className = "";
	
	private String conDB = ""; // 연동 데이터베이스(기본은 수주테이블만 잡혀있음)
	private String conFlag = "cal"; // 조회할 데이터베이스가 일반 일정인지, 연동 일정인지
	
	
	public String getIdx() {
		return idx;
	}
	public void setIdx(String idx) {
		this.idx = idx;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	
	
	public String getConDB() {
		return conDB;
	}
	public void setConDB(String conDB) {
		this.conDB = conDB;
	}
	public String getConFlag() {
		return conFlag;
	}
	public void setConFlag(String conFlag) {
		this.conFlag = conFlag;
	}
	
}
