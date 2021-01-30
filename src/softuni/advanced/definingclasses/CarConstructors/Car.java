package softuni.advanced.definingclasses.CarConstructors;

public class Car {

    private String brand;
    private String model;
    private int horsePower;

    public Car (String brand) {
        this.brand = brand;
        this.model = "unknown";
        this.horsePower = -1;
    }
    public Car (String brand, String model, int horsePower) {
        this(brand);
        this.model = model;
        this.horsePower = horsePower;
    }

    public void carInfo () {
        System.out.println(String.format("The car is: %s %s - %d HP.", brand, model, horsePower));
    }

}
