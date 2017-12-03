package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import com.mysql.jdbc.PreparedStatement;

import Utils.JdbcUtil;



/**
 *This class  is to Junit  test for database
 * 
 * */
public class dao_demoTest {
	
	/**
	 * add method
	 * 
	 */
	@Test
	public void addDemo(){
		Connection conn = null;
		java.sql.PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
		       conn = JdbcUtil.getConnection();
	                String sql = "INSERT INTO user (email,firstname,password,level,lastname,address,city,state,zipcode)VALUES (?,?,?,?,?,?,?,?,?)";
	                stmt = conn.prepareStatement(sql);
	                stmt.setString(1, "bbbb");
	                stmt.setString(2, "abb");
	                stmt.setString(3, "bba");
	                stmt.setString(4, "ba");
	                stmt.setString(5, "a");
	                stmt.setString(6,"a");
	                stmt.setString(7,"a");
	                stmt.setString(8, "a");
	                stmt.setInt(9, 11);
	                stmt.executeUpdate();
			//遍历rs
			while(rs.next()){
				System.out.println(rs.getString("Name"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}finally{
			JdbcUtil.release(conn, stmt, rs);
		}
		return ;
	}
	
	/**
	 *  Query  method 
	 * 
	 */
	@Test
	public void queryDemo(){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.createStatement();
			
			String sql = "select * from airline";
			//select *from user where username='zhangsan' and password = '123456'
			stmt.execute(sql);
			rs = stmt.executeQuery(sql);
			
			//遍历rs
			while(rs.next()){
				System.out.println(rs.getString("Name"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}finally{
			JdbcUtil.release(conn, stmt, rs);
		}
		return ;
	}
	
	/**
	 * 
	 * Update method
	 * 
	 */
	@Test
	public void updateDemo(){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.createStatement();
			
			String sql = "select * from airline";
			//select *from user where username='zhangsan' and password = '123456'
			stmt.execute(sql);
			rs = stmt.executeQuery(sql);
			
			//遍历rs
			while(rs.next()){
				System.out.println(rs.getString("Name"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}finally{
			JdbcUtil.release(conn, stmt, rs);
		}
		return ;
	}
	
	
	/**
	 * 
	 * delete method
	 */
	@Test
	public void deleteDemo(){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.createStatement();
			
			String sql = "select * from airline";
			//select *from user where username='zhangsan' and password = '123456'
			stmt.execute(sql);
			rs = stmt.executeQuery(sql);
			
			//遍历rs
			while(rs.next()){
				System.out.println(rs.getString("Name"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}finally{
			JdbcUtil.release(conn, stmt, rs);
		}
		return ;
	}



}
