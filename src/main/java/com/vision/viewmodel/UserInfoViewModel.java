package com.vision.viewmodel;


public class UserInfoViewModel {

	private double currentLatitude; // DEFAULT 23.00

	private double currentLongitude; // DEFAULT 90.00

	public double getCurrentLatitude() {
		return currentLatitude;
	}

	public void setCurrentLatitude(double currentLatitude) {
		this.currentLatitude = currentLatitude;
	}

	public double getCurrentLongitude() {
		return currentLongitude;
	}

	public void setCurrentLongitude(double currentLongitude) {
		this.currentLongitude = currentLongitude;
	}
	
	
}
