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
        try {
            conn = JdbcUtil.getConnection();
            String sql = "SELECT *,al.name AS airlinename FROM leg L, airport A, airport B,airline al WHERE L.DepAirportID = A.Id AND L.ArrAirportID = B.Id  AND A.City =? AND B.City =? AND al.id=L.AirlineID  AND TO_DAYS(DATE(L.DepTime))%7 = TO_DAYS(DATE(?))%7";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, flight.getDepartCity());
            stmt.setString(2, flight.getArriveCity());
            stmt.setString(3,flight.getDepartDate());
            System.out.println(flight);
            System.out.println(sql);
            rs = stmt.executeQuery();
            
            //set up existFlight
            while (rs.next()) {
                System.out.println(rs.getString("Name"));
                FlightInformaiton f = new FlightInformaiton();
                f.getAirline().add(rs.getString("airlineName"));
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

    public List <FlightInformaiton> findOnewayFightOneStop(Flight flight) {
        List <FlightInformaiton> existFlightList = new ArrayList<FlightInformaiton>();
        Connection conn = null;
        java.sql.PreparedStatement stmt = null;               
        ResultSet rs = null;
        try {
            conn = JdbcUtil.getConnection();
            String sql = "SELECT L.DepTime AS DepartTime1, L.ArrTime AS ArriveTime1, L2.DepTime AS DepartTime2, L.ArrTime AS ArriveTime2, A.Name AS Name1, B.Name AS Name2, C.Name AS Name3,al1.name AS airlinename1, al2.name AS airlinename2 FROM leg L, Leg L2, airport A, airport B, airport C, airline al1, airline al2 WHERE L.DepAirportID = A.id AND L2.ArrAirportID = B.id AND  A.city = ? AND  B.city = ? AND al1.id=L.AirlineID AND al2.id=L2.AirlineID AND L.ArrAirportID = L2.DepAirportID AND C.id = L.ArrAirportID AND TO_DAYS(DATE(L.DepTime))%7 = TO_DAYS(DATE(?))%7 AND L.ArrTime < L2.DepTime";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, flight.getDepartCity());
            stmt.setString(2, flight.getArriveCity());
            stmt.setString(3, "2011-01-06");
//            System.out.println(flight);
            rs = stmt.executeQuery();
            //set up existFlight
            while (rs.next()) {
                FlightInformaiton f = new FlightInformaiton();
                f.getAirline().add(rs.getString("airlineName1"));
                f.getAirline().add(rs.getString("airlineName2"));
                f.setDepartTime(rs.getString("departtime1"));
                f.setReturnTime(rs.getString("ArriveTime1"));
                f.getTransferAirport().add(rs.getString("Name2"));
                f.setDepartAirport(rs.getString("Name1"));
                f.setArriveAirport(rs.getString("Name3"));
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
