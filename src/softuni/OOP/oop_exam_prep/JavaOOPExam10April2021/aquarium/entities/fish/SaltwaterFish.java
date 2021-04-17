package softuni.OOP.oop_exam_prep.JavaOOPExam10April2021.aquarium.entities.fish;

public class SaltwaterFish extends BaseFish{

    //Can only live in SaltwaterAquarium!

    private static int initialSize = 5;

    public SaltwaterFish(String name, String species, double price) {
        super(name, species, price);
    }

    @Override
    public void eat() {
        initialSize = this.getSize() + 5;
    }
}
