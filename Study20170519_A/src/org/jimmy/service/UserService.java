package org.jimmy.service;

import org.jimmy.dao.UserDAO;
import org.jimmy.model.User;

public class UserService {
	private UserDAO dao = null;
	
	public void addUser(User u) {
		dao.save(u);
	}

	public UserDAO getDao() {
		return dao;
	}

	public void setDao(UserDAO dao) {
		this.dao = dao;
	}
	
}
