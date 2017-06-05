package org.jimmy.junit;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class DriverTest {

	@Test
	public void testDriverManager() throws Exception {
		String driverClass = "org.postgresql.Driver";
		String jdbcUrl = "jdbc:postgresql://localhost:5432/wx20170324";
		String user = "wx";
		String password = "kerry2016!";
		

		String driverClass2 = "oracle.jdbc.OracleDriver";
		String jdbcUrl2 = "jdbc:oracle:thin:@172.20.245.11:1521:E900";
		String user2 = "jimmy";
		String password2 = "wujianbing";

		Class.forName(driverClass);
		Class.forName(driverClass2);
		Connection conn = DriverManager.getConnection(jdbcUrl, user, password);
//		Connection conn = DriverManager.getConnection(jdbcUrl2, user2, password2);
		System.out.println(conn);
	}

}
