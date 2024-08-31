package fi.tuomax.adventofcode.year2022.day03;

import org.junit.Test;

import fi.tuomax.adventofcode.PuzzleTester;

public class Test_RucksackReorganiztion 
extends PuzzleTester
{
    
    @Test
    public void test_Part1()
    {
        runTests(new RucksackReorganization_Solver_Part1());
    }

    @Test
    public void test_Part2()
    {
        runTests(new RucksackReorganization_Solver_Part2());
    }

}
