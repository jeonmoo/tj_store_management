package setting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	//db접속메서드
	public static Connection getConn() {

		String url = "jdbc:mysql://localhost:3306/store?characterEncoding=utf-8&serverTimezone=Asia/Seoul";// url셋팅
		String id = "root";// mysql접속 ID
		String password = "mysql";// 비밀번호
		Connection con = null;// db연결
		try {
			// db접속위해 드라이버 클래스 로드
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 로드 성공");
			con = DriverManager.getConnection(url, id, password);
			System.out.println("데이터베이스 연결 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버를 찾을 수 없습니다.");
		} catch (SQLException e) {
			System.out.println("연결에 실패하였습니다.");
		}
		return con;
	}

}
