package com.vision.exception;

import java.sql.Timestamp;
import java.util.Map;

public class ExceptionHandler {

	public static Map<String, Object> handleException(String classNameAndMethodName,String exceptionMessage){
		System.err.println("Exception : [At] : "+ new Timestamp(System.currentTimeMillis())+" [From]-------------> : "+ classNameAndMethodName +" [Reason]-------------> : "+ exceptionMessage);
		return null;
	}
	
}
