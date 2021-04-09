package softuni.OOP.oop_exam_prep.JavaOOPExam12Dec2020.bakery.core;

import softuni.OOP.oop_exam_prep.JavaOOPExam12Dec2020.bakery.core.interfaces.Controller;
import softuni.OOP.oop_exam_prep.JavaOOPExam12Dec2020.bakery.entities.bakedFoods.Bread;
import softuni.OOP.oop_exam_prep.JavaOOPExam12Dec2020.bakery.entities.bakedFoods.Cake;
import softuni.OOP.oop_exam_prep.JavaOOPExam12Dec2020.bakery.entities.bakedFoods.interfaces.BakedFood;
import softuni.OOP.oop_exam_prep.JavaOOPExam12Dec2020.bakery.entities.drinks.Tea;
import softuni.OOP.oop_exam_prep.JavaOOPExam12Dec2020.bakery.entities.drinks.Water;
import softuni.OOP.oop_exam_prep.JavaOOPExam12Dec2020.bakery.entities.drinks.interfaces.Drink;
import softuni.OOP.oop_exam_prep.JavaOOPExam12Dec2020.bakery.entities.tables.InsideTable;
import softuni.OOP.oop_exam_prep.JavaOOPExam12Dec2020.bakery.entities.tables.OutsideTable;
import softuni.OOP.oop_exam_prep.JavaOOPExam12Dec2020.bakery.entities.tables.interfaces.Table;
import softuni.OOP.oop_exam_prep.JavaOOPExam12Dec2020.bakery.repositories.interfaces.DrinkRepository;
import softuni.OOP.oop_exam_prep.JavaOOPExam12Dec2020.bakery.repositories.interfaces.FoodRepository;
import softuni.OOP.oop_exam_prep.JavaOOPExam12Dec2020.bakery.repositories.interfaces.TableRepository;

import static softuni.OOP.oop_exam_prep.JavaOOPExam12Dec2020.bakery.common.OutputMessages.BILL;
import static softuni.OOP.oop_exam_prep.JavaOOPExam12Dec2020.bakery.common.OutputMessages.TOTAL_INCOME;

public class ControllerImpl implements Controller {

    private FoodRepository<BakedFood> foodRepository;
    private DrinkRepository<Drink> drinkRepository;
    private TableRepository<Table> tableRepository;
    private double totalIncome;

    public ControllerImpl(FoodRepository<BakedFood> foodRepository, DrinkRepository<Drink> drinkRepository,
                          TableRepository<Table> tableRepository) {

        this.foodRepository = foodRepository;
        this.drinkRepository = drinkRepository;
        this.tableRepository = tableRepository;
        this.totalIncome = 0.0;
    }

    @Override
    public String addFood(String type, String name, double price) {
        BakedFood bakedFood = this.foodRepository.getByName(name);
        if (bakedFood != null) {
            throw new IllegalArgumentException(String.format("%s %s is already in the menu", type, name));
        }

        switch (type) {
            case "Bread":
                bakedFood = new Bread(name, price);
                break;
            case "Cake":
                bakedFood = new Cake(name, price);
                break;
        }
        this.foodRepository.add(bakedFood);

        return String.format("Added %s (%s) to the menu", name, type);
    }

    @Override
    public String addDrink(String type, String name, int portion, String brand) {

        Drink drink = this.drinkRepository.getByNameAndBrand(name, brand);
        if (drink != null) {
            throw new IllegalArgumentException(String.format("%s %s is already in the menu", type, name));
        }

        switch (type) {
            case "Tea":
                drink = new Tea(name, portion, brand);
                break;
            case "Water":
                drink = new Water(name, portion, brand);
                break;
        }
        this.drinkRepository.add(drink);

        return String.format("Added %s (%s) to the drink menu", name, brand);
    }

    @Override
    public String addTable(String type, int tableNumber, int capacity) {
        Table table = this.tableRepository.getByNumber(tableNumber);

        if (table != null) {
            throw new IllegalArgumentException(String.format("Table %d is already added to the restaurant",
                    tableNumber));
        }
        switch (type) {
            case "InsideTable":
                table = new InsideTable(tableNumber, capacity);
                break;
            case "OutsideTable":
                table = new OutsideTable(tableNumber, capacity);
                break;
        }

        this.tableRepository.add(table);

        return String.format("Added table number %d in the bakery", tableNumber);
    }

    @Override
    public String reserveTable(int numberOfPeople) {

        for (Table table : tableRepository.getAll()) {
            if (!table.isReserved() && table.getCapacity() >= numberOfPeople) {
                table.reserve(numberOfPeople);
                return String.format("Table %d has been reserved for %d people", table.getTableNumber(), numberOfPeople);
            }
        }

        return String.format("No available table for %d people", numberOfPeople);
    }

    @Override
    public String orderFood(int tableNumber, String foodName) {
        Table table = this.tableRepository.getByNumber(tableNumber);
        if (table == null || !table.isReserved()) {
            throw new IllegalArgumentException(String.format("Could not find table with %d", tableNumber));
        }

        BakedFood bakedFood = this.foodRepository.getByName(foodName);

        if (bakedFood == null) {
            throw new IllegalArgumentException(String.format("No %s in the menu", foodName));
        }

        table.orderFood(bakedFood);
        return String.format("Table %d ordered %s", tableNumber, foodName);
    }

    @Override
    public String orderDrink(int tableNumber, String drinkName, String drinkBrand) {
        Table table = this.tableRepository.getByNumber(tableNumber);
        if (table == null || !table.isReserved()) {
            throw new IllegalArgumentException(String.format("Could not find table %d", tableNumber));
        }

        Drink drink = this.drinkRepository.getByNameAndBrand(drinkName, drinkBrand);

        if (drink == null) {
            throw new IllegalArgumentException(String.format("There is no %s %s available", drinkName, drinkBrand));
        }

        table.orderDrink(drink);
        return String.format("Table %s ordered %s %s", tableNumber, drinkName, drinkBrand);

    }

    @Override
    public String leaveTable(int tableNumber) {
        Table table = this.tableRepository.getByNumber(tableNumber);
        double bill = table.getBill();
        this.totalIncome += bill;
        table.clear();

        return String.format(BILL, tableNumber, bill);
    }

    @Override
    public String getFreeTablesInfo() {
        StringBuilder sb = new StringBuilder();
        for (Table table : tableRepository.getAll()) {
            if (!table.isReserved()) {
                sb.append(table.getFreeTableInfo())
                        .append(System.lineSeparator());
            }
        }

        return sb.toString().trim();
    }

    @Override
    public String getTotalIncome() {

        return String.format(TOTAL_INCOME, this.totalIncome);
    }
}
