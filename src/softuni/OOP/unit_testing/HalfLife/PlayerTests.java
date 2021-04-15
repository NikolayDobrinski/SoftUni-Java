package softuni.OOP.unit_testing.HalfLife;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class PlayerTests {

    private Player player;
    private String userName = "David";
    private int health = 100;

    @Before
    public void setUp() {
        player = new Player(userName, health);
    }

    //setUsername() tests

    @Test(expected = NullPointerException.class)
    public void testSetUsernameShouldThrowExWhenTheNameIsNull() {
        Player player = new Player(null, 100);
    }

    @Test(expected = NullPointerException.class)
    public void testSetUsernameShouldThrowExWhenNameLengthIsLessThanOneSymbol() {
        Player player = new Player("", 100);
    }

    @Test
    public void testSetUsernameShouldSetItCorrect() {
        Assert.assertEquals(userName, player.getUsername());
    }

    // setHealth() tests

    @Test(expected = IllegalArgumentException.class)
    public void setHealthShouldThrowExWhenHealthUnderZero() {
        String userName = "David";
        int health = -1;
        Player player = new Player(userName, health);
    }

    @Test
    public void setHealthShouldSetItCorrect() {
        Assert.assertEquals(health, player.getHealth());
    }

    //  getGuns() test

    @Test
    public void testGetGunsShouldReturnListWithExistingGuns() {
        player.addGun(new Gun("Pistol", 10));
        player.addGun(new Gun("M16", 100));
        List<Gun> expected = List.of(player.getGun("Pistol"), player.getGun("M16"));
        List<Gun> actual = player.getGuns();
        Assert.assertEquals(expected, actual);
    }

    // takeDamage() tests

    @Test(expected = IllegalStateException.class)
    public void testTakeDamageShouldThrowExWhenHealthUnderOrEqualZero() {
        String userName = "David";
        int health = 0;
        Player player = new Player(userName, health);
        player.takeDamage(5);
    }

    @Test
    public void testTakeDamageWithBiggerValueThanHealthShoudSetTheHealthToZero() {
        String userName = "David";
        int health = 3;
        Player player = new Player(userName, health);
        player.takeDamage(5);
        Assert.assertEquals(0, player.getHealth());
    }

    @Test
    public void testTakeDamageWithLowerValueThanHealthShouldSubtractBothValues() {
        String userName = "David";
        int health = 8;
        Player player = new Player(userName, health);
        player.takeDamage(5);
        Assert.assertEquals(3, player.getHealth());
    }

    // addGun() tests

    @Test(expected = NullPointerException.class)
    public void testAddGunShouldThrowExWhenNamePassedIsNull() {
        player.addGun(null);
    }

    @Test
    public void testAddGunShouldAddItCorrect() {
        Gun expectedGun = new Gun("Pistol", 10);
        player.addGun(expectedGun);
        Assert.assertEquals(expectedGun, player.getGun("Pistol"));
    }

    // removeGun() test

    @Test
    public void testRemoveGunShouldRemoveTheGivenGunAndReturnBoolean() {
        Gun gun = new Gun("Pistol", 10);
        player.addGun(gun);
        boolean result = player.removeGun(gun);
        Assert.assertTrue(result);
    }
}
