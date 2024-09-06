package fi.tuomax.adventofcode.year2022.day10;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.json.JSONArray;
import org.junit.Test;

import fi.tuomax.adventofcode.PuzzleTestCase;
import fi.tuomax.adventofcode.PuzzleTester;

public class Test_CathoderayTube
extends PuzzleTester
{

    @Test
    public void test_RunningSum()
    {
        CathoderayTube_Part1 solver = new CathoderayTube_Part1();
        List<PuzzleTestCase> testCases = fetchTestCases(solver.getMetadata(), "mini");
        solver.run(testCases.get(0).input());
        JSONArray expected = json.getJSONArray("mini").getJSONObject(0).getJSONArray("expected_strengths");
        for (int i = 0; i < solver.runningSum.size()-1; i++) {
            assertEquals(expected.getInt(i), (int) solver.runningSum.get(i));
        }
    }

    @Test
    public void test_Part1()
    {
        runTests(new CathoderayTube_Part1());
    }

    @Test
    public void test_Part2()
    {
        runTests(new CathoderayTube_Part2());
    }

}
