package com.revature.sevices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.models.User;
import com.revature.dao.*;

public class UserServiceImpl implements UserService {
	
	static User sessionEmployee = null;
	
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
		
		logger.info("UserServiceImpl::login() called. Logging in user...");
		
		User target = userDAO.login(username, password);
	
		logger.info("Received from DAO. Login attempt");
		
		if (username.equalsIgnoreCase(target.getUsername()) && password.equals(target.getPassword())) {
			logger.info("User " + username + " has logged in.");
			return true;
		} else {
			logger.info("login attempt failed");
		return false;
		}
	}
	
	public boolean logout(String username, String password) {
		
		User logged = userDAO.login(username, password);
		
		logger.info("UserServiceImpl::logout() called. Logging out " + logged.getUsername());
		
		if (username.equals(logged.getUsername()) && password.equals(logged.getPassword())) {
			logger.info("User " + logged.getUsername() + " has logged out.");
			return true;
		} else {
			logger.info("Failed to log out " + logged.getUsername());
			return false;
		}
	}

	@Override
	public User getUserByUsername(String username) {
		
		logger.info("UserServiceImpl::getUserByUsername() called. Getting user info...");
		
		User target = userDAO.getByUsername(username);
		
		if(username.equals(target.getUsername())) {
			logger.info("Recieved user info");
			return target;
		}else {
	logger.info("Incorrect Username");
		return null;
	}
}

}
