package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	
	
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection connection;
		String database = "cemsdb";
		String username = "cems"; // Change it to your username
		String password = "cemspassword"; // Change it to your password
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		connection = DriverManager.getConnection("jdbc:mysql://localhost/"+database,username,password);
		
		
		return connection;
	}

}
