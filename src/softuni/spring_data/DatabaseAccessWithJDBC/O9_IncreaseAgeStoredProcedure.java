package softuni.spring_data.DatabaseAccessWithJDBC;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class O9_IncreaseAgeStoredProcedure {
    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:h2:~/minions_db", "sa", "");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter minion ID: ");
        int minionId = Integer.parseInt(scanner.nextLine());

        CallableStatement callableStatement = connection
                .prepareCall("CALL usp_get_older(?)");

        callableStatement.setInt(1, minionId);

        callableStatement.executeUpdate();
    }
}
