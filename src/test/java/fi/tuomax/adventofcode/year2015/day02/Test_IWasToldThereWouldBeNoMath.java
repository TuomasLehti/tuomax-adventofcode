package fi.tuomax.adventofcode.year2015.day02;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import fi.tuomax.adventofcode.PuzzleTestCase;
import fi.tuomax.adventofcode.PuzzleTester;
import fi.tuomax.adventofcode.framework.solving.Metadata;

public class Test_IWasToldThereWouldBeNoMath 
extends PuzzleTester
{

    @Test
    public void test_Part1()
    {
        List<PuzzleTestCase> suite = fetchTestCases(new Metadata(2015, 2, 1, null, null));
        for (PuzzleTestCase testCase : suite) {
            IWasToldThereWouldBeNoMath_Solver part1 = new IWasToldThereWouldBeNoMath_Part1();
            part1.run(testCase.input());
            assertEquals(testCase.expectedAnswer(), part1.getAnswer());
        }
    }

    @Test
    public void test_Part2()
    {
        List<PuzzleTestCase> suite = fetchTestCases(new Metadata(2015, 2, 2, null, null));
        for (PuzzleTestCase testCase : suite) {
            IWasToldThereWouldBeNoMath_Solver part2 = new IWasToldThereWouldBeNoMath_Part2();
            part2.run(testCase.input());
            assertEquals(testCase.expectedAnswer(), part2.getAnswer());
        }
    }
    
}
