package softuni.OOP.polymorphism.Animals;

public abstract class Animal {
    private String name;
    private String favoriteFood;

    public Animal(String name, String favoriteFood) {
        this.name = name;
        this.favoriteFood = favoriteFood;
    }

    public String getName() {
        return name;
    }

    public String getFavoriteFood() {
        return favoriteFood;
    }

    public String explainSelf() {
        return String.format("I am %s and my favourite food is %s",
                this.getName(), this.getFavoriteFood());
    }

}
