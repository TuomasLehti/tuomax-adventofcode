package fi.tuomax.adventofcode.year2016.day01;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import fi.tuomax.adventofcode.PuzzleTestCase;
import fi.tuomax.adventofcode.PuzzleTester;
import fi.tuomax.adventofcode.framework.solving.Solver;

public class Test_NoTimeForTaxicab_Part1 
extends PuzzleTester
{

    @Test
    public void test()
    {
        Solver solver = new NoTimeForATaxicab_Part1();
        List<PuzzleTestCase> suite = fetchTestCases(solver.getMetadata());
        for (PuzzleTestCase testCase : suite) {
            solver.run(testCase.input());
            assertEquals(testCase.expectedAnswer(), solver.getAnswer());
        }
    }

    @Test
    public void testPart2()
    {
        Solver solver = new NoTimeForATaxicab_Part2();
        List<PuzzleTestCase> suite = fetchTestCases(solver.getMetadata());
        for (PuzzleTestCase testCase : suite) {
            solver.run(testCase.input());
            assertEquals(testCase.expectedAnswer(), solver.getAnswer());
        }

    }
    
}
