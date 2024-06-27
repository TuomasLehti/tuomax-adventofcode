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
    
}
