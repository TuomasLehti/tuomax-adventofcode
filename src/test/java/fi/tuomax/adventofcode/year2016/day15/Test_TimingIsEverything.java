package fi.tuomax.adventofcode.year2016.day15;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.Test;

import fi.tuomax.adventofcode.PuzzleTester;
import fi.tuomax.adventofcode.framework.inputting.InputFactory;

public class Test_TimingIsEverything 
extends PuzzleTester
{

    @Test
    public void test()
    {
        try {
            TimingIsEverything_Part1 solver = new TimingIsEverything_Part1();
            solver.run(InputFactory.inputFromMetadata(solver.getMetadata(), "test.txt"));
            assertEquals("5", solver.getAnswer());
        } catch (IOException e) {
            fail(e.getMessage());
        }
    }
    
}
