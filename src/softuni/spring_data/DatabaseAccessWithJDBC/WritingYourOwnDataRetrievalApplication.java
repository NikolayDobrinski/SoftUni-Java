package softuni.spring_data.DatabaseAccessWithJDBC;

import java.sql.*;
import java.util.Scanner;

public class WritingYourOwnDataRetrievalApplication {
    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/diablo", "root", "");

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter username: ");
        String username = scan.nextLine();

        PreparedStatement ps = connection.prepareStatement("SELECT user_name, first_name, last_name WHERE user_name = ?");

        ps.setString(1, username);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            String userName = rs.getString("user_name");
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");

            System.out.println("User: " + userName);
            System.out.println(firstName + " " + lastName + " has played 6 games" );
        }
        else {
            System.out.println("No such user exists");
        }
    }
}
