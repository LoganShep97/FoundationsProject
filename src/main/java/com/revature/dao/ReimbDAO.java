package com.revature.dao;

import com.revature.models.Reimbursements;
import com.revature.models.User;

public interface ReimbDAO {

	public int submitTicket(Reimbursements reimb);
	
	public int updateTicket(Reimbursements reimb);
	
	public int getTicketByUser(User user);
	
}
