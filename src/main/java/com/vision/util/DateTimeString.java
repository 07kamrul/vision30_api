package com.vision.util;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class DateTimeString {

	public static String date;
	public static String time;

	public static String getDate() {
		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter date = DateTimeFormatter.ofPattern("dd MMM, yyyy");
		String formattedDate = myDateObj.format(date);
		return formattedDate;
	}

	public static String getTime() {
		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm:ss a");
		String formattedTime = myDateObj.format(time);
		return formattedTime;
	}

	public static long getDateDifferenceWithCurrentDate(Timestamp givenDate) {

		Date currentDate = new Date(System.currentTimeMillis());
		long difference_In_Days = 0;
		// Calculate time difference
		long difference_In_Time = currentDate.getTime() - givenDate.getTime();
		difference_In_Days = (difference_In_Time / (1000 * 60 * 60 * 24)) % 365;
		System.out.println(difference_In_Days + " days, ");

		return difference_In_Days;
	}

	public static Date getCurrentWeeksFirstDate() {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		// cal.set(2021, 4, 15);

		int daysBackToSat = cal.get(Calendar.DAY_OF_WEEK) == 7 ? 0 : cal.get(Calendar.DAY_OF_WEEK);
		cal.add(Calendar.DATE, daysBackToSat * -1);

		return new Date(cal.getTimeInMillis());

	}

}
