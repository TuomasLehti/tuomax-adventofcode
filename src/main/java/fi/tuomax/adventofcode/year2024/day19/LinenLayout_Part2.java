package fi.tuomax.adventofcode.year2024.day19;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Solver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.LoggerFactory;

/**
 * <p>Solves Advent of Code 2024, day 19, part 2:
 * Linen Layout.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2024/day/19">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class LinenLayout_Part2
extends Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2024, 19, 2,
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

    long possibleCount = 0;

    private Map<String, Long> memo = new HashMap<>();

    @Override
    protected void solve()
    {
        for (String design : parser().getDesigns()) {
            possibleCount += countPossible(design, parser().getPatterns());
        }
        setAnswer(possibleCount);
    }
            
    private long countPossible(String design, List<String> patterns) 
    {
        if (memo.keySet().contains(design)) {
            return memo.get(design);
        }
        long count = 0;
        for (String pattern : patterns) {
            if (design.equals(pattern))
                count++;
            else if (design.startsWith(pattern)) 
                count += countPossible(design.substring(pattern.length()), patterns);
        }
        memo.put(design, count);
        return count;
    }

}
// 1271551994 too low