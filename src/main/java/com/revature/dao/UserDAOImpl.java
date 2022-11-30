package com.revature.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.models.*;
import com.revature.util.JDBCConnectionUtil;

public class UserDAOImpl implements UserDAO {
	
	private static Connection conn;

	private static Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);
	
	public UserDAOImpl() {
		 		conn = JDBCConnectionUtil.getConnection();
	}
	
	@Override
	public int create(User user) {
		try {
			
				String sql = "INSERT INTO users (u_username, u_password, u_firstname, u_lastname, u_email, u_role_id) VALUES(?, ?, ?, ?, ?, ?)";
				
				PreparedStatement pstnt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				
				pstnt.setString(1, user.getUsername());
				pstnt.setString(2, user.getPassword());
				pstnt.setString(3, user.getFirstName());
				pstnt.setString(4, user.getLastName());
				pstnt.setString(5, user.geteMail());
				pstnt.setInt(6, user.getRole());
				
				
				pstnt.executeUpdate();
				
				ResultSet rs = pstnt.getGeneratedKeys();
				
				rs.next();
				
				logger.info("UserDAOImpl - create(), - new user id is " + rs.getInt(1));
				return rs.getInt("u_id");
				
			}catch(SQLException e) {
				System.out.println(e.getMessage());
			}
			
			
			return 0;
		}
	

	@Override
	public User getById(int userId) {
		try {
			
			String sql = "SELECT * FROM users WHERE u_id = ?";
			
			PreparedStatement pstnt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			pstnt.setInt(1, userId);
			
			ResultSet rs = pstnt.executeQuery();
			
			logger.info("UserDAOImpl - getById(), - User info retrieved");
			
			User target = new User();
			while(rs.next()) {
				target.setUserId(rs.getInt("u_id"));
				target.setUsername(rs.getString("u_username"));
				target.setPassword(rs.getString("u_password"));
				target.setFirstName(rs.getString("u_firstname"));
				target.setLastName(rs.getString("u_lastname"));
				target.seteMail(rs.getString("u_email"));
				target.setRole(rs.getInt("u_role"));
			}
			return target;
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public User getByUsername(String username) {
		try {
			
			String sql = "SELECT * FROM users WHERE u_username = ?";
			
			PreparedStatement pstnt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			pstnt.setString(1, username);
			
			ResultSet rs = pstnt.executeQuery();
			
			logger.info("UserDAOImpl - getByUsername(), - User info retrieved");
			
			User target = new User();
			while(rs.next()) {
				target.setUserId(rs.getInt("u_id"));
				target.setUsername(rs.getString("u_username"));
				target.setPassword(rs.getString("u_password"));
				target.setFirstName(rs.getString("u_firstname"));
				target.setLastName(rs.getString("u_lastname"));
				target.seteMail(rs.getString("u_email"));
				target.setRole(rs.getInt("u_role"));
			}
			return target;
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public int submitTicket(Reimbursements reimb) {
		
		String sql = "INSERT INTO reimbursements (r_amount, r_description) VALUES (?, ?)";
		
		
		return 0;
	}

	@Override
	public int processTicket(String username, int reimbId) {
		
		return 0;
	}

}
