package fi.tuomax.adventofcode.year2015.day17;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.Test;

import fi.tuomax.adventofcode.framework.inputting.InputFactory;

public class Test_NoSuchThingAsTooMuch 
{

    @Test
    public void testPart1()
    {
        try {
            NoSuchThingAsTooMuch_Part1_Test part = new NoSuchThingAsTooMuch_Part1_Test();
            part.run(InputFactory.inputFromMetadata(part.getMetadata(), "test.txt"));
            assertEquals("4", part.getAnswer());
        } catch (IOException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testPart2()
    {
        try {
            NoSuchThingAsTooMuch_Part2_Test part = new NoSuchThingAsTooMuch_Part2_Test();
            part.run(InputFactory.inputFromMetadata(part.getMetadata(), "test.txt"));
            assertEquals("3", part.getAnswer());
        } catch (IOException e) {
            fail(e.getMessage());
        }
    }
    
}
