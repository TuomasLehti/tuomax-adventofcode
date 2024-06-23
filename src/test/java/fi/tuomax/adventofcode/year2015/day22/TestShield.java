package fi.tuomax.adventofcode.year2015.day22;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fi.tuomax.adventofcode.year2015.day22.players.Boss;
import fi.tuomax.adventofcode.year2015.day22.players.Hero;
import fi.tuomax.adventofcode.year2015.day22.spells.Shield;

public class TestShield 
{

    @Test
    public void test()
    {
        Shield shield = new Shield();
        Hero player = new Hero(10, 250, shield);
        Boss opponent = new Boss(13, 8);

        /* player */
        shield.turn(player, opponent);

        /* opponent */
        shield.turn(player, opponent);
        player.getsHit(opponent.getDamage()); // no shield, 8 damage

        /* player */
        assertEquals(2, (int) player.getHitPoints());
        shield.turn(player, opponent);
        shield.cast(player, opponent);

        /* opponent */
        shield.turn(player, opponent);
        player.getsHit(opponent.getDamage()); // shield, 1 damage

        /* player */
        assertEquals(1, (int) player.getHitPoints());
    }
    
}
