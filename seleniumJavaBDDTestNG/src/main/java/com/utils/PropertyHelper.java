package com.utils;

import java.util.*;

import static com.constants.FrameworkConstant.PROPERTY_FILE_PATH;

import java.io.*; 

public class PropertyHelper {
	
	private static Properties property = new Properties();
	private static final Map<String, String> CONFIGMAP = new HashMap<String, String>();

	static {
		try {
			FileInputStream fis = new FileInputStream(PROPERTY_FILE_PATH);
			property.load(fis);
			for (Map.Entry<Object, Object> entry : property.entrySet()) {
				CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim());
			}
			Log.logInfo("Property load successfully.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * Get the property value based on property name
	 * @param Name of property
	 * @return Value of property
	 */
	public static String get(PropertyEnum key) {
		if (Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))) {
			try {
				throw new Exception("Property name '" + key.toString().toLowerCase() 
						+ "' not found. Please check configTest.properties file.");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return CONFIGMAP.get(key.name().trim().toLowerCase());
	}
}
