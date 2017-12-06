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
                return reservations;
        }             
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
                return reservations;
        }      
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
                return reservations;
        }      
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
                return reservations;
        }      
	}
	
}
