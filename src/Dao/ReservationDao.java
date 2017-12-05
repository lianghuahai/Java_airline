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
}
