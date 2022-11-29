package com.revature.dao;

import com.revature.models.Reimbursements;
import com.revature.models.User;

public interface UserDAO {

	public int create(User user);
	
	public User getById(int id);
	
	public User getByUsername(String username);
	
	public int submitTicket(Reimbursements reimb);
	
	public int processTicket(String username, int reimbId);
	
}
