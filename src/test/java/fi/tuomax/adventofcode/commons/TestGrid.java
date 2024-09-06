package fi.tuomax.adventofcode.commons;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestGrid 
{

    @Test
    public void testSubgrid()
    {
        Grid<Integer> big = new Grid<>(10, 10);
        for (int row = 0; row < 10; row++)
            for (int col = 0; col < 10; col++)
                big.set(col, row, col * row);
            
        Grid<Integer> small = big.subgrid(2, 2, 4, 4);
        assertEquals(4, (int) small.get(0, 0));
        assertEquals(6, (int) small.get(1, 0));
        assertEquals(8, (int) small.get(2, 0));
        assertEquals(6, (int) small.get(0, 1));
        assertEquals(9, (int) small.get(1, 1));
        assertEquals(12, (int) small.get(2, 1));
        assertEquals(8, (int) small.get(0, 2));
        assertEquals(12, (int) small.get(1, 2));
        assertEquals(16, (int) small.get(2, 2));
    }
    
}
