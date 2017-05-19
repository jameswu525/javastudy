package org.jimmy.dao.impl;

import org.jimmy.dao.UserDAO;
import org.jimmy.model.User;

public class UserDAOImpl implements UserDAO{

	@Override
	public void save(User entity) {
		System.out.println("save it in oracle database : User = " + entity.getUsername() + " / Sexing = " + entity.getSexing());
	}

}
