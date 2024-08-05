package fi.tuomax.adventofcode.year2016.day13;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import fi.tuomax.adventofcode.commons.Coordinates;
import fi.tuomax.adventofcode.commons.Dfs;
import fi.tuomax.adventofcode.commons.DfsState;

public class Test_State 
{

    @Test
    public void test()
    {
        MazeGenerator.favoriteNumber = 10;
        CubicleDfsState.target = new Coordinates(7L, 4L);
        CubicleDfsState state = new CubicleDfsState();

        Set<DfsState> nextStates = state.nextStates();
        // cast them all to the right class
        Set<CubicleDfsState> rtfStates = new HashSet<>();
        for (DfsState s : nextStates)
            rtfStates.add((CubicleDfsState) s);
        
        state.print(10, 10);
        System.out.println();

        for (CubicleDfsState s : rtfStates) {
            s.print(10, 10);
            System.out.println();
        }

    }

    @Test
    public void testDfs()
    {
        MazeGenerator.favoriteNumber = 10;
        Dfs dfs = new Dfs();
        CubicleDfsState.target = new Coordinates(7L, 4L);
        DfsState state = dfs.search(new CubicleDfsState());
        assertEquals(11, (int) state.getStep());
    }
    
}
