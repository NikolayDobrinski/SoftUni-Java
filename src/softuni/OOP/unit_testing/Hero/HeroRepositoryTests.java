package softuni.OOP.unit_testing.Hero;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HeroRepositoryTests {

    private HeroRepository heroRepository;
    private Hero hero;
    private String name = "Peter";
    private int level = 100;

    @Before
    public void setUp() {
        heroRepository = new HeroRepository();
        hero = new Hero(name, level);
    }

    @Test
    public void testGetCountShouldReturnTheCount() {
        heroRepository.create(hero);
        Assert.assertEquals(1, heroRepository.getCount());
    }

    // create() tests

    @Test(expected = NullPointerException.class)
    public void testCreateShouldThrowExIfNullPassedToCreate() {
        HeroRepository heroRepository = new HeroRepository();
        heroRepository.create(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateShouldThrowExIfSuchHeroAlreadyExist() {
        heroRepository.create(hero);
        heroRepository.create(hero);
    }

    @Test
    public void testCreateShouldAddItToTheRepositoryCorrect() {
        heroRepository.create(hero);
        Hero actual = heroRepository.getHero("Peter");
        Assert.assertEquals(hero, actual);
    }

    // remove() tests

    @Test(expected = NullPointerException.class)
    public void testRemoveShouldThrowExWhenNullPassedInsteadAName() {
        heroRepository.create(hero);
        heroRepository.remove(null);
    }

    @Test
    public void testRemoveShouldReturnTrueWhenTheEntityWasRemoved() {
        heroRepository.create(hero);
        Assert.assertTrue(heroRepository.remove("Peter"));
    }

    @Test
    public void testRemoveShouldReturnFalseWhenTheEntityWasNotRemoved() {
        heroRepository.create(hero);
        Assert.assertFalse(heroRepository.remove("John"));
    }

    // getHero() tests

    @Test
    public void testGetHeroWithHighestLevelShouldReturnThisHero() {
        heroRepository = new HeroRepository();
        Hero peter = new Hero("Peter", 100); // Peter is with higher level than John
        Hero john = new Hero("John", 90);
        heroRepository.create(peter);
        heroRepository.create(john);
        Assert.assertEquals(peter, heroRepository.getHeroWithHighestLevel());
    }

    @Test
    public void testGetHeroWithHighestLevelShouldReturnNullWhenRepositoryIsEmpty() {
        HeroRepository heroRepository = new HeroRepository();
        Assert.assertEquals(null, heroRepository.getHeroWithHighestLevel());
    }

    // getHeroes() tests

    @Test
    public void testGetHeroesShouldReturnCollectionWithOneEntityWhenOneCreated() {
        heroRepository.create(hero);
        Assert.assertEquals(1, heroRepository.getHeroes().size());
    }

    @Test
    public void testGetHeroesShouldReturnSameNameOfHeroAsTheOneThatWasCreated() {
        heroRepository.create(hero);
        Hero expected = heroRepository.getHero("Peter");
        Assert.assertEquals(expected, heroRepository.getHeroes().iterator().next());
    }
}
