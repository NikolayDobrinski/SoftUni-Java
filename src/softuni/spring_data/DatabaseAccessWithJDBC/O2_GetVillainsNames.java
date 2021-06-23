package softuni.spring_data.DatabaseAccessWithJDBC;

import java.sql.*;

public class O2_GetVillainsNames {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Connection connection = DriverManager.getConnection("jdbc:mysql:localhost:3306/minions_db", "sa", "");

        PreparedStatement preparedStatement = connection
                .prepareStatement("SELECT v.name, COUNT(DISTINCT mv.minion_id) AS `m.count` " +
                        "FROM villains AS v JOIN minions_villains AS mv " +
                        "ON v.id = mv.villains_id" +
                        " GROUP BY v.name" +
                        " HAVING `m.count` > 15;)");

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            String name = resultSet.getString(1);
            int minions = resultSet.getInt(2);

            System.out.printf("%s %d %n", name, minions);
        }
    }
}
