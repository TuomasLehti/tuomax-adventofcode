package fi.tuomax.adventofcode.commons;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestWalker 
{

    @Test
    public void test_Restriction()
    {
        Walker walker = new Walker();
        walker.restrict(new Coordinates(0L, 0L), new Coordinates(1L, 1L));
        walker.step(Direction.getInstance(Direction.EAST));
        assertEquals(new Coordinates(1L, 0L), walker.getCurrentCoords());
        walker.step(Direction.getInstance(Direction.EAST));
        assertEquals(new Coordinates(1L, 0L), walker.getCurrentCoords());
    }
    
}
