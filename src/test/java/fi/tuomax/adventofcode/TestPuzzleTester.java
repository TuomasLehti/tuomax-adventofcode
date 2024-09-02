package fi.tuomax.adventofcode;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import org.json.JSONArray;
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

    @Test
    public void testFetchTestSuite()
    {
        final String FILENAME = "/fi/tuomax/adventofcode/test_testsuite.json";
        final String SUITE_NAME = "suite";
        final String[] TEST_INPUTS = 
            new String[]{"Hello", "my", "friend", "you"};
        final String[] TEST_ANSWERS = 
            new String[]{"darkness", "old", "suit", "sir"};
        File file = fetchResource(FILENAME);
        JSONObject json = readJson(file);
        JSONArray suite = json.getJSONArray(SUITE_NAME);
        List<PuzzleTestCase> cases = fetchTestCases(null, suite);
        assertEquals(TEST_INPUTS.length, cases.size());
        for (int i = 0; i < TEST_INPUTS.length; i++) {
            assertEquals(TEST_INPUTS[i], cases.get(i).input().get(0));
            assertEquals(TEST_ANSWERS[i], cases.get(i).expectedAnswer());
        }
    }
    
}
