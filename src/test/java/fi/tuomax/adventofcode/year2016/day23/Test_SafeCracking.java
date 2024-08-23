package fi.tuomax.adventofcode.year2016.day23;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.Test;

import fi.tuomax.adventofcode.framework.inputting.InputFactory;

public class Test_SafeCracking 
{

    @Test
    public void test()
    {
        try {
            SafeCracking_Part1 solver = new SafeCracking_Part1();
            solver.run(InputFactory.inputFromMetadata(solver.getMetadata(), "test.txt"));
            assertEquals("3", solver.getAnswer());
        } catch (IOException e) {
            fail(e.getMessage());
        }
    }

}