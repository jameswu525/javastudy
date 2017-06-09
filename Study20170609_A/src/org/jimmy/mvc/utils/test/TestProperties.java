package org.jimmy.mvc.utils.test;

import java.io.IOException;
import java.util.Properties;

import org.jimmy.mvc.utils.PropertiesUtils;
import org.junit.Test;

public class TestProperties {

	@Test
	public void testGetProperties() throws IOException {
		System.out.println("=========================");

		Properties p = PropertiesUtils.readProperties("jdbc.properties");
		System.out.println(p.getProperty("driverClassName"));
		
	}
}
