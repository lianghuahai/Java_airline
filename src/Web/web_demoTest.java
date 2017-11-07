package Web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import com.mysql.jdbc.Driver;

public class web_demoTest {
	@Test
	public void demo() throws SQLException{
				//注册驱动-----注册mysql的驱动
				DriverManager.registerDriver(new Driver());
				//数据库的所在位置
				String url = "jdbc:mysql://localhost:3306/airlinedb";
				//登录数据库的用户名
				String user = "root";
				//用户名对应的密码
				String password = "huahai03";
				//获得连接
				Connection conn = DriverManager.getConnection(url, user, password);
				//创建用于向数据库发送sql的statment对象
				Statement stmt = conn.createStatement();
				//注意：这里的sql不要有分号
				String sql = "select * from airline";
				
				//执行sql并且返回结果集
				ResultSet rs = stmt.executeQuery(sql);
				
				//遍历结果集
				while(rs.next()){
					System.out.println(rs.getString("Name"));
				}
				
				
				//关闭资源 ----关闭的顺序，后打开先关闭。
				rs.close();
				stmt.close();
				conn.close();
	}
}
