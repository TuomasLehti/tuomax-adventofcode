package fi.tuomax.adventofcode.year2024.day02;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

import fi.tuomax.adventofcode.PuzzleTester;

public class Test_RednosedReports
extends PuzzleTester
{

    @Test
    public void test_Safeness()
    {

        assertTrue(ReportEvaluator.isSafe(Arrays.asList(new Integer[]{1,2,3,4,5})));
        assertTrue(ReportEvaluator.isSafe(Arrays.asList(new Integer[]{1,3,5,7,9})));
        assertFalse(ReportEvaluator.isSafe(Arrays.asList(new Integer[]{1,2,7,8,9})));

        assertTrue(ReportEvaluator.isSafe(Arrays.asList(new Integer[]{5,4,3,2,1})));
        assertTrue(ReportEvaluator.isSafe(Arrays.asList(new Integer[]{9,7,5,3,1})));
        assertFalse(ReportEvaluator.isSafe(Arrays.asList(new Integer[]{9,8,7,2,1})));

        assertFalse(ReportEvaluator.isSafe(Arrays.asList(new Integer[]{1,2,4,2,1})));


    }

    @Test
    public void test_Safeness_WhenSameLevel()
    {
        assertFalse(ReportEvaluator.isSafe(Arrays.asList(new Integer[]{8,6,4,4,1})));

    }

    @Test
    public void test_Part1()
    {
        runTests(new RednosedReports_Part1());
    }

    @Test
    public void test_Part2()
    {
        runTests(new RednosedReports_Part2());
    }

}
