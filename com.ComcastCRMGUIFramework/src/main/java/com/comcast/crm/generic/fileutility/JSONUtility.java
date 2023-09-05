package com.comcast.crm.generic.fileutility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONUtility {

	public String getDataFromJSONFile(String key) throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader("./configAppData/commondata.json"));
		JSONObject map = (JSONObject) obj;
		String value = map.get(key).toString();
		return value;
		
	}
}
