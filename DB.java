package CRUD;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {

	static Connection conn=null;
	public static Connection connect() {
		try {
			String url ="jdbc:mysql://localhost:3306/crud";
			String userName="root";
			String password="R@hulMySQL@1410";
			
			//establish connection
			conn=DriverManager.getConnection(url,userName,password);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

}
