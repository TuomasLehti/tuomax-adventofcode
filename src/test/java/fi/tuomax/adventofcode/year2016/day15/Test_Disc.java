package fi.tuomax.adventofcode.year2016.day15;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Test_Disc 
{

    @Test
    public void test_FromInput()
    {
        Disc disc = Disc.fromInput("Disc #1 has 5 positions; at time=0, it is at position 4.");
        assertEquals(5, (int) disc.numOfPositions());
        assertEquals(4, (int) disc.startPosition());
    }

    @Test
    public void test_PositionAt()
    {
        Disc disc = Disc.fromInput("Disc #1 has 5 positions; at time=0, it is at position 4.");
        assertEquals(4, (int) disc.positionAt(0));
        assertEquals(0, (int) disc.positionAt(1));
        assertEquals(1, (int) disc.positionAt(2));
        assertEquals(2, (int) disc.positionAt(3));
        assertEquals(3, (int) disc.positionAt(4));
        assertEquals(4, (int) disc.positionAt(5));
        assertEquals(0, (int) disc.positionAt(6));
    }
    
}
