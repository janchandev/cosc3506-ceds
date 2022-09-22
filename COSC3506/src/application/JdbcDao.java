package application;

import java.sql.*;

public class JdbcDao {
	
	// Replace below database url, username and password with your actual database credentials
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/cemsdb?useSSL=false";
	private static final String DATABASE_USERNAME = "cems";
	private static final String DATABASE_PASSWORD = "cemspassword";
	private static final String INSERT_QUERY = "INSERT INTO registration" +
            " (full_name, email_id, password,student_id) VALUES (?, ?, ?,?)";
    private  static final String CHECK_USER_EMAIL_PASSWORD = "select * from registration where " +
            "email_id=? and password=?";

    private  static final String CREATE_CLUB = "INSERT INTO `viewclubs` " +
            "(`ClubName`, `ClubDescription`, `ContactEmail`, `LeaveClub`)" +
            " VALUES ( ?, ?, ?, ?);";
	
	
	public void insertRecord(String fullName, String emailId, String password, String studentId) throws SQLException {
		
		// load and register JDBC driver for MySQL
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
        // Step 1: Establishing a Connection and 
		// try-with-resource statement will auto close the connection.
        try (Connection connection = DriverManager
            .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY)) {
            preparedStatement.setString(1, fullName);
            preparedStatement.setString(2, emailId);
            preparedStatement.setString(3, password);
            preparedStatement.setString(4, studentId);

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // print SQL exception information
            printSQLException(e);
        }
    }

	public static void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

    public boolean checkLogin(String emailId, String password) {

        // load and register JDBC driver for MySQL
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        // Step 1: Establishing a Connection and
        // try-with-resource statement will auto close the connection.
        try (Connection connection = DriverManager
                .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

             PreparedStatement preparedStatement = connection.prepareStatement(CHECK_USER_EMAIL_PASSWORD)) {

            preparedStatement.setString(1, emailId);
            preparedStatement.setString(2, password);

            System.out.println(preparedStatement);


            ResultSet result = preparedStatement.executeQuery();
            if(result.next()){
                System.out.println("Login...");
                return true;
            }
            else {
                System.out.println("Error");
                return false;
            }



        } catch (SQLException e) {
            // print SQL exception information
            printSQLException(e);
            return  false;
        }
    }

    public void createClub(String name, String email, String description, String price) {
        // load and register JDBC driver for MySQL
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        // Step 1: Establishing a Connection and
        // try-with-resource statement will auto close the connection.
        try (Connection connection = DriverManager
                .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_CLUB)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, description);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, "no");

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // print SQL exception information
            printSQLException(e);
        }
    }
}
