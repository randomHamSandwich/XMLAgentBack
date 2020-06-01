package com.xml.agBa.util;

import java.time.LocalDateTime;

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
	

}
