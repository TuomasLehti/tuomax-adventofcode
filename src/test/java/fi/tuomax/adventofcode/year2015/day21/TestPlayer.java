package fi.tuomax.adventofcode.year2015.day21;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestPlayer 
{

    @Test
    public void testExample()
    {
        Player player = new Player(8, 5, 5);
        Player opponent = new Player(12, 7, 2);
        assertTrue(player.wins(opponent));
    }

    @Test
    public void testEquallyPowerful()
    {
        Player player = new Player(15, 5, 0);
        Player opponent = new Player(15, 5, 0);
        assertTrue(player.wins(opponent));
    }

    @Test
    public void testMinimumDamage()
    {
        Player player = new Player(15, 5, 0);
        Player opponent = new Player(15, 1, 999);
        assertTrue(player.wins(opponent));
    }

    @Test
    public void testClearVictory()
    {
        Player player = new Player(150, 5, 0);
        Player opponent = new Player(15, 1, 0);
        assertTrue(player.wins(opponent));
    }

}
