package fi.tuomax.adventofcode.year2016.day14;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fi.tuomax.adventofcode.commons.MD5;

public class Test_MD5Requirement 
{

    @Test
    public void test_TreeNumbers()
    {
        Integer number = MD5.getNumber(
            "abc", 
            new ConsecutiveCharsRequirement(3), 
            1, 0, -1
        );
        assertEquals(18, (int) number);
    }

    @Test
    public void test_FiveNumbers()
    {
        Integer number = MD5.getNumber(
            "abc", 
            new ConsecutiveCharsRequirement('e', 5), 
            1, 40, 40 + 1000
        );
        assertEquals(816, (int) number);
    }

    @Test
    public void test_FiveNumbers_Fail()
    {
        Integer number = MD5.getNumber(
            "abc", 
            new ConsecutiveCharsRequirement('8', 5), 
            1, 19, 19 + 1000
        );
        assertEquals(-1, (int) number);
    }

    @Test
    public void test_ConsecutivenessAtLastPossibleMoment()
    {
        ConsecutiveCharsRequirement req = new ConsecutiveCharsRequirement('a', 3);
        assertTrue(req.fulfilledBy("xyzaaa"));
        assertTrue(req.fulfilledBy("aaa"));
        assertFalse(req.fulfilledBy("xyzaa"));
        assertFalse(req.fulfilledBy("aa"));
    }
    
}
