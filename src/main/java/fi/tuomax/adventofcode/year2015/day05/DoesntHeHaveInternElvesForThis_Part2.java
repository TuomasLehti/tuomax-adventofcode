package fi.tuomax.adventofcode.year2015.day05;

import fi.tuomax.adventofcode.framework.solving.Metadata;

/** 
 * <p>Solves Advent of Code 2015, day 5, part 2: 
  * Doesn't He Have Intern-Elves For This?</p>
 * 
 * <p>This class boils down to a factory, because it just provides the correct
 * string niceness evaluator for this part of the puzzle. The actual logic for
 * solving can be found from the parent class.</p>
 * 
 * @see 
 *      <a href="https://adventofcode.com/2015/day/5">
 *      Puzzle on the Advent of Code website.</a>
 */
public class DoesntHeHaveInternElvesForThis_Part2
extends DoesntHeHaveInternElvesForThis
{

    private StringNicenessEvaluator evaluator = null;

    @Override
    protected StringNicenessEvaluator getEvaluator() {
        if (evaluator == null)
            evaluator = new StringNicenessEvaluator_Part2();
        return evaluator;
    }

    @Override
    protected Metadata manufactureMetadata() {
        return new Metadata(        
            2015, 
            5, 
            2, 
            "Doesn't He Have Intern-Elves For This?", 
            ""
        );
    
        }
    
}
