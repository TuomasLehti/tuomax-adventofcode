package fi.tuomax.adventofcode.year2015.day04;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import fi.tuomax.adventofcode.PuzzleTestCase;
import fi.tuomax.adventofcode.PuzzleTester;
import fi.tuomax.adventofcode.commons.MD5;
import fi.tuomax.adventofcode.framework.solving.Metadata;

public class TestMD5 
extends PuzzleTester
{

    @Test
    public void test()
    {
        final String PREFIX = "00000";
        List<PuzzleTestCase> suite = fetchTestCases(new Metadata(2015, 4, 1, null, null));
        for (PuzzleTestCase testCase : suite) {
            assertEquals(testCase.expectedAnswer(), MD5.getHash(testCase.input().get(0), PREFIX));
        }

    }
    
}
