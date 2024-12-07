package fi.tuomax.adventofcode.year2024.day07;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.Test;

public class Test_EquationSolver 
{

    @Test
    public void test_BaseCase()
    {
        EquationSolver es = new EquationSolver();
        Set<Long> ans = es.possibleAnswersForEquation("3 5");
        assertEquals(2, ans.size());
        assertTrue(ans.contains(8L));
        assertTrue(ans.contains(15L));
    }
    
    @Test
    public void test_Recursion()
    {
        /* not PEMDAS, but left to right */
        /* 3 + 5 + 7 = 15 */
        /* 3 + 5 * 7 = 56 */
        /* 3 * 5 + 7 = 22 */
        /* 3 * 5 * 7 = 105 */
        EquationSolver es = new EquationSolver();
        Set<Long> ans = es.possibleAnswersForEquation("3 5 7");
        assertEquals(4, ans.size());
        assertTrue(ans.contains(15L));
        assertTrue(ans.contains(56L));
        assertTrue(ans.contains(22L));
        assertTrue(ans.contains(105L));
    }

    @Test
    public void test_RecursionLimit()
    {
        /* +++
         * ++*
         * +*+
         * +**
         * *++
         * *+*
         * **+
         * ***
         * 9717711360
            135793394

         */
        EquationSolver es = new EquationSolver();
        Set<Long> ans = es.possibleAnswersForEquation("0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16");
        assertEquals(65536, ans.size());
    }
}
