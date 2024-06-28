package fi.tuomax.adventofcode.year2016.day04;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.List;

import org.junit.Test;

import fi.tuomax.adventofcode.PuzzleTester;
import fi.tuomax.adventofcode.framework.solving.Metadata;

public class TestRoom 
extends PuzzleTester
{

    @Test
    public void test_Reals()
    {
        readJson(new Metadata(2016, 4, null, null, null), "tests.json");

        List<String> reals = getStrings(json.getJSONArray("reals"));
        for (String input : reals) {
            Room room = new Room(input);
            assertTrue(input, room.isReal());
        }
    }

    @Test
    public void test_Decoys()
    {
        readJson(new Metadata(2016, 4, null, null, null), "tests.json");

        List<String> reals = getStrings(json.getJSONArray("decoys"));
        for (String input : reals) {
            Room room = new Room(input);
            assertFalse(input, room.isReal());
        }
    }
    
}
