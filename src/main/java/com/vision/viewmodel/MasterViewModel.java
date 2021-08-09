package com.vision.viewmodel;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class MasterViewModel {
	private String[] ids;

	private String token;

	private String appCode;

	private int fileSequence;

	private String username;

	private String searchText;

	private String type;
	private boolean isImageNeeded;

	private MultipartFile[] files;

	private Date date; // 2021-06-09
	private Date fromDate;
	private Date toDate;

	private String[] comments;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getAppCode() {
		return appCode;
	}

	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}

	public int getFileSequence() {
		return fileSequence;
	}

	public void setFileSequence(int fileSequence) {
		this.fileSequence = fileSequence;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isImageNeeded() {
		return isImageNeeded;
	}

	public void setImageNeeded(boolean isImageNeeded) {
		this.isImageNeeded = isImageNeeded;
	}

	public MultipartFile[] getFiles() {
		return files;
	}

	public void setFiles(MultipartFile[] files) {
		this.files = files;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public String[] getIds() {
		return ids;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
	}

	public String[] getComments() {
		return comments;
	}

	public void setComments(String[] comments) {
		this.comments = comments;
	}

}