package softuni.fundamentals.midexamprep;

import java.util.Arrays;
import java.util.Scanner;

public class TheLift {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int peopleWaiting = Integer.parseInt(scan.nextLine());

        int[] wagons = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(element -> Integer.parseInt(element)).toArray();
        int currentState = 0;

        for (int i = 0; i < wagons.length; i++) {
            currentState += wagons[i];
        }
        int capacityOfLift = (wagons.length) * 4;
        int freeSeats = capacityOfLift - currentState;

        while (peopleWaiting > 0 && freeSeats > 0) {

            for (int i = 0; i < wagons.length; i++) {
                int currentFreeSpace = 4 - wagons[i];

                if (peopleWaiting >= currentFreeSpace) {
                    int peopleOnLift = currentFreeSpace;
                    peopleWaiting -= currentFreeSpace;
                    wagons[i] += peopleOnLift;
                    freeSeats -= peopleOnLift;
                } else {
                    wagons[i] = peopleWaiting;
                    peopleWaiting = 0;
                    freeSeats -= peopleWaiting;
                }


            }
        }
        if (peopleWaiting == 0 && freeSeats > 0) {
            System.out.println("The lift has empty spots!");
            for (int wagon : wagons) {
                System.out.print(wagon + " ");
            }
        } else if (peopleWaiting > 0 && freeSeats == 0) {
            System.out.printf("There isn't enough space! %d people in a queue!%n", peopleWaiting);
            for (int wagon : wagons) {
                System.out.print(wagon + " ");
            }
        } else {
            for (int wagon : wagons) {
                System.out.print(wagon + " ");
            }


        }
    }
}

