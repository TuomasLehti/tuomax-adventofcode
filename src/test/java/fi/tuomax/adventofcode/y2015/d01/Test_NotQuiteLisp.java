package fi.tuomax.adventofcode.y2015.d01;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import fi.tuomax.adventofcode.PuzzleTestCase;
import fi.tuomax.adventofcode.PuzzleTester;
import fi.tuomax.adventofcode.framework.Metadata;

public class Test_NotQuiteLisp 
extends PuzzleTester
{

    @Test
    public void test_Part1()
    {
        List<PuzzleTestCase> suite = fetchTestCases(new Metadata(2015, 1, 1, null, null));
        for (PuzzleTestCase testCase : suite) {
            NotQuiteLisp_Part1 part1 = new NotQuiteLisp_Part1(testCase.input());
            part1.run();
            assertEquals(testCase.expectedAnswer(), part1.getAnswer());
        }
    }

    @Test
    public void test_Part2()
    {
        List<PuzzleTestCase> suite = fetchTestCases(new Metadata(2015, 1, 2, null, null));
        for (PuzzleTestCase testCase : suite) {
            NotQuiteLisp_Part2 part2 = new NotQuiteLisp_Part2(testCase.input());
            part2.run();
            assertEquals(testCase.expectedAnswer(), part2.getAnswer());
        }
    }
    
}
