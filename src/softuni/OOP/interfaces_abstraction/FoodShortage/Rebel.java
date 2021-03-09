package softuni.OOP.interfaces_abstraction.FoodShortage;

public class Rebel implements Person, Buyer{

    private static final int INCREASE_FOOD_WITH_FIVE = 5;

    private String name;
    private int age;
    private String group;
    private int food;

    public Rebel(String name, int age, String group) {
        this.name = name;
        this.age = age;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGroup() {
        return group;
    }

    @Override
    public void buyFood() {
        this.food += INCREASE_FOOD_WITH_FIVE;
    }

    @Override
    public int getFood() {
        return food;
    }
}
