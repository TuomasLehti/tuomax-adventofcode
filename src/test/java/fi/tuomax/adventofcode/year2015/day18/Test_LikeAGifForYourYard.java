package fi.tuomax.adventofcode.year2015.day18;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.Test;

import fi.tuomax.adventofcode.framework.inputting.InputFactory;

public class Test_LikeAGifForYourYard 
{

    @Test
    public void testPart1()
    {
        try {
            LikeAGifForYourYard_Part1 part = new LikeAGifForYourYard_Part1();
            part.setRounds(4);
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
            LikeAGifForYourYard_Part2 part = new LikeAGifForYourYard_Part2();
            part.setRounds(5);
            part.run(InputFactory.inputFromMetadata(part.getMetadata(), "test.txt"));
            assertEquals("17", part.getAnswer());
        } catch (IOException e) {
            fail(e.getMessage());
        }
    }
    
}
