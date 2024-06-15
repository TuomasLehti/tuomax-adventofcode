package fi.tuomax.adventofcode.year2015.day09;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.Test;

import fi.tuomax.adventofcode.framework.inputting.InputFactory;
import fi.tuomax.adventofcode.framework.solving.Solver;

public class Test_AllInASingleNight 
{

    @Test
    public void testPart1() {
        try {
            Solver solver = new AllInASingleNight_Part1();
            solver.run(InputFactory.inputFromMetadata(solver.getMetadata(), "test.txt"));
            assertEquals("605", solver.getAnswer());
        } catch (IOException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testPart2() {
        try {
            Solver solver = new AllInASingleNight_Part2();
            solver.run(InputFactory.inputFromMetadata(solver.getMetadata(), "test.txt"));
            assertEquals("982", solver.getAnswer());
        } catch (IOException e) {
            fail(e.getMessage());
        }
    }
    
}
