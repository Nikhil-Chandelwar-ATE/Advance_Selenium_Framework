package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {

	public String getDataFromProprtyFile(String key) throws IOException {
		
		FileInputStream fis = new FileInputStream("./configAppData/commondata.properties");
		Properties property = new Properties();
		property.load(fis);
		String value = property.getProperty(key);
		return value;
		
	}
}
