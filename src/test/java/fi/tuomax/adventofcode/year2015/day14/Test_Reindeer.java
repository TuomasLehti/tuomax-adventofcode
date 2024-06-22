package fi.tuomax.adventofcode.year2015.day14;

import static org.junit.Assert.assertEquals;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import fi.tuomax.adventofcode.PuzzleTester;
import fi.tuomax.adventofcode.framework.solving.Metadata;

public class Test_Reindeer 
extends PuzzleTester
{

    @Test
    public void testFromInput()
    {
        readJson(new Metadata(2015, 14, null, null, null), "tests.json");
        JSONArray tests = json.getJSONArray("part1");
        for (int i = 0; i < tests.length(); i++) {
            JSONObject test = tests.getJSONObject(i);
            Reindeer reindeer = Reindeer.fromInput(test.getString("input"));
            Integer time = test.getInt("time");
            Integer answer = test.getInt("answer");
            assertEquals(answer, reindeer.distance(time));
        }

    }
    
}
