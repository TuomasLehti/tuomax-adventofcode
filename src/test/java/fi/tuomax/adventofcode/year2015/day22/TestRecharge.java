package fi.tuomax.adventofcode.year2015.day22;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fi.tuomax.adventofcode.year2015.day22.players.Boss;
import fi.tuomax.adventofcode.year2015.day22.players.Hero;
import fi.tuomax.adventofcode.year2015.day22.spells.Recharge;
import fi.tuomax.adventofcode.year2015.day22.spells.Shield;

public class TestRecharge 
{

    @Test
    public void test()
    {
        Hero player = new Hero(10, 500, new Shield());
        Boss opponent = new Boss(10, 8);
        Recharge r = new Recharge();

        assertTrue(r.isCastable());

        r.cast(player, opponent);
        assertEquals(500, (int) player.getMana());
        assertFalse(r.isCastable());
        
        r.turn(player, opponent); // timer -> 4
        assertEquals(500 + 101, (int) player.getMana());
        assertFalse(r.isCastable());
        r.turn(player, opponent); // timer -> 3
        assertEquals(500 + 2 * 101, (int) player.getMana());
        assertFalse(r.isCastable());
        r.turn(player, opponent); // timer -> 2
        assertEquals(500 + 3 * 101, (int) player.getMana());
        assertFalse(r.isCastable());
        r.turn(player, opponent); // timer -> 1
        assertEquals(500 + 4 * 101, (int) player.getMana());
        assertFalse(r.isCastable());
        r.turn(player, opponent); // timer -> 0, wears out, still not yet castable
        assertEquals(500 + 5 * 101, (int) player.getMana());
        assertFalse(r.isCastable());
        r.turn(player, opponent); // is now castable
        assertEquals(500 + 5 * 101, (int) player.getMana());
        assertTrue(r.isCastable());
    }
    
}
