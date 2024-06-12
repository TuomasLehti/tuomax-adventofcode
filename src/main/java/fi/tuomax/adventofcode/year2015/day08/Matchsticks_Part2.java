package fi.tuomax.adventofcode.year2015.day08;

import java.util.List;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.parsing.StringListParser;
import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.solving.Solver;

/**
 * Solves Advent of Code 2015, day 8, part 2: 
 * Matchsticks.
 * @see 
 *      <a href="https://adventofcode.com/2015/day/8">
 *      Puzzle on the Advent of Code website.</a>
 */
public class Matchsticks_Part2
extends Solver
{

    /**
     * <p>Solves part 2.</p>
     * 
     * <p>Most of the work, ie working out the lengts of string literals and 
     * their representations in memory, is done in <code>SantaString</code>-
     * class.</p>
     * 
     * <p>The naming of the strings can be a bit misleading. String literal is
     * the representation of a string in a medium, eg disk. Each character in
     * this string represents a byte in the literal string. Any reference to a
     * string in memory means the decoded string.<p>
     * 
     * <p>For example a string literal is \x27, which takes up one byte in
     * memory.</p>
     */
    @Override
    protected void solve() {
        Integer result = 0;
        for (String s : ((StringListParser) parser).getStrings()) {
            result += SantaString.charsInLiteral(s) - s.length();
        }
        setAnswer(result.toString());
    }

    @Override
    protected Metadata manufactureMetadata() {
        return new Metadata(        
            2015, 
            8, 
            2, 
            "Matchsticks", 
            ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input) {
        return new StringListParser(input);   
    }
    
}
