package softuni.OOP.oop_exam_prep.JavaOOPExam16Aug2020.onlineShop.models.products.components;

public class Motherboard extends BaseComponent{

    @Override
    public int getGeneration() {
        return super.getGeneration();
    }

    private static final double MULTIPLIER = 1.25;

    public Motherboard(int id, String manufacturer, String model, double price, double overallPerformance, int generation) {
        super(id, manufacturer, model, price, overallPerformance * MULTIPLIER, generation);
    }
}
