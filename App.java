import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class App {
    // JDBC URL, username, and password of MySQL server
    private static final String JDBC_URL = "jdbc:mysql://localhost/ram123";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Kanpur@123";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultset= null;
        try {
            // Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection
            System.out.println("Connecting to database...");
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

            // Execute a query to create database
            System.out.println("Creating database...");
            statement = connection.createStatement();
            String sql = "select*from stu";
            resultset=statement.executeQuery(sql);
    while(resultset.next())
    {
        int std_id = resultset.getInt("std_id");
        String name=resultset.getString("name");
        String Address=resultset.getString("Address");
        String Roll_no=resultset.getString("Roll_no");

        System.out.println("id:"+1);
        System.out.println("Fname:"+name);
        System.out.println("Address:"+Address);
        System.out.println("Roll_no"+1234);
    }
    resultset.close();
        } catch (Exception e) {
            // Handle any errors
            e.printStackTrace();
        } finally {
            // Finally block to close resources
            try {
                if (statement != null) statement.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                if (connection != null) connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
