package com.revature.sevices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.models.User;
import com.revature.dao.*;

public class UserServiceImpl implements UserService {

	
	private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	private static UserDAO userDAO;
	
	@Override
	public boolean registerUser(User user) {

				logger.info("UserServiceImpl::register() called. Creating new user...");
		
				int id = userDAO.create(user);

				logger.info("Recieved from DAO. New ID: " + id);

				return (id != 0) ? true : false;
	}

	@Override
	public boolean login(String username, String password) {

		return false;
	}

	@Override
	public User getUserById(int id) {

		return null;
	}

	@Override
	public boolean submitTicket(User user) {

		return false;
	}

	@Override
	public boolean processTicket(User user) {
		
		return false;
	}

}
