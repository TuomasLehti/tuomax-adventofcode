package fi.tuomax.adventofcode.year2015.day11;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.json.JSONArray;
import org.junit.Test;

import fi.tuomax.adventofcode.PuzzleTester;
import fi.tuomax.adventofcode.framework.solving.Metadata;

public class Test_Password 
extends PuzzleTester
{

    @Test
    public void testInvalids()
    {
        readJson(new Metadata(2015, 11, null, null, null), "password validator tests.json");
        JSONArray invalids = json.getJSONArray("invalids");
        for (int i = 0; i < invalids.length(); i++) {
            String password = invalids.getString(i);
            Password pwd = new Password(password);
            assertFalse(password, pwd.isValid());
        }
    }

    @Test
    public void testValids()
    {
        readJson(new Metadata(2015, 11, null, null, null), "password validator tests.json");
        JSONArray invalids = json.getJSONArray("valids");
        for (int i = 0; i < invalids.length(); i++) {
            String password = invalids.getString(i);
            Password pwd = new Password(password);
            assertTrue(password, pwd.isValid());
        }
    }

    @Test
    public void testIncrement()
    {
        readJson(new Metadata(2015, 11, null, null, null), "password validator tests.json");
        JSONArray increments = json.getJSONArray("increments");
        for (int i = 0; i < increments.length(); i++) {
            String pwd = increments.getJSONObject(i).getString("pwd");
            String next = increments.getJSONObject(i).getString("next");
            Password password = new Password(pwd);
            password.incrementToNextValid();
            assertEquals(pwd, next, password.getPassword());
        }

    }
    
}

