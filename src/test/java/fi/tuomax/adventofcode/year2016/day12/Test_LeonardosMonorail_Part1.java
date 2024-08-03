package fi.tuomax.adventofcode.year2016.day12;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.Test;

import fi.tuomax.adventofcode.PuzzleTester;
import fi.tuomax.adventofcode.framework.inputting.InputFactory;

public class Test_LeonardosMonorail_Part1 
extends PuzzleTester
{

    @Test
    public void test_Part1()
    {
        try {
            LeonardosMonorail_Part1 solver = new LeonardosMonorail_Part1();
            solver.run(InputFactory.inputFromMetadata(solver.getMetadata(), "test.txt"));
            assertEquals("42", solver.getAnswer());
        } catch (IOException e) {
            fail(e.getMessage());
        }

    }
    
}
