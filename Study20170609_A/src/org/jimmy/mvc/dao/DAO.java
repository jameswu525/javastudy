package org.jimmy.mvc.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.jimmy.mvc.utils.DaoUtils;

public class DAO<T> {
	private static QueryRunner runner = new QueryRunner();
	private Class<T> clazz = null;

	public DAO() {
		Type superClass = getClass().getGenericSuperclass();
		if (superClass instanceof ParameterizedType) {
			ParameterizedType clz = (ParameterizedType) superClass;
			Type[] ts = clz.getActualTypeArguments();
			if (ts != null && ts.length > 0)
				clazz = (Class<T>) ts[0];
		}
	}

	public int update(String sql, Object... args) {
		return update(DaoUtils.createConnectionFromPool(), sql, args);
	}

	public int update(Connection conn, String sql, Object... args) {
		try {
			System.out.println(sql);
			return runner.update(conn, sql, args);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
			DaoUtils.releaseResource(conn, null, null);
		}
		return 0;
	}

	public T queryBean(String sql, Object... args) {
		return queryBean(DaoUtils.createConnectionFromPool(), sql, args);
	}

	public T queryBean(Connection conn, String sql, Object... args) {
		T result = null;
		try {
			if (args != null && args.length > 0) 
				result = runner.query(conn, sql, new BeanHandler<T>(clazz), args);
			else 
				result = runner.query(conn, sql, new BeanHandler<T>(clazz));
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
			DaoUtils.releaseResource(conn, null, null);
		}
		return result;
	}

	public List<T> queryList(String sql, Object... args) {
		return queryList(DaoUtils.createConnectionFromPool(), sql, args);
	}

	public List<T> queryList(Connection conn, String sql, Object... args) {
		List<T> result = null;
		try {
			if (args != null && args.length > 0) 
				result = runner.query(conn, sql, new BeanListHandler<T>(clazz), args);
			else 
				result = runner.query(conn, sql, new BeanListHandler<T>(clazz));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DaoUtils.releaseResource(conn, null, null);
		}
		return result;
	}

	public <E> E queryValue(String sql, Object... args) {
		return queryValue(DaoUtils.createConnectionFromPool(), sql, args);
	}

	public <E> E queryValue(Connection conn, String sql, Object... args) {
		E result = null;
		try {
			if (args != null && args.length > 0) 
				result = runner.query(conn, sql, new ScalarHandler<E>(), args);
			else 
				result = runner.query(conn, sql, new ScalarHandler<E>());
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
			DaoUtils.releaseResource(conn, null, null);
		}
		return result;
	}

}
