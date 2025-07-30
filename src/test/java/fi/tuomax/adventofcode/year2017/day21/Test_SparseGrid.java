package fi.tuomax.adventofcode.year2017.day21;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fi.tuomax.adventofcode.commons.Coordinates;
import fi.tuomax.adventofcode.commons.SparseGrid;
import fi.tuomax.adventofcode.commons.Direction.TurnDirection;

public class Test_SparseGrid 
{

    @Test
    public void test_Copy()
    {
        SparseGrid<Integer> grid = new SparseGrid<>();
        grid.add(Coordinates.fromInteger(0, 0), 1);
        grid.add(Coordinates.fromInteger(2, 0), 2);
        grid.add(Coordinates.fromInteger(0, 2), 3);
        grid.add(Coordinates.fromInteger(2, 2), 4);
        SparseGrid<Integer> copy = grid.copy();
        assertEquals(1, (int) copy.get(Coordinates.fromInteger(0, 0)));
        assertEquals(2, (int) copy.get(Coordinates.fromInteger(2, 0)));
        assertEquals(3, (int) copy.get(Coordinates.fromInteger(0, 2)));
        assertEquals(4, (int) copy.get(Coordinates.fromInteger(2, 2)));
    }

    @Test
    public void test_Translate()
    {
        SparseGrid<Integer> grid = new SparseGrid<>();
        grid.add(Coordinates.fromInteger(0, 0), 1);
        grid.add(Coordinates.fromInteger(2, 0), 2);
        grid.add(Coordinates.fromInteger(0, 2), 3);
        grid.add(Coordinates.fromInteger(2, 2), 4);
        grid.translate(Coordinates.fromInteger(-5, -5));
        assertEquals(1, (int) grid.get(Coordinates.fromInteger(-5, -5)));
        assertEquals(2, (int) grid.get(Coordinates.fromInteger(-3, -5)));
        assertEquals(3, (int) grid.get(Coordinates.fromInteger(-5, -3)));
        assertEquals(4, (int) grid.get(Coordinates.fromInteger(-3, -3)));
    }

    @Test
    public void test_Rotate()
    {
        SparseGrid<Integer> grid = new SparseGrid<>();
        grid.add(Coordinates.fromInteger(0, 0), 1);
        grid.add(Coordinates.fromInteger(2, 0), 2);
        grid.add(Coordinates.fromInteger(0, -2), 3);
        grid.add(Coordinates.fromInteger(2, -2), 4);
        grid.rotate(TurnDirection.RIGHT);
        assertEquals(3, (int) grid.get(Coordinates.fromInteger(0, 0)));
        assertEquals(1, (int) grid.get(Coordinates.fromInteger(2, 0)));
        assertEquals(4, (int) grid.get(Coordinates.fromInteger(0, -2)));
        assertEquals(2, (int) grid.get(Coordinates.fromInteger(2, -2)));

        /*
         * 1.2          3.1
         * 3.4          4.2
         */
    }

    @Test
    public void test_Rotate_Bug()
    {
        SparseGrid<Boolean> grid = new SparseGrid<>();
        grid.add(Coordinates.fromInteger(0,0), true);
        grid.add(Coordinates.fromInteger(1,0), null);
        grid.add(Coordinates.fromInteger(0, -1), null);
        grid.add(Coordinates.fromInteger(1, -1), null);

        grid.rotate(TurnDirection.RIGHT);
        assertNull(grid.get(Coordinates.fromInteger(0, 0)));
        assertTrue(grid.get(Coordinates.fromInteger(1, 0)));
        assertNull(grid.get(Coordinates.fromInteger(0, -1)));
        assertNull(grid.get(Coordinates.fromInteger(1, -1)));

        grid.rotate(TurnDirection.RIGHT);
        assertNull(grid.get(Coordinates.fromInteger(0, 0)));
        assertNull(grid.get(Coordinates.fromInteger(1, 0)));
        assertNull(grid.get(Coordinates.fromInteger(0, -1)));
        assertTrue(grid.get(Coordinates.fromInteger(1, -1)));

        grid.rotate(TurnDirection.RIGHT);
        assertNull(grid.get(Coordinates.fromInteger(0, 0)));
        assertNull(grid.get(Coordinates.fromInteger(1, 0)));
        assertTrue(grid.get(Coordinates.fromInteger(0, -1)));
        assertNull(grid.get(Coordinates.fromInteger(1, -1)));

        grid.rotate(TurnDirection.RIGHT);
        assertTrue(grid.get(Coordinates.fromInteger(0, 0)));
        assertNull(grid.get(Coordinates.fromInteger(1, 0)));
        assertNull(grid.get(Coordinates.fromInteger(0, -1)));
        assertNull(grid.get(Coordinates.fromInteger(1, -1)));
    }

    @Test
    public void test_ReflectHorizontally()
    {
        SparseGrid<Integer> grid = new SparseGrid<>();
        grid.add(Coordinates.fromInteger(0, 0), 1);
        grid.add(Coordinates.fromInteger(2, 0), 2);
        grid.add(Coordinates.fromInteger(0, -2), 3);
        grid.add(Coordinates.fromInteger(2, -2), 4);
        grid.reflectHorizontally();
        assertEquals(2, (int) grid.get(Coordinates.fromInteger(0, 0)));
        assertEquals(1, (int) grid.get(Coordinates.fromInteger(2, 0)));
        assertEquals(4, (int) grid.get(Coordinates.fromInteger(0, -2)));
        assertEquals(3, (int) grid.get(Coordinates.fromInteger(2, -2)));
    }

    @Test
    public void test_ReflectHorizontally_Bug()
    {
        SparseGrid<Boolean> grid = new SparseGrid<>();
        grid.add(Coordinates.fromInteger(0,0), true);
        grid.add(Coordinates.fromInteger(1,0), null);
        grid.add(Coordinates.fromInteger(0, -1), null);
        grid.add(Coordinates.fromInteger(1, -1), null);

        grid.reflectHorizontally();
        assertNull(grid.get(Coordinates.fromInteger(0, 0)));
        assertTrue(grid.get(Coordinates.fromInteger(1, 0)));
        assertNull(grid.get(Coordinates.fromInteger(0, -1)));
        assertNull(grid.get(Coordinates.fromInteger(1, -1)));
    }
    
}
