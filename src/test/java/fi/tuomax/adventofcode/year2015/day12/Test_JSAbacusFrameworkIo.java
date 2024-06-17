package fi.tuomax.adventofcode.year2015.day12;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import fi.tuomax.adventofcode.PuzzleTestCase;
import fi.tuomax.adventofcode.PuzzleTester;
import fi.tuomax.adventofcode.framework.solving.Solver;

public class Test_JSAbacusFrameworkIo 
extends PuzzleTester
{

    @Test
    public void testPart1()
    {
        runTests(new JSAbacusFrameworkIo_Part1());
    }

    @Test
    public void testPart2()
    {
        runTests(new JSAbacusFrameworkIo_Part2());
    }
    
    public void runTests(Solver solver)
    {
        List<PuzzleTestCase> suite = fetchTestCases(solver.getMetadata());
        for (PuzzleTestCase testCase : suite) {
            solver.run(testCase.input());
            assertEquals(testCase.expectedAnswer(), solver.getAnswer());
        }

    }

}
