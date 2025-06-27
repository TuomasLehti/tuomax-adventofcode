package fi.tuomax.adventofcode.commons;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Test_Coordinates3d 
{

    @Test
    public void test_TaxiCabDistance()
    {
        Coordinates3d coords = new Coordinates3d(1L, 2L, -3L);
        assertEquals(6L, (long) coords.taxiCabDistance());
    }

    @Test
    public void test_Translate()
    {
        Coordinates3d coords = new Coordinates3d(1L, 2L, -3L);
        Coordinates3d amount = new Coordinates3d(-2L, 0L, 5L);
        Coordinates3d expected = new Coordinates3d(-1L, 2L, 2L);
        assertEquals(expected, coords.translate(amount));
    }
    
}
