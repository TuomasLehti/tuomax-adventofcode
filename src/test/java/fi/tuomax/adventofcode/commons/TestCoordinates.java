package fi.tuomax.adventofcode.commons;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestCoordinates 
{

    @Test
    public void testTaxicabDistanceTo()
    {
        Coordinates from = new Coordinates(50L, 50L);
        assertEquals(10L, (long) from.taxicabDistance(new Coordinates(55L, 55L)));
        assertEquals(10L, (long) from.taxicabDistance(new Coordinates(45L, 55L)));
        assertEquals(10L, (long) from.taxicabDistance(new Coordinates(55L, 45L)));
        assertEquals(10L, (long) from.taxicabDistance(new Coordinates(45L, 45L)));
    }
    
}
