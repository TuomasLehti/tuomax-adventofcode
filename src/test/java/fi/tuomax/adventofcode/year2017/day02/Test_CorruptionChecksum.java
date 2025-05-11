package fi.tuomax.adventofcode.year2017.day02;

import org.junit.Test;

import fi.tuomax.adventofcode.PuzzleTester;

public class Test_CorruptionChecksum
extends PuzzleTester
{

    @Test
    public void test_Part1()
    {
        runTests(new CorruptionChecksum_Part1());
    }

    @Test
    public void test_Part2()
    {
        runTests(new CorruptionChecksum_Part2());
    }

}
