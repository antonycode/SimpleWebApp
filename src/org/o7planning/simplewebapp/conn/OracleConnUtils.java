package org.o7planning.simplewebapp.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConnUtils {
	public static Connection getOracleConnection()
			throws ClassNotFoundException, SQLException {

		// Chú ý: Thay đổi các thông số kết nối cho phù hợp.
		String hostName = "localhost";
		String sid = "db11g";
		String userName = "mytest";
		String password = "12345";

		return getOracleConnection(hostName, sid, userName, password);
	}

	public static Connection getOracleConnection(String hostName, String sid,
			String userName, String password) throws ClassNotFoundException,
	SQLException {

		// Khai báo class Driver cho DB Oracle
		// Việc này cần thiết với Java 5
		// Java6 trở lên tự động tìm kiếm Driver thích hợp.
		// Nếu bạn dùng Java > 6, thì ko cần dòng này cũng được.
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// Cấu trúc URL Connection dành cho Oracle
		// Ví dụ: jdbc:oracle:thin:@localhost:1521:db11g
		String connectionURL = "jdbc:oracle:thin:@" + hostName + ":1521:" + sid;

		Connection conn = DriverManager.getConnection(connectionURL, userName,
				password);
		return conn;
	}
}
