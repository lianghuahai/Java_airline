package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Utils.JdbcUtil;
import Bean.Flight;

public class FlightDao {

    public List <Flight> findOnewayFight(Flight flight) {
        List <Flight> existFlightList = new ArrayList<Flight>();
          Connection conn = null;
          java.sql.PreparedStatement stmt = null;
          ResultSet rs = null;
          try {
                  conn = JdbcUtil.getConnection();
                  String sql = "INSERT INTO user (email,firstname,password,level,lastname,address,city,state,zipcode)VALUES (?,?,?,?,?,?,?,?,?)";
                  stmt = conn.prepareStatement(sql);
//                  stmt.setString(1, existFight.getEmail());
//                  stmt.setString(2, existFight.getFirstname());
//                  stmt.setString(3, existFight.getPassword());
//                  stmt.setString(4, user.getLevel());
//                  stmt.setString(5, user.getLastname());
//                  stmt.setString(6, user.getAddress());
//                  stmt.setString(7, user.getCity());
//                  stmt.setString(8, user.getState());
//                  stmt.setString(9, user.getZipcode());
                  rs = stmt.executeQuery();
                  
                  //set up existFlight
                  while (rs.next()) {
                      //set data to existFlightList
                 }

          } catch (SQLException e) {
                 throw new RuntimeException();
          }finally{
                  JdbcUtil.release(conn, stmt, rs);
          } 
        return existFlightList;
    }

}
