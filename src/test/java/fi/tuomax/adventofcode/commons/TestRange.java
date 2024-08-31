package fi.tuomax.adventofcode.commons;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;

public class TestRange 
{

    @Test
    public void testMalformation()
    {
        try {
            @SuppressWarnings("unused")
            Range range = new Range(9L, 0L);
            fail("No expected exception.");
        } catch (IllegalArgumentException e) {
            assert(true);
        }
    }

    @Test
    public void testGetLength()
    {
        Range range = new Range(0L, 9L);
        assertEquals(10L, (long) range.getLength());
    }

    @Test
    public void testGetLengthOfOne()
    {
        Range range = new Range(1L, 1L);
        assertEquals(1L, (long) range.getLength());
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
    public void testContainsRange()
    {
        Range range = new Range(10L, 20L);
        assertTrue(range.contains(new Range(12L, 17L)));
        assertTrue(range.contains(new Range(10L, 17L)));
        assertTrue(range.contains(new Range(12L, 20L)));
        assertTrue(range.contains(new Range(10L, 20L)));
        assertFalse(range.contains(new Range(9L, 15L)));
        assertFalse(range.contains(new Range(15L, 21L)));
        assertFalse(range.contains(new Range(9L, 21L)));
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

        // Edge case: split before start
        parts = range.splitBefore(0L);
        assertEquals(0L, (long) parts.get(0).getStart());
        assertEquals(9L, (long) parts.get(0).getEnd());

        // Range doesn't contain index
        parts = range.splitBefore(99L);
        assertEquals(0L, (long) parts.get(0).getStart());
        assertEquals(9L, (long) parts.get(0).getEnd());

        // Edge case: index is one greater than range end
        parts = range.splitBefore(10L);
        assertEquals(0L, (long) parts.get(0).getStart());
        assertEquals(9L, (long) parts.get(0).getEnd());
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

        // Edge case: split after end
        parts = range.splitAfter(9L);
        assertEquals(0L, (long) parts.get(0).getStart());
        assertEquals(9L, (long) parts.get(0).getEnd());

        // Range doesn't contain index
        parts = range.splitAfter(-99L);
        assertEquals(0L, (long) parts.get(0).getStart());
        assertEquals(9L, (long) parts.get(0).getEnd());

        // Edge case: index is one less than range start
        parts = range.splitBefore(10L);
        assertEquals(0L, (long) parts.get(0).getStart());
        assertEquals(9L, (long) parts.get(0).getEnd());
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

    @Test
    public void testOverlaps()
    {
        Range range = new Range(10L, 20L);
        assertFalse(range.overlaps(new Range(0L, 5L)));
        assertTrue(range.overlaps(new Range(5L, 10L)));
        assertTrue(range.overlaps(new Range(5L, 15L)));
        assertTrue(range.overlaps(new Range(5L, 25L)));
        assertTrue(range.overlaps(new Range(15L, 25L)));
        assertTrue(range.overlaps(new Range(20L, 25L)));
        assertTrue(range.overlaps(new Range(5L, 25L)));
        assertTrue(range.overlaps(new Range(14L, 16L)));
        assertFalse(range.overlaps(new Range(25L, 30L)));
    }

    @Test
    public void testSplit()
    {
        Range range = new Range(10L, 20L);
        List<Range> split;

        split = range.split(new Range(0L, 5L));
        assertEquals(null, split.get(0));
        assertEquals(null, split.get(1));
        assertEquals(new Range(10L, 20L), split.get(2));

        split = range.split(new Range(0L, 15L));
        assertEquals(null, split.get(0));
        assertEquals(new Range(10L, 15L), split.get(1));
        assertEquals(new Range(16L, 20L), split.get(2));

        split = range.split(new Range(15L, 30L));
        assertEquals(new Range(10L, 14L), split.get(0));
        assertEquals(new Range(15L, 20L), split.get(1));
        assertEquals(null, split.get(2));

        split = range.split(new Range(25L, 30L));
        assertEquals(new Range(10L, 20L), split.get(0));
        assertEquals(null, split.get(1));
        assertEquals(null, split.get(2));

        split = range.split(new Range(0L, 30L));
        assertEquals(null, split.get(0));
        assertEquals(new Range(10L, 20L), split.get(1));
        assertEquals(null, split.get(2));

        split = range.split(new Range(14L, 16L));
        assertEquals(new Range(10L, 13L), split.get(0));
        assertEquals(new Range(14L, 16L), split.get(1));
        assertEquals(new Range(17L, 20L), split.get(2));
    }

    @Test
    public void testSplit_EqualStarts()
    {
        Range range = new Range(0L, 4L);
        Range other = new Range(0L, 2L);
        assertEquals(null, range.split(other).get(0));
        assertEquals(new Range(0L, 2L), range.split(other).get(1));
        assertEquals(new Range(3L, 4L), range.split(other).get(2));
    }
    
}
