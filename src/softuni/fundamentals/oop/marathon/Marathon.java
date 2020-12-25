package softuni.fundamentals.oop.marathon;

public class Marathon {
    public static void main(String[] args) {

        Athlete mike = new Athlete("Mike", 10, "Moscow");
        Athlete betsy = new Athlete("Betsy", 12, "New York");

        mike.setMarathonLocation("Boston");
        betsy.setMarathonLocation("London");

        System.out.println(mike);
        System.out.println(betsy);

    }
}
