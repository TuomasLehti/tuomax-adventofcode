package fi.tuomax.adventofcode.commons;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class Test_CycleDetector_HasRepeats 
{

    @Test
    public void test_HasRepeats()
    {
        List<Integer> ints = Arrays.asList(new Integer[]{1, 2, 1, 2});
        assertTrue(CycleDetector.hasRepeats(ints, 0));
    }

    @Test
    public void test_NoRepeats()
    {
        List<Integer> ints = Arrays.asList(new Integer[]{1, 2, 3, 4});
        assertFalse(CycleDetector.hasRepeats(ints, 0));
    }

    @Test
    public void test_HasRepeats_OddLength()
    {
        List<Integer> ints = Arrays.asList(new Integer[]{1, 2, 1});
        assertFalse(CycleDetector.hasRepeats(ints, 0));
    }

    @Test
    public void test_NoRepeats_OddLength()
    {
        List<Integer> ints = Arrays.asList(new Integer[]{1, 2, 3});
        assertFalse(CycleDetector.hasRepeats(ints, 0));
    }

    @Test
    public void test_Offset_HasRepeats()
    {
        List<Integer> ints = Arrays.asList(new Integer[]{0, 1, 2, 1, 2});
        assertTrue(CycleDetector.hasRepeats(ints, 1));
    }

    @Test
    public void test_Offset_NoRepeats()
    {
        List<Integer> ints = Arrays.asList(new Integer[]{0, 1, 2, 3, 4});
        assertFalse(CycleDetector.hasRepeats(ints, 1));
    }

    @Test
    public void test_Offset_HasRepeats_OddLength()
    {
        List<Integer> ints = Arrays.asList(new Integer[]{0, 1, 2, 1});
        assertFalse(CycleDetector.hasRepeats(ints, 1));
    }

    @Test
    public void test_Offset_NoRepeats_OddLength()
    {
        List<Integer> ints = Arrays.asList(new Integer[]{0, 1, 2, 2});
        assertFalse(CycleDetector.hasRepeats(ints, 1));
    }
    
}
