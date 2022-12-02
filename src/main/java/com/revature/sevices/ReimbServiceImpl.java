package com.revature.sevices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.dao.ReimbDAOImpl;
import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;
import com.revature.models.Reimbursements;
import com.revature.models.User;

public class ReimbServiceImpl implements ReimbService {
	
	private static Logger logger = LoggerFactory.getLogger(ReimbServiceImpl.class);
	
	private static ReimbDAOImpl ReimbDAO = new ReimbDAOImpl();

	@Override
	public boolean submitTicket(Reimbursements reimb) {
	
		logger.info("UserServiceImpl::register() called. Creating new user...");
		
		int id = ReimbDAO.submitTicket(reimb);

		logger.info("Recieved from DAO. User Submits ticket.");

		return (id != 0) ? true : false;
	}

	@Override
	public boolean updateTicket(Reimbursements reimb) {
	
		logger.info("UserServiceImpl::updateTicket() called. Updating Ticket...");
		
		int id = ReimbDAO.updateTicket(reimb);
		User logged = UserServiceImpl.sessionEmployee;
		
		// Checks if logged in User is a manager
		if (UserServiceImpl.sessionEmployee.getRole() == 2) {
			if (id == reimb.getReimbId()) {
				logger.info(UserServiceImpl.sessionEmployee.getUsername() + "has updated the ticket.");
				return true;
			}else {
				logger.info("There was a problem updating the ticket.");
				return false;
			}
		}else {
			logger.info("This user is not a manager.");
			return false;
		}
	}

}
