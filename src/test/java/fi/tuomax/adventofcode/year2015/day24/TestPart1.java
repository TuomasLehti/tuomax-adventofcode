package fi.tuomax.adventofcode.year2015.day24;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.Test;

import fi.tuomax.adventofcode.framework.inputting.InputFactory;

public class TestPart1 
{

    @Test
    public void test()
    {
        try {
            ItHangsInTheBalance_Part1 part1 = new ItHangsInTheBalance_Part1();
            part1.run(InputFactory.inputFromMetadata(part1.getMetadata(), "test.txt"));
            assertEquals("99", part1.getAnswer());
        } catch (IOException e) {
            fail(e.getMessage());
        }
    }
    
}
