package fi.tuomax.adventofcode.year2016.day22;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fi.tuomax.adventofcode.commons.Coordinates;

public class Test_Node 
{

    @Test
    public void test_Constructor_Success()
    {
        Node node = new Node("/dev/grid/node-x1-y14    86T   65T    21T   75%");
        assertEquals(new Coordinates(1L, 14L), node.position());
        assertEquals(86, (int) node.getSize());
        assertEquals(65, (int) node.getUsed());
    }
    
}
