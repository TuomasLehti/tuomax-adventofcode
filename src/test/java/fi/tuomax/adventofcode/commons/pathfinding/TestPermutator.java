package fi.tuomax.adventofcode.commons.pathfinding;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class TestPermutator 
{

    @Test
    public void testPermutator()
    {
        List<String> permutables = new ArrayList<>(Arrays.asList("abc".split("")));
        List<List<String>> permuted = Permutator.getPermutations(permutables);
        assertEquals(6, permuted.size());
        assertEquals("abc", String.join("", permuted.get(0)));
        assertEquals("acb", String.join("", permuted.get(1)));
        assertEquals("bac", String.join("", permuted.get(2)));
        assertEquals("bca", String.join("", permuted.get(3)));
        assertEquals("cab", String.join("", permuted.get(4)));
        assertEquals("cba", String.join("", permuted.get(5)));
    }
    
}
