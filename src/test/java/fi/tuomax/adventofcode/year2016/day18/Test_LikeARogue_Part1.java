package fi.tuomax.adventofcode.year2016.day18;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.Test;

import fi.tuomax.adventofcode.PuzzleTester;
import fi.tuomax.adventofcode.framework.inputting.InputFactory;

public class Test_LikeARogue_Part1 
extends PuzzleTester
{

    @Test
    public void test() 
    {
        try {
            LikeARogue_Part1 solver = new LikeARogue_Part1();
            solver.setParameters(readJsonFile(solver.getMetadata(), "test parameters.json"));
            solver.run(InputFactory.inputFromMetadata(solver.getMetadata(), "test.txt"));
            assertEquals("38", solver.getAnswer());
        } catch (IOException e) {
            fail(e.toString());
        }
    }
    
}
