package softuni.OOP.polymorphism.WildFarm;

public abstract class Food {
    int quantity;

    public Food(int quantity) {
        this.quantity = quantity;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
