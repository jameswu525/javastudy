package org.jimmy.cordemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDemo {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		System.out.println(System.getProperties());
		Properties p = new Properties();
		System.out.println("============================");
		p.load(new FileInputStream(System.getProperty("java.class.path") + "/db.properties"));
		System.out.println("用户名：" + p.get("username"));
	}
}
