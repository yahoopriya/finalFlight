package com.epam.cleartrip.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader {
	
	public Properties property = new Properties(); 
	
	public void propertyFileLoader() {
	
	String testPropertyFile = String.format("//config//%s.properties", System.getProperty("propertyFile"));
	File propertyFile = new File(System.getProperty("user.dir" )+testPropertyFile);
	try {
		FileReader fileReader = new FileReader(propertyFile);
		property.load(fileReader);
	} catch ( IOException e) {
		e.printStackTrace();
	}

}
}