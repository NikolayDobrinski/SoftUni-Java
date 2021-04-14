package softuni.OOP.oop_exam_prep.JavaOOPRetakeExam22Aug2020.easterRaces.entities.cars;

public class MuscleCar extends BaseCar{


    public MuscleCar(String model, int horsePower) {
        super(model, horsePower, 5000);
    }

    @Override
    protected void setHorsePower(int horsePower) {
        if (horsePower < 400 || horsePower > 600) {
            throw new IllegalArgumentException(String.format("Invalid horse power: %d.", horsePower));
        }
        super.setHorsePower(horsePower);
    }
}
