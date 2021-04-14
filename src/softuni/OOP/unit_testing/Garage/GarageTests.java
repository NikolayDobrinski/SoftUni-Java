package softuni.OOP.unit_testing.Garage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

public class GarageTests {

    private Garage garage;

    @Before
    public void setUp() {
        garage = new Garage();
        garage.addCar(new Car("Mercedes", 200, 10000));
        garage.addCar(new Car("BMW", 210, 12000));
    }


    @Test
    public void testGetCountShouldReturnTheCount() {
        int expected = 2;
        int actual = garage.getCount();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindAllCarsWithMaxSpeedAboveShouldReturnListWithCars() {
        List<Car> garageCars = garage.getCars();
        List<Car> expected = garageCars.stream().filter(c -> c.getMaxSpeed() > 205).collect(Collectors.toList());
        List<Car> actual = garage.findAllCarsWithMaxSpeedAbove(205);
        Assert.assertEquals(expected, actual);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddCarShouldThrowExIfCarIsNull() {
        garage.addCar(null);
    }

    @Test
    public void testAddCarShouldAddIt() {
        int expected = garage.getCount();
        garage.addCar(new Car("Opel", 160, 5000));
        int actual = garage.getCount();
        Assert.assertEquals(expected + 1, actual);
    }

    @Test
    public void testGetTheMostExpensiveCarShouldReturnIt() {
     List<Car> allCars = garage.getCars();
        Car expected = allCars.stream().filter(c -> c.getBrand().equals("BMW")).findFirst().orElse(null);
        Car actual = garage.getTheMostExpensiveCar();

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testFindAllCarsByBrand() {
        List<Car> allCars = garage.getCars();
        List<Car> expected = allCars.stream().filter(f -> f.getBrand().equals("Mercedes")).collect(Collectors.toList());
        List<Car> actual = garage.findAllCarsByBrand("Mercedes");
        Assert.assertEquals(expected, actual);
    }
}