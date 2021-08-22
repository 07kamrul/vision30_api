package com.vision.viewmodel;

import java.util.HashMap;
import java.util.Map;

public class AuthResponseViewModel {

	private String token;
	private String expiredDate;
	private Map<String, Object> data = new HashMap<>();

	private String message;

	public AuthResponseViewModel() {

	}

	public AuthResponseViewModel(String token) {
		super();
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getExpiredDate() {
		return expiredDate;
	}

	public void setExpiredDate(String expiredDate) {
		this.expiredDate = expiredDate;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}

	public AuthResponseViewModel(String token, String expiredDate, Map<String, Object> data) {
		this.token = token;
		this.expiredDate = expiredDate;
		this.data = data;
	}

	public AuthResponseViewModel(String message, Map<String, Object> data) {
		this.message = message;
	}

}
