package com.iris22.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Class used for reading properties file
 * @author radhi
 *
 */
public class PropUtil {
	
	public String getValue(String filePath , String key) {
		FileInputStream fis = null;
		try {
			 fis =  new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("File Not Found: "+filePath);
		}
		Properties prop = new Properties();
		try {
			prop.load(fis);
		} catch (IOException e) {
			System.err.println("Unable to load properties file: "+filePath);
		}
		return prop.getProperty(key);
	}
	/**
	 * This method can be used on OR.properties file only.
	 * @param key for which we want the locator
	 * @return the locator value in the form of {@code String}
	 */
	public String[] getLocator(String key) {
		String baseDir = System.getProperty("user.dir");//user.dir --> for user directory path
		return getValue(baseDir+"/src/main/resources/OR.properties", key).split("##");

	}
}
