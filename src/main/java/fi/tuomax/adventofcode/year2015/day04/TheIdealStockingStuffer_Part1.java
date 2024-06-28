package fi.tuomax.adventofcode.year2015.day04;

import java.util.List;

import fi.tuomax.adventofcode.commons.MD5;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.parsing.StringParser;
import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.solving.Solver;

/** 
 * <p>Solves Advent of Code 2015, day 4, part 1: 
 * The Ideal Stocking Stuffer</p>
 * 
 * <p>Also serves as a base class for part 2. The business logic for solving
 * different parts of this puzzle should be refactored to a base class, from
 * which both solvers should be descendants of. I will leave it as is for now,
 * because it is such a simple puzzle and this structuring of code does the
 * job also.</p>
 * 
 * @see 
 *      <a href="https://adventofcode.com/2015/day/4">
 *      Puzzle on the Advent of Code website.</a>
 */
public class TheIdealStockingStuffer_Part1 
extends Solver
{

    /**
     * This is the prefix, which the generated MD5 hash has to have.
     * It should be set in the constructor via the setter.
     */
    private String prefix;

    protected String getPrefix() 
    {
        return prefix;
    }

    protected void setPrefix(String prefix) 
    {
        this.prefix = prefix;
    }

    public TheIdealStockingStuffer_Part1()
    {
        setPrefix("00000");
    }

    /** The actual work is done in a different class one again. */
    @Override
    protected void solve() 
    {
        StringParser parser = (StringParser) this.parser;
        setAnswer(MD5.getHash(parser.getString(), getPrefix()));
    }

    @Override
    protected Metadata manufactureMetadata() 
    {
        return new Metadata(        
            2015, 
            4, 
            1, 
            "The Ideal Stocking Stuffer", 
            ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input) {
        return new StringParser(input);
    }
    
}
