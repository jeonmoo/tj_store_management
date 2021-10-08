package setting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConn {
	public static Connection getConn() throws ClassNotFoundException, SQLException{

		Class.forName("com.mysql.cj.jdbc.Driver");
		String user = "root";
		String password = "mysql";
		String url = "jdbc:mysql://localhost:3306/store?characterEncoding=utf-8&serverTimezone=Asia/Seoul";
		return DriverManager.getConnection(url,user,password);
		
		
	}

}
