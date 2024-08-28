package fi.tuomax.adventofcode.year2016.day25;

import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.Test;

import fi.tuomax.adventofcode.framework.inputting.InputFactory;

public class Test_Optimized 
{

    @Test
    public void test()
    {
        try {
            ClockSignal_Part1 solver = new ClockSignal_Part1();
            solver.run(InputFactory.inputFromMetadata(solver.getMetadata(), "input optimized.txt"));
        } catch (IOException e) {
            fail(e.getMessage());
        }
    }
    
}
