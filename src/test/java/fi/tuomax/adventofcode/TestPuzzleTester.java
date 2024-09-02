package fi.tuomax.adventofcode;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import org.json.JSONObject;
import org.junit.Test;

public class TestPuzzleTester 
extends PuzzleTester
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

    @Test
    public void testReadJson()
    {
        final String FILENAME = "/fi/tuomax/adventofcode/test_json.json";
        final String NAME = "Hello";
        final String EXPECTED = "world";
        File file = fetchResource(FILENAME);
        JSONObject json = readJson(file);
        assertEquals(EXPECTED, json.getString(NAME));
    }
    
}
