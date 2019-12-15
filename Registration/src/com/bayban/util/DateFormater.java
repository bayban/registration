package com.bayban.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormater {

	public static Date stringToDate(String datestr, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);

		try {
			return sdf.parse(datestr);
		} catch (ParseException e) {
			return null;
		}
	}

}
