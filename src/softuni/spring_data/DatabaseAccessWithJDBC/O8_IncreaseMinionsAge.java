package softuni.spring_data.DatabaseAccessWithJDBC;

import java.sql.*;
import java.util.Scanner;

public class O8_IncreaseMinionsAge {
    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:h2:~/minions_db", "sa", "");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter minions ID's: ");
        String allId = scanner.nextLine();

        String[] idSplited = allId.split(" ");

        for (int i = 0; i < idSplited.length; i++) {
            int currentId = Integer.parseInt(idSplited[i]);

            PreparedStatement updateAge = connection
                    .prepareStatement("UPDATE minions " +
                            "SET age = age + 1 " +
                            "WHERE id = ?");

            updateAge.setInt(1, currentId);
            updateAge.executeUpdate();

            PreparedStatement updateName = connection
                    .prepareStatement("UPDATE minions " +
                            "SET name = LOWER(name) " +
                            "WHERE id = ?");

            updateName.setInt(1, currentId);
            updateName.executeUpdate();
        }

        PreparedStatement printAll = connection
                .prepareStatement("SELECT * FROM minions");
        ResultSet resultSet = printAll.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");

            System.out.printf("%d %s %d%n", id, name, age);
        }
    }
}
