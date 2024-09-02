package fi.tuomax.adventofcode.year2016.day14;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.Test;

import fi.tuomax.adventofcode.PuzzleTester;
import fi.tuomax.adventofcode.framework.inputting.InputFactory;

public class Test_OnetimePad 
extends PuzzleTester
{

    @Test
    public void testPart1()
    {
        try {
            OnetimePad_Part1 solver = new OnetimePad_Part1();
            solver.setParameters(readJsonFile(solver.getMetadata(), "parameters.json"));
            solver.run(InputFactory.inputFromMetadata(solver.getMetadata(), "test.txt"));
            assertEquals("22728", solver.getAnswer());
        } catch (IOException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testPart2()
    {
        try {
            OnetimePad_Part2 solver = new OnetimePad_Part2();
            solver.setParameters(readJsonFile(solver.getMetadata(), "parameters.json"));
            solver.run(InputFactory.inputFromMetadata(solver.getMetadata(), "test.txt"));
            assertEquals("22551", solver.getAnswer());
        } catch (IOException e) {
            fail(e.getMessage());
        }
    }
    
}
