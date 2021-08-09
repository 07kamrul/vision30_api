package com.vision.util;

import java.io.File;
import java.util.UUID;

public class Utility {

	public static final String PROJECT_ABSOLUTE_PATH = System.getProperty("user.dir");

	public static void createDirectory(String directoryAblolutePath) {
		File file = new File(directoryAblolutePath);
		if (!file.exists()) {
			file.mkdir();
			file.setExecutable(true);
			file.setWritable(true);
			file.setReadable(true);
		}
	}

	public static String getImageUploadDir(String uploadDir, UUID shoutID) {
		String dir = PROJECT_ABSOLUTE_PATH + "/src/main/resources/" + uploadDir + shoutID + "";
		File file = new File(dir);
		if (file.exists()) {
			return dir;
		}

		file.mkdirs();
		file.setExecutable(true);
		file.setWritable(true);
		file.setReadable(true);

		return dir;
	}

	public static String getImageUploadDir(String imageDir) {
		String dir = PROJECT_ABSOLUTE_PATH + "/src/main/resources/" + imageDir;
		File file = new File(dir);
		if (file.exists()) {
			return dir;
		}

		file.mkdirs();
		file.setExecutable(true);
		file.setWritable(true);
		file.setReadable(true);

		return dir;
	}

	public static UUID getUUIDFromString(String id) {
		UUID uuid = null;
		if (!id.equalsIgnoreCase("NA")) {
			uuid = UUID.fromString(id);
		}
		return uuid;
	}

	public static String processLineString(String[] routePoints) {
		String startLineString = "LINESTRING (";
		String endLineString = ")";

		StringBuffer sb = new StringBuffer();

		for (String routePoint : routePoints) {
			sb.append(routePoint + ",");
		}

		String str = sb.toString();
		String middleLineString = str.substring(0, str.length() - 1);
		String lineString = startLineString + middleLineString + endLineString;

		return lineString;

	}

}
