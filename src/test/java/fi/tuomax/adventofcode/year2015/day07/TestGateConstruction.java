package fi.tuomax.adventofcode.year2015.day07;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestGateConstruction 
{

    @Test
    public void testAnd()
    {
        GateAnd andGate = new GateAnd("dy AND ej -> el");
        assertEquals("dy", andGate.getFirstInput());
        assertEquals("ej", andGate.getSecondInput());
    }

    @Test
    public void testNot()
    {
        GateNot notGate = new GateNot("NOT gs -> gt");
        assertEquals("gs", notGate.getFirstInput());
    }

    @Test
    public void testAssign()
    {
        GateAssign assignGate = new GateAssign("44430 -> b");
        assertEquals("44430", assignGate.getFirstInput());
    }

}
