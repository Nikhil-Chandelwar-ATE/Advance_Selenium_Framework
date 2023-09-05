package com.comcast.crm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	public int getRandomNumber() {
		
		Random random = new Random();
		int randomNumber = random.nextInt(5000);
		return randomNumber;
	}
	
	public String getSystemDateYYYYMMDD() {
		
		Date date = new Date();
		SimpleDateFormat simple = new SimpleDateFormat("YYYY-MM-dd");
		String dateFormat = simple.format(date);
		return dateFormat;
	}
	
	public String getRequiredDateYYYYMMDD(int days) {
		
		SimpleDateFormat simple = new SimpleDateFormat("YYYY-MM-dd");
		Calendar calendar = simple.getCalendar();
		calendar.add(calendar.DAY_OF_MONTH, days);
		String requiredDate = simple.format(calendar.getTime());
		return requiredDate;
	}
}
