package fi.tuomax.adventofcode.year2022.day01;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Solver;
import java.util.List;

/**
 * <p>Solves Advent of Code 2022, day 1, part 1:
 * Calorie Counting.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2022/day/1">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class CalorieCounting_Part1
extends Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2022, 1, 1,
            "Calorie Counting", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input)
    {
        return new CalorieCounting_Parser(input);
    }

    @Override
    protected void solve()
    {
        List<Integer> caloriesOfElves = 
                ((CalorieCounting_Parser) parser).getCaloriesOfElves();
        setAnswer(caloriesOfElves.get(caloriesOfElves.size() - 1));
    }

}
