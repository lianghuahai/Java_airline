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

    public void register(User user) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
                conn = JdbcUtil.getConnection();
                stmt = conn.createStatement();
                
                String sql = "INSERT INTO user ("+ user.getEmail()+ ","+user.getFirstname()+ "," 
                +user.getLastname()+ ","+user.getAddress()+","+user.getCity()+ ","
                +user.getState()+","+user.getZipcode()+","+user.getLevel()+","+user.getPassword()+")"
                + "VALUES (email, firstname, lastname,address,city,state,zipcode,level,password)";

                stmt.execute(sql);
                rs = stmt.executeQuery(sql);
//            Statement接口提供了三种执行SQL语句的方法：executeQuery 、executeUpdate 和execute   
//            1、ResultSet executeQuery(String sqlString)：执行查询数据库的SQL语句，返回一个结果集（ResultSet）对象。   
//            2、int executeUpdate(String sqlString)：用于执行INSERT、UPDATE或 DELETE语句以及SQL DDL语句，如：CREATE TABLE和DROP TABLE等   
//            3、execute(sqlString):用于执行返回多个结果集、多个更新计数或二者组合的语句。
                //遍历rs
                while(rs.next()){
                        System.out.println(rs.getString("Name"));
                }
                
        } catch (SQLException e) {
                e.printStackTrace();
        }finally{
                JdbcUtil.release(conn, stmt, rs);
        }               
    }

}
