package com.hy.capstone.project;

import java.io.Serializable;

public class FileVO implements Serializable{
	private String file_id = "";
	private String file_name = "";
	private String file_ext = "";
	private String file_realnm = "";
	private String file_savenm = "";
	private String file_url = "";
	private String reg_date = "";
	private String del_date = "";
    private long size = 0L;
    private String id = "";
	public String getFile_id() {
		return file_id;
	}
	public void setFile_id(String file_id) {
		this.file_id = file_id;
	}
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	public String getFile_ext() {
		return file_ext;
	}
	public void setFile_ext(String file_ext) {
		this.file_ext = file_ext;
	}
	public String getFile_realnm() {
		return file_realnm;
	}
	public void setFile_realnm(String file_realnm) {
		this.file_realnm = file_realnm;
	}
	public String getFile_savenm() {
		return file_savenm;
	}
	public void setFile_savenm(String file_savenm) {
		this.file_savenm = file_savenm;
	}
	public String getFile_url() {
		return file_url;
	}
	public void setFile_url(String file_url) {
		this.file_url = file_url;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public String getDel_date() {
		return del_date;
	}
	public void setDel_date(String del_date) {
		this.del_date = del_date;
	}
	public long getSize() {
		return size;
	}
	public void setSize(long size) {
		this.size = size;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	
	
}
