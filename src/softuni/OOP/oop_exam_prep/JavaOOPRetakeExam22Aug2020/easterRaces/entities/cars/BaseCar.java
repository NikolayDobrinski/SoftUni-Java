package softuni.OOP.oop_exam_prep.JavaOOPRetakeExam22Aug2020.easterRaces.entities.cars;

public abstract class BaseCar implements Car{

    private String model;
    private int horsePower;
    private double cubicCentimeters;

    protected BaseCar(String model, int horsePower, double cubicCentimeters) {
        this.setModel(model);
        this.horsePower = horsePower;
        this.cubicCentimeters = cubicCentimeters;
    }

    private void setModel(String model) {
        if (model == null || model.trim().isEmpty() || model.length() < 4) {
            throw new IllegalArgumentException(String.format("Model %s cannot be less than 4 symbols.", model));
        }
        this.model = model;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public int getHorsePower() {
        return this.horsePower;
    }

    @Override
    public double getCubicCentimeters() {
        return this.cubicCentimeters;
    }

    @Override
    public double calculateRacePoints(int laps) {
        return this.getCubicCentimeters() / this.getHorsePower() * laps;
    }

    protected void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }
}
