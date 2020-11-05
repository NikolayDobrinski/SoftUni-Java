package softuni.fundamentals.objectsandclasses;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Articles {
    static class Articless {
        String title;
        String content;
        String author;

        public String getTitle() {
            return title;
        }

        public String getContent() {
            return content;
        }

        public String getAuthor() {
            return author;
        }

        public String toString() {
            return String.format("%s - %s: %s%n", getTitle(), getContent(), getAuthor());
        }

        public Articless(String title, String content, String author) {
            this.title = title;
            this.content = content;
            this.author = author;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Articless> list = new ArrayList<>();

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String[] command = scan.nextLine().split(", ");

            String title = command[0];
            String content = command[1];
            String author = command[2];

            Articless current = new Articless(title, content, author);

            list.add(current);

        }

        String action = scan.nextLine();

        switch (action) {
            case "title":
                list.sort(Comparator.comparing(Articless::getTitle));
                break;
            case "content":
                list.sort(Comparator.comparing(Articless::getContent));
                break;
            case "author":
                list.sort(Comparator.comparing(Articless::getAuthor));
                break;
        }

        System.out.println(list.toString().replaceAll("[\\[\\],]", ""));


    }
}
