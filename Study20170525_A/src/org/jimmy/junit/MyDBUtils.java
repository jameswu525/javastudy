package org.jimmy.junit;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.jimmy.jdbc.JDBCUtils;
import org.jimmy.jdbc.PropertiesBean;
import org.junit.Test;

public class MyDBUtils {
	
	private QueryRunner runner = new QueryRunner();
	/**
	 * 測試QueryRunner的update
	 */
	@Test
	public void testQueryRunnerUpdate() {
		// 1， 創建QueryRunner		
		// 2, 连接
		Connection conn = null;
		
		// 可用于Update，Insert， Delete更新类的操作。
		String sql = "delete from t_links where id = ?";
		
		try {
			conn = JDBCUtils.createConnectionFromPool();
			runner.update(conn, sql, 2);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.releaseResource(conn, null, null);
		}
	}
	

	@Test
	public void testQueryRunnerQuery() {
		// 2, 连接
		Connection conn = null;
		
		// 可用于Update，Insert， Delete更新类的操作。

		StringBuilder sb = new StringBuilder();
		sb.append(" 	select id,	");
		sb.append(" 	name,	");
		sb.append(" 	app_id,	");
		sb.append(" 	telephone,	");
		sb.append(" 	province,	");
		sb.append(" 	city,	");
		sb.append(" 	street,	");
		sb.append(" 	start_time,	");
		sb.append(" 	end_time,	");
		sb.append(" 	zipcode,	");
		sb.append(" 	isjde,	");
		sb.append(" 	active,	");
		sb.append(" 	created_at,	");
		sb.append(" 	updated_at,	");
		sb.append(" 	deleted_at,	");
		sb.append(" 	mch_id,	");
		sb.append(" 	partner_key,	");
		sb.append(" 	bill_sync_day,	");
		sb.append(" 	alipay_app_id,	");
		sb.append(" 	alipay_cer,	");
		sb.append(" 	ali_community_id,	");
		sb.append(" 	out_community_id,	");
		sb.append(" 	alipay_app_public,	");
		sb.append(" 	alipay_public,	");
		sb.append(" 	alipay_product_code	");
		sb.append(" 	from kerry_properties	");
		sb.append(" 	where id = ? or id = ? or id = ?");
		sb.append(" 	order by id");
		
		String sql = sb.toString();
		
		try {
			conn = JDBCUtils.createConnectionFromPool();
			ResultSetHandler<List<PropertiesBean>> rst = new ResultSetHandler<List<PropertiesBean>>() {
				@Override
				public List<PropertiesBean> handle(ResultSet rs) throws SQLException {
					List<PropertiesBean> list = new ArrayList<>();
					
					List<String> properties = new ArrayList<>();
					int cols = rs.getMetaData().getColumnCount();
					ResultSetMetaData metaData = rs.getMetaData();
					for (int i = 1; i <= cols; i++) {
						properties.add(metaData.getColumnLabel(i));
					}

					try {
					while (rs.next()) {
						PropertiesBean bean = new PropertiesBean();
						for (String name : properties) {
								BeanUtils.setProperty(bean, name, rs.getObject(name));
						}
						list.add(bean);
					}
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}
					
					return list;
				}
			};
			List<PropertiesBean> list = runner.query(conn, sql, rst, new Object[]{1,2,6});
			for (PropertiesBean bean : list) {
				System.out.println(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.releaseResource(conn, null, null);
		}
	}
	
	/**
	 * BeanHandler 能获取记录集的第一行记录。
	 * 
	 */
	@Test
	public void testBeanHandler() {
		Connection conn = null;
		try {
			conn = JDBCUtils.createConnectionFromPool();

			StringBuilder sb = new StringBuilder();
			sb.append(" 	select id,	");
			sb.append(" 	name,	");
			sb.append(" 	app_id,	");
			sb.append(" 	telephone,	");
			sb.append(" 	province,	");
			sb.append(" 	city,	");
			sb.append(" 	street,	");
			sb.append(" 	start_time,	");
			sb.append(" 	end_time,	");
			sb.append(" 	zipcode,	");
			sb.append(" 	isjde,	");
			sb.append(" 	active,	");
			sb.append(" 	created_at,	");
			sb.append(" 	updated_at,	");
			sb.append(" 	deleted_at,	");
			sb.append(" 	mch_id,	");
			sb.append(" 	partner_key,	");
			sb.append(" 	bill_sync_day,	");
			sb.append(" 	alipay_app_id,	");
			sb.append(" 	alipay_cer,	");
			sb.append(" 	ali_community_id,	");
			sb.append(" 	out_community_id,	");
			sb.append(" 	alipay_app_public,	");
			sb.append(" 	alipay_public,	");
			sb.append(" 	alipay_product_code	");
			sb.append(" 	from kerry_properties	");
			sb.append(" 	where id = ? or id = ? or id = ?");
			sb.append(" 	order by id");
			
			String sql = sb.toString();
			

			PropertiesBean bean = runner.query(conn, sql, new BeanHandler<PropertiesBean>(PropertiesBean.class), new Object[]{1,2,6});
			System.out.println(bean);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.releaseResource(conn, null, null);
		}
	}	
	

	/**
	 * BeanListHandler 能获取记录集的第一行记录。
	 * 
	 */
	@Test
	public void testBeanListHandler() {
		Connection conn = null;
		try {
			conn = JDBCUtils.createConnectionFromPool();

			StringBuilder sb = new StringBuilder();
			sb.append(" 	select id,	");
			sb.append(" 	name,	");
			sb.append(" 	app_id,	");
			sb.append(" 	telephone,	");
			sb.append(" 	province,	");
			sb.append(" 	city,	");
			sb.append(" 	street,	");
			sb.append(" 	start_time,	");
			sb.append(" 	end_time,	");
			sb.append(" 	zipcode,	");
			sb.append(" 	isjde,	");
			sb.append(" 	active,	");
			sb.append(" 	created_at,	");
			sb.append(" 	updated_at,	");
			sb.append(" 	deleted_at,	");
			sb.append(" 	mch_id,	");
			sb.append(" 	partner_key,	");
			sb.append(" 	bill_sync_day,	");
			sb.append(" 	alipay_app_id,	");
			sb.append(" 	alipay_cer,	");
			sb.append(" 	ali_community_id,	");
			sb.append(" 	out_community_id,	");
			sb.append(" 	alipay_app_public,	");
			sb.append(" 	alipay_public,	");
			sb.append(" 	alipay_product_code	");
			sb.append(" 	from kerry_properties	");
			sb.append(" 	where id = ? or id = ? or id = ?");
			sb.append(" 	order by id");
			
			String sql = sb.toString();
			

			List<PropertiesBean> list = runner.query(conn, sql, new BeanListHandler<PropertiesBean>(PropertiesBean.class), new Object[]{1,2,6});
			for (PropertiesBean bean : list) {
				System.out.println(bean);
			}			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.releaseResource(conn, null, null);
		}
	}
	

	/**
	 * MapHandler 能获取记录集的第一行记录。
	 * 
	 */
	@Test
	public void testMapHandler() {
		Connection conn = null;
		try {
			conn = JDBCUtils.createConnectionFromPool();

			StringBuilder sb = new StringBuilder();
			sb.append(" 	select id,	");
			sb.append(" 	name,	");
			sb.append(" 	app_id,	");
			sb.append(" 	telephone,	");
			sb.append(" 	province,	");
			sb.append(" 	city,	");
			sb.append(" 	street,	");
			sb.append(" 	start_time,	");
			sb.append(" 	end_time,	");
			sb.append(" 	zipcode,	");
			sb.append(" 	isjde,	");
			sb.append(" 	active,	");
			sb.append(" 	created_at,	");
			sb.append(" 	updated_at,	");
			sb.append(" 	deleted_at,	");
			sb.append(" 	mch_id,	");
			sb.append(" 	partner_key,	");
			sb.append(" 	bill_sync_day,	");
			sb.append(" 	alipay_app_id,	");
			sb.append(" 	alipay_cer,	");
			sb.append(" 	ali_community_id,	");
			sb.append(" 	out_community_id,	");
			sb.append(" 	alipay_app_public,	");
			sb.append(" 	alipay_public,	");
			sb.append(" 	alipay_product_code	");
			sb.append(" 	from kerry_properties	");
			sb.append(" 	where id = ? or id = ? or id = ?");
			sb.append(" 	order by id");
			
			String sql = sb.toString();
			

			Map<String, Object> map = runner.query(conn, sql, new MapHandler(), new Object[]{1,2,6});
				System.out.println(map);
				
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.releaseResource(conn, null, null);
		}
	}
	


	/**
	 * MapListHandler 能获取记录集的第一行记录。
	 * 
	 */
	@Test
	public void testMapListHandler() {
		Connection conn = null;
		try {
			conn = JDBCUtils.createConnectionFromPool();

			StringBuilder sb = new StringBuilder();
			sb.append(" 	select id,	");
			sb.append(" 	name,	");
			sb.append(" 	app_id,	");
			sb.append(" 	telephone,	");
			sb.append(" 	province,	");
			sb.append(" 	city,	");
			sb.append(" 	street,	");
			sb.append(" 	start_time,	");
			sb.append(" 	end_time,	");
			sb.append(" 	zipcode,	");
			sb.append(" 	isjde,	");
			sb.append(" 	active,	");
			sb.append(" 	created_at,	");
			sb.append(" 	updated_at,	");
			sb.append(" 	deleted_at,	");
			sb.append(" 	mch_id,	");
			sb.append(" 	partner_key,	");
			sb.append(" 	bill_sync_day,	");
			sb.append(" 	alipay_app_id,	");
			sb.append(" 	alipay_cer,	");
			sb.append(" 	ali_community_id,	");
			sb.append(" 	out_community_id,	");
			sb.append(" 	alipay_app_public,	");
			sb.append(" 	alipay_public,	");
			sb.append(" 	alipay_product_code	");
			sb.append(" 	from kerry_properties	");
			sb.append(" 	where id = ? or id = ? or id = ?");
			sb.append(" 	order by id");
			
			String sql = sb.toString();
			

			List<Map<String, Object>> map = runner.query(conn, sql, new MapListHandler(), new Object[]{1,2,6});
				System.out.println(map);
				
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.releaseResource(conn, null, null);
		}
	}
}
