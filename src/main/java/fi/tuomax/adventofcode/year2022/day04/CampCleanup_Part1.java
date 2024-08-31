package fi.tuomax.adventofcode.year2022.day04;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.commons.Range;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Solver;

import java.util.List;

/**
 * <p>Solves Advent of Code 2022, day 4, part 1:
 * Camp Cleanup.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2022/day/4">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class CampCleanup_Part1
extends Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2022, 4, 1,
            "Camp Cleanup", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input)
    {
        return new CampCleanup_Parser(input);
    }

    @Override
    protected void solve()
    {
        List<Range[]> pairs = ((CampCleanup_Parser) parser).getPairs();
        Integer result = 0;
        for (Range[] pair : pairs)
            if (pair[0].contains(pair[1]) || pair[1].contains(pair[0]))
                result++;
        setAnswer(result);
    }

}
