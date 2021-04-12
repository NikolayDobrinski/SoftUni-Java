package softuni.OOP.unit_testing.Aquarium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AquariumTests {

    private String name = "Sofia";
    private int capacity = 10;
    private Aquarium aquarium;

    @Before
    public void setUp() {
        aquarium = new Aquarium(name, capacity);
    }

    //addName tests

    @Test(expected = NullPointerException.class)
    public void testSetNameShouldThrowExIfTheNameIsNull() {
        Aquarium aquarium = new Aquarium(null, 10);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameShouldThrowExIfTheNameIsEmpty() {
        Aquarium aquarium = new Aquarium("", 10);
    }

    @Test
    public void testSetNameShouldSetIt() {

        Assert.assertEquals(name, aquarium.getName());
    }

    // getCapacity test

    @Test
    public void testGetCapacityShouldReturnTheCapacity() {

        Assert.assertEquals(capacity, aquarium.getCapacity());
    }

    // setCapacity tests

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityLessThanZeroShouldThrowEx() {
        String name = "Sofia";
        int capacity = -1;
        Aquarium aquarium = new Aquarium(name, capacity);
    }

    @Test
    public void testSetCapacityGreaterThanZeroShouldSetIt() {
        String name = "Sofia";
        int capacity = 0;
        Aquarium aquarium = new Aquarium(name, capacity);
        Assert.assertEquals(capacity, aquarium.getCapacity());
    }

    @Test
    public void testGetCountShouldReturnZeroWhenAquariumIsEmpty() {
        String name = "Sofia";
        int capacity = 0;
        Aquarium aquarium = new Aquarium(name, capacity);
        Assert.assertEquals(capacity, aquarium.getCount());
    }

    // addFish tests

    @Test(expected = IllegalArgumentException.class)
    public void testAddFishIntoFullAquariumShouldThrowEx() {
        String name = "Sofia";
        int capacity = 2;
        Aquarium aquarium = new Aquarium(name, capacity);
        Fish one = new Fish("One");
        Fish two = new Fish("Two");
        Fish three = new Fish("Three");
        aquarium.add(one);
        aquarium.add(two);
        aquarium.add(three);
    }

    @Test
    public void testAddFishIntoAquariumShouldAddIt() {
        String name = "Sofia";
        int capacity = 4;
        Aquarium aquarium = new Aquarium(name, capacity);
        Fish one = new Fish("One");
        Fish two = new Fish("Two");
        Fish three = new Fish("Three");
        aquarium.add(one);
        aquarium.add(two);
        aquarium.add(three);
        Assert.assertEquals(3, aquarium.getCount());
    }

    // Remove tests
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveShouldThrowExIfSuchFishDoesntExist() {
        String name = "Sofia";
        int capacity = 4;
        Aquarium aquarium = new Aquarium(name, capacity);
        Fish one = new Fish("One");
        Fish two = new Fish("Two");
        Fish three = new Fish("Three");
        aquarium.add(one);
        aquarium.add(two);
        aquarium.add(three);
        aquarium.remove("four");

    }

    @Test
    public void testRemoveShouldRemoveTheFish() {
        String name = "Sofia";
        int capacity = 4;
        Aquarium aquarium = new Aquarium(name, capacity);
        Fish one = new Fish("One");
        Fish two = new Fish("Two");
        Fish three = new Fish("Three");
        aquarium.add(one);
        aquarium.add(two);
        aquarium.add(three);
        aquarium.remove("One");
        Assert.assertEquals(2, aquarium.getCount());

    }

    // sellFish tests

    @Test(expected = IllegalArgumentException.class)
    public void testSellFishShouldThrowExIfSuchDoesNotExist() {
        String name = "Sofia";
        int capacity = 4;
        Aquarium aquarium = new Aquarium(name, capacity);
        Fish one = new Fish("One");
        Fish two = new Fish("Two");
        Fish three = new Fish("Three");
        aquarium.add(one);
        aquarium.add(two);
        aquarium.add(three);
        aquarium.remove("One");
        aquarium.sellFish("Four");
    }

    @Test
    public void testSellFishShouldReturnTheRequiredFish() {
        String name = "Sofia";
        int capacity = 4;
        Aquarium aquarium = new Aquarium(name, capacity);
        Fish one = new Fish("One");
        Fish two = new Fish("Two");
        Fish three = new Fish("Three");
        aquarium.add(one);
        aquarium.add(two);
        aquarium.add(three);
        Fish required = new Fish("One");
        aquarium.sellFish("One");
        Assert.assertEquals(false, one.isAvailable());
        Assert.assertEquals(required.getName(), one.getName());

    }

    // report test

    @Test
    public void testReportShouldReturnInformation() {
        String name = "Sofia";
        int capacity = 4;
        Aquarium aquarium = new Aquarium(name, capacity);
        Fish one = new Fish("One");
        Fish two = new Fish("Two");
        aquarium.add(one);
        aquarium.add(two);
        String expected = "Fish available at Sofia: One, Two";
        String actual = aquarium.report();
        Assert.assertEquals(expected, actual);

    }

}

