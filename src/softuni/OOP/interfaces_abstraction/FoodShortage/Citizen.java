package softuni.OOP.interfaces_abstraction.FoodShortage;

public class Citizen implements Identifiable, Birthable, Person, Buyer{

    private static final int INCREASE_FOOD_WITH_TEN = 10;

    private String name;
    private int age;
    private String id;
    private String birthDate;
    private int food;

    public Citizen(String name, int age, String id, String birthDate) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthDate = birthDate;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public String getBirthDate() {
        return this.birthDate;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void buyFood() {
        this.food += INCREASE_FOOD_WITH_TEN;
    }

    @Override
    public int getFood() {
        return this.food;
    }
}
