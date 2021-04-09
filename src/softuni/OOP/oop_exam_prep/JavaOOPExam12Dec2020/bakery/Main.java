package softuni.OOP.oop_exam_prep.JavaOOPExam12Dec2020.bakery;

import softuni.OOP.oop_exam_prep.JavaOOPExam12Dec2020.bakery.core.ControllerImpl;
import softuni.OOP.oop_exam_prep.JavaOOPExam12Dec2020.bakery.core.EngineImpl;
import softuni.OOP.oop_exam_prep.JavaOOPExam12Dec2020.bakery.core.interfaces.Controller;
import softuni.OOP.oop_exam_prep.JavaOOPExam12Dec2020.bakery.entities.bakedFoods.interfaces.BakedFood;
import softuni.OOP.oop_exam_prep.JavaOOPExam12Dec2020.bakery.entities.drinks.interfaces.Drink;
import softuni.OOP.oop_exam_prep.JavaOOPExam12Dec2020.bakery.entities.tables.interfaces.Table;
import softuni.OOP.oop_exam_prep.JavaOOPExam12Dec2020.bakery.io.ConsoleReader;
import softuni.OOP.oop_exam_prep.JavaOOPExam12Dec2020.bakery.io.ConsoleWriter;
import softuni.OOP.oop_exam_prep.JavaOOPExam12Dec2020.bakery.repositories.DrinkRepositoryImpl;
import softuni.OOP.oop_exam_prep.JavaOOPExam12Dec2020.bakery.repositories.FoodRepositoryImpl;
import softuni.OOP.oop_exam_prep.JavaOOPExam12Dec2020.bakery.repositories.TableRepositoryImpl;
import softuni.OOP.oop_exam_prep.JavaOOPExam12Dec2020.bakery.repositories.interfaces.*;

public class Main {
    public static void main(String[] args) {

        String a = " ";
        int a1 = a.length();
        FoodRepository<BakedFood> foodRepository = new FoodRepositoryImpl();
        DrinkRepository<Drink> drinkRepository = new DrinkRepositoryImpl();
        TableRepository<Table> tableRepository = new TableRepositoryImpl();

        Controller controller = new ControllerImpl(foodRepository, drinkRepository, tableRepository);


         ConsoleReader reader = new ConsoleReader();
         ConsoleWriter writer = new ConsoleWriter();
         EngineImpl engine = new EngineImpl(reader, writer, controller);
         engine.run();
    }
}
