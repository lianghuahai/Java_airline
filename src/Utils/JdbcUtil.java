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
		
		Properties prop = new Properties();
		
		//通过类加载器的方式获得文件的输入流
		// "/" 表示的是 class目录。---绝对路径
		// 如果没有斜杠，表示的当前文件同一个目录。
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * 获得数据库的连接 注:该方法已经自己加载驱动
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		
		return DriverManager.getConnection(url, username,
				password);
	}

	
	/**
	 * 资源的释放
	 * @param conn  连接资源
	 * @param stmt  statment对象
	 * @param rs    结果集
	 */
	public static void release(Connection conn, Statement stmt, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rs = null;
		}

		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			stmt = null;
		}

		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn = null;
		}
	}

}
