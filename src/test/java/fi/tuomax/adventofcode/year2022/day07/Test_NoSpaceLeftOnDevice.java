package fi.tuomax.adventofcode.year2022.day07;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import fi.tuomax.adventofcode.PuzzleTestCase;
import fi.tuomax.adventofcode.PuzzleTester;
import fi.tuomax.adventofcode.framework.inputting.InputFactory;
import fi.tuomax.adventofcode.framework.solving.Metadata;

public class Test_NoSpaceLeftOnDevice 
extends PuzzleTester
{

    @Test
    public void test_Parser()
    {
        Metadata metadata = new Metadata(2022, 7, null, null, null);
        List<PuzzleTestCase> suite = fetchTestCases(metadata, "directory_sizes");

        NoSpaceLeftOnDevice_Parser parser = null;
        try {
            parser = 
                    new NoSpaceLeftOnDevice_Parser(
                            InputFactory.inputFromMetadata(metadata, "test.txt")
                    );
        } catch (IOException e) {
            fail(e.toString());
        }

        parser.parse();
        Directory tree = parser.getDirectoryTree();
        for (PuzzleTestCase test : suite) {
            Directory dir = tree.search(test.input().get(0));
            assertEquals(dir.size(), Long.valueOf(test.expectedAnswer()));
        }
        
    }

    @Test
    public void test_Part1()
    {
        runTests(new NoSpaceLeftOnDevice_Part1());
    }

    @Test
    public void test_Part2()
    {
        runTests(new NoSpaceLeftOnDevice_Part2());
    }

    protected List<PuzzleTestCase> fetchTestCases(Metadata metadata, String suiteName) 
    {
        readJson(metadata);
        JSONArray suite = json.getJSONArray(suiteName);

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


}
