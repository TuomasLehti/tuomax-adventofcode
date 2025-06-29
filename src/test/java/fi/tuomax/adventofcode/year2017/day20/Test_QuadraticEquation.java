package fi.tuomax.adventofcode.year2017.day20;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Test_QuadraticEquation 
{

    @Test
    public void test()
    {
        QuadraticEquation qeq = QuadraticEquation.fromThreePoints(
            new Long[]{-3787L, -3741L, -3690L});
        
        assertArrayEquals(
            new float[]{-3787f, -3741f, -3690f, -3634f, -3573f, -3507f, -3436f},
            new float[]{
                qeq.getY(0),
                qeq.getY(1),
                qeq.getY(2),
                qeq.getY(3),
                qeq.getY(4),
                qeq.getY(5),
                qeq.getY(6),
            },
            0.001f);
    }

    @Test
    public void test_NumOfSolutions()
    {
        assertEquals(2, new QuadraticEquation(1f, -5f, 6f).numOfRealSolutions());
        assertEquals(1, new QuadraticEquation(1f, -6f, 9f).numOfRealSolutions());
        assertEquals(0, new QuadraticEquation(1f, 4f, 5f).numOfRealSolutions());
    }

    @Test
    public void test_Solutions()
    {
        QuadraticEquation qeq = new QuadraticEquation(1f, -5f, 6f);
        assertTrue( 
            qeq.getSolutions().contains(
                (5 + (float) Math.sqrt(-5 * -5 - 4 * 1 * 6)) / 2
            )
        );
        assertTrue( 
            qeq.getSolutions().contains(
                (5 - (float) Math.sqrt(-5 * -5 - 4 * 1 * 6)) / 2
            )
        );
    }

    @Test
    public void test_Solutions_NoQuadraticTerm() 
    {
        QuadraticEquation qeq = new QuadraticEquation(0f, 5f, 5f);
        assertEquals(1, qeq.getSolutions().size());
        assertTrue(qeq.getSolutions().contains(-1f));
    }

    @Test
    public void test_StraightLine()
    {
        QuadraticEquation qeq = new QuadraticEquation(0f, 5f, 5f);
        assertTrue(qeq.isStraightLine());
        assertFalse(qeq.isHorizontalLine());
    }

    @Test
    public void test_HorizontalLine()
    {
        QuadraticEquation qeq = new QuadraticEquation(0f, 0f, 5f);
        assertTrue(qeq.isStraightLine());
        assertTrue(qeq.isHorizontalLine());
    }

    @Test
    public void test_Intersects()
    {
        assertTrue(
            new QuadraticEquation(1, 0, 0).intersects(
                new QuadraticEquation(-1, 0, 4)
            )
        );
        assertTrue(
            new QuadraticEquation(1, 0, 0).intersects(
                new QuadraticEquation(-1, 0, 0)
            )
        );
        assertFalse(
            new QuadraticEquation(1, 0, 0).intersects(
                new QuadraticEquation(2, 0, 4)
            )
        );
    }
    
}
