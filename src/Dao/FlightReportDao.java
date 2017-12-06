package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Bean.ComprehensiveFlightInfo;
import Utils.JdbcUtil;

public class FlightReportDao {
	public List<ComprehensiveFlightInfo> getAllFlightInfo(){
		List <ComprehensiveFlightInfo> existFlightList = new ArrayList<ComprehensiveFlightInfo>();
        Connection conn = null;
        java.sql.PreparedStatement stmt = null;               
        ResultSet rs = null;
        try {
            conn = JdbcUtil.getConnection();
            String sql = "SELECT F.FlightNo, F.NoOfSeats, F.DaysOperating, F.MinLengthOfStay, F.MaxLengthOfStay, L.LegNo, L.ArrTime, L.DepTime ,AL.Name, AP.Name AS DepartAP, AP2.Name AS ArriveAP FROM flight F, leg L, airline AL, airport AP, airport AP2 WHERE F.FlightNo = L.FlightNo AND F.AirlineID = L.AirlineID AND AL.Id = F.AirlineID AND L.DepAirportID = AP.Id AND L.ArrAirportID = AP2.Id;";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            //set up existFlight
            while (rs.next()) {
                
            	ComprehensiveFlightInfo f = new ComprehensiveFlightInfo();
                f.setAirlineName(rs.getString("Name"));
                f.setFlightNo(rs.getInt("FlightNo"));
                f.setNoOfSeats(rs.getInt("NoOfSeats"));
                f.setDaysOperating(rs.getString("DaysOperating"));
                f.setMinLengthOfStay(rs.getInt("MinLengthOfStay"));
                f.setMaxLengthOfStay(rs.getInt("MaxLengthOfStay"));
                f.setLegNo(rs.getInt("LegNo"));
                f.setArriveTime(rs.getTimestamp("ArrTime").toString());
                f.setDepartTime(rs.getTimestamp("DepTime").toString());
                f.setArriveAirport(rs.getString("ArriveAP"));
                f.setDepartAirport(rs.getString("DepartAP"));
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
	
	public List<ComprehensiveFlightInfo> getMostActiveFlights(){
		List <ComprehensiveFlightInfo> existFlightList = new ArrayList<ComprehensiveFlightInfo>();
        Connection conn = null;
        java.sql.PreparedStatement stmt = null;               
        ResultSet rs = null;
        try {
            conn = JdbcUtil.getConnection();
            String sql = "SELECT A.Name, F.* FROM flight F, airline A WHERE A.id = f.AirlineID ORDER BY LENGTH(f.DaysOperating)-LENGTH(REPLACE(f.DaysOperating,'1','')) DESC";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            //set up existFlight
            while (rs.next()) {
                
            	ComprehensiveFlightInfo f = new ComprehensiveFlightInfo();
                f.setAirlineName(rs.getString("Name"));
                f.setFlightNo(rs.getInt("FlightNo"));
                f.setNoOfSeats(rs.getInt("NoOfSeats"));
                f.setDaysOperating(rs.getString("DaysOperating"));
                f.setMinLengthOfStay(rs.getInt("MinLengthOfStay"));
                f.setMaxLengthOfStay(rs.getInt("MaxLengthOfStay"));
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
	
	public List<ComprehensiveFlightInfo> getAllFlightsOfAirport(String airportName){
		List <ComprehensiveFlightInfo> existFlightList = new ArrayList<ComprehensiveFlightInfo>();
        Connection conn = null;
        java.sql.PreparedStatement stmt = null;               
        ResultSet rs = null;
        try {
            conn = JdbcUtil.getConnection();
            String sql = "SELECT AL.Name, F.FlightNo, F.NoOfSeats, F.DaysOperating, F.MinLengthOfStay, F.MaxLengthOfStay, L.LegNo, L.ArrTime, L.DepTime, AP.Name AS DepartAP, AP2.Name AS ArriveAP FROM flight F, leg L, airline AL, airport AP, airport AP2 WHERE F.FlightNo = L.FlightNo AND F.AirlineID = L.AirlineID AND AL.Id = F.AirlineID AND L.DepAirportID = AP.Id AND L.ArrAirportID = AP2.Id AND AP.Name=?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, airportName);
            rs = stmt.executeQuery();
            
            //set up existFlight
            while (rs.next()) {
                
            	ComprehensiveFlightInfo f = new ComprehensiveFlightInfo();
                f.setAirlineName(rs.getString("Name"));
                f.setFlightNo(rs.getInt("FlightNo"));
                f.setNoOfSeats(rs.getInt("NoOfSeats"));
                f.setDaysOperating(rs.getString("DaysOperating"));
                f.setMinLengthOfStay(rs.getInt("MinLengthOfStay"));
                f.setMaxLengthOfStay(rs.getInt("MaxLengthOfStay"));
                f.setLegNo(rs.getInt("LegNo"));
                f.setArriveTime(rs.getTimestamp("ArrTime").toString());
                f.setDepartTime(rs.getTimestamp("DepTime").toString());
                f.setArriveAirport(rs.getString("ArriveAP"));
                f.setDepartAirport(rs.getString("DepartAP"));
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
