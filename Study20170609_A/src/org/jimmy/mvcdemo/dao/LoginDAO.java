package org.jimmy.mvcdemo.dao;

import org.jimmy.mvc.dao.DAO;
import org.jimmy.mvc.utils.DaoUtils;
import org.jimmy.mvcdemo.entity.UserEntity;

public class LoginDAO extends DAO {
	public UserEntity getUserEntity(String username) {
		String sql = "select id, username, password from sys_users where upper(username) = ? and deleted_at is null";
		return DaoUtils.queryAsBean(UserEntity.class, sql, new Object[]{username.toUpperCase()});
	}
}
