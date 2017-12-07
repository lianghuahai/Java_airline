package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Bean.Reservation;
import Utils.JdbcUtil;

public class ReservationDao {
	public List<Reservation> getMonthReport(String dateFrom, String dateTo){
		Connection conn = null;
        java.sql.PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Reservation> reservations = new ArrayList<Reservation>();
        try {
                conn = JdbcUtil.getConnection();
                String sql = "SELECT * FROM reservation WHERE ResrDate > ? AND ResrDate < ?";
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, dateFrom);
                stmt.setString(2, dateTo);
                rs = stmt.executeQuery();
                
                while(rs.next()){
                	Reservation res = new Reservation();
                	res.setBookingFee(rs.getDouble("BookingFee"));
                	res.setReservationDate(rs.getTimestamp("ResrDate").toString());
                	res.setTotalFare(rs.getDouble("TotalFare"));
                	reservations.add(res);
                }

        } catch (SQLException e) {
               throw new RuntimeException();
        }finally{
                JdbcUtil.release(conn, stmt, rs);
        }   
        return reservations;
	}
	
	public List<Reservation> getReservationsByFlight(String airlineName, int flightNo){
		Connection conn = null;
        java.sql.PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Reservation> reservations = new ArrayList<Reservation>();
        try {
                conn = JdbcUtil.getConnection();
                String sql = "SELECT DISTINCT A.Name, I.FlightNo, R.ResrNo, R.ResrDate, R.BookingFee, R.TotalFare, R.AccountNo FROM Reservation R, Includes I, Airline A WHERE R.ResrNo = I.ResrNo AND I.FlightNo = ? AND I.AirlineId = A.Id AND A.Name = ?";
                stmt = conn.prepareStatement(sql);
                stmt.setInt(1, flightNo);
                stmt.setString(2, airlineName);
                rs = stmt.executeQuery();
                
                while(rs.next()){
                	Reservation res = new Reservation();
                	res.setAirlineName(airlineName);
                	res.setFlightNo(flightNo);
                	res.setReservationNo(rs.getInt("ResrNo"));
                	res.setBookingFee(rs.getDouble("BookingFee"));
                	res.setReservationDate(rs.getTimestamp("ResrDate").toString());
                	res.setTotalFare(rs.getDouble("TotalFare"));
                	res.setAccountNo(rs.getInt("AccountNo"));
                	reservations.add(res);
                }

        } catch (SQLException e) {
               throw new RuntimeException();
        }finally{
                JdbcUtil.release(conn, stmt, rs);
        }   
        return reservations;
	}
	
	public List<Reservation> getReservationsByCustomer(String firstName, String lastName){
		Connection conn = null;
        java.sql.PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Reservation> reservations = new ArrayList<Reservation>();
        try {
                conn = JdbcUtil.getConnection();
                String sql = "SELECT P.FirstName, P.LastName, R.* FROM Reservation R, Customer C, Person P WHERE R.AccountNo = C.AccountNo AND C.Id = P.Id AND P.FirstName = ? AND P.LastName = ?";
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, firstName);
                stmt.setString(2, lastName);
                rs = stmt.executeQuery();
                
                while(rs.next()){
                	Reservation res = new Reservation();
                	res.setFirstName(firstName);
                	res.setLastName(lastName);
                	res.setReservationNo(rs.getInt("ResrNo"));
                	res.setBookingFee(rs.getDouble("BookingFee"));
                	res.setReservationDate(rs.getTimestamp("ResrDate").toString());
                	res.setTotalFare(rs.getDouble("TotalFare"));
                	res.setAccountNo(rs.getInt("AccountNo"));
                	reservations.add(res);
                }

        } catch (SQLException e) {
               throw new RuntimeException();
        }finally{
                JdbcUtil.release(conn, stmt, rs);
        }   
        return reservations;
	}
	
	
	public List<Reservation> getReservationsByDestinationCity(String destinationCity){
		Connection conn = null;
        java.sql.PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Reservation> reservations = new ArrayList<Reservation>();
        try {
                conn = JdbcUtil.getConnection();
                String sql = "SELECT DISTINCT A.City AS Destination,R.ResrNo, R.BookingFee FROM Reservation R, Leg L, Airport A, Includes I WHERE L.ArrAirportID = A.Id AND L.LegNo = I.LegNo  AND I.ResrNo = R.ResrNo AND A.City = ?";
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, destinationCity);
                rs = stmt.executeQuery();
                
                while(rs.next()){
                	Reservation res = new Reservation();
                	res.setDestinationCity(destinationCity);
                	res.setReservationNo(rs.getInt("ResrNo"));
                	res.setBookingFee(rs.getDouble("BookingFee"));
                	reservations.add(res);
                }

        } catch (SQLException e) {
               throw new RuntimeException();
        }finally{
                JdbcUtil.release(conn, stmt, rs);
        }
        return reservations;
	}
	
	public List<Reservation> getTopCustomerRepresentativeOfRevenue(){
		Connection conn = null;
        java.sql.PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Reservation> reservations = new ArrayList<Reservation>();
        try {
                conn = JdbcUtil.getConnection();
                String sql = "SELECT P.Firstname, P.Lastname,SUM(R.BookingFee) AS TotalRevenue FROM Reservation R, Employee E, Person P WHERE R.RepSSN = E.SSN AND E.Id = P.Id GROUP BY R.RepSSN ORDER BY TotalRevenue DESC";
                stmt = conn.prepareStatement(sql);
                rs = stmt.executeQuery();
                
                while(rs.next()){
                	Reservation res = new Reservation();
                	res.setFirstName(rs.getString("Firstname"));
                	res.setLastName(rs.getString("Lastname"));
                	res.setBookingFee(rs.getDouble("TotalRevenue"));
                	reservations.add(res);
                }

        } catch (SQLException e) {
               throw new RuntimeException();
        }finally{
                JdbcUtil.release(conn, stmt, rs);
        }   
        return reservations;
	}
	
	public List<Reservation> getTopCustomerOfRevenue(){
		Connection conn = null;
        java.sql.PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Reservation> reservations = new ArrayList<Reservation>();
        try {
                conn = JdbcUtil.getConnection();
                String sql = "SELECT P.FirstName, P.LastName, SUM(R.BookingFee) AS TotalRevenue FROM Reservation R, customer C, Person P WHERE R.AccountNo = C.AccountNo AND P.id = C.id GROUP BY R.AccountNo ORDER BY TotalRevenue DESC";
                stmt = conn.prepareStatement(sql);
                rs = stmt.executeQuery();
                
                while(rs.next()){
                	Reservation res = new Reservation();
                	res.setFirstName(rs.getString("Firstname"));
                	res.setLastName(rs.getString("Lastname"));
                	res.setBookingFee(rs.getDouble("TotalRevenue"));
                	reservations.add(res);
                }

        } catch (SQLException e) {
               throw new RuntimeException();
        }finally{
                JdbcUtil.release(conn, stmt, rs);
        }   
        return reservations;
	}
	
	public List<Reservation> getCustomersOnGivenFlight(String airlineName, int flightNo){
		Connection conn = null;
        java.sql.PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Reservation> reservations = new ArrayList<Reservation>();
        try {
                conn = JdbcUtil.getConnection();
                String sql = "SELECT DISTINCT a.Name, i.FlightNo, p.FirstName,p.LastName FROM customer c,reservation r,includes i,person p, Airline a WHERE  i.FlightNo=? AND a.Name = ? AND a.id = i.AirlineID AND r.AccountNo=c.AccountNo AND i.ResrNo=r.ResrNo AND p.id=c.id";
                stmt = conn.prepareStatement(sql);
                stmt.setInt(1, flightNo);
                stmt.setString(2, airlineName);
                rs = stmt.executeQuery();
                
                while(rs.next()){
                	Reservation res = new Reservation();
                	res.setAirlineName(airlineName);
                	res.setFlightNo(flightNo);
                	res.setFirstName(rs.getString("Firstname"));
                	res.setLastName(rs.getString("Lastname"));
                	reservations.add(res);
                }

        } catch (SQLException e) {
               throw new RuntimeException();
        }finally{
                JdbcUtil.release(conn, stmt, rs);
        }   
        return reservations;
	}
	
	
	//3.2 Functions
	public void recordReservation(Reservation r){
		Connection conn = null;
        java.sql.PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtil.getConnection();
            String sql = "SELECT MAX(ResrNo) FROM reservation";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            int previousMax = -1;
            if(rs.next()){
            	previousMax = rs.getInt("ResrNo");
            }
            
            if(previousMax==-1){
            	return;
            }
            
            sql = "INSERT INTO reservation ( ResrNo, ResrDate, BookingFee, TotalFare, RepSSN, AccountNo) VALUES ( ?, ?, ?, ?, ?, ?);";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, previousMax+1);
            stmt.setString(2, r.getReservationDate());
            stmt.setDouble(3, r.getBookingFee());
            stmt.setDouble(4, r.getTotalFare());
            stmt.setInt(5, r.getRepSSN());
            stmt.setInt(6, r.getAccountNo());
            stmt.executeUpdate();

        } catch (SQLException e) {
           throw new RuntimeException();
        }finally{
            JdbcUtil.release(conn, stmt, rs);
        }
	}
	
	public void addFlightToReservation(Reservation r){
		Connection conn = null;
        java.sql.PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtil.getConnection();
            String sql = "INSERT INTO includes (ResrNo, AirlineID, FlightNo, LegNo, Date) VALUES(?, (SELECT A.id FROM airline A WHERE A.Name = ?), ?, ?, (SELECT L.DepTime FROM leg L, airline A WHERE L.AirlineID = A.id AND A.Name = ? AND L.FlightNo = ? AND L.LegNo = ?));";
            
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, r.getReservationNo());
            stmt.setString(2, r.getAirlineName());
            stmt.setDouble(3, r.getFlightNo());
            stmt.setDouble(4, r.getLegNo());
            stmt.setString(5, r.getAirlineName());
            stmt.setDouble(6, r.getFlightNo());
            stmt.setDouble(7, r.getLegNo());
            stmt.executeUpdate();

        } catch (SQLException e) {
           throw new RuntimeException();
        }finally{
            JdbcUtil.release(conn, stmt, rs);
        }
	}
}
