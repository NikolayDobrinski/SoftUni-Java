package softuni.fundamentals.oop.duck;

public class Duck {

    private String name;
    private int lifeExpectancy;
    private String favoriteFood;

    public Duck (String name, int lifeExpectancy, String favoriteFood) {
        super();
        this.name = name;
        this.lifeExpectancy = lifeExpectancy;
        this.favoriteFood = favoriteFood;
    }

    void Waddle () {
        System.out.println( this.name + " is waddling");
    }
    void Quack () {
        System.out.println("quack quack");
    }

    @Override
    public String toString() {
        return "My name is " + name + " I like to eat " + favoriteFood + " life expectancy: " + lifeExpectancy;
    }

}
