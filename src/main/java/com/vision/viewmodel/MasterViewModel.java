package com.vision.viewmodel;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class MasterViewModel {
	private String[] ids;
	private String token;
	private String appCode;
	private int fileSequence;

	private String username;
	private String additionalUsername;

	private String searchText;

	private boolean isImageNeeded;

	private MultipartFile[] files;

	private Date date; // 2021-06-09
	private Date fromDate;
	private Date toDate;

	private String[] comments;

	private String title;
	private String descriptions; // DEFAULT 'Descriptions'

	private int amount; // DEFAULT 0000
	private String status;
	private String dipositeSlip;

	private String personId;
	private String personName;
	private String personGender; // DEFAULT 'Male'
	private String personMobile;
	private String personEmail;
	private String personUsername;

	private boolean isUser; // NOT NULL
	private boolean isAdmin; // NOT NULL
	private int memberId; // NOT NULL

	public String[] getIds() {
		return ids;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
	}

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

	public String[] getComments() {
		return comments;
	}

	public void setComments(String[] comments) {
		this.comments = comments;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDipositeSlip() {
		return dipositeSlip;
	}

	public void setDipositeSlip(String dipositeSlip) {
		this.dipositeSlip = dipositeSlip;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getPersonGender() {
		return personGender;
	}

	public void setPersonGender(String personGender) {
		this.personGender = personGender;
	}

	public String getPersonMobile() {
		return personMobile;
	}

	public void setPersonMobile(String personMobile) {
		this.personMobile = personMobile;
	}

	public String getPersonEmail() {
		return personEmail;
	}

	public void setPersonEmail(String personEmail) {
		this.personEmail = personEmail;
	}

	public String getPersonUsername() {
		return personUsername;
	}

	public void setPersonUsername(String personUsername) {
		this.personUsername = personUsername;
	}

	public boolean isUser() {
		return isUser;
	}

	public void setUser(boolean isUser) {
		this.isUser = isUser;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getAdditionalUsername() {
		return additionalUsername;
	}

	public void setAdditionalUsername(String additionalUsername) {
		this.additionalUsername = additionalUsername;
	}

}