package org.o7planning.simplewebapp.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLServerConnUtils_SQLJDBC {
	// Kết nối vào SQLServer.
	// (Sử dụng thư viện điều khiển SQLJDBC)
	public static Connection getSQLServerConnection_SQLJDBC()
			throws ClassNotFoundException, SQLException {

		// Chú ý: Thay đổi các thông số kết nối cho phù hợp.
		String hostName = "localhost";
		String sqlInstanceName = "SQLEXPRESS";
		String database = "mytest";
		String userName = "sa";
		String password = "12345";

		return getSQLServerConnection_SQLJDBC(hostName, sqlInstanceName,
				database, userName, password);
	}



	// Trường hợp sử dụng SQLServer.
	// Và thư viện SQLJDBC.
	private static Connection getSQLServerConnection_SQLJDBC(String hostName,
			String sqlInstanceName, String database, String userName,
			String password) throws ClassNotFoundException, SQLException {
		// Khai báo class Driver cho DB SQLServer
		// Việc này cần thiết với Java 5
		// Java6 tự động tìm kiếm Driver thích hợp.
		// Nếu bạn dùng Java > 5, thì ko cần dòng này cũng được.
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

		// Cấu trúc URL Connection dành cho SQLServer
		// Ví dụ:
		// jdbc:sqlserver://ServerIp:1433/SQLEXPRESS;databaseName=simplehr
		String connectionURL = "jdbc:sqlserver://" + hostName + ":1433"
				+ ";instance=" + sqlInstanceName + ";databaseName=" + database;

		Connection conn = DriverManager.getConnection(connectionURL, userName,
				password);
		return conn;
	}

}
