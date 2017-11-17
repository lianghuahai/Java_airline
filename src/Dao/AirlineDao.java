package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Bean.Airline;
import Utils.JdbcUtil;

public class AirlineDao {
	
	public List<Airline> findAllAirline(){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		 List<Airline> alist = new ArrayList<Airline>();
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.createStatement();
			
			String sql = "select * from Airline";
			stmt.execute(sql);
			rs = stmt.executeQuery(sql);
			
			//遍历rs
			while(rs.next()){
				Airline a = new Airline();
				a.setName(rs.getString("Name"));
				alist.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally{
			JdbcUtil.release(conn, stmt, rs);
		}
		
		return alist;
	}
}
