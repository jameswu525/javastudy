package org.jimmy.test;

import org.jimmy.dao.UserDAO;
import org.jimmy.dao.impl.UserDAOImpl;
import org.jimmy.model.User;
import org.jimmy.service.UserService;
import org.junit.Test;

public class TestUser {

	@Test
	public void test() {
		UserService service = new UserService();
		UserDAO dao = new UserDAOImpl();
		User entity = new User("Jimmy", "general");
		service.setDao(dao);
		service.addUser(entity);
	}

}
