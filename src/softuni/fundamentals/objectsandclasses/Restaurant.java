package softuni.fundamentals.objectsandclasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Restaurant {

    static class Reservation {
        String holderName;
        int phone;
        int seats;

        public Reservation(String holderName, int phone, int seats) {
            this.holderName = holderName;
            this.phone = phone;
            this.seats = seats;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int counterReservations = 1;

        List<Reservation> reservations = new ArrayList<>();

        System.out.println("                       *** RESERVATION SYSTEM ***");
        System.out.print("Enter new reservation or search for existing ones by typing 'new' or 'search': ");
        String action = scan.nextLine();

        if (!action.equals("search")) {

            System.out.printf("Reservation %d - Holder name: ", counterReservations);
            String input = scan.nextLine();

            while (!input.equals("search")) {
                String currentName = "";
                if (counterReservations == 1) {
                    String name = input;
                    currentName = name;
                } else if (counterReservations > 1) {

                    System.out.printf("Reservation %d - Holder name: ", counterReservations);
                    String name = scan.nextLine();
                    if (name.equals("search")) {
                        break;
                    }
                    currentName = name;
                }

                System.out.printf("Reservation %d - Phone number: ", counterReservations);
                int phone = scan.nextInt();
                System.out.printf("Reservation %d - Number of seats: ", counterReservations);
                int seats = scan.nextInt();

                Reservation r = new Reservation(currentName, phone, seats);

                reservations.add(r);

                System.out.printf("Reservation %d - Confirmed!%n", counterReservations);
                System.out.println("---------------------------------------------------");
                System.out.println("Please, enter new reservation or search for existing ones by typing 'search'!");

                counterReservations++;

                input = scan.nextLine();
            }
        }
        System.out.println("---------------------------------------------------------------");
        System.out.print("Please, enter search criteria - by guestName / by phoneNumber: ");
        String searchBy = scan.nextLine();
        int index = -1;

        switch (searchBy) {
            case "guestName":
                System.out.print("Please enter Guest's name here: ");
                String guestName = scan.nextLine();
                for (int i = 0; i < reservations.size(); i++) {
                    Reservation reservation = reservations.get(i);
                    if (guestName.equals(reservation.holderName)) {
                        index = i;
                    }
                }
                if (index != -1) {
                    Reservation reservation = reservations.get(index);
                    int seatsReserved = reservation.seats;
                    System.out.printf("Welcome, %s! Your reservation for %d people is waiting for you!",
                            reservation.holderName, seatsReserved);
                } else {
                    System.out.println("Sorry, no reservation for this customer!");
                }
                break;

            case "phoneNumber":
                System.out.print("Please enter Guest's phone number here: ");
                int phoneNumber = scan.nextInt();
                for (int i = 0; i < reservations.size(); i++) {
                    Reservation reservation = reservations.get(i);
                    if (phoneNumber == (reservation.phone)) {
                        index = i;
                    }
                }
                if (index != -1) {
                    Reservation reservation = reservations.get(index);
                    int seatsReserved = reservation.seats;
                    System.out.printf("Welcome, %s! Your reservation for %d people is waiting for you!",
                            reservation.holderName, seatsReserved);
                } else {
                    System.out.println("Sorry, no reservation for this customer!");
                }
                break;
        }
    }

}

