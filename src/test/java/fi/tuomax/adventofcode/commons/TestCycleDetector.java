package fi.tuomax.adventofcode.commons;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import fi.tuomax.adventofcode.commons.CycleDetector.CycleData;

public class TestCycleDetector 
{

    @Test
    public void test_IsRepeating() 
    {
        List<Integer> ints = Arrays.asList(new Integer[]{1, 1});
        assertTrue(CycleDetector.isRepeating(ints, 0, 1));
    }

    @Test
    public void test_IsRepeating_WhenNotRepeating()
    {
        List<Integer> ints = Arrays.asList(new Integer[]{1, 2});
        assertFalse(CycleDetector.isRepeating(ints, 0, 1));
    }

    @Test
    public void test_IsRepeating_WhenIsRepeating_CycleLengtOfTwo()
    {
        List<Integer> ints = Arrays.asList(new Integer[]{1, 2, 1, 2});
        assertTrue(CycleDetector.isRepeating(ints, 0, 2));
    }

    @Test
    public void test_IsRepeating_WhenNotRepeating_CycleLengthOfTwo()
    {
        List<Integer> ints = Arrays.asList(new Integer[]{1, 2, 3, 4});
        assertFalse(CycleDetector.isRepeating(ints, 0, 2));
    }

    @Test
    public void test_IsRepeating_WhenRepeating_IncompleteLastCycle()
    {
        List<Integer> ints = Arrays.asList(new Integer[]{1, 2, 3, 4, 1, 2, 3, 4, 1, 2, 3});
        assertFalse(CycleDetector.isRepeating(ints, 0, 4));
    }

    @Test
    public void test_IsRepeating_WhenNotRepeating_IncompleteLastCycle()
    {
        List<Integer> ints = Arrays.asList(new Integer[]{1, 2, 3, 4, 1, 2, 3, 4, 1, 2, 5});
        assertFalse(CycleDetector.isRepeating(ints, 0, 4));
    }

    @Test
    public void test_IsRepeating_WhenNotRepeating_Offset()
    {
        List<Integer> ints = Arrays.asList(new Integer[]{1, 2, 3, 4});
        assertFalse(CycleDetector.isRepeating(ints, 1, 1));
    }

    @Test
    public void test_IsRepeating_WhenNotRepeating_Offset_ConsumesEverything()
    {
        List<Integer> ints = Arrays.asList(new Integer[]{1, 2, 3, 4});
        assertFalse(CycleDetector.isRepeating(ints, 1, 3));
    }

    @Test
    public void test_NoElements()
    {
        try {
            CycleDetector.detect(Arrays.asList(new Integer[]{}));
            fail("No exception thrown.");
        } catch (IllegalArgumentException e) {
            assert(true);
        }
    }

    @Test
    public void test_OnlyOneElement()
    {
        try {
            CycleDetector.detect(Arrays.asList(new Integer[]{ 1 }));
            fail("No exception thrown.");
        } catch (IllegalArgumentException e) {
            assert(true);
        }
    }

    @Test
    public void test_CycleLengthOfOne()
    {
        CycleData d = CycleDetector.detect(Arrays.asList(new Integer[]{ 1, 1 }));
        assertEquals(0, (long) d.start());
        assertEquals(1, (long) d.length());
    }

    @Test
    public void test_CycleLengthOfTwo()
    {
        CycleData d = CycleDetector.detect(Arrays.asList(new Integer[]{ 1, 2, 1, 2 }));
        assertEquals(0, (long) d.start());
        assertEquals(2, (long) d.length());
    }

    @Test
    public void test_CycleNotDetected()
    {
        CycleData d = CycleDetector.detect(Arrays.asList(new Integer[]{ 1, 2, 3, 4 }));
        assertEquals(-1, (long) d.start());
        assertEquals(-1, (long) d.length());
    }

    @Test
    public void test_CycleLengthOfTwo_RepeatedSeveralTimes()
    {
        CycleData d = CycleDetector.detect(Arrays.asList(new Integer[]{ 1, 2, 1, 2, 1, 2, 1, 2 }));
        assertEquals(0L, (long) d.start());
        assertEquals(2L, (long) d.length());
    }

    @Test
    public void test_Offset()
    {
        CycleData d = CycleDetector.detect(Arrays.asList(new Integer[]{ 1, 2, 3, 4, 2, 3, 4, 2, 3, 4 }));
        assertEquals(1L, (long) d.start());
        assertEquals(3L, (long) d.length());
    }

    @Test
    public void test_Offset_NoCycle()
    {
        CycleData d = CycleDetector.detect(Arrays.asList(new Integer[]{ 1, 2, 3, 4, 2, 3, 4, 2, 3, 5, 6, 8 }));
        assertEquals(-1L, (long) d.start());
        assertEquals(-1L, (long) d.length());
    }

    @Test
    public void test_Offset_IncompleteCycle_Cycles()
    {
        CycleData d = CycleDetector.detect(Arrays.asList(new Integer[]{ 1, 2, 3, 4, 2, 3, 4, 2, 3, 4, 2, 3 }));
        assertEquals(-1L, (long) d.start());
        assertEquals(-1L, (long) d.length());
    }

    @Test
    public void test_Offset_IncompleteCycle_DoesNotCycle()
    {
        CycleData d = CycleDetector.detect(Arrays.asList(new Integer[]{ 1, 2, 3, 4, 2, 3, 4, 2, 3, 4, 2, 5 }));
        assertEquals(-1L, (long) d.start());
        assertEquals(-1L, (long) d.length());
    }
    
}
