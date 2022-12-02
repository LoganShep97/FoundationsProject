package com.revature.sevices;

import com.revature.models.Reimbursements;

public interface ReimbService {

	public boolean submitTicket(Reimbursements reimb);
	
	public boolean updateTicket(Reimbursements reimb);
}
