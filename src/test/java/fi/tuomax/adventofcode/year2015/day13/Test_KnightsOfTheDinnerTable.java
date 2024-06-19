package fi.tuomax.adventofcode.year2015.day13;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.Test;

import fi.tuomax.adventofcode.framework.inputting.InputFactory;

public class Test_KnightsOfTheDinnerTable 
{

    @Test
    public void testPart1()
    {
        try {
            KnightsOfTheDinnerTable_Part1 part1 = new KnightsOfTheDinnerTable_Part1();
            part1.run(InputFactory.inputFromMetadata(part1.getMetadata(), "test.txt"));
            assertEquals("330", part1.getAnswer());
        } catch (IOException e) {
            fail(e.getMessage());
        }
    }

}
