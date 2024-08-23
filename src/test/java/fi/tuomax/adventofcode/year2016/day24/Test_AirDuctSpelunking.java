package fi.tuomax.adventofcode.year2016.day24;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.Test;

import fi.tuomax.adventofcode.framework.inputting.InputFactory;

public class Test_AirDuctSpelunking 
{

    @Test
    public void test_Part1()
    {
        try {
            AirDuctSpelunking solver = new AirDuctSpelunking_Part1();
            solver.run(InputFactory.inputFromMetadata(solver.getMetadata(), "test.txt"));
            assertEquals("14", solver.getAnswer());
        } catch (IOException e) {
            fail(e.getMessage());
        }
    }
    
}
