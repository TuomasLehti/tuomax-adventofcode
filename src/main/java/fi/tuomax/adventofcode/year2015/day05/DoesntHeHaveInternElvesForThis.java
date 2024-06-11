package fi.tuomax.adventofcode.year2015.day05;

import java.util.List;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.parsing.StringListParser;
import fi.tuomax.adventofcode.framework.solving.Solver;

/** 
 * <p>Base class for solving Advent of Code 2015, day 5: 
 * Doesn't He Have Intern-Elves For This?</p>
 * @see 
 *      <a href="https://adventofcode.com/2015/day/5">
 *      Puzzle on the Advent of Code website.</a>
 */
public abstract class DoesntHeHaveInternElvesForThis 
extends Solver
{

    /**
     * Go through the strings one at a time. The niceness of a string is 
     * worked out in a different class, instance of which can be obtained from 
     * the getEvaluator-method.
     */
    @Override
    protected void solve()
    {
        Integer numOFNice = 0;
        for (String s : ((StringListParser) parser).getStrings()) {
            if (getEvaluator().isNice(s))
                numOFNice++;
        }
        setAnswer(numOFNice);
    }

    /**
     * A factory method for obtaining the evaluator for different parts.
     */
    protected abstract StringNicenessEvaluator getEvaluator();

    @Override
    protected Parser manufactureParser(List<String> input) {
        return new StringListParser(input);
    }

}
