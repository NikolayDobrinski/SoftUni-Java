package softuni.spring_data.DatabaseAccessWithJDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class O5_ChangeTownNamesCasing {
    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:h2:~/minions_db", "sa", "");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter country name: ");
        String countryName = scanner.nextLine();

        PreparedStatement preparedStatement = connection
                .prepareStatement("UPDATE towns" +
                        " SET name = UPPER(name)" +
                        " WHERE country = ?");
        preparedStatement.setString(1, countryName);

        int affectedRows = preparedStatement.executeUpdate();

        if (affectedRows == 0) {
            System.out.println("No town names");
            return;
        }

        System.out.printf("%d town names were affected.%n", affectedRows);
        PreparedStatement preparedStatementTowns = connection
                .prepareStatement("SELECT name FROM towns WHERE country = ?");
        preparedStatementTowns.setString(1, countryName);
        ResultSet resultSet = preparedStatementTowns.executeQuery();

        List<String> names = new ArrayList<>();

        while (resultSet.next()) {
            String name = resultSet.getString("name");
            names.add(name);
        }
        System.out.print("[");
        System.out.print(String.join(", ", names));
        System.out.print("]");
    }
}
