package softuni.fundamentals.exercise.dbvariables;

import java.util.Scanner;

public class Elevator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numberPeople = Integer.parseInt(scan.nextLine());
        int elevatorCapacity = Integer.parseInt(scan.nextLine());

        int totalCourses = (int) Math.ceil((double) numberPeople / elevatorCapacity);

        System.out.println(totalCourses);

    }
}
