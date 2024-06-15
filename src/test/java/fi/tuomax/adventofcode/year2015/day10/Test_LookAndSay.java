package fi.tuomax.adventofcode.year2015.day10;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Test_LookAndSay 
{

    @Test
    public void test()
    {
        assertEquals("11", LookAndSay.lookAndSay("1"));
        assertEquals("21", LookAndSay.lookAndSay("11"));
        assertEquals("1211", LookAndSay.lookAndSay("21"));
        assertEquals("111221", LookAndSay.lookAndSay("1211"));
        assertEquals("312211", LookAndSay.lookAndSay("111221"));
    }

}
