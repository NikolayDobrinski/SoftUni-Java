package softuni.fundamentals.finalexamprep;
import java.util.Scanner;

/**Description:
 * On the first line you will be given a string containing all of your stops. Until you receive the command "Travel",
 * you will be given some commands to manipulate that initial string. The commands can be:
 * Add Stop:{index}:{string} – insert the given string at that index only if the index is valid
 * Remove Stop:{start_index}:{end_index} – remove the elements of the string from the starting index to the end index (inclusive) if both indices are valid
 * Switch:{old_string}:{new_string} – if the old string is in the initial string, replace it with the new one. (all occurrences)
 */

public class WorldTour {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        StringBuilder allStops = new StringBuilder(scan.nextLine());
        String command = scan.nextLine();

        while (!command.equals("Travel")) {
            String[] commandParts = command.split(":");
            String currentCommand = commandParts[0];

            switch (currentCommand) {
                case "Add Stop":
                    int insertIndex = Integer.parseInt(commandParts[1]);
                    String insertString = commandParts[2];
                    if (isValidIndex(allStops, insertIndex)) {
                        allStops.insert(insertIndex, insertString);
                    }
                    break;
                case "Remove Stop":
                    int startIndex = Integer.parseInt(commandParts[1]);
                    int endIndex = Integer.parseInt(commandParts[2]);
                    if (isValidIndex(allStops, startIndex) && isValidIndex(allStops, endIndex)) {
                        allStops.replace(startIndex, endIndex + 1, "");
                    }
                    break;
                case "Switch":
                    String oldString = commandParts[1];
                    String newString = commandParts[2];
                    allStops = new StringBuilder(allStops.toString().replaceAll(oldString, newString));
                    break;
            }
            System.out.println(allStops);
            command = scan.nextLine();
        }
        System.out.println("Ready for world tour! Planned stops: " + allStops);

    }

    static boolean isValidIndex(StringBuilder s, int index) {
        return index >= 0 && index < s.length();
    }
}
