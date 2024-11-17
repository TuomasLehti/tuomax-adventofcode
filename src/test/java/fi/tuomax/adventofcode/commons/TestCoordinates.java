package fi.tuomax.adventofcode.commons;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fi.tuomax.adventofcode.commons.Direction.TurnDirection;

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

    @Test
    public void Test_Rotate90Degrees()
    {
        Coordinates coords = Coordinates.fromInteger(2, 0);
        coords = coords.rotate90Degrees(TurnDirection.RIGHT);
        assertEquals(coords, Coordinates.fromInteger(0, -2));
        coords = coords.rotate90Degrees(TurnDirection.RIGHT);
        assertEquals(coords, Coordinates.fromInteger(-2, 0));
        coords = coords.rotate90Degrees(TurnDirection.RIGHT);
        assertEquals(coords, Coordinates.fromInteger(0, 2));
        coords = coords.rotate90Degrees(TurnDirection.RIGHT);
        assertEquals(coords, Coordinates.fromInteger(2, 0));

        coords = Coordinates.fromInteger(10, 4);
        coords = coords.rotate90Degrees(TurnDirection.LEFT);
        assertEquals(coords, Coordinates.fromInteger(-4, 10));
        coords = coords.rotate90Degrees(TurnDirection.LEFT);
        assertEquals(coords, Coordinates.fromInteger(-10, -4));
        coords = coords.rotate90Degrees(TurnDirection.LEFT);
        assertEquals(coords, Coordinates.fromInteger(4, -10));
        coords = coords.rotate90Degrees(TurnDirection.LEFT);
        assertEquals(coords, Coordinates.fromInteger(10, 4));
    }
    
}
