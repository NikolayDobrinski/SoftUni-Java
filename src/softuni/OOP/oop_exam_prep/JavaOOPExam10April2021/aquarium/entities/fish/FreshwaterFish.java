package softuni.OOP.oop_exam_prep.JavaOOPExam10April2021.aquarium.entities.fish;

public class FreshwaterFish extends BaseFish{

    //Can only live in FreshwaterAquarium!

    private static int initialSize = 3;

    public FreshwaterFish(String name, String species, double price) {
        super(name, species, price);
    }

    @Override
    public void eat() {
        initialSize = this.getSize() + 3;
    }
}
