package com.revature.sevices;

import com.revature.models.User;

public interface UserService {

	public boolean registerUser(User user);
	
	public boolean login(String username, String password);
	
	public boolean logout(String username, String password);
	
	public User getUserByUsername(String username);
	
}
