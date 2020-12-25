package softuni.fundamentals.oop.duck;

public class Pond {
    public static void main(String[] args) {

        Duck mobyDuck = new Duck("Moby", 90/3, "grass");
        Duck woodDuck = new Duck("Wood", 95/3, "seeds");

        mobyDuck.Waddle();
        System.out.println(woodDuck);

    }
}
