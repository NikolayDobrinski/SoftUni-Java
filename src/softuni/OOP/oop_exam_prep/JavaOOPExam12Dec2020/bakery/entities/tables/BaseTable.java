package softuni.OOP.oop_exam_prep.JavaOOPExam12Dec2020.bakery.entities.tables;

import softuni.OOP.oop_exam_prep.JavaOOPExam12Dec2020.bakery.entities.bakedFoods.interfaces.BakedFood;
import softuni.OOP.oop_exam_prep.JavaOOPExam12Dec2020.bakery.entities.drinks.interfaces.Drink;
import softuni.OOP.oop_exam_prep.JavaOOPExam12Dec2020.bakery.entities.tables.interfaces.Table;

import java.util.ArrayList;
import java.util.Collection;

import static softuni.OOP.oop_exam_prep.JavaOOPExam12Dec2020.bakery.common.ExceptionMessages.INVALID_NUMBER_OF_PEOPLE;
import static softuni.OOP.oop_exam_prep.JavaOOPExam12Dec2020.bakery.common.ExceptionMessages.INVALID_TABLE_CAPACITY;

public abstract class BaseTable implements Table {

    private Collection<BakedFood> foodOrders;
    private Collection<Drink> drinkOrders;
    private int tableNumber;
    private int capacity;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReserved;
    private double price;

    protected BaseTable(int tableNumber, int capacity, double pricePerPerson) {
        this.tableNumber = tableNumber;
        this.setCapacity(capacity);
        this.setPricePerPerson(pricePerPerson);
        this.foodOrders = new ArrayList<>();
        this.drinkOrders = new ArrayList<>();
        this.price = 0;
    }

    @Override
    public int getTableNumber() {
        return this.tableNumber;
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public int getNumberOfPeople() {
        return this.numberOfPeople;
    }

    @Override
    public double getPricePerPerson() {
        return this.pricePerPerson;
    }

    @Override
    public boolean isReserved() {
        return this.isReserved;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public void reserve(int numberOfPeople) {
        this.setNumberOfPeople(numberOfPeople);
        this.price = numberOfPeople * this.getPricePerPerson();
        this.isReserved = true;

    }

    @Override
    public void orderFood(BakedFood food) {
        this.foodOrders.add(food);
    }

    @Override
    public void orderDrink(Drink drink) {
        this.drinkOrders.add(drink);
    }

    @Override
    public double getBill() {

        double total = this.getPrice(); //takes the price - numberOfPeople * pricePerPerson
        total += this.foodOrders.stream().mapToDouble(f -> f.getPrice()).sum();
        total += this.drinkOrders.stream().mapToDouble(d -> d.getPrice()).sum();

        return total;
    }

    @Override
    public void clear() {
        this.foodOrders.clear();
        this.drinkOrders.clear();
        this.isReserved = false;
        this.price = 0;
    }

    @Override
    public String getFreeTableInfo() {
        return String.format("Table: %d%n" +
                "Type: %s%n" +
                "Capacity: %d%n" +
                "Price per Person: %.2f",
                this.tableNumber,
                this.getClass().getSimpleName(),
                this.capacity,
                this.pricePerPerson);
    }

    // Validation

    private void setPricePerPerson(double pricePerPerson) {
        this.pricePerPerson = pricePerPerson;
    }

    private void setCapacity(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException(INVALID_TABLE_CAPACITY);
        }
        this.capacity = capacity;
    }

    private void setNumberOfPeople(int numberOfPeople) {
        if (numberOfPeople <= 0) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople = numberOfPeople;
    }
}


