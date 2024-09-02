package fi.tuomax.adventofcode.year2022.day07;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.List;

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

}
