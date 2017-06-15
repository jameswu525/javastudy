package org.jimmy.mvcdemo.service;

import org.jimmy.mvc.service.BasicService;
import org.jimmy.mvc.utils.StringUtils;
import org.jimmy.mvcdemo.dao.LoginXML;
import org.jimmy.mvcdemo.entity.UserEntity;

public class LoginService extends BasicService {
	public UserEntity validateUser(String name, String password) {
		if ("".equals(name) || name == null) {
			return new UserEntity(false, "tip01001");
		}
//		LoginDAO dao = new LoginDAO();   // office via postgresql
		LoginXML dao = new LoginXML();   // home via constant
//		System.out.println(StringUtils.getMD5(password));
		UserEntity entity = dao.getUserEntity(name);
		if (StringUtils.getMD5(password).equals(entity.getPassword())) {
			entity.success();
			return entity;
		} else {
			return entity;
		}
	}

}
