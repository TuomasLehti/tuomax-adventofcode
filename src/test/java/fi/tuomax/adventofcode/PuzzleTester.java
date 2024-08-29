package fi.tuomax.adventofcode;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fi.tuomax.adventofcode.framework.inputting.InputFactory;
import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.solving.Solver;

/**
 * Includes helpers for testing. This class should be inherited by all other
 * test classes.
 */
public class PuzzleTester 
{

    private Logger logger = LoggerFactory.getLogger(getClass());

    protected JSONObject json;

    /**
     * Reads the json file which contains the test cases.
     */
    protected void readJson(Metadata metadata)
    {
        readJson(metadata, "tests.json");
    }

    /**
     * Reads the json file which contains the test cases.
     */
    protected void readJson(Metadata metadata, String filename)
    {
        File file = new File(InputFactory.inputLocation(metadata, filename));
        try {
            String content = new String(Files.readAllBytes(file.toPath()));
            json = new JSONObject(content);
        } catch (IOException e) {
            fail(e.getMessage());
        }
    }

    @Deprecated
    protected JSONObject fetchJson(Metadata metadata, String filename)
    {
        File file = new File(InputFactory.inputLocation(metadata, filename));
        try {
            String content = new String(Files.readAllBytes(file.toPath()));
            return new JSONObject(content);
        } catch (IOException e) {
            return null;
        }
    }

    /**
     * Fetches the suite of tests from json.
     */
    protected List<PuzzleTestCase> fetchTestCases(Metadata metadata) 
    {
        readJson(metadata);
        JSONArray suite = json.getJSONArray(
                String.format("part%d", metadata.part()));

        List<PuzzleTestCase> tests = new ArrayList<>();
        for (Object o : suite) {
            JSONObject test = (JSONObject) o;
            if (test.has("input")) {
                tests.add(
                    createSingleLineTest(test)
                );
            } else if (test.has("file")) {
                tests.add(
                    createMultiLineTest(metadata, test)
                );
            } 
        }
        return tests;
    }

    private PuzzleTestCase createMultiLineTest(Metadata metadata, JSONObject test) {
        List<String> input = null;
        try {
            input = InputFactory.inputFromMetadata(
                metadata, test.getString("file")
            );
        } catch (JSONException | IOException e) {
            logger.error(e.getMessage(), e);
            input = new ArrayList<>();
        }
        return new PuzzleTestCase(input, test.getString("answer"));
    }

    private PuzzleTestCase createSingleLineTest(JSONObject test) {
        return new PuzzleTestCase(
            InputFactory.inputFromString(test.getString("input")), 
            test.getString("answer")
        );
    }

    public File fetchResource(String filename)
    {
        URL url = getClass().getResource(filename);
        assertNotNull(url);
        return new File(url.getPath().substring(1));
    }

    public void runTests(Solver solver)
    {
        List<PuzzleTestCase> suite = fetchTestCases(solver.getMetadata());
        for (PuzzleTestCase testCase : suite) {
            // may return null, which is fine by solver
            solver.setParameters(fetchJson(solver.getMetadata(), "test parameters.json"));
            solver.run(testCase.input());
            assertEquals(testCase.expectedAnswer(), solver.getAnswer());
        }
    }

    protected List<String> getStrings(JSONArray json)
    {
        List<String> strings = new ArrayList<>();
        for (Object o : json) {
            strings.add((String) o);
        }
        return strings;
    }

    
}
