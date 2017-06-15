package org.jimmy.mvcdemo.dao;

import org.jimmy.mvc.dao.DAO;
import org.jimmy.mvcdemo.entity.UserEntity;

public class LoginXML extends DAO<UserEntity> {
	public UserEntity getUserEntity(String username) {
//		String sql = "select id, username, password from sys_users where upper(username) = ? and deleted_at is null";
//		UserEntity entity = queryBean(sql, new Object[]{username.toUpperCase()});
//		return entity == null ? new UserEntity() : entity;
		UserEntity entity = new UserEntity();
		entity.setUsername(username);
		entity.setPassword("202cb962ac59075b964b07152d234b70");  // password = 123  (md5)
		return entity == null ? new UserEntity() : entity;
	}
}
