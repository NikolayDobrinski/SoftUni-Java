package softuni.advanced.definingclasses.BankAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**Description:
 * We need to create a class named BankAccount.
 * The class must have private fields for - Id, balance and interest rate.
 * The class must also have public methods for - setInterestRate, getInterest (years) and deposit (amount).
 * We need to create a test client that supports the following commands and prints the action until we get the End command.
 * - Creation
 * - Deposit {Id} {Amount}
 * - SetInterest
 * - GetInterest {ID} {Years}
 * End
 */

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String line = scan.nextLine();

        Map<Integer, BankAccount> vault = new HashMap<>();

        while (!line.equals("End")) {
            String[] command = line.split("\\s+");
            String action = command[0];

            String output = "";

            switch (action) {
                case "Create":
                    BankAccount bankAccount = new BankAccount();
                    vault.put(bankAccount.getId(), bankAccount);
                    output = "Account ID" + bankAccount.getId() + " created";
                    break;
                case "Deposit":
                    int id = Integer.parseInt(command[1]);
                    double amount = Double.parseDouble(command[2]);
                    if (vault.containsKey(id)) {
                        vault.get(id).deposit(amount);
                        output = String.format("Deposited %.0f to ID%d", amount, id);
                        //output = "Deposited " + amount + " to ID" + id;
                    } else {
                        output = "Account does not exist";
                    }

                    break;
                case "SetInterest":
                    double setInterest = Double.parseDouble(command[1]);
                    BankAccount.setInterestRate(setInterest);

                    break;
                case "GetInterest":
                    int idGetInterest = Integer.parseInt(command[1]);
                    int years = Integer.parseInt(command[2]);

                    if (vault.containsKey(idGetInterest)) {

                        double interest = vault.get(idGetInterest).getInterest(years);

                        output = String.format("%.2f", interest);
                    } else {
                        output = "Account does not exist";
                    }

                    break;

            }

            System.out.println(output);

            line = scan.nextLine();
        }

    }
}
