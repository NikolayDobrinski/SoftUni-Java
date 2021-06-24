package softuni.spring_data.DatabaseAccessWithJDBC;

import java.sql.*;
import java.util.Scanner;

public class O4_AddMinion {

    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:h2:~/minions_db", "sa", "");

        // четем двата реда вход

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter input: ");
        String inputMinion = scanner.nextLine();
        String inputVillian = scanner.nextLine();

        //Сплитвам редовете за да взема нужната информация и да проверя в базите

        String[] villainInfo = inputVillian.split(": ");
        String villainName = villainInfo[1];

        //проверявам дали има наличен такъв Villain

        PreparedStatement preparedStatementVillain = connection
                .prepareStatement("SELECT id FROM villains WHERE name = ?");
        preparedStatementVillain.setString(1, villainName);

        ResultSet resultSetVillain = preparedStatementVillain.executeQuery();

        int getVillainId = 0;

        //проверявам дали е върнало, че има такъв Villain, като ако getVillainId = 0, значи няма такъв

        if (resultSetVillain.next()) {
            getVillainId = resultSetVillain.getInt("id");
        }

        // ако няма намерен, създаваме нов Villain

        if (getVillainId == 0) {
            PreparedStatement preparedStatementAddNewVillain = connection
                    .prepareStatement("INSERT INTO villains (name, evilness_factor) VALUES (?, ?)");
            preparedStatementAddNewVillain.setString(1, villainName);
            preparedStatementAddNewVillain.setString(2, "evil");

            preparedStatementAddNewVillain.executeUpdate();

            System.out.printf("Villain %s was added to the database.%n", villainName);
        }

        // Сплитваме входната информация за миниона

        String[] splitMinionInfo = inputMinion.split(": ");
        String[] minionInfo = splitMinionInfo[1].split(" ");
        String name = minionInfo[0];
        int age = Integer.parseInt(minionInfo[1]);
        String town = minionInfo[2];

        //проверявам в базата дали има такъв град

        PreparedStatement getTownId = connection.prepareStatement("SELECT id FROM towns WHERE name = ?");
        getTownId.setString(1, town);

        ResultSet resultSetTownId = getTownId.executeQuery();
        int id = 0;

        if (resultSetTownId.next()) {
            id = resultSetTownId.getInt("id");
        }

        int newId = 0;

        //ако няма такъв град, създаваме нов град

        if (id == 0) {
            PreparedStatement createNewTown = connection
                    .prepareStatement("INSERT INTO towns (name) VALUES (?)");
            createNewTown.setString(1, town);

            createNewTown.executeUpdate();

            System.out.printf("Town %s was added to the database.%n", town);

            //взимаме ID-то на новия град за да го въведем като правим новия минион

            PreparedStatement getNewTownId = connection.prepareStatement("SELECT id FROM town WHERE name = ?");
            getNewTownId.setString(1, town);

            ResultSet resultSetNewTownId = getNewTownId.executeQuery();

            if (resultSetNewTownId.next()) {
                newId = resultSetNewTownId.getInt("id");
            }
        }

        //провярявам дали има такъв минион в базата

        PreparedStatement preparedStatement = connection
                .prepareStatement("SELECT * FROM minions WHERE name = ?");
        preparedStatement.setString(1, name);

        ResultSet resultSet = preparedStatement.executeQuery();

        //ако няма и е върнало null, създавам нов минион

        if (resultSet == null) {
            PreparedStatement addNewMinion = connection
                    .prepareStatement("INSERT INTO minions (name, age, town_id) VALUES (?, ?, ?)");
            addNewMinion.setString(1, name);
            addNewMinion.setInt(2, age);
            addNewMinion.setInt(3, newId);

            addNewMinion.executeUpdate();

            System.out.printf("Successfully added %s to be minion of %s.%n", name, villainName);
        }
    }
}
