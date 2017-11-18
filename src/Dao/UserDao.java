package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import Bean.User;
import Utils.JdbcUtil;
public class UserDao {
	
	@Test
	public User findUser(User user) {
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
			return null;
		}finally{
			JdbcUtil.release(conn, stmt, rs);
		}
		return null;
	}

}
