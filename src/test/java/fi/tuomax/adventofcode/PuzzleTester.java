package fi.tuomax.adventofcode;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
     * Reads the json file which contains the test cases. Default input 
     * directory structure and file name is used.
     */
    protected void readJson(Metadata metadata)
    {
        json = readJsonFile(metadata, InputFactory.DEFAULT_TEST_INPUT_FILENAME);
    }

    /**
     * Reads the json file which contains the test cases. Default input 
     * directory structure is used.
     */
    protected void readJson(Metadata metadata, String filename)
    {
        json = readJson(new File(
                InputFactory.inputLocation(metadata, filename)));
    }

    /**
     * Reads a json file.
     */
    protected JSONObject readJson(File file)
    {
        try {
            String content = new String(Files.readAllBytes(file.toPath()));
            return new JSONObject(content);
        } catch (IOException e) {
            return null;
        }
    }

    /**
     * Reads a json file from the standard input directory structure.
     */
    protected JSONObject readJsonFile(Metadata metadata, String filename)
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
        return fetchTestCases(
            metadata, 
            String.format("part%d", metadata.part())
        );
    }

    /**
     * Fetches a suite of tests from json.
     */
    protected List<PuzzleTestCase> fetchTestCases(Metadata metadata, String suiteName) 
    {
        readJson(metadata);
        JSONArray suite = json.getJSONArray(suiteName);
        return fetchTestCases(metadata, suite);
    }

    /**
     * Fetches a suite of test cases from a json array.
     * 
     * The input for these test cases may come from a single line of text or 
     * from a file. If the input is a file, it must be read from the standard
     * input directory, which is why the metadata must exists here. If 
     * you'ven't planned any tests involving input from a file, it is fine
     * to make metadata null.
     * 
     * @param metadata
     *      Used for determining the actual location of the input file in disk.
     *      May be null if no file tests are taking place.
     * 
     * @param suite
     *      A JSON array of test cases.
     * 
     * @return
     *      A list of test cases.
     */
    protected List<PuzzleTestCase> fetchTestCases(Metadata metadata, JSONArray suite)
    {
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

    /**
     * Runs a suite of tests against a solver.
     * 
     * @param solver
     *      The solver to test.
     */
    public void runTests(Solver solver)
    {
        List<PuzzleTestCase> suite = fetchTestCases(solver.getMetadata());
        for (PuzzleTestCase testCase : suite) {
            // may return null, which is fine by solver
            solver.setParameters(readJsonFile(solver.getMetadata(), "test parameters.json"));
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
