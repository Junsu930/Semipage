package com.vita.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String user = "js";
	String pw = "wnstn";
	
	public UserDAO() {
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pw);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public int registerCheck(String userId) {
	
		String sql = "SELECT * FROM SHOPPING_USER WHERE USER_ID = ?";
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return 0;
			}else {
				return 1;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if( rs!=null) rs.close();
				if( pstmt!=null) pstmt.close();
				if( conn!=null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return -1;
	}
	
	public int register(String userId, String userPwd, String userName, String userPhone) {
		String sql = "INSERT INTO SHOPPING_USER VALUES (?, ?, ?, ?, DEFAULT)";
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd );
			pstmt.setString(3, userName);
			pstmt.setString(4, userPhone);
			
			return pstmt.executeUpdate();
			
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if( pstmt!=null) pstmt.close();
				if( conn!=null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return -1;
	}
	
	public int checkId(String id) {
		String sql = "SELECT * FROM SHOPPING_USER WHERE USER_ID = ?";
		int idCheck = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next() || id.equals("")) {
				idCheck=0;
			} else {
				idCheck = 1;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
				try {
					if( rs!=null) rs.close();
					if( pstmt!=null) pstmt.close();
					if( conn!=null) conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return idCheck;
	}

}
