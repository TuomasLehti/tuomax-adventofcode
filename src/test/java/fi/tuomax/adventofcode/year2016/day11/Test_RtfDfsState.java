package fi.tuomax.adventofcode.year2016.day11;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import fi.tuomax.adventofcode.commons.BfsState;

public class Test_RtfDfsState 
{

    @Test
    public void test_IsTargetState()
    {
        RtfDfsState state = new RtfDfsState(new int[]{44, 44, 44, 44});
        assertTrue(state.isTargetState());
    }

    @Test
    public void test_IsNotTargetState()
    {
        RtfDfsState state = new RtfDfsState(new int[]{44, 44, 44, 43});
        assertFalse(state.isTargetState());
        state = new RtfDfsState(new int[]{44, 44, 44, 34});
        assertFalse(state.isTargetState());
    }

    @Test
    public void test_Equals()
    {
        RtfDfsState state = new RtfDfsState(new int[]{44, 44, 44, 43});
        RtfDfsState other = new RtfDfsState(new int[]{44, 44, 44, 43});
        assertTrue(state.equals(other));
    }

    @Test
    public void test_Equals_DifferentElements()
    {
        RtfDfsState state = new RtfDfsState(new int[]{44, 44, 44, 43});
        RtfDfsState other = new RtfDfsState(new int[]{44, 43, 44, 44});
        assertTrue(state.equals(other));

    }

    @Test
    public void test_NotEquals()
    {
        RtfDfsState state = new RtfDfsState(new int[]{44, 44, 44, 43});
        RtfDfsState other = new RtfDfsState(new int[]{44, 44, 44, 42});
        assertFalse(state.equals(other));
    }

    @Test
    public void test_HashCode()
    {
        RtfDfsState state = new RtfDfsState(new int[]{11, 11, 11, 11});
        System.out.println(state.hashCode());
        state.moveChipUp(0);
        System.out.println(state.hashCode());
        state.moveChipDown(0);
        System.out.println(state.hashCode());
        state = new RtfDfsState(new int[]{44, 44, 44, 44, 44, 44, 44});
        System.out.println(state.hashCode());
    }

    @Test
    public void test_IsSafeState()
    {
        RtfDfsState state = new RtfDfsState(new int[]{11, 11, 11, 11});
        assertTrue(state.isSafeState());

        state = new RtfDfsState(new int[]{12, 13});
        assertTrue(state.isSafeState());

        state = new RtfDfsState(new int[]{11, 12});
        assertFalse(state.isSafeState());

        state = new RtfDfsState(new int[]{33, 13});
        assertTrue(state.isSafeState());        
    }

    @Test
    public void test_NextStates()
    {
        RtfDfsState state = new RtfDfsState(new int[]{11, 11});
        Set<BfsState> nextStates = state.nextStates();

        // cast them all to the right class
        Set<RtfDfsState> rtfStates = new HashSet<>();
        for (BfsState s : nextStates)
            rtfStates.add((RtfDfsState) s);

        assertEquals(3, rtfStates.size());
        assertTrue(rtfStates.contains(new RtfDfsState(2, new int[]{12, 12}, 1)));
        assertTrue(rtfStates.contains(new RtfDfsState(2, new int[]{21, 21}, 1)));
        assertTrue(rtfStates.contains(new RtfDfsState(2, new int[]{22, 11}, 1)));
    }

    @Test
    public void test_AocExample()
    {
        assertTrue("first", yields(new int[]{12, 13}, 1, new int[]{22, 13}, 2));
        assertTrue("second", yields(new int[]{22, 13}, 2, new int[]{33, 13}, 3));
        assertTrue("third", yields(new int[]{33, 13}, 3, new int[]{23, 13}, 2));
        assertTrue("fourth", yields(new int[]{23, 13}, 2, new int[]{13, 13}, 1));
        assertTrue("fifth", yields(new int[]{13, 13}, 1, new int[]{23, 23}, 2));
        assertTrue("sixth", yields(new int[]{23, 23}, 2, new int[]{33, 33}, 3));
        assertTrue("seventh", yields(new int[]{33, 33}, 3, new int[]{43, 43}, 4));
        assertTrue("eighth", yields(new int[]{43, 43}, 4, new int[]{43, 33}, 3));
        assertTrue("nineth", yields(new int[]{43, 33}, 3, new int[]{44, 34}, 4));
        assertTrue("tenth", yields(new int[]{44, 34}, 4, new int[]{34, 34}, 3));
        assertTrue("elebenth", yields(new int[]{34, 34}, 3, new int[]{44, 44}, 4));
    }

    private boolean yields(int[] given, int givenElevator, int[] expected, int expectedElevator)
    {
        RtfDfsState state = new RtfDfsState(givenElevator, given, 0);
        Set<BfsState> nextStates = state.nextStates();
        Set<RtfDfsState> rtfStates = new HashSet<>();
        for (BfsState s : nextStates)
            rtfStates.add((RtfDfsState) s);
        return rtfStates.contains(new RtfDfsState(expectedElevator, expected, 1));
    }
    
}
