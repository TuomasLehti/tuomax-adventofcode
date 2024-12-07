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
    public void test_Part2_BaseCase()
    {
        EquationSolver es = new EquationSolver();
        Set<Long> ans = es.possibleAnswersForEquationPart2("3 5");
        assertEquals(3, ans.size());
        assertTrue(ans.contains(8L));
        assertTrue(ans.contains(15L));
        assertTrue(ans.contains(35L));
    }

    @Test
    public void test_Recursion_Part2()
    {
        /* not PEMDAS, but left to right */
        
        /* 3 + 5 + 7 = 15 */
        /* 3 + 5 * 7 = 56 */
        /* 3 + 5 | 7 = 87 --*/
        /* 3 * 5 + 7 = 22 */
        /* 3 * 5 * 7 = 105 */
        /* 3 * 5 | 7 = 157 --*/
        /* 3 | 5 + 7 = 42 */
        /* 3 | 5 * 7 = 245 */
        /* 3 | 5 | 7 = 357 --*/

        EquationSolver es = new EquationSolver();
        Set<Long> ans = es.possibleAnswersForEquationPart2("3 5 7");
        assertEquals(9, ans.size());
        assertTrue(ans.contains(15L));/**/
        assertTrue(ans.contains(56L));/**/
        assertTrue(ans.contains(87L));
        assertTrue(ans.contains(22L));/**/
        assertTrue(ans.contains(105L));/**/
        assertTrue(ans.contains(157L));
        assertTrue(ans.contains(42L));/**/
        assertTrue(ans.contains(245L)); /**/
        assertTrue(ans.contains(357L));
    }

}
