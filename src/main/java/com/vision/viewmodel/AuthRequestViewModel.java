package com.vision.viewmodel;

public class AuthRequestViewModel {

	private String username;
	private String password;

	public AuthRequestViewModel(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public AuthRequestViewModel() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
