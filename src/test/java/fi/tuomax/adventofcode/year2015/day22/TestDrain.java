package fi.tuomax.adventofcode.year2015.day22;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fi.tuomax.adventofcode.year2015.day22.players.Boss;
import fi.tuomax.adventofcode.year2015.day22.players.Hero;
import fi.tuomax.adventofcode.year2015.day22.spells.Drain;
import fi.tuomax.adventofcode.year2015.day22.spells.Shield;

public class TestDrain
{

    @Test
    public void test()
    {
        Hero player = new Hero(10, 250, new Shield());
        Boss opponent = new Boss(13, 8);
        new Drain().cast(player, opponent);
        assertEquals(8, (int) opponent.getHitPoints());
        assertEquals(12, (int) player.getHitPoints());
    }
    
}
