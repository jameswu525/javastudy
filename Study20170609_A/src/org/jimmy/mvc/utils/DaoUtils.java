package org.jimmy.mvc.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.jimmy.mvc.exception.MVCException;

public class DaoUtils {
	private static BasicDataSource bds = null;
	private static QueryRunner runner = new QueryRunner();
	
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
	
	public int excuteCUD(String sql, Object ... args) {
		return excuteCUD(createConnectionFromPool(), sql, args);
	}
	
	public int excuteCUD(Connection conn, String sql, Object ... args) {
		try {
			return runner.update(conn, sql, args);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return 0;
	}
	
	public static <T> T queryAsBean(Class<T> cls, String sql, Object...args ) {
		return queryAsBean(cls, createConnectionFromPool(), sql, args);
	}
	
	public static <T> T queryAsBean(Class<T> cls, Connection conn, String sql, Object...args ) {
		T result = null;
		try {
			result = runner.query(conn, sql, new BeanHandler<T>(cls), args);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
			releaseResource(conn, null, null);
		}
		return result;
	}

	public static <T> List<T> queryAsList(Class<T> cls, String sql, Object...args ) {
		return queryAsList(cls, createConnectionFromPool(), sql, args);
	}
	
	public static <T> List<T> queryAsList(Class<T> cls, Connection conn, String sql, Object...args ) {
		List<T> result = null;
		try {
			result = runner.query(conn, sql, new BeanListHandler<T>(cls), args);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
			releaseResource(conn, null, null);
		}
		return result;
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