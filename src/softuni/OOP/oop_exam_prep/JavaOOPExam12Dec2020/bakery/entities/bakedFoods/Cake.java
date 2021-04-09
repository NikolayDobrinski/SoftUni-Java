package softuni.OOP.oop_exam_prep.JavaOOPExam12Dec2020.bakery.entities.bakedFoods;

public class Cake extends BaseFood{

    private static final double INITIAL_CAKE_PORTION = 245;

    public Cake(String name, double price) {
        super(name, INITIAL_CAKE_PORTION, price);
    }
}
