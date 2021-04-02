package softuni.OOP.design_patterns.factory_pattern;

public class Pizza implements IPizza{

    private int diameter;

    public Pizza(int diameter) {
        this.diameter = diameter;
    }

    @Override
    public void prepare() {
        System.out.println("Preparing...");
    }

    @Override
    public void bake() {
        System.out.println("Baking...");
    }

    @Override
    public void box() {
        System.out.println("It's ready!");
    }
}
