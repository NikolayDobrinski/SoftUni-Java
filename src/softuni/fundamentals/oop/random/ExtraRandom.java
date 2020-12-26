package softuni.fundamentals.oop.random;

import java.util.Random;

public class ExtraRandom extends Randomness {

    public String nextLetter() {
        int letterStartsAt = 97;
        int randomInt = new Random().nextInt(26) + letterStartsAt;
        return "" + (char) randomInt;
    }
}
