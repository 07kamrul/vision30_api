package com.vision.util;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;

public interface IControllerUtil {
	public boolean isApiKeyValidated(HttpServletRequest request, String apiKey, String latLng);
	public boolean isApiKeyValidated(HttpServletRequest request,  String latLng);
	public void buildResponseEntity(Map<String, Object> data);
	public void buildFailedResponseEntity();
	public void buildPreConditionFailedResponseEntity(HttpServletRequest request,String latLng);
	public void sendLog();
	public ResponseEntity<Map<String, Object>> getResponseEntity();
}
