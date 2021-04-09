package softuni.OOP.oop_exam_prep.JavaOOPExam12Dec2020.bakery.entities.tables;

public class OutsideTable extends BaseTable{

    private static final double PRICE_PER_PERSON = 3.50;

    public OutsideTable(int tableNumber, int capacity) {
        super(tableNumber, capacity, PRICE_PER_PERSON);
    }
}
