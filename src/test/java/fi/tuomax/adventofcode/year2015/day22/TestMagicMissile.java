package fi.tuomax.adventofcode.year2015.day22;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fi.tuomax.adventofcode.year2015.day22.players.Boss;
import fi.tuomax.adventofcode.year2015.day22.players.Hero;
import fi.tuomax.adventofcode.year2015.day22.spells.MagicMissile;
import fi.tuomax.adventofcode.year2015.day22.spells.Shield;

public class TestMagicMissile 
{

    @Test
    public void test()
    {
        Hero player = new Hero(10, 500, new Shield());
        Boss opponent = new Boss(10, 8);
        new MagicMissile().cast(player, opponent);
        assertEquals(6, (int) opponent.getHitPoints());
    }
    
}
