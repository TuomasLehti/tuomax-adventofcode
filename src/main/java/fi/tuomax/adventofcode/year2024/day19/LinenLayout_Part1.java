package fi.tuomax.adventofcode.year2024.day19;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Solver;
import java.util.List;

/**
 * <p>Solves Advent of Code 2024, day 19, part 1:
 * Linen Layout.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2024/day/19">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class LinenLayout_Part1
extends Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2024, 19, 1,
            "Linen Layout", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input)
    {
        return new LinenLayout_Parser(input);
    }

    private LinenLayout_Parser parser()
    {
        return (LinenLayout_Parser) parser;
    }

    @Override
    protected void solve()
    {
        int possibleCount = 0;
        for (String design : parser().getDesigns())
            if (isPossible(design, parser().getPatterns()))
                possibleCount++;
        setAnswer(possibleCount);
    }
            
    private boolean isPossible(String design, List<String> patterns) 
    {
        if (patterns.contains(design)) return true;
        for (String pattern : patterns) {
            if (design.startsWith(pattern)) {
                if (isPossible(design.substring(pattern.length()), patterns))
                    return true;
            }
        }
        return false;
    }

}
