package fi.tuomax.adventofcode.year2016.day18;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import fi.tuomax.adventofcode.PuzzleTestCase;
import fi.tuomax.adventofcode.PuzzleTester;
import fi.tuomax.adventofcode.framework.solving.Metadata;

public class Test_Trap 
extends PuzzleTester
{

    @Test
    public void test()
    {
        List<PuzzleTestCase> tests = fetchTestCases(new Metadata(2016, 18, 1, null, null));
        for (PuzzleTestCase test : tests) {
            Trap tarp = new Trap(test.input().get(0));
            assertEquals(test.expectedAnswer(), tarp.getNext());
        }
    }
    
}
