package org.jimmy.mvcdemo.service;

import org.jimmy.mvc.service.BasicService;
import org.jimmy.mvc.utils.StringUtils;
import org.jimmy.mvcdemo.dao.LoginDAO;
import org.jimmy.mvcdemo.entity.UserEntity;

public class LoginService extends BasicService {
	public UserEntity validateUser(String name, String password) {
		if ("".equals(name) || name == null) {
			return new UserEntity(false, "tip01001");
		}
		LoginDAO dao = new LoginDAO();
		UserEntity entity = dao.getUserEntity(name);
		if (StringUtils.getMD5(password).equals(entity.getPassword())) {
			entity.success();
			return entity;
		} else {
			return entity;
		}
	}

}
