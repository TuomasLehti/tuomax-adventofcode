package fi.tuomax.adventofcode.commons;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class TestRange 
{

    @Test
    public void testGetLength()
    {
        Range range = new Range(0L, 9L);
        assertEquals(10L, (long) range.getLength());
    }

    @Test
    public void testContains()
    {
        Range range = new Range(0L, 9L);
        assertFalse(range.contains(-9L));
        assertFalse(range.contains(-1L));
        assertTrue(range.contains(0L));
        assertTrue(range.contains(3L));
        assertTrue(range.contains(9L));
        assertFalse(range.contains(10L));
        assertFalse(range.contains(19L));
    }

    @Test
    public void testSplitBefore()
    {
        Range range = new Range(0L, 9L);
        List<Range> parts; 
        
        // Split normally
        parts = range.splitBefore(5L);
        assertEquals(0L, (long) parts.get(0).getStart());
        assertEquals(4L, (long) parts.get(0).getEnd());
        assertEquals(5L, (long) parts.get(1).getStart());
        assertEquals(9L, (long) parts.get(1).getEnd());
    }

    @Test
    public void testSplitAfter()
    {
        Range range = new Range(0L, 9L);
        List<Range> parts; 
        
        // Split normally
        parts = range.splitAfter(5L);
        assertEquals(0L, (long) parts.get(0).getStart());
        assertEquals(5L, (long) parts.get(0).getEnd());
        assertEquals(6L, (long) parts.get(1).getStart());
        assertEquals(9L, (long) parts.get(1).getEnd());
    }

    @Test
    public void testEquals()
    {
        Range range = new Range(0L, 9L);
        Range equal = new Range(0L, 9L);
        Range inequal = new Range(1L, 10L);
        assertEquals(equal, range);
        assertEquals(range, equal);
        assertNotEquals(inequal, range);
        assertNotEquals(range, inequal);
    }
    
}
