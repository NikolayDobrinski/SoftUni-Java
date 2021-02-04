package softuni.advanced.definingclasses.Google;

public class Car {
    private String carModel;

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public int getCarSpeed() {
        return carSpeed;
    }

    public void setCarSpeed(int carSpeed) {
        this.carSpeed = carSpeed;
    }

    private int carSpeed;

    public Car(String carModel, int carSpeed) {
        this.carModel = carModel;
        this.carSpeed = carSpeed;
    }
}
