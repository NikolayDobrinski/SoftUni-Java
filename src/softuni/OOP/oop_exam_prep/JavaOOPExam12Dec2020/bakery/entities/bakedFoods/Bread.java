package softuni.OOP.oop_exam_prep.JavaOOPExam12Dec2020.bakery.entities.bakedFoods;

public class Bread extends BaseFood{

    private static final double INITIAL_BREAD_PORTION = 200;

    public Bread(String name, double price) {
        super(name, INITIAL_BREAD_PORTION, price);
    }
}
