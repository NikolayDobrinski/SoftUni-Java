package softuni.spring_data.DatabaseAccessWithJDBC;

import java.sql.*;
import java.util.Scanner;

public class O4_AddMinion {

    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:h2:~/minions_db", "sa", "");

        // reading the input

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter input: ");
        String inputMinion = scanner.nextLine();
        String inputVillian = scanner.nextLine();

        //split the input and extract information needed

        String[] villainInfo = inputVillian.split(": ");
        String villainName = villainInfo[1];

        //checking all villains names existing into the database

        PreparedStatement preparedStatementVillain = connection
                .prepareStatement("SELECT name FROM villains");

        ResultSet findVillain = preparedStatementVillain.executeQuery();

        boolean isFound = false;

        while (findVillain.next()) {
            String name = findVillain.getString("name");
            if (name.equals(villainName)) {
                isFound = true;
                break;
            }
        }
        // if villain with such name does not exists, I am creating new one

        if (!isFound) {

            PreparedStatement preparedStatementAddNewVillain = connection
                    .prepareStatement("INSERT INTO villains (name, evilness_factor) VALUES (?, ?)");
            preparedStatementAddNewVillain.setString(1, villainName);
            preparedStatementAddNewVillain.setString(2, "evil");

            preparedStatementAddNewVillain.executeUpdate();

            System.out.printf("Villain %s was added to the database.%n", villainName);
        }

        // split the input information about minion

        String[] splitMinionInfo = inputMinion.split(": ");
        String[] minionInfo = splitMinionInfo[1].split(" ");
        String name = minionInfo[0];
        int age = Integer.parseInt(minionInfo[1]);
        String town = minionInfo[2];

        // checking all town names existing into database

        PreparedStatement getTown = connection.prepareStatement("SELECT name FROM towns");

        ResultSet findTown = getTown.executeQuery();
        boolean townFound = false;

        while (findTown.next()) {
            String townName = findTown.getString("name");
            if (townName.equals(town)) {
                townFound = true;
                break;
            }
        }

        // if such town does not exists, I am creating new one

        if (!townFound) {
            PreparedStatement createNewTown = connection
                    .prepareStatement("INSERT INTO towns (name) VALUES (?)");
            createNewTown.setString(1, town);

            createNewTown.executeUpdate();

            System.out.printf("Town %s was added to the database.%n", town);
        }

        // I need to get the town Id, because i have to put the town_id when creating new minion

        PreparedStatement getNewTownId = connection
                .prepareStatement("SELECT * FROM towns WHERE name = ?");
        getNewTownId.setString(1, town);

        ResultSet resultSetTownId = getNewTownId.executeQuery();

        int newTownId = 0;

        while (resultSetTownId.next()) {
            String townName = resultSetTownId.getString("name");
            if (townName.equals(town)) {
                newTownId = resultSetTownId.getInt("id");
            }
        }

        // checking for the minion

        PreparedStatement preparedStatement = connection
                .prepareStatement("SELECT * FROM minions");

        ResultSet resultSet = preparedStatement.executeQuery();

        boolean minionFound = false;
        while (resultSet.next()) {
            String minionName = resultSet.getString("name");
            if (minionName.equals(name)) {
                minionFound = true;
                break;
            }
        }

        // if minion with such name does not exists into database, I create new one

        if (!minionFound) {
            PreparedStatement addNewMinion = connection
                    .prepareStatement("INSERT INTO minions (name, age, town_id) VALUES (?, ?, ?)");
            addNewMinion.setString(1, name);
            addNewMinion.setInt(2, age);
            addNewMinion.setInt(3, newTownId);

            addNewMinion.executeUpdate();

            System.out.printf("Successfully added %s to be minion of %s.%n", name, villainName);
        }
    }
}
