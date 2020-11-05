package softuni.fundamentals.objectsandclasses;

import java.util.Random;
import java.util.Scanner;

public class AdvertisementMessage {
    static class Message {
        String[] phrases = {"Excellent product.", "Such a great product.", "I always use that product.",
                "Best product of its category.", "Exceptional product.", "I can’t live without this product."};

        String[] events = {"Now I feel good.", "I have succeeded with this product.", "Makes miracles." +
                " I am happy of the results!", "I cannot believe but now I feel awesome.", "Try it yourself," +
                " I am very satisfied.", "I feel great!"};

        String[] authors = {"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};
        String[] cities = {"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};

        public String[] getPhrases() {
            return phrases;
        }

        public String[] getEvents() {
            return events;
        }

        public String[] getAuthors() {
            return authors;
        }

        public String[] getCities() {
            return cities;
        }


        Random random = new Random();

        public String randomMessage() {

            return String.format("%s %s %s - %s", phrases[random.nextInt(phrases.length)],
                    events[random.nextInt(events.length)], authors[random.nextInt(events.length)],
                    cities[random.nextInt(cities.length)]);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        Message output = new Message();

        for (int i = 0; i < n; i++) {
            System.out.println(output.randomMessage());
        }


    }
}

