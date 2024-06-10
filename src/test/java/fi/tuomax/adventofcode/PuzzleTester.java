package fi.tuomax.adventofcode;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import fi.tuomax.adventofcode.framework.inputting.InputFactory;
import fi.tuomax.adventofcode.framework.solving.Metadata;

/**
 * Includes helpers for testing. This class should be inherited by all other
 * test classes.
 */
public class PuzzleTester 
{

    protected JSONObject json;

    /**
     * Reads the json file which contains the test cases.
     */
    protected void readJson(Metadata metadata)
    {
        File file = new File(InputFactory.inputLocation(metadata, "tests.json"));
        try {
            String content = new String(Files.readAllBytes(file.toPath()));
            json = new JSONObject(content);
        } catch (IOException e) {
            fail(e.getMessage());
        }
    }

    /**
     * Fetches the suite of tests from json.
     */
    protected List<PuzzleTestCase> fetchTestCases(Metadata metadata)
    {
        readJson(metadata);
        JSONArray suite = json.getJSONArray(String.format("part%d", metadata.part()));

        List<PuzzleTestCase> tests = new ArrayList<>();
        for (Object o : suite) {
            JSONObject test = (JSONObject) o;
            tests.add(new PuzzleTestCase(InputFactory.inputFromString(test.getString("input")), test.getString("answer")));
        }
        return tests;
    }


    public File fetchResource(String filename)
    {
        URL url = getClass().getResource(filename);
        assertNotNull(url);
        return new File(url.getPath().substring(1));
    }
    
}
