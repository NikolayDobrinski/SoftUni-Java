package softuni.spring_data.DatabaseAccessWithJDBC;

import java.sql.*;
import java.util.Scanner;

public class O3_GetMinionNames {
    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:mysql:localhost:3306/minions_db", "sa", "");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter villain id: ");
        int villainId = Integer.parseInt(scanner.nextLine());

        PreparedStatement preparedStatementVillainName = connection
                .prepareStatement("SELECT name FROM villains WHERE id = ?");

        preparedStatementVillainName.setInt(1, villainId);
        ResultSet resultSetVillainName = preparedStatementVillainName.executeQuery();

        if (resultSetVillainName.next()) {
            System.out.println("Villain: " + resultSetVillainName.getString("name"));

            PreparedStatement preparedStatement = connection
                    .prepareStatement("SELECT m.name, m.age FROM minions AS m " +
                            "JOIN minions_villains AS mv " +
                            "ON m.id = mv.minion_id " +
                            "WHERE mv.villain_id = ?");

            preparedStatement.setInt(1, villainId);

            int counter = 0;

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");

                System.out.println((String.format("%d. %s %d", ++counter, name, age)));
            }
        }
        else {
            System.out.printf("No villain with ID %d exists in the database", villainId);
        }
    }
}
