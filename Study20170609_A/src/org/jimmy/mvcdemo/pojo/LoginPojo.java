package org.jimmy.mvcdemo.pojo;

import org.jimmy.mvc.pojo.Pojo;
import org.jimmy.mvc.pojo.PojoCache;
import org.jimmy.mvc.utils.StringUtils;
import org.jimmy.mvcdemo.dao.LoginDAO;
import org.jimmy.mvcdemo.entity.UserEntity;

public class LoginPojo extends Pojo {
	public PojoCache validateUser(String name, String password) {
		if ("".equals(name) || name == null) {
			return new PojoCache(false, "tip01001");
		}
		LoginDAO dao = new LoginDAO();
		UserEntity entity = dao.getUserEntity(name);
		if (StringUtils.getMD5(password).equals(entity.getPassword())) {
			return new PojoCache(entity);
		} else {
			return new PojoCache(false, "tip01001");
		}
	}

}
