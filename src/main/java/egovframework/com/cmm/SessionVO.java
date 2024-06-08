package egovframework.com.cmm;

import java.io.Serializable;

public class SessionVO implements Serializable {
	

	private static final long serialVersionUID = 1L;
		
	private String uInfo_IDX = "";
	private String uInfo_ID = "";	
	private String uInfo_nickName = "";
	private String uInfo_birthDay = "";
	private String gInfo_NUMBER = "";
	
	
	public String getgInfo_NUMBER() {
		return gInfo_NUMBER;
	}
	public void setgInfo_NUMBER(String gInfo_NUMBER) {
		this.gInfo_NUMBER = gInfo_NUMBER;
	}
	public String getuInfo_IDX() {
		return uInfo_IDX;
	}
	public void setuInfo_IDX(String uInfo_IDX) {
		this.uInfo_IDX = uInfo_IDX;
	}
	public String getuInfo_ID() {
		return uInfo_ID;
	}
	public void setuInfo_ID(String uInfo_ID) {
		this.uInfo_ID = uInfo_ID;
	}
	public String getuInfo_nickName() {
		return uInfo_nickName;
	}
	public void setuInfo_nickName(String uInfo_nickName) {
		this.uInfo_nickName = uInfo_nickName;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getuInfo_birthDay() {
		return uInfo_birthDay;
	}
	public void setuInfo_birthDay(String uInfo_birthDay) {
		this.uInfo_birthDay = uInfo_birthDay;
	}
	
	// Parameter 정의 구문 : 렌트카 메뉴 컨트롤 체크
	private String param_rent = "";	
	
	public String getparam_rent(){
		return param_rent;
	}
	public void setparam_rent(String rent){
		this.param_rent = rent;
	}
	
	// Parameter 정의 구문 : BLE 메뉴 컨트롤 체크
	private String param_ble = "";
	
	public String getparam_ble(){
		return param_rent;
	}
	public void setparam_ble(String ble){
		this.param_ble = ble;
	}
	
	// Parameter 정의 구문 : App 코드 = 전용 어플 구분 키워드
	// 100 or null : IoTGPS v1.0
	// 220 : 렌트카
	// 250 : 블루투스
	private String param_apps = "";
	
	public String getparam_apps(){
		return param_apps;
	}
	public void setparam_apps(String param_apps){
		this.param_apps = param_apps;
	}
	

	// 2020-07-07 : Map 유형 선택 적 적용 관련 mapType 항목 추가
	private String uInfo_mapType = "";

	public String getuInfo_mapType() {
		return uInfo_mapType;
	}
	public void setuInfo_mapType(String uInfo_mapType) {
		this.uInfo_mapType = uInfo_mapType;
	}
	
}
