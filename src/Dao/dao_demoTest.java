package Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Bean.Flight;
import Bean.FlightInformaiton;
import Utils.JdbcUtil;


/**
 *This class  is to Junit  test for database
 * 
 * */
public class dao_demoTest {
    @Test
    public void findOnewayFight() {
          Connection conn = null;
          List <FlightInformaiton> existFlightList = new ArrayList<FlightInformaiton>();
          java.sql.PreparedStatement stmt = null;               
          ResultSet rs = null;
         Flight flight = new Flight(); 
          flight.setDepartCity("New York");
          flight.setArriveCity("Los Angeles");
          try {
                  conn = JdbcUtil.getConnection();
                  String sql = "SELECT *,al.name AS airlinename FROM leg L, airport A, airport B,airline al WHERE L.DepAirportID = A.Id AND L.ArrAirportID = B.Id AND A.City =? AND B.City =? AND al.id=L.AirlineID AND TO_DAYS(DATE(L.DepTime))%7 = TO_DAYS(DATE(?))%7";
                  stmt = conn.prepareStatement(sql);
                  stmt.setString(1, flight.getDepartCity());
                  stmt.setString(2, flight.getArriveCity());
                  stmt.setString(3, "2011-01-05");
                  System.out.println(flight);
                  System.out.println(sql);
                  rs = stmt.executeQuery();
                  
                  //set up existFlight
                  while (rs.next()) {
                      System.out.println(rs.getString("Name"));
                      FlightInformaiton f = new FlightInformaiton();
                      f.setAirline(rs.getString("airlineName"));
                      f.setDepartTime(rs.getString("DepTime"));
                      f.setReturnTime(rs.getString("ArrTime"));
                      f.setDepartAirport(rs.getString(9));
                      f.setArriveAirport(rs.getString(13));
                      f.setTicketPrice(999.0);
                      //set data to existFlightList
                      existFlightList.add(f);
                 }

          } catch (SQLException e) {
                 throw new RuntimeException();
          }finally{
                  JdbcUtil.release(conn, stmt, rs);
          } 
    }
    
    
	/**
	 * add method
	 * 
	 */
	@SuppressWarnings("null")
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
			
			String sql = "SELECT * FROM leg L, airport A, airport B WHERE L.DepAirportID = A.Id AND L.ArrAirportID = B.Id AND A.City = 'New York' AND B.City ='Los Angeles' AND TO_DAYS(DATE(L.DepTime))%7 = TO_DAYS(DATE('2011-01-05'))%7;";
			//select *from user where username='zhangsan' and password = '123456'
			stmt.execute(sql);
			rs = stmt.executeQuery(sql);
			int i=0;
			//遍历rs
			while(rs.next()){
				System.out.println(rs);
				i++;
			}
			System.out.println(i);
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
