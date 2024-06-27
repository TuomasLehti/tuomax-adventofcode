package fi.tuomax.adventofcode.year2016.day03;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Test_Triangle 
{

    @Test
    public void test()
    {
        assertTrue(new Triangle("3 4 5").isPossible());
        assertFalse(new Triangle(" 50  99 250").isPossible());
    }
    
}
