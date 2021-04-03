package softuni.OOP.unit_testing.Spaceship;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SpaceshipTests {

    private Spaceship spaceship;

    @Before
    public void setUp() {
        this.spaceship = new Spaceship("Spacecraft", 5);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameShouldFailWhenNull() {
        new Spaceship(null, 10);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameShouldFailWhenEmpty() {
        new Spaceship("   ", 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityShouldFailWhenBelowZero() {
        new Spaceship("Spaceship", -1);
    }

    @Test
    public void testGetAstronautsCountShouldReturnTwoWhenTwoAdded() {
        spaceship.add(new Astronaut("Ivan", 94));
        spaceship.add(new Astronaut("Peter", 96));
        assertEquals(2, spaceship.getCount());
    }

    @Test
    public void testGetAstronautsCountShouldReturnZeroWehnEmpty() {
        assertEquals(0, spaceship.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddSameAstronautTwiceShouldFail() {
        spaceship.add(new Astronaut("Ivan", 94));
        spaceship.add(new Astronaut("Ivan", 94));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAstronautWhenCapacityIsFullShouldFail() {
        Spaceship spaceship = new Spaceship("Spaceship", 1);
        spaceship.add(new Astronaut("Ivan", 94));
        spaceship.add(new Astronaut("Peter", 96));
    }

    @Test
    public void testRemoveAstronautShouldReturnFalseWhenNoSuchAdded() {
        this.spaceship.add(new Astronaut("Ivan", 94));
        Assert.assertFalse(this.spaceship.remove("other"));
    }

    @Test
    public void testRemoveAstronautShouldReturnTrueWhenSuchAdded() {
        this.spaceship.add(new Astronaut("Ivan", 94));
        Assert.assertTrue(this.spaceship.remove("Ivan"));
    }
}
