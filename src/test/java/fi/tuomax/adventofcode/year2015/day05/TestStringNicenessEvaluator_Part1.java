package fi.tuomax.adventofcode.year2015.day05;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import fi.tuomax.adventofcode.PuzzleTester;
import fi.tuomax.adventofcode.framework.solving.Metadata;

public class TestStringNicenessEvaluator_Part1 
extends PuzzleTester
{

    @Test
    public void testNices()
    {
        readJson(new Metadata(2015, 5, 1, null, null));
        List<String> nices = getStrings(json.getJSONObject("part1").getJSONArray("nices"));
        for (String input : nices) {
            StringNicenessEvaluator e = new StringNicenessEvaluator_Part1();
            assertTrue(e.isNice(input));
        }
    }

    @Test
    public void testNaughties()
    {
        readJson(new Metadata(2015, 5, 1, null, null));
        List<String> naughties = getStrings(json.getJSONObject("part1").getJSONArray("naughties"));
        for (String input : naughties) {
            StringNicenessEvaluator e = new StringNicenessEvaluator_Part1();
            assertFalse(e.isNice(input));
        }
    }

}
