package Utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class JdbcUtil {

	private static String driverClass;
	private static String url;
	private static String username;
	private static String password;
	
	static{
		// load data from configures
		Properties prop = new Properties();
		InputStream is = JdbcUtil.class.getResourceAsStream("/db.properties");
		
		try {
			prop.load(is);
			driverClass = prop.getProperty("driverClass");
			url = prop.getProperty("url");
			username = prop.getProperty("username");
			password = prop.getProperty("password");
			try {
				Class.forName(driverClass);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Get data connection
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		
		return DriverManager.getConnection(url, username,
				password);
	}

	/**
	 * release the source
	 * @param conn  Connection source
	 * @param stmt  statment source
	 * @param rs    resultSet source
	 */
	public static void release(Connection conn, Statement stmt, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs = null;
		}

		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			stmt = null;
		}

		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn = null;
		}
	}

}
