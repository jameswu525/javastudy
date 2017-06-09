package org.jimmy.mvc.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.jimmy.mvc.exception.MVCException;

public class DaoUtils {
	private static BasicDataSource bds = null;
	
	private DaoUtils() throws MVCException {
		if (bds != null) {
			throw new MVCException("excep01001");
		}
	}
	
	public static Connection createConnectionFromPool() {
		Connection conn = null;
		try {
			if (bds == null) {
				bds = BasicDataSourceFactory.createDataSource(PropertiesUtils.readProperties("jdbc.properties"));
			}
			conn = bds.getConnection();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return conn;
	}
	
	public static void releaseResource(Connection conn, Statement state, ResultSet set) {
		if (set != null) {
			try {
				set.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if (state != null) {
			try {
				state.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}