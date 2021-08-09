package com.vision.util;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class ControllerModel {
	
	private Map<String, Object> responseData;
	private Map<String, Object> apiKeyValidationMap;
	private Timestamp startTime;
	private String descMsg = "";
	private boolean isReadyToSendAccessLog = true;
	private String endpoint;
	private String apiKey;
	private String latLng;
	private HttpServletRequest request;
	private ResponseEntity<Map<String,Object>> responseEntity = null;
	
	public ControllerModel() {
		this.startTime = new Timestamp(System.currentTimeMillis());
		this.responseData = new HashMap<String, Object>();
	}
	
//	public ControllerModel(String endpoint, String apiKey, String latLng, HttpServletRequest request){
//		this.apiKey = apiKey!=null ? apiKey : "";
//		this.endpoint = endpoint;
//		this.latLng = latLng;
//		this.request = request;
//		
//		this.startTime = new Timestamp(System.currentTimeMillis());
//		this.responseData = new HashMap<String, Object>();
//	}

	public Map<String, Object> getResponseData() {
		return responseData;
	}


	public void setResponseData(Map<String, Object> responseData) {
		this.responseData = responseData;
	}


	public Map<String, Object> getApiKeyValidationMap() {
		return apiKeyValidationMap;
	}


	public void setApiKeyValidationMap(Map<String, Object> apiKeyValidationMap) {
		this.apiKeyValidationMap = apiKeyValidationMap;
	}


	public Timestamp getStartTime() {
		return startTime;
	}


	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}


	public String getDescMsg() {
		return descMsg;
	}


	public void setDescMsg(String descMsg) {
		this.descMsg = descMsg;
	}


	public boolean isReadyToSendAccessLog() {
		return isReadyToSendAccessLog;
	}


	public void setReadyToSendAccessLog(boolean isReadyToSendAccessLog) {
		this.isReadyToSendAccessLog = isReadyToSendAccessLog;
	}


	public String getEndpoint() {
		return endpoint;
	}


	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}


	public String getApiKey() {
		return apiKey;
	}


	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}


	public String getLatLng() {
		return latLng;
	}

	public void setLatLng(String latLng) {
		this.latLng = latLng;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public ResponseEntity<Map<String, Object>> getResponseEntity() {
		return responseEntity;
	}


	public void setResponseEntity(ResponseEntity<Map<String, Object>> responseEntity) {
		this.responseEntity = responseEntity;
	}
	
	
	
}
