package fi.tuomax.adventofcode.year2017.day21;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fi.tuomax.adventofcode.commons.Coordinates;

public class Test_SparseBooleanGrid 
{

    @Test
    public void test_fromString()
    {
        final String INPUT = "../.#";
        SparseBooleanGrid grid = new SparseBooleanGrid(INPUT, "/", '#');
        assertEquals(2L, (long) grid.width());
        assertEquals(2L, (long) grid.height());
        assertNull(grid.get(Coordinates.fromInteger(0, 0)));
        assertNull(grid.get(Coordinates.fromInteger(1, 0)));
        assertNull(grid.get(Coordinates.fromInteger(0, -1)));
        assertTrue(grid.get(Coordinates.fromInteger(1, -1)));
    }

    @Test
    public void test_asString()
    {
        SparseBooleanGrid grid = new SparseBooleanGrid();
        grid.add(Coordinates.fromInteger(0, 0), null);
        grid.add(Coordinates.fromInteger(1, 0), null);
        grid.add(Coordinates.fromInteger(0, -1), null);
        grid.add(Coordinates.fromInteger(1, -1), true);
        assertEquals("../.#", grid.asString("#", ".", "", "/"));
    }

    @Test
    public void test_Equals()
    {
        SparseBooleanGrid one = new SparseBooleanGrid(".#./..#/###", "/", '#');
        SparseBooleanGrid other = new SparseBooleanGrid(".#./..#/###", "/", '#');
        assertTrue(one.equals(other));
    }

    
}
