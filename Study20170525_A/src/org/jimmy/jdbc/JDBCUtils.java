package org.jimmy.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

/**
 * 制作一个传入SQL即可获取对应结果集List的方法。
 * @author JimmyWu
 *
 */
public class JDBCUtils {
	private static BasicDataSource bds = null;
	
	private JDBCUtils() {}
	
	/**
	 * 
	 * @param cls 返回结果集的对象
	 * @param sql SQL语句
	 * @param args SQL中填充的参数
	 * @return
	 */
	public static <T> List<T> excuteSQL(Class<T> cls, String sql, Object... args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet res = null;
		List<T> list = new ArrayList<>();
		try {
//			conn = createConnection();
			// 模拟启动线程同时获取20个连接，超出设置最大个数，线程必须等待其他线程释放连接后才能继续申请
//			for (int i = 0; i < 20; i++) {
//				new Thread() {
//					public void run() {
//						Connection conn = null;
//						long start = new Date().getTime();
//						try {
//							// 等待连接
//							conn = createConnectionViaBasicDS();
//						} catch (Exception e) {
//							e.printStackTrace();
//						}
//						long end = new Date().getTime();
//						// 获取的connection为不同的object，是否证明pool其实在重新申请分配连接
//						System.out.println("耗时：" + (end - start) + "ms, " + conn + " / " + conn.hashCode());
//						
//						try {
//							sleep(1000);
//						} catch (InterruptedException e) {
//							e.printStackTrace();
//						}
//						
//						try {
//							// 关闭连接
//							conn.close();
//						} catch (SQLException e) {
//							e.printStackTrace();
//						}
//					}
//				}.start();
//				
//			}
			
			
			conn = createConnectionFromPool();
			//		Statement state = conn.createStatement();     // 避免使用Statement方式，防止SQL注入
			//		state.executeQuery("SELECT * FROM DUAL");
			ps = conn.prepareStatement(sql);
			if (args != null) {
				for (int i = 0; i < args.length; i++) {
					ps.setObject(i + 1, args[i]);
				}
			}
			res = ps.executeQuery();
			List<String> properties = new ArrayList<>();
			int cols = res.getMetaData().getColumnCount();
			ResultSetMetaData metaData = res.getMetaData();
			for (int i = 1; i <= cols; i++) {
				properties.add(metaData.getColumnLabel(i));
			}

			while (res.next()) {
				T instance = cls.newInstance();
				for (String colName : properties) {
					// 获取属性的Set方法
//					Field f = cls.getDeclaredField(colName);
//					String fSetMethod = "set" + colName.substring(0, 1).toUpperCase() + colName.substring(1);
//					Method setMethod = cls.getDeclaredMethod(fSetMethod, new Class[] {f.getType()});
//					String value = String.valueOf(res.getObject(colName));
//					setMethod.invoke(instance,  new Object[]{value});
					
					// 使用BeanUtils工具类替换该部分
					String value = String.valueOf(res.getObject(colName));
					BeanUtils.setProperty(instance, colName, value);
				}
				list.add(instance);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			releaseResource(conn, ps, res);
		}

		return list;
	}
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public static Connection createConnection() throws Exception {
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
		
		Class.forName(prop.getProperty("jdbc.driver"));
		Connection conn = DriverManager.getConnection(prop.getProperty("jdbc.url"), prop.getProperty("jdbc.username"), prop.getProperty("jdbc.password"));
//		System.out.println(conn.getTransactionIsolation());
		/*
		 *       <code>Connection.TRANSACTION_READ_UNCOMMITTED</code>,
	     *        <code>Connection.TRANSACTION_READ_COMMITTED</code>,
	     *        <code>Connection.TRANSACTION_REPEATABLE_READ</code>,
	     *        <code>Connection.TRANSACTION_SERIALIZABLE</code>, or
	     *        <code>Connection.TRANSACTION_NONE</code>.
		 */
		return conn;
	}
	
	public static Connection createConnectionViaBasicDS() throws Exception {
		if (bds == null) {
			bds = new BasicDataSource();
			InputStream in = ClassLoader.getSystemResourceAsStream("jdbc.properties");
			Properties prop = new Properties();
			try {
				prop.load(in);
			} catch (IOException e) {
				prop.setProperty("jdbc.driver", "org.postgresql.Driver");
				prop.setProperty("jdbc.username", "wx");
				prop.setProperty("jdbc.password", "kerry2016!");
				prop.setProperty("jdbc.url", "jdbc:postgresql://localhost:5432/wx20170324");
			}
			bds.setDriverClassName(prop.getProperty("jdbc.driver"));
			bds.setUsername(prop.getProperty("jdbc.username"));
			bds.setPassword(prop.getProperty("jdbc.password"));
			bds.setUrl(prop.getProperty("jdbc.url"));
			// 初始化连接个数
			bds.setInitialSize(1);
			// 最大连接数
			bds.setMaxTotal(3);
			// 最小预留个数
			bds.setMinIdle(1);
			// 设置最大等待申请连接的时间，超时则跑出SQL Exception
			bds.setMaxWaitMillis(5000);
		}
//		//		Class.forName(prop.getProperty("jdbc.driver"));
////		Connection conn = DriverManager.getConnection(prop.getProperty("jdbc.url"), prop.getProperty("jdbc.username"), prop.getProperty("jdbc.password"));
//		System.out.println(conn.getTransactionIsolation());
		/*
		 *       <code>Connection.TRANSACTION_READ_UNCOMMITTED</code>,
	     *        <code>Connection.TRANSACTION_READ_COMMITTED</code>,
	     *        <code>Connection.TRANSACTION_REPEATABLE_READ</code>,
	     *        <code>Connection.TRANSACTION_SERIALIZABLE</code>, or 
	     *        <code>Connection.TRANSACTION_NONE</code>.
		 */
		return bds.getConnection();
	}

	public static Connection createConnectionFromPool() throws Exception {
		if (bds == null) {
		InputStream in = ClassLoader.getSystemResourceAsStream("jdbc.properties");
		Properties prop = new Properties();
		try {
			prop.load(in);
		} catch (IOException e) {
			prop.setProperty("jdbc.driver", "org.postgresql.Driver");
			prop.setProperty("jdbc.username", "wx");
			prop.setProperty("jdbc.password", "kerry2016!");
			prop.setProperty("jdbc.url", "jdbc:postgresql://localhost:5432/wx20170324");
		}
		bds = BasicDataSourceFactory.createDataSource(prop);
		}
//		Class.forName(prop.getProperty("jdbc.driver"));
//		Connection conn = DriverManager.getConnection(prop.getProperty("jdbc.url"), prop.getProperty("jdbc.username"), prop.getProperty("jdbc.password"));
		Connection conn = bds.getConnection();
//		System.out.println(conn.getTransactionIsolation());
		/*
		 *       <code>Connection.TRANSACTION_READ_UNCOMMITTED</code>,
	     *        <code>Connection.TRANSACTION_READ_COMMITTED</code>,
	     *        <code>Connection.TRANSACTION_REPEATABLE_READ</code>,
	     *        <code>Connection.TRANSACTION_SERIALIZABLE</code>, or
	     *        <code>Connection.TRANSACTION_NONE</code>.
		 */
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
