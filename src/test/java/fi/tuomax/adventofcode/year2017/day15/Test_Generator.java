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

    @Test
    public void test_calculation_part2()
    {
        Generator a = new Generator_Part2(65L, 16807L, 4L);
        assertEquals(   1352636452L, (long) a.calculate());
        assertEquals(1992081072L, (long) a.calculate());
        assertEquals( 530830436L, (long) a.calculate());
        assertEquals(1980017072L, (long) a.calculate());
        assertEquals(740335192L, (long) a.calculate());
    }
    
}


 

 