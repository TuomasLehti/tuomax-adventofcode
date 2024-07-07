package fi.tuomax.adventofcode.year2016.day09;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import fi.tuomax.adventofcode.PuzzleTestCase;
import fi.tuomax.adventofcode.PuzzleTester;
import fi.tuomax.adventofcode.framework.solving.Metadata;

public class Test_Decompressor 
extends PuzzleTester
{

    @Test
    public void testPart1()
    {
        List<PuzzleTestCase> tests = fetchTestCases(new Metadata(2016, 9, 1, null, null));
        Decompressor decompressor = new Decompressor();
        for (PuzzleTestCase test : tests) {
            assertEquals(
                test.input().get(0), 
                test.expectedAnswer(), 
                String.valueOf(decompressor.decompress(test.input().get(0))));
        }
    }

    @Test
    public void testPart2()
    {
        List<PuzzleTestCase> tests = fetchTestCases(new Metadata(2016, 9, 2, null, null));
        Decompressor decompressor = new RecursiveDecompressor();
        for (PuzzleTestCase test : tests) {
            assertEquals(
                test.input().get(0), 
                test.expectedAnswer(), 
                String.valueOf(decompressor.decompress(test.input().get(0))));
        }
    }

}
