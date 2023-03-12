package com.vita.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestDAO {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String user = "js";
	String pw = "wnstn";
	
	public TestDAO() {
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pw);	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public TestDTO test(int param) {
		
		TestDTO dto = null;
		try {
			String sql = "SELECT * FROM PRODUCT WHERE PRODUCT_NUM = ?";
			System.out.println(param);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, param);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
		
				String productName = rs.getString("PRODUCT_NAME");
				int price = rs.getInt("PRODUCT_PRICE");
				String productDetail = rs.getString("PRODUCT_DESC");
				
				dto = new TestDTO(productName, price, productDetail);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return dto ;		
	}
	
}
