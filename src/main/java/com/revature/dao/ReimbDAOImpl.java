package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.models.Reimbursements;
import com.revature.models.User;
import com.revature.util.JDBCConnectionUtil;

public class ReimbDAOImpl implements ReimbDAO {
	
	private static Connection conn;

	private static Logger logger = LoggerFactory.getLogger(ReimbDAOImpl.class);

	public ReimbDAOImpl() {
		conn = JDBCConnectionUtil.getConnection();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int submitTicket(Reimbursements reimb) {
		try {
			
			String sql = "INSERT INTO reimbursement (r_amount, r_description, r_author, r_statusid) VALUES(?, ?, ?, 1)";
			
			PreparedStatement pstnt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			pstnt.setInt(1, reimb.getAmount());
			pstnt.setString(2, reimb.getDescription());
			pstnt.setString(3, reimb.getAuthor());
			
			
			pstnt.executeUpdate();
			
			ResultSet rs = pstnt.getGeneratedKeys();
			
			rs.next();
			
			logger.info("ReimbDAOImpl - submitTicket(), - user submitted " + rs.getInt(1));
			return rs.getInt("r_id");
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return 0;
	}

	@Override
	public int getTicketByUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateTicket(Reimbursements reimb) {
		try {
			
		String sql = "UPDATE reimbursement SET r_statusid = ? WHERE r_id = ?";
		
		PreparedStatement pstnt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);	
		
		pstnt.setInt(1, reimb.getStatus());
		pstnt.setInt(2, reimb.getReimbId());
		
		pstnt.executeUpdate();
		
		ResultSet rs = pstnt.getGeneratedKeys();
		
		rs.next();
		
		logger.info("ReimbDAOImpl - submitTicket(), - user submitted " + rs.getInt(2));
		return rs.getInt("r_id");
		
		
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}

}
