package com.vision.exception;

import java.sql.Timestamp;
import java.util.Map;

/**
 * 
 * @author shariful
 *
 */
public class CustomExceptionHandler {

	// private static final Logger logger =
	// LoggerFactory.getLogger(CustomExceptionHandler.class);

	public static Map<String, Object> handleException(String classNameAndMethodName, String exceptionMessage) {
		System.err
				.println("Exception : [At] : " + new Timestamp(System.currentTimeMillis()) + " [From]-------------> : "
						+ classNameAndMethodName + " [Reason]-------------> : " + exceptionMessage);
		// logger.debug("Exception : [At] : "+ new
		// Timestamp(System.currentTimeMillis())+" [From]-------------> : "+
		// classNameAndMethodName +" [Reason]-------------> : "+ exceptionMessage);
		return null;
	}

}
