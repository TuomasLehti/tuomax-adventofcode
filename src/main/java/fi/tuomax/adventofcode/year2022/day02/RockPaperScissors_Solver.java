package fi.tuomax.adventofcode.year2022.day02;

import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.parsing.StringListParser;
import fi.tuomax.adventofcode.framework.solving.Solver;

import java.util.List;
import java.util.Map;

/**
 * <p>Common parts of solving Advent of Code 2022, day 2:
 * Rock Paper Scissors.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2022/day/2">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public abstract class RockPaperScissors_Solver
extends Solver
{

    @Override
    protected Parser manufactureParser(List<String> input)
    {
        return new StringListParser(input);
    }

    /**
     * Manufactures the lookup table used by solve().
     */
    protected abstract Map<String, Integer> manufacturePointsTable();

    /**
     * Goes through each game (row of input) and adds up the scores, which
     * are found in the lookup table.
     */
    @Override
    protected void solve()
    {
        List<String> games = ((StringListParser) parser).getStrings();
        Map<String, Integer> pointsTable = manufacturePointsTable();
        Integer result = 0;
        for (String game : games)
            result += pointsTable.getOrDefault(game, 0);
        setAnswer(result);
    }

}
