package fi.tuomax.adventofcode;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import org.junit.Test;

public class TestHelpersForTests 
extends HelpersForTests
{

    @Test
    public void testFetchResource()
    {
        final String FILENAME = "/fi/tuomax/adventofcode/hello.txt";
        final String EXPECTED = "Hello, world!";
        try {
            File file = fetchResource(FILENAME);
            List<String> hello = Files.readAllLines(file.toPath());
            assertEquals(EXPECTED, hello.get(0));
        } catch (IOException e) {
            fail(e.getMessage());
        }
    }
    
}
