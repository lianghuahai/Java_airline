package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

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
