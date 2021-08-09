package com.vision.util;

import static com.vision.util.GlobalConstants.EXCEPTION;
import static com.vision.util.GlobalConstants.INTERNAL_ERROR;
import static com.vision.util.GlobalConstants.MESSAGE;
import static com.vision.util.GlobalConstants.OK;
import static com.vision.util.GlobalConstants.PRECONDITION_FAILED;
import static com.vision.util.GlobalConstants.RESPONSE_CODE;
import static com.vision.util.GlobalConstants.STATUS;
import static com.vision.util.GlobalConstants.SUCCESSFUL;
import static com.vision.util.GlobalConstants.UNAUTHORIZED;

import java.sql.Timestamp;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ControllerUtil implements IControllerUtil {
	@Autowired
	private ServiceUtil serviceUtil;

	@Autowired
	private ControllerModel controllerModel;

	private boolean isApiKeyValidated() {
		boolean isApiKeyValidated = false;
		if (controllerModel != null) {

			if (controllerModel.getApiKeyValidationMap().get("status").toString().equalsIgnoreCase("successful")) {
				isApiKeyValidated = true;
			}

		}

		return isApiKeyValidated;
	}

	@Override
	public boolean isApiKeyValidated(HttpServletRequest request, String apiKey, String latLng) {
		boolean isApiKeyValidated = true;
		String endpoint = request.getServletPath().substring(1);
		// this.controllerModel = new ControllerModel(endpoint, apiKey, latLng,
		// request);
		// System.out.println(controllerModel);
		controllerModel.setEndpoint(endpoint);
		controllerModel.setApiKey(apiKey);
		controllerModel.setLatLng(latLng);
		controllerModel.setRequest(request);
		// System.out.println("controllerModel "+controllerModel);

		if (controllerModel.getApiKeyValidationMap().get("status").toString().equalsIgnoreCase("successful")) {
			isApiKeyValidated = true;
		}

		return isApiKeyValidated;
	}

	@Override
	public boolean isApiKeyValidated(HttpServletRequest request, String latLng) {
		boolean isApiKeyValidated = false;
		if (controllerModel == null) {
			String endpoint = request.getServletPath().substring(1);
			controllerModel.setEndpoint(endpoint);
			controllerModel.setLatLng(latLng);
			controllerModel.setRequest(request);
		}

		if (controllerModel.getApiKeyValidationMap().get(STATUS).toString().equalsIgnoreCase(SUCCESSFUL)) {
			isApiKeyValidated = true;
		}

		return isApiKeyValidated;
	}

	@Override
	public void buildResponseEntity(Map<String, Object> data) {

		controllerModel.setResponseData(data);
		if (data.get(RESPONSE_CODE).equals(PRECONDITION_FAILED)) {

			controllerModel
					.setResponseEntity(new ResponseEntity<Map<String, Object>>(data, HttpStatus.PRECONDITION_FAILED));

		} else if (data.get(RESPONSE_CODE).equals(OK)) {
			controllerModel.setResponseEntity(new ResponseEntity<Map<String, Object>>(data, HttpStatus.OK));

		} else if (data.get(RESPONSE_CODE).equals(INTERNAL_ERROR)) {

			controllerModel
					.setResponseEntity(new ResponseEntity<Map<String, Object>>(data, HttpStatus.INTERNAL_SERVER_ERROR));

		} else if (data.get(RESPONSE_CODE).equals(UNAUTHORIZED)) {

			controllerModel.setResponseEntity(new ResponseEntity<Map<String, Object>>(data, HttpStatus.UNAUTHORIZED));
		}

		sendLog();
	}

	@Override
	public void buildPreConditionFailedResponseEntity(HttpServletRequest request, String latLng) {
		String endpoint = request.getServletPath().substring(1);
		controllerModel.setEndpoint(endpoint);
		controllerModel.setLatLng(latLng);
		controllerModel.setRequest(request);
		isApiKeyValidated();
		serviceUtil.addMessage("Sorry! unable to check preconditions");
		Map<String, Object> data = serviceUtil.getServiceReturnForPreconditionFailed();

		controllerModel
				.setResponseEntity(new ResponseEntity<Map<String, Object>>(data, HttpStatus.PRECONDITION_FAILED));

		sendLog();
	}

	@Override
	public void buildFailedResponseEntity() {
		if (controllerModel.getApiKeyValidationMap().get(STATUS).toString().equalsIgnoreCase(EXCEPTION)) {
			controllerModel.setReadyToSendAccessLog(false);

			controllerModel.setResponseEntity(new ResponseEntity<Map<String, Object>>(
					controllerModel.getApiKeyValidationMap(), HttpStatus.INTERNAL_SERVER_ERROR));
		} else {

			controllerModel.getResponseData().put(MESSAGE, controllerModel.getApiKeyValidationMap().get(MESSAGE));
			controllerModel.getResponseData().put(RESPONSE_CODE,
					controllerModel.getApiKeyValidationMap().get(RESPONSE_CODE));
			controllerModel.getResponseData().put(STATUS, controllerModel.getApiKeyValidationMap().get(STATUS));

			controllerModel.setResponseEntity(new ResponseEntity<Map<String, Object>>(controllerModel.getResponseData(),
					HttpStatus.UNAUTHORIZED));

		}

		sendLog();
	}

	@Override
	public void sendLog() {
		Timestamp endTime = new Timestamp(System.currentTimeMillis());
		controllerModel.getApiKeyValidationMap().put("startTime", controllerModel.getStartTime());
		controllerModel.getApiKeyValidationMap().put("endTime", endTime);
		controllerModel.getApiKeyValidationMap().put("apiEndpoint", controllerModel.getEndpoint());
		controllerModel.getApiKeyValidationMap().put("latLng", controllerModel.getLatLng());
		controllerModel.getApiKeyValidationMap().put("descMsg", controllerModel.getDescMsg());

		controllerModel.getApiKeyValidationMap();

	}

	@Override
	public ResponseEntity<Map<String, Object>> getResponseEntity() {
		return controllerModel.getResponseEntity();
	}

}
