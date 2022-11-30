package com.revature.sevices;

import com.revature.models.User;

public interface UserService {

	public boolean registerUser(User user);
	
	public boolean login(String username, String password);
	
	public User getUserById(int id);
	
	public User getUserByUsername(String username);
	
	public boolean submitTicket(User user);
	
	public boolean processTicket(User user);
}
