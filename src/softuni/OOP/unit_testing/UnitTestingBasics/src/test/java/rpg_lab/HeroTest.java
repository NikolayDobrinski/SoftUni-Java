package rpg_lab;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HeroTest {
    private static final int TARGET_XP = 13;

    @Test
    public void testHeroGainsExperienceWhenTargetIsKilled() {
        Weapon weapon = mock(Weapon.class);

        Hero hero = new Hero("Java_Wizard", weapon);

        Target target = mock(Target.class);

        when(target.isDead()).thenReturn(true);
        when(target.giveExperience()).thenReturn(TARGET_XP);

        hero.attack(target);

        assertEquals(TARGET_XP, hero.getExperience());
    }
}