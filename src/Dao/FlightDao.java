package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Bean.Flight;
import Bean.FlightInformaiton;
import Utils.JdbcUtil;

public class FlightDao {

    @Test
    public List <FlightInformaiton> findOnewayFightNoStop(Flight flight) {
        List <FlightInformaiton> existFlightList = new ArrayList<FlightInformaiton>();
        Connection conn = null;
        java.sql.PreparedStatement stmt = null;               
        ResultSet rs = null;
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
                f.setTicketPrice(999.00);
                //set data to existFlightList
                existFlightList.add(f);
           }

          } catch (SQLException e) {
                 throw new RuntimeException();
          }finally{
                  JdbcUtil.release(conn, stmt, rs);
          } 
        return existFlightList;
    }

}
