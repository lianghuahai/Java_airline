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
			
			String sql = "select * from person";
			//select *from user where username='zhangsan' and password = '123456'
			stmt.execute(sql);
			rs = stmt.executeQuery(sql);
			

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
                        
                        String sql = "select * from person";
                        //select *from user where username='zhangsan' and password = '123456'
                        stmt.execute(sql);
                        rs = stmt.executeQuery(sql);
                        

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
                String sql = "SELECT MAX(id) AS maxId FROM person";
                stmt = conn.prepareStatement(sql);
                rs = stmt.executeQuery();
                int previousMaxId=0;
                if(rs.next()){
                     previousMaxId = rs.getInt(1);
                }
                sql = "INSERT INTO person (email,firstname,password,level,lastname,address,city,state,zipcode, id)VALUES (?,?,?,?,?,?,?,?,?,?)";
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
                stmt.setInt(10, previousMaxId+1);;
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
                
                String sql = "select * from person where email='"+email+"'";
                stmt.execute(sql);
                rs = stmt.executeQuery(sql);
               

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
    
    public void addEmployee(User user){
    	Connection conn = null;
        java.sql.PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
                conn = JdbcUtil.getConnection();
                String sql = "SELECT MAX(id) AS maxId FROM person";
                stmt = conn.prepareStatement(sql);
                rs = stmt.executeQuery();
                int previousMaxId=0;
                if(rs.next()){
                     previousMaxId = rs.getInt(1);
                }
                sql = "INSERT INTO person (email,firstname,password,level,lastname,address,city,state,zipcode, id)VALUES (?,?,?,?,?,?,?,?,?,?)";
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
                stmt.setInt(10, previousMaxId+1);;
                stmt.executeUpdate();
                System.out.println("11111111111111111");
                System.out.println(user);
                sql = "INSERT INTO employee (Id,SSN,IsManager,StartDate,HourlyRate)VALUES(?,?,?,?,?)";
                stmt = conn.prepareStatement(sql);
                stmt.setInt(1, previousMaxId+1);
                stmt.setInt(2, user.getSSN());
                stmt.setInt(3, user.getIsManager());
                stmt.setString(4, user.getStartDate());
                stmt.setDouble(5, user.getHourlyRate());
                stmt.executeUpdate();
                System.out.println("1");
        } catch (SQLException e) {
               throw new RuntimeException();
        }finally{
                JdbcUtil.release(conn, stmt, rs);
        }               
    }
    
    public User getEmployeeBySSN(int SSN){
    	Connection conn = null;
        java.sql.PreparedStatement stmt = null;
        ResultSet rs = null;
        User user = null;
        try {
                conn = JdbcUtil.getConnection();
                String sql = "SELECT * FROM employee WHERE SSN=?";
                stmt = conn.prepareStatement(sql);
                stmt.setInt(1, SSN);
                rs = stmt.executeQuery();
                if(rs.next()){
                     user = new User();
                     user.setSSN(rs.getInt("SSN"));
                     user.setIsManager(rs.getInt("IsManager"));
                     user.setHourlyRate(rs.getDouble("HourlyRate"));  
                }
        } catch (SQLException e) {
               throw new RuntimeException();
        }finally{
                JdbcUtil.release(conn, stmt, rs);
        }             
        return user;
    }
    
    public void updateEmployeeInfo(User user){
    	Connection conn = null;
        java.sql.PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
                conn = JdbcUtil.getConnection();
                String sql = "UPDATE employee SET HourlyRate = ?, IsManager = ? WHERE SSN = ?";
                stmt = conn.prepareStatement(sql);
                stmt.setDouble(1, user.getHourlyRate());
                stmt.setInt(2, user.getIsManager());
                stmt.executeUpdate();

        } catch (SQLException e) {
               throw new RuntimeException();
        }finally{
                JdbcUtil.release(conn, stmt, rs);
        }             
    }
    
    public void deleteEmployee(int SSN){
    	Connection conn = null;
        java.sql.PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
                conn = JdbcUtil.getConnection();
                String sql = "SELECT id FROM employee WHERE SSN=?";
                stmt = conn.prepareStatement(sql);
                stmt.setInt(1, SSN);
                rs = stmt.executeQuery();
                int id = rs.getInt("id");
                
                
                sql = "DELETE FROM employee WHERE SSN = ?;";
                stmt = conn.prepareStatement(sql);
                stmt.setDouble(1, SSN);
                stmt.executeUpdate();
                
                sql = "DELETE FROM person WHERE id = ?;";
                stmt = conn.prepareStatement(sql);
                stmt.setDouble(1, id);
                stmt.executeUpdate();

        } catch (SQLException e) {
               throw new RuntimeException();
        }finally{
                JdbcUtil.release(conn, stmt, rs);
        }             
    }
}
