package fi.tuomax.adventofcode.commons;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fi.tuomax.adventofcode.commons.Direction.TurnDirection;

public class TestDirection 
{

    @Test
    public void test_TurnRight_FourDirMode()
    {
        Direction direction = Direction.getInstance();
        assertEquals(
            Direction.getInstance(Direction.EAST), 
            direction.turn(TurnDirection.RIGHT));
        assertEquals(
            Direction.getInstance(Direction.SOUTH), 
            direction.turn(TurnDirection.RIGHT));
        assertEquals(
            Direction.getInstance(Direction.WEST), 
            direction.turn(TurnDirection.RIGHT));
        assertEquals(
            Direction.getInstance(Direction.NORTH), 
            direction.turn(TurnDirection.RIGHT));
    }

    @Test
    public void test_GetInstance()
    {
        assertEquals(Direction.NORTH, Direction.getInstance(Direction.NORTH).get());
        assertEquals(Direction.NORTHEAST, Direction.getInstance(Direction.NORTHEAST).get());
        assertEquals(Direction.EAST, Direction.getInstance(Direction.EAST).get());
        assertEquals(Direction.SOUTHEAST, Direction.getInstance(Direction.SOUTHEAST).get());
        assertEquals(Direction.SOUTH, Direction.getInstance(Direction.SOUTH).get());
        assertEquals(Direction.SOUTHWEST, Direction.getInstance(Direction.SOUTHWEST).get());
        assertEquals(Direction.WEST, Direction.getInstance(Direction.WEST).get());
        assertEquals(Direction.NORTHWEST, Direction.getInstance(Direction.NORTHWEST).get());
    }
    
}
