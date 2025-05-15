package fi.tuomax.adventofcode.year2017.day15;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Test_Generator 
{

    @Test
    public void test_calculation()
    {
        Generator a = new Generator(65L, 16807L);
        assertEquals(   1092455L, (long) a.calculate());
        assertEquals(1181022009L, (long) a.calculate());
        assertEquals( 245556042L, (long) a.calculate());
        assertEquals(1744312007L, (long) a.calculate());
        assertEquals(1352636452L, (long) a.calculate());
    }
    
}
