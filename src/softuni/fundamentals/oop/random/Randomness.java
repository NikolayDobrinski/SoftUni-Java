package softuni.fundamentals.oop.random;

import java.util.Random;

public class Randomness {
    public static void main(String[] args) {
        Random random = new Random();
        ExtraRandom extraRandom = new ExtraRandom();

        System.out.println(random.nextInt());
        System.out.println(random.nextBoolean());
        System.out.println(random.nextDouble());

        System.out.println(extraRandom.nextLetter());

    }
}
