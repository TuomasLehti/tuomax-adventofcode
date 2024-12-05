package fi.tuomax.adventofcode.year2024.day05;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class Test_Rule 
{

    @Test
    public void test_InRightOrder()
    {
        Rule rule = new Rule("5|6");
        assertTrue(rule.inRightOrder(Arrays.asList(new Integer[]{3, 4, 5, 6, 7})));
        assertFalse(rule.inRightOrder(Arrays.asList(new Integer[]{7, 6, 5, 4, 3})));
    }

    @Test
    public void test_Applies()
    {
        Rule rule = new Rule("5|6");
        assertTrue(rule.applies(Arrays.asList(new Integer[]{3, 4, 5, 6, 7})));
        assertFalse(rule.applies(Arrays.asList(new Integer[]{6, 7})));
        assertFalse(rule.applies(Arrays.asList(new Integer[]{3, 4, 5})));
        assertFalse(rule.applies(Arrays.asList(new Integer[]{3, 4, 7, 8})));
    }
    
}
