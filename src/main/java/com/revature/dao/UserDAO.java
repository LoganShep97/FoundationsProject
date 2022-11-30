package com.revature.dao;

import com.revature.models.Reimbursements;
import com.revature.models.User;

public interface UserDAO {

	public int create(User user);
	
	public User getById(int userId);
	
	public User getByUsername(String username);
	
	public User login(String username, String password);
	
	public int submitTicket(Reimbursements reimb);
	
	public int processTicket(User user, int reimbId);
	
}
