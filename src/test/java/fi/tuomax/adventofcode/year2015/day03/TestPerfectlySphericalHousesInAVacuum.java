package fi.tuomax.adventofcode.year2015.day03;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import fi.tuomax.adventofcode.PuzzleTestCase;
import fi.tuomax.adventofcode.PuzzleTester;
import fi.tuomax.adventofcode.framework.solving.Metadata;

public class TestPerfectlySphericalHousesInAVacuum 
extends PuzzleTester
{

    @Test
    public void part1()
    {
        List<PuzzleTestCase> suite = fetchTestCases(new Metadata(2015, 3, 1, null, null));
        for (PuzzleTestCase testCase : suite) {
            PerfectlySphericalHousesInAVacuum_Part1 part1 = new PerfectlySphericalHousesInAVacuum_Part1();
            part1.run(testCase.input());
            assertEquals(testCase.expectedAnswer(), part1.getAnswer());
        }
    }

    @Test
    public void part2()
    {
        List<PuzzleTestCase> suite = fetchTestCases(new Metadata(2015, 3, 2, null, null));
        for (PuzzleTestCase testCase : suite) {
            PerfectlySphericalHousesInAVacuum_Part2 part1 = new PerfectlySphericalHousesInAVacuum_Part2();
            part1.run(testCase.input());
            assertEquals(testCase.expectedAnswer(), part1.getAnswer());
        }
    }
    
}
