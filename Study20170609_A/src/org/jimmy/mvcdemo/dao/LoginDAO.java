package org.jimmy.mvcdemo.dao;

import org.jimmy.mvc.dao.DAO;
import org.jimmy.mvcdemo.entity.UserEntity;

public class LoginDAO extends DAO<UserEntity> {
	public UserEntity getUserEntity(String username) {
		String sql = "select id, username, password from sys_users where upper(username) = ? and deleted_at is null";
		UserEntity entity = queryBean(sql, new Object[]{username.toUpperCase()});
		return entity == null ? new UserEntity() : entity;
	}
}
