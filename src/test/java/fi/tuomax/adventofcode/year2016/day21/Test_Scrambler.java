package fi.tuomax.adventofcode.year2016.day21;

import static org.junit.Assert.assertEquals;

import org.json.JSONObject;
import org.json.JSONArray;
import org.junit.Test;

import fi.tuomax.adventofcode.PuzzleTester;
import fi.tuomax.adventofcode.framework.solving.Metadata;

public class Test_Scrambler 
extends PuzzleTester
{

    @Test
    public void test_ToString()
    {
        Scrambler scrambler = new Scrambler("Hello");
        assertEquals("Hello", scrambler.toString());
    }
    
    @Test
    public void test_Operations()
    {
        JSONObject json = readJsonFile(new Metadata(2016, 21, 1, null, null), "tests.json");
        JSONArray tests = json.getJSONArray("part1");
        for (Object o : tests) {
            JSONObject test = (JSONObject) o;
            Scrambler scrambler = new Scrambler(test.getString("source"));
            scrambler.scramble(test.getString("operation"));
            assertEquals(test.getString("operation"), test.getString("expected"), scrambler.toString());
        }
    }

    @Test
    public void test_RotateRight()
    {
        Scrambler scrambler = new Scrambler("Hello");
        scrambler.scramble("rotate right 2");
        assertEquals("loHel", scrambler.toString());
        scrambler.scramble("rotate right 6");
        assertEquals("lloHe", scrambler.toString());
    }

    @Test
    public void test_Move()
    {
        Scrambler scrambler = new Scrambler("Hello");
        scrambler.scramble("move position 1 to position 2");
        assertEquals("Hlelo", scrambler.toString());
        scrambler.scramble("move position 3 to position 1");
        assertEquals("Hlleo", scrambler.toString());
        scrambler.scramble("move position 3 to position 0");
        assertEquals("eHllo", scrambler.toString());
        scrambler.scramble("move position 3 to position 4");
        assertEquals("eHlol", scrambler.toString());
    }

    @Test
    public void test_UnswapPos()
    {
        final String PASSWORD = "qwertyui";
        final String OPERATION = "swap position 2 with position 5";
        Scrambler scrambler = new Scrambler(PASSWORD);
        scrambler.scramble(OPERATION);
        scrambler.unscramble(OPERATION);
        assertEquals(PASSWORD, scrambler.toString());
    }

    @Test
    public void test_UnswapLetter()
    {
        final String PASSWORD = "qwertyui";
        final String OPERATION = "swap letter w with letter y";
        Scrambler scrambler = new Scrambler(PASSWORD);
        scrambler.scramble(OPERATION);
        scrambler.unscramble(OPERATION);
        assertEquals(PASSWORD, scrambler.toString());
    }

    @Test
    public void test_UnrotateRight()
    {
        final String PASSWORD = "qwertyui";
        final String OPERATION = "rotate right 2";
        Scrambler scrambler = new Scrambler(PASSWORD);
        scrambler.scramble(OPERATION);
        scrambler.unscramble(OPERATION);
        assertEquals(PASSWORD, scrambler.toString());
    }

    @Test
    public void test_UnrotateLeft()
    {
        final String PASSWORD = "qwertyui";
        final String OPERATION = "rotate left 2";
        Scrambler scrambler = new Scrambler(PASSWORD);
        scrambler.scramble(OPERATION);
        scrambler.unscramble(OPERATION);
        assertEquals(PASSWORD, scrambler.toString());
    }

    @Test
    public void test_UnrotateLetter_SmallIdx()
    {
        final String PASSWORD = "qwertyui";
        final String OPERATION = "rotate based on position of letter w";
        Scrambler scrambler = new Scrambler(PASSWORD);
        scrambler.scramble(OPERATION);
        scrambler.unscramble(OPERATION);
        assertEquals(PASSWORD, scrambler.toString());
    }

    @Test
    public void test_UnrotateLetter_BigIdx()
    {
        final String PASSWORD = "qwertyui";
        final String OPERATION = "rotate based on position of letter u";
        Scrambler scrambler = new Scrambler(PASSWORD);
        scrambler.scramble(OPERATION);
        scrambler.unscramble(OPERATION);
        assertEquals(PASSWORD, scrambler.toString());
    }

    @Test
    public void test_UnreversePos()
    {
        final String PASSWORD = "qwertyui";
        final String OPERATION = "reverse positions 3 through 6";
        Scrambler scrambler = new Scrambler(PASSWORD);
        scrambler.scramble(OPERATION);
        scrambler.unscramble(OPERATION);
        assertEquals(PASSWORD, scrambler.toString());
    }

    @Test
    public void test_UnmovePos()
    {
        final String PASSWORD = "qwertyui";
        final String OPERATION = "move position 2 to position 5";
        Scrambler scrambler = new Scrambler(PASSWORD);
        scrambler.scramble(OPERATION);
        scrambler.unscramble(OPERATION);
        assertEquals(PASSWORD, scrambler.toString());
    }

    
}
