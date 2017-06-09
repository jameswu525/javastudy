package org.jimmy.mvc.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesUtils {
	private static Map<String, Properties> map = new HashMap<>();

	private PropertiesUtils() {
	}
	
	static void addProperties(String name, Properties prop) {
		if (!map.containsKey(name))
			map.put(name, prop);
	}
	
	public static Properties readProperties(String propName) {
		return map.containsKey(propName)  ? map.get(propName) : new Properties();
	}

	public static String readPropertiesValue(String propName, String key) {
		return readProperties(propName).getProperty(key);
	}

}
