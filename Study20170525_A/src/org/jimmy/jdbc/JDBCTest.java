package org.jimmy.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

public class JDBCTest {
	public static void main(String[] args) {
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

		// select 
		List<PropertiesBean> list = JDBCUtils.excuteSQL(PropertiesBean.class, sb.toString(), new Object[]{1, 2, 3});
		for (PropertiesBean bean : list) {
			System.out.println(bean);
		}
		System.out.println("===============================================================");
		// update one by one
		//updateSQL();    // 耗时：7194ms
		
		// update per 1000
		updateSQL2();     // 耗时：2729ms
	}
	
	
	private static void updateSQL() {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JDBCUtils.createConnectionFromPool();
			conn.setAutoCommit(false);
			String sql = "insert into t_links (id, name, link, property_id) values (?,?,?,?)";
			ps = conn.prepareStatement(sql);
			long start = new Date().getTime();
			for (int i = 0; i < 100000; i++) {
				ps.setInt(1, i+1);
				ps.setString(2,  "Name:" + (i + 1));
				ps.setString(3,  "Link://" + (i + 1));
				ps.setInt(4,  i+1);
				ps.executeUpdate();
			}
			conn.commit();
			long end = new Date().getTime();
			System.out.println("耗时：" + (end - start) + "ms");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.releaseResource(conn, ps, null);
		}
	}
	
	private static void updateSQL2() {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JDBCUtils.createConnectionFromPool();
			conn.setAutoCommit(false);
			String sql = "insert into t_links (id, name, link, property_id) values (?,?,?,?)";
			ps = conn.prepareStatement(sql);
			long start = new Date().getTime();
			int time = 1;
			for (int i = 0; i < 100000; i++) {
				ps.setInt(1, i+1);
				ps.setString(2,  "Name:" + (i + 1));
				ps.setString(3,  "Link://" + (i + 1));
				ps.setInt(4,  time);
				ps.addBatch();
				if ((i+1) % 1000 == 0) {
					ps.executeBatch();
					ps.clearBatch();
					long end = new Date().getTime();
//					System.out.println("第" + time++ + "次提交，耗时：" + (end - start) + "ms");
				} else if (i == 100000-1) {
					ps.executeBatch();
					ps.clearBatch();
					long end = new Date().getTime();
//					System.out.println("第" + time++ + "次提交，耗时：" + (end - start) + "ms");
				}
			}
			conn.commit();
			long end = new Date().getTime();
			System.out.println("耗时：" + (end - start) + "ms");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.releaseResource(conn, ps, null);
		}
	}
	

	private boolean validateLoginInfor() {
		boolean result = false;
		Connection conn = null;
		Statement state = null;
		String url = "jdbc:postgresql://localhost:5432/wx20170324";
		String username = "wx";
		String password = "kerry2016!";
		System.out.println(url + ":" + username);
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(url, username, password);
			state = conn.createStatement();
			
			ResultSet res = state.executeQuery("select current_date");
			if (res.next()) {
				System.out.println(res.getString(1));
				result = true;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				state.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return result;
	}
}
