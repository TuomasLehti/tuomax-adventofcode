package fi.tuomax.adventofcode.year2016.day05;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fi.tuomax.adventofcode.PuzzleTester;
import fi.tuomax.adventofcode.framework.inputting.InputFactory;

public class Test_HowAboutANiceGameOfChess 
extends PuzzleTester
{

    @Test
    public void test_Part1()
    {
        HowAboutANiceGameOfChess_Part1 solver = new HowAboutANiceGameOfChess_Part1();
        readJson(solver.getMetadata(), "tests.json");
        solver.run(InputFactory.inputFromString(json.getString("seed")));
        assertEquals(json.getString("answer_part1"), solver.getAnswer());
    }

    @Test
    public void test_Part2()
    {
        HowAboutANiceGameOfChess_Part2 solver = new HowAboutANiceGameOfChess_Part2();
        readJson(solver.getMetadata(), "tests.json");
        solver.run(InputFactory.inputFromString(json.getString("seed")));
        assertEquals(json.getString("answer_part2"), solver.getAnswer());
    }
    
}
