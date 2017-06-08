package org.jimmy.junit;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class TestC3P0 {
	
	@Test
	public void testC3P0ConfigFile() throws Exception {
		ComboPooledDataSource cpds = new ComboPooledDataSource("helloc3p0");

		System.out.println(cpds.getConnection());
	}
	
	@Test
	public void testC3P0() throws Exception {
		InputStream in = ClassLoader.getSystemResourceAsStream("jdbc.properties");
		Properties prop = new Properties();
		try {
			prop.load(in);
		} catch (IOException e) {
			prop.put("jdbc.driver", "org.postgresql.Driver");
			prop.put("jdbc.username", "wx");
			prop.put("jdbc.password", "kerry2016!");
			prop.put("jdbc.url", "jdbc:postgresql://localhost:5432/wx20170324");
		}

		ComboPooledDataSource cpds = new ComboPooledDataSource();
		cpds.setDriverClass(prop.getProperty("jdbc.driver"));
		cpds.setJdbcUrl(prop.getProperty("jdbc.url"));
		cpds.setUser(prop.getProperty("jdbc.username"));
		cpds.setPassword(prop.getProperty("jdbc.password"));
		
		System.out.println(cpds.getConnection());
	}

}
