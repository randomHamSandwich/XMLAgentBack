package com.xml.agBa.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.xml.agBa.model.Ad;

public class DateChecker {

	public DateChecker() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static boolean isBetween(LocalDateTime startDateTime, LocalDateTime endDateTime,
			LocalDateTime specifiedDateTime) {
		return (startDateTime.isBefore(specifiedDateTime) && endDateTime.isAfter(specifiedDateTime))
				|| startDateTime.equals(specifiedDateTime) || endDateTime.equals(specifiedDateTime);
	}

	public static LocalDateTime convertTimeForDb(String dateTime) {
		String startDateTimeRemoveT = dateTime.replace("T", "-");
		DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm");
		LocalDateTime localDateTime = LocalDateTime.parse(startDateTimeRemoveT, formater);
		
		return localDateTime ;
	}

}
