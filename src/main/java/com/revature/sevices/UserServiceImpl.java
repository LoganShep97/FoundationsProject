package com.revature.sevices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.models.User;
import com.revature.dao.*;

public class UserServiceImpl implements UserService {

	
	private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	private static UserDAO userDAO = new UserDAOImpl();
	
	@Override
	public boolean registerUser(User user) {

				logger.info("UserServiceImpl::register() called. Creating new user...");
		
				int id = userDAO.create(user);

				logger.info("Recieved from DAO. New ID: " + id);

				return (id != 0) ? true : false;
	}

	@Override
	public boolean login(String username, String password) {
		
		logger.info("UserServiceImpl::register() called. Logging in user...");
		
		User target = userDAO.login(username, password);
		
		if (username == target.getUsername() && password == target.getPassword()) {
			logger.info("User " + username + " has logged in.");
			return true;
		} else {
		return false;
		}
	}

	@Override
	public User getUserById(int userId) {

			logger.info("UserServiceImpl::getUserById() called. Getting user info...");
		
			User target = userDAO.getById(userId);
			
			if(userId == target.getUserId()) {
				logger.info("Recieved user info: " + target.toString());
				return target;
			}else {
		logger.info("Incorrect User Id");
		return null;
			}
	}

	@Override
	public User getUserByUsername(String username) {
		
		logger.info("UserServiceImpl::getUserByUsername() called. Getting user info...");
		
		User target = userDAO.getByUsername(username);
		
		if(username == target.getUsername()) {
			logger.info("Recieved user info");
			return target;
		}else {
	logger.info("Incorrect Username");
		return null;
	}
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
