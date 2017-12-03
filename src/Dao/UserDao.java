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
			
			String sql = "select * from user";
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

	@Test
        public User checkUserLogin(User user) {
                Connection conn = null;
                Statement stmt = null;
                ResultSet rs = null;
                
                try {
                        conn = JdbcUtil.getConnection();
                        stmt = conn.createStatement();
                        
                        String sql = "select * from user";
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
        java.sql.PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
                conn = JdbcUtil.getConnection();
                String sql = "INSERT INTO user (email,firstname,password,level,lastname,address,city,state,zipcode)VALUES (?,?,?,?,?,?,?,?,?)";
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, user.getEmail());
                stmt.setString(2, user.getFirstname());
                stmt.setString(3, user.getPassword());
                stmt.setString(4, user.getLevel());
                stmt.setString(5, user.getLastname());
                stmt.setString(6, user.getAddress());
                stmt.setString(7, user.getCity());
                stmt.setString(8, user.getState());
                stmt.setString(9, user.getZipcode());
                stmt.executeUpdate();

        } catch (SQLException e) {
               throw new RuntimeException();
        }finally{
                JdbcUtil.release(conn, stmt, rs);
        }               
    }

    public User findUserbyEmail(String email) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        User user = null;
        try {
                conn = JdbcUtil.getConnection();
                stmt = conn.createStatement();
                
                String sql = "select * from user where email='"+email+"'";
                stmt.execute(sql);
                rs = stmt.executeQuery(sql);
               
                //遍历rs
                if(rs.next()){
                    user=new User();
                    user.setAddress(rs.getString("address"));
                    user.setCity(rs.getString("city"));
                    user.setEmail(rs.getString("email"));
                    user.setFirstname( rs.getString("firstname"));
                    user.setLastname(rs.getString("lastname"));
                    user.setLevel(rs.getString("level"));
                    user.setPassword(rs.getString("password"));
                    user.setState(rs.getString("state"));
                    user.setZipcode(rs.getString("zipcode"));
                }
                
        } catch (SQLException e) {
                e.printStackTrace();
                return null;
        }finally{
                JdbcUtil.release(conn, stmt, rs);
        }
        return user;
    }
}
