package fi.tuomax.adventofcode.year2015.day08;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import fi.tuomax.adventofcode.PuzzleTestCase;
import fi.tuomax.adventofcode.PuzzleTester;
import fi.tuomax.adventofcode.framework.solving.Metadata;

public class TestSantaString 
extends PuzzleTester
{

    @Test
    public void test_part1()
    {
        List<PuzzleTestCase> testCases = fetchTestCases(
            new Metadata(2015, 8, 1, "", "")
        );
        for (PuzzleTestCase testCase : testCases)
            assertEquals(Integer.valueOf(testCase.expectedAnswer()), SantaString.charsInMemory(testCase.input().get(0)));
    }

    @Test
    public void test_part2()
    {
        List<PuzzleTestCase> testCases = fetchTestCases(
            new Metadata(2015, 8, 2, "", "")
        );
        for (PuzzleTestCase testCase : testCases)
            assertEquals(Integer.valueOf(testCase.expectedAnswer()), SantaString.charsInLiteral(testCase.input().get(0)));
    }
    
}
