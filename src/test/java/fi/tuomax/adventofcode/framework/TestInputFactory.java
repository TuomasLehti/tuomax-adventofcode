package fi.tuomax.adventofcode.framework;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import fi.tuomax.adventofcode.PuzzleTester;
import fi.tuomax.adventofcode.framework.inputting.InputFactory;

public class TestInputFactory 
extends PuzzleTester
{
    
    @Test
    public void testFromFile()
    {
        final String FILENAME = "/fi/tuomax/adventofcode/hello.txt";
        final String EXPECTED = "Hello, world!";

        List<String> lines;
        try {
            lines = InputFactory.inputFromFile(fetchResource(FILENAME));
            assertEquals(EXPECTED, lines.get(0));
        } catch (IOException e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

}
