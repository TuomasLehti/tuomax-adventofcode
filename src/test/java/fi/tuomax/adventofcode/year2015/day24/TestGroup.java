package fi.tuomax.adventofcode.year2015.day24;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestGroup 
{

    @Test
    public void test()
    {
        Group group = new Group();
        
        group.push(10);
        assertEquals(10, (long) group.weight());
        assertEquals(10, (long) group.quantumEntanglement());

        group.push(20);
        assertEquals(30, (long) group.weight());
        assertEquals(200, (long) group.quantumEntanglement());

        group.push(30);
        assertEquals(60, (long) group.weight());
        assertEquals(6000, (long) group.quantumEntanglement());

        assertEquals(30, (int) group.pop());
        assertEquals(30, (long) group.weight());
        assertEquals(200, (long) group.quantumEntanglement());

        assertEquals(20, (int) group.pop());
        assertEquals(10, (long) group.weight());
        assertEquals(10, (long) group.quantumEntanglement());

        assertEquals(10, (int) group.pop());
        assertEquals(0, (long) group.weight());
        assertEquals(1, (long) group.quantumEntanglement());
    }
    
}
