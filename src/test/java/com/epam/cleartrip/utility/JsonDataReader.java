package com.epam.cleartrip.utility;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonDataReader {

	public static LinkedHashMap<String, String> dataContext = null;

	@SuppressWarnings("unchecked")
	public void loadDatafromjson() throws IOException {		
		String testDataFile = String.format("//Data//%s.json", System.getProperty("dataFile"));
		File jsonfile = new File(System.getProperty("user.dir" )+testDataFile);
		ObjectMapper mapper = new ObjectMapper();
		dataContext = mapper.readValue(jsonfile, LinkedHashMap.class);       
	}	
}