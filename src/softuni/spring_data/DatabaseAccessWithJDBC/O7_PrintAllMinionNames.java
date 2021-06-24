package softuni.spring_data.DatabaseAccessWithJDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class O7_PrintAllMinionNames {
    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:h2:~/minions_db", "sa", "");

        PreparedStatement preparedStatement = connection
                .prepareStatement("SELECT name FROM minions");

        ResultSet resultSet = preparedStatement.executeQuery();

        List<String> allMinions = new ArrayList<>();

        while (resultSet.next()) {
            String name = resultSet.getString(1);
            allMinions.add(name);
        }
        int start = 0;
        int end = allMinions.size() - 1;

        for (int i = 0; i < allMinions.size(); i++) {
            System.out.println(i % 2 == 0
                    ? allMinions.get(start++)
                    : allMinions.get(end--)
            );
        }
    }
}
