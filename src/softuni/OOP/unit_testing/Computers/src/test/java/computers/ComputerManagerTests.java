package softuni.OOP.unit_testing.Computers.src.test.java.computers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import softuni.OOP.oop_exam_prep.JavaOOPExam16Aug2020.Computers.src.main.java.computers.Computer;
import softuni.OOP.oop_exam_prep.JavaOOPExam16Aug2020.Computers.src.main.java.computers.ComputerManager;

import java.util.List;

public class ComputerManagerTests {

    private ComputerManager manager;
    private Computer computerHP;
    private Computer computerAsus;

    @Before
    public void setUp() {

        manager = new ComputerManager();
        computerHP = new Computer("HP", "Zenbook", 1900.10);
        computerAsus = new Computer("Mac", "Expire", 1750.00);
    }

    // getCount test
    @Test
    public void testGetCountShouldReturnTheNumberOfComputers() {

        manager.addComputer(computerHP);
        manager.addComputer(computerAsus);

        Assert.assertEquals(2, manager.getCount());
    }

    // addComputer tests
    @Test(expected = IllegalArgumentException.class)
    public void testWhenAddedComputerWithNullValueFailShoutBeThrown() {

        Computer newComputer = null;
        manager.addComputer(newComputer);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddComputerShouldNotBeAbleToAddTwiceSameComputerAndThrowsException() {

        Computer computerHPOne = new Computer("HP", "Zenbook", 1900.10);
        Computer computerHPTwo = new Computer("HP", "Zenbook", 1900.10);

        manager.addComputer(computerHPOne);
        manager.addComputer(computerHPTwo);
    }

    @Test
    public void testAddComputerThatDoesNotAppearsShoudBeAddedToManager() {

        manager.addComputer(computerHP);
        manager.addComputer(computerAsus);

        Assert.assertEquals(2, manager.getCount());
    }

    //removeComputer tests

    @Test
    public void testRemoveComputerShouldRemoveComputerAndReturnIt() {

        manager.addComputer(computerHP);
        manager.addComputer(computerAsus);

        Computer removedComputer = manager.removeComputer("HP", "Zenbook");

        Assert.assertEquals(computerHP, removedComputer);
    }

    // getComputer tests
    @Test
    public void testGetComputerShouldReturnItIfExists() {

        manager.addComputer(computerHP);
        manager.addComputer(computerAsus);

        Computer expectedComputer = manager.getComputer("HP", "Zenbook");

        Assert.assertEquals(computerHP, expectedComputer);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetComputerShouldFailIfSuchComputerMissing() {

        manager.addComputer(computerHP);
        manager.addComputer(computerAsus);

        Computer expectedComputer = manager.getComputer("Dell", "Inspire");
    }

    @Test
    public void testGetComputersByManufacturerShouldReturnOnlyComputersFromThisBrand() {

        Computer computerHPOne = new Computer("HP", "ZenbookOne", 1900.10);
        Computer computerAsus = new Computer("Mac", "Expire", 1750.00);
        Computer computerHPTwo = new Computer("HP", "ZenbookTwo", 1900.10);
        Computer computerHPThree = new Computer("HP", "ZenbookThree", 1900.10);

        manager.addComputer(computerHPOne);
        manager.addComputer(computerAsus);
        manager.addComputer(computerHPTwo);
        manager.addComputer(computerHPThree);

        List<Computer> hpComputersList = manager.getComputersByManufacturer("HP");

        Assert.assertEquals(3, hpComputersList.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetComputersByManufacturerShouldFailWhenManufacturerPassedIsNull() {

        List<Computer> hpComputersList = manager.getComputersByManufacturer(null);

    }
}