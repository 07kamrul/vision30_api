package com.vision.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class CommonServiceModel {
	private Map<String, Object> data = new HashMap<String, Object>();
	private List<String> message = new ArrayList<>();
	private int invalidFieldCount;

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}

	public List<String> getMessage() {
		return message;
	}

	public void setMessage(List<String> message) {
		this.message = message;
	}

	public int getInvalidFieldCount() {
		return invalidFieldCount;
	}

	public void setInvalidFieldCount(int invalidFieldCount) {
		this.invalidFieldCount = invalidFieldCount;
	}
}
